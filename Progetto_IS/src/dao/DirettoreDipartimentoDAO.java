package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dcs.ConnectionManager;
import domainClasses.DirettoreDipartimento;
import domainClasses.ProgettoFormativo;

public class DirettoreDipartimentoDAO {

	public DirettoreDipartimentoDAO(){
		
	}
	
	private static final String INSERT_SQL = "INSERT INTO direttore VALUES(?, ?, ?, ?, ?, ?)";
	
	public static void insert(DirettoreDipartimento direttoreDipartimento) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setString(1, direttoreDipartimento.getIdDirettore());
		ps.setString(2, direttoreDipartimento.getNome());
		ps.setString(3, direttoreDipartimento.getCognome());
		ps.setString(4, direttoreDipartimento.getEmail());
		ps.setString(5, direttoreDipartimento.getPassword());
		ps.setInt(6, direttoreDipartimento.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM direttore WHERE idDirettore=?";
	
	public static void load(DirettoreDipartimento direttoreDipartimento) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setString(1, direttoreDipartimento.getIdDirettore());
		rs = ps.executeQuery();
		rs.next();

		direttoreDipartimento.setIdDirettore(rs.getString("idDirettore"));
		direttoreDipartimento.setNome(rs.getString("nome"));
		direttoreDipartimento.setCognome(rs.getString("cognome"));
		direttoreDipartimento.setEmail(rs.getString("email"));
		direttoreDipartimento.setPassword(rs.getString("password"));
		direttoreDipartimento.setTipoAccount(rs.getInt("tipoAccount"));
		
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE direttore SET nome=?, cognome=?, email=?, password=?, tipoAccount=?  WHERE idDirettore=?";
	
	public static void update(DirettoreDipartimento direttoreDipartimento) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setString(6, direttoreDipartimento.getIdDirettore());
		ps.setString(1, direttoreDipartimento.getNome());
		ps.setString(2, direttoreDipartimento.getCognome());
		ps.setString(3, direttoreDipartimento.getEmail());
		ps.setString(4, direttoreDipartimento.getPassword());
		ps.setInt(5, direttoreDipartimento.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM direttore WHERE idDirettore=?";
	
	public static void delete(DirettoreDipartimento direttoreDipartimento) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		
		ps.setString(1, direttoreDipartimento.getIdDirettore());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String FIND_ALL = "SELECT * FROM direttore";
	
	public static  ArrayList<DirettoreDipartimento> findAll() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_ALL);
		rs = ps.executeQuery();
		ArrayList<DirettoreDipartimento> list = new ArrayList<DirettoreDipartimento>();

		
		while(rs.next()){
			
		DirettoreDipartimento direttoreDipartimento = new DirettoreDipartimento();
	
		direttoreDipartimento.setIdDirettore(rs.getString("idDirettore"));
		direttoreDipartimento.setNome(rs.getString("nome"));
		direttoreDipartimento.setCognome(rs.getString("cognome"));
		direttoreDipartimento.setEmail(rs.getString("email"));
		direttoreDipartimento.setPassword(rs.getString("password"));
		direttoreDipartimento.setTipoAccount(rs.getInt("tipoAccount"));
		
		list.add(direttoreDipartimento);	

		
		}
		rs.close();
		ps.close();
		con.close();
		
		return list;
	}
	
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM direttore WHERE email=?";
	
