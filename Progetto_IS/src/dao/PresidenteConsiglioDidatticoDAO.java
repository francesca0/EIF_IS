package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dcs.ConnectionManager;
import domainClasses.PresidenteConsiglioDidattico;
import domainClasses.ProgettoFormativo;


public class PresidenteConsiglioDidatticoDAO {

	public PresidenteConsiglioDidatticoDAO() {
		
	}
	
private static final String INSERT_SQL = "INSERT INTO presidente VALUES(?, ?, ?, ?, ?, ?)";
	
	public static void insert(PresidenteConsiglioDidattico presidenteConsiglioDidattico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setString(1, presidenteConsiglioDidattico.getIdPresidente());
		ps.setString(2, presidenteConsiglioDidattico.getNome());
		ps.setString(3, presidenteConsiglioDidattico.getCognome());
		ps.setString(4, presidenteConsiglioDidattico.getEmail());
		ps.setString(5, presidenteConsiglioDidattico.getPassword());
		ps.setInt(6, presidenteConsiglioDidattico.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM presidente WHERE idPresidente=?";
	
	public static void load(PresidenteConsiglioDidattico presidenteConsiglioDidattico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setString(1, presidenteConsiglioDidattico.getIdPresidente());
		rs = ps.executeQuery();
		rs.next();

		presidenteConsiglioDidattico.setIdPresidente(rs.getString("idPresidente"));
		presidenteConsiglioDidattico.setNome(rs.getString("nome"));
		presidenteConsiglioDidattico.setCognome(rs.getString("cognome"));
		presidenteConsiglioDidattico.setEmail(rs.getString("email"));
		presidenteConsiglioDidattico.setPassword(rs.getString("password"));
		presidenteConsiglioDidattico.setTipoAccount(rs.getInt("tipoAccount"));
		
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE presidente SET nome=?, cognome=?, email=?, password=?, tipoAccount=?  WHERE idPresidente=?";
	
	public static void update(PresidenteConsiglioDidattico presidenteConsiglioDidattico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setString(6, presidenteConsiglioDidattico.getIdPresidente());
		ps.setString(1, presidenteConsiglioDidattico.getNome());
		ps.setString(2, presidenteConsiglioDidattico.getCognome());
		ps.setString(3, presidenteConsiglioDidattico.getEmail());
		ps.setString(4, presidenteConsiglioDidattico.getPassword());
		ps.setInt(5, presidenteConsiglioDidattico.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM presidente WHERE idPresidente=?";
	
	public static void delete(PresidenteConsiglioDidattico presidenteConsiglioDidattico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		ps.setString(1, presidenteConsiglioDidattico.getIdPresidente());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM presidente WHERE email=?";
	
	public static PresidenteConsiglioDidattico findAllByEmail(PresidenteConsiglioDidattico presidenteConsiglioDidattico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_EMAIL);
		
		ps.setString(1, presidenteConsiglioDidattico.getEmail());
		rs = ps.executeQuery();
		rs.next();
		
		presidenteConsiglioDidattico.setIdPresidente(rs.getString("idPresidente"));
		presidenteConsiglioDidattico.setNome(rs.getString("nome"));
		presidenteConsiglioDidattico.setCognome(rs.getString("cognome"));
		presidenteConsiglioDidattico.setEmail(rs.getString("email"));
		presidenteConsiglioDidattico.setPassword(rs.getString("password"));
		presidenteConsiglioDidattico.setTipoAccount(rs.getInt("tipoAccount"));
		
		rs.close();
		ps.close();
		con.close();
		
		return presidenteConsiglioDidattico;
	}
	
	private static final String VISUALIZZA_PF = "SELECT * FROM progetto_formativo WHERE approvazioneRa='1' AND firmaPcd='0' AND confermaUst='0'";
	
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
	
	private static final String FIRMA_PF = "UPDATE progetto_formativo SET firmaPcd='1' WHERE idProgettoFormativo=? AND approvazioneRa='1' AND firmaPcd='0'";			
	
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
	
	private static final String VISIONA_PF = "SELECT * FROM progetto_formativo WHERE firmaPcd='1'";
	
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
