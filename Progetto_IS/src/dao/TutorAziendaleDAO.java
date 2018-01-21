package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dcs.ConnectionManager;
import domainClasses.ProgettoFormativo;
import domainClasses.TutorAziendale;

public class TutorAziendaleDAO {

	public TutorAziendaleDAO(){
		
	}
	
private static final String INSERT_SQL = "INSERT INTO tutor_aziendale VALUES(?, ?, ?, ?, ?, ?)";
	
	public static void insert(TutorAziendale tutorAziendale) throws ClassNotFoundException, SQLException{
			
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setString(1, tutorAziendale.getIdTutorAziendale());
		ps.setString(2, tutorAziendale.getNome());
		ps.setString(3, tutorAziendale.getCognome());
		ps.setString(4, tutorAziendale.getEmail());
		ps.setString(5, tutorAziendale.getPassword());
		ps.setInt(6, tutorAziendale.getTipoAccount());
	
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM tutor_aziendale WHERE idTutorAziendale=?";
	
	public static void load(TutorAziendale tutorAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setString(1, tutorAziendale.getIdTutorAziendale());
		rs = ps.executeQuery();
		rs.next();

		tutorAziendale.setIdTutorAziendale(rs.getString("idTutorAziendale"));
		tutorAziendale.setNome(rs.getString("nome"));
		tutorAziendale.setCognome(rs.getString("cognome"));
		tutorAziendale.setEmail(rs.getString("email"));
		tutorAziendale.setPassword(rs.getString("password"));
		tutorAziendale.setTipoAccount(rs.getInt("tipoAccount"));
	
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE tutor_aziendale SET nome=?, cognome=?, email=?, password=?, tipoAccount=? WHERE idTutorAziendale=?";
	
	public static void update(TutorAziendale tutorAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setString(6, tutorAziendale.getIdTutorAziendale());
		ps.setString(1, tutorAziendale.getNome());
		ps.setString(2, tutorAziendale.getCognome());
		ps.setString(3, tutorAziendale.getEmail());
		ps.setString(4, tutorAziendale.getPassword());
		ps.setInt(5, tutorAziendale.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM tutor_aziendale WHERE idTutorAziendale=?";
	
	public static void delete(TutorAziendale tutorAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		ps.setString(1, tutorAziendale.getIdTutorAziendale());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String FIND_ALL = "SELECT * FROM tutor_aziendale";
	
	public static  ArrayList<TutorAziendale> findAll() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<TutorAziendale> list = new ArrayList<TutorAziendale>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_ALL);
		rs = ps.executeQuery();
		
		while(rs.next()){
			
		TutorAziendale tutorAziendale = new TutorAziendale();
	
		tutorAziendale.setIdTutorAziendale(rs.getString("idTutorAziendale"));
		tutorAziendale.setNome(rs.getString("nome"));
		tutorAziendale.setCognome(rs.getString("cognome"));
		tutorAziendale.setEmail(rs.getString("email"));
		tutorAziendale.setPassword(rs.getString("password"));
		tutorAziendale.setTipoAccount(rs.getInt("tipoAccount"));
		tutorAziendale.setAziendaTaz(rs.getString("aziendaTaz"));
		
		list.add(tutorAziendale);	
	
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return list;
	}
	
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM tutor_aziendale WHERE email=?";
	
	public static TutorAziendale findAllByEmail(TutorAziendale tutorAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_EMAIL);
		
		ps.setString(1, tutorAziendale.getEmail());
		rs = ps.executeQuery();
		rs.next();
		
		tutorAziendale.setIdTutorAziendale(rs.getString("idTutorAziendale"));
		tutorAziendale.setNome(rs.getString("nome"));
		tutorAziendale.setCognome(rs.getString("cognome"));
		tutorAziendale.setEmail(rs.getString("email"));
		tutorAziendale.setPassword(rs.getString("password"));
		tutorAziendale.setTipoAccount(rs.getInt("tipoAccount"));
		
		rs.close();
		ps.close();
		con.close();
		
		return tutorAziendale;
	}
	
	private static final String VISUALIZZA_PF = "SELECT * FROM progetto_formativo WHERE approvazioneRa='1' AND firmaTaz='0' AND idTaz=?";
	
	public static ArrayList<ProgettoFormativo> visualizzaPf(TutorAziendale tutorAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(VISUALIZZA_PF);
		ps.setString(1, tutorAziendale.getIdTutorAziendale());
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
	
	private static final String FIRMA_PF = "UPDATE progetto_formativo SET firmaTaz='1' WHERE idProgettoFormativo=? AND approvazioneRa='1' AND firmaTaz='0' AND idTaz=?";
	
	public static void firmaPf(ProgettoFormativo progettoFormativo, TutorAziendale tutorAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIRMA_PF);
		
		ps.setString(1, progettoFormativo.getIdProgettoFormativo());
		ps.setString(2, tutorAziendale.getIdTutorAziendale());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
		
	private static final String VISIONA_PF = "SELECT * FROM progetto_formativo WHERE firmaTaz='1' AND idTaz=?";
	
	public static ArrayList<ProgettoFormativo> visionaPf(TutorAziendale tutorAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//TutorAziendale tutorAziendale = new TutorAziendale();
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(VISIONA_PF);
		ps.setString(1, tutorAziendale.getIdTutorAziendale());
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