	public static DirettoreDipartimento findAllByEmail(DirettoreDipartimento direttoreDipartimento) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_EMAIL);
		
		ps.setString(1, direttoreDipartimento.getEmail());
		rs = ps.executeQuery();
		rs.next();
		
		direttoreDipartimento.setIdDirettore(rs.getString("idDirettore"));
		direttoreDipartimento.setNome(rs.getString("nome"));
		direttoreDipartimento.setCognome(rs.getString("cognome"));
		direttoreDipartimento.setEmail(rs.getString("email"));
		direttoreDipartimento.setPassword(rs.getString("password"));
		direttoreDipartimento.setTipoAccount(rs.getInt("tipoAccount"));
		
		rs.close();
		ps.close();
		con.close();
		
		return direttoreDipartimento;
	}
	
	private static final String VISUALIZZA_PF = "SELECT * FROM progetto_formativo WHERE approvazioneRa='1' AND firmaDd='0' AND confermaUst='0'";
	
	public static ArrayList<ProgettoFormativo> visualizzaPf() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(VISUALIZZA_PF);

		rs = ps.executeQuery();
		
		while(rs.next()){
			
			ProgettoFormativo progettoFormativo = new ProgettoFormativo();
			
			progettoFormativo.setIdProgettoFormativo(rs.getString("idProgettoFormativo"));
			progettoFormativo.setMatricolaStudente(rs.getString("matricolaStudente"));
			progettoFormativo.setIdTaz(rs.getString("idTaz"));
			progettoFormativo.setIdTirocinio(rs.getString("idTirocinio"));
			progettoFormativo.setIdRa(rs.getString("idRa"));
			progettoFormativo.setIdTac(rs.getString("idTac"));
			progettoFormativo.setIdDd(rs.getString("idDd"));
			progettoFormativo.setIdPcd(rs.getString("idPcd"));
			progettoFormativo.setFirmaTaz(rs.getInt("firmaTaz"));
			progettoFormativo.setApprovazioneRa(rs.getInt("approvazioneRa"));
			progettoFormativo.setFirmaTac(rs.getInt("firmaTac"));
			progettoFormativo.setFirmaDd(rs.getInt("firmaDd"));
			progettoFormativo.setFirmaPcd(rs.getInt("firmaPcd"));
			progettoFormativo.setConfermaUst(rs.getInt("confermaUst"));
			progettoFormativo.setNomeFile(rs.getString("nomeFile"));
			progettoFormativo.setRifiutato(rs.getInt("rifiutato"));
			progettoFormativo.setAnnullato(rs.getInt("annullato"));
			
			list.add(progettoFormativo);
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return list;
	}
	
	private static final String FIRMA_PF = "UPDATE progetto_formativo SET firmaDd='1' WHERE idProgettoFormativo=? AND approvazioneRa='1' AND firmaDd='0'";
			
	public static void firmaPf(ProgettoFormativo progettoFormativo) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIRMA_PF);
		
		ps.setString(1, progettoFormativo.getIdProgettoFormativo());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String VISIONA_PF = "SELECT * FROM progetto_formativo WHERE firmaDd='1'";
	
	public static ArrayList<ProgettoFormativo> visionaPf() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(VISIONA_PF);

		rs = ps.executeQuery();
		
		while(rs.next()){
			
			ProgettoFormativo progettoFormativo = new ProgettoFormativo();
			
			progettoFormativo.setIdProgettoFormativo(rs.getString("idProgettoFormativo"));
			progettoFormativo.setMatricolaStudente(rs.getString("matricolaStudente"));
			progettoFormativo.setIdTaz(rs.getString("idTaz"));
			progettoFormativo.setIdTirocinio(rs.getString("idTirocinio"));
			progettoFormativo.setIdRa(rs.getString("idRa"));
			progettoFormativo.setIdTac(rs.getString("idTac"));
			progettoFormativo.setIdDd(rs.getString("idDd"));
			progettoFormativo.setIdPcd(rs.getString("idPcd"));
			progettoFormativo.setFirmaTaz(rs.getInt("firmaTaz"));
			progettoFormativo.setApprovazioneRa(rs.getInt("approvazioneRa"));
			progettoFormativo.setFirmaTac(rs.getInt("firmaTac"));
			progettoFormativo.setFirmaDd(rs.getInt("firmaDd"));
			progettoFormativo.setFirmaPcd(rs.getInt("firmaPcd"));
			progettoFormativo.setConfermaUst(rs.getInt("confermaUst"));
			progettoFormativo.setNomeFile(rs.getString("nomeFile"));
			progettoFormativo.setRifiutato(rs.getInt("rifiutato"));
			progettoFormativo.setAnnullato(rs.getInt("annullato"));
			
			list.add(progettoFormativo);
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return list;
	}
}