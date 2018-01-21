package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dcs.ConnectionManager;
import domainClasses.ProgettoFormativo;
import domainClasses.ResponsabileAziendale;

public class ResponsabileAziendaleDAO {

private ResponsabileAziendaleDAO(){
		
	}
	
	private static final String INSERT_SQL = "INSERT INTO responsabile VALUES(?, ?, ?, ?, ?, ?, ?)";
	
	public static void insert(ResponsabileAziendale responsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setString(1, responsabileAziendale.getIdResponsabile());
		ps.setString(2, responsabileAziendale.getNome());
		ps.setString(3, responsabileAziendale.getCognome());
		ps.setString(4, responsabileAziendale.getAziendaRa());
		ps.setString(5, responsabileAziendale.getEmail());
		ps.setString(6, responsabileAziendale.getPassword());
		ps.setInt(7, responsabileAziendale.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM responsabile WHERE idResponsabile=?";
	
	public static void load(ResponsabileAziendale responsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setString(1, responsabileAziendale.getIdResponsabile());
		rs = ps.executeQuery();
		rs.next();

		responsabileAziendale.setIdResponsabile(rs.getString("idResponsabile"));
		responsabileAziendale.setNome(rs.getString("nome"));
		responsabileAziendale.setCognome(rs.getString("cognome"));
		responsabileAziendale.setAziendaRa(rs.getString("aziendaRa"));
		responsabileAziendale.setEmail(rs.getString("email"));
		responsabileAziendale.setPassword(rs.getString("password"));
		responsabileAziendale.setTipoAccount(rs.getInt("tipoAccount"));
		
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE responsabile SET nome=?, cognome=?, aziendaRa=?, email=?, password=?, tipoAccount=?  WHERE idResponsabile=?";
	
	public static void update(ResponsabileAziendale responsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setString(7, responsabileAziendale.getIdResponsabile());
		ps.setString(1, responsabileAziendale.getNome());
		ps.setString(2, responsabileAziendale.getCognome());
		ps.setString(3, responsabileAziendale.getAziendaRa());
		ps.setString(4, responsabileAziendale.getEmail());
		ps.setString(5, responsabileAziendale.getPassword());
		ps.setInt(6, responsabileAziendale.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM responsabile WHERE idResponsabile=?";
	
	public static void delete(ResponsabileAziendale responsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		ps.setString(1, responsabileAziendale.getIdResponsabile());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}

	private static final String FIND_ALL = "SELECT * FROM responsabile";
	
	public static  ArrayList<ResponsabileAziendale> findAll() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ResponsabileAziendale> list = new ArrayList<ResponsabileAziendale>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_ALL);
		rs = ps.executeQuery();
		
		while(rs.next()){
			
		ResponsabileAziendale responsabileAziendale = new ResponsabileAziendale();
	
		responsabileAziendale.setIdResponsabile(rs.getString("idResponsabile"));
		responsabileAziendale.setNome(rs.getString("nome"));
		responsabileAziendale.setCognome(rs.getString("cognome"));
		responsabileAziendale.setAziendaRa(rs.getString("aziendaRa"));
		responsabileAziendale.setEmail(rs.getString("email"));
		responsabileAziendale.setPassword(rs.getString("password"));
		responsabileAziendale.setTipoAccount(rs.getInt("tipoAccount"));
		
		list.add(responsabileAziendale);	
	
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return list;
	}
	
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM responsabile WHERE email=?";
	
	public static ResponsabileAziendale findAllByEmail(ResponsabileAziendale responsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_EMAIL);
		
		ps.setString(1, responsabileAziendale.getEmail());
		rs = ps.executeQuery();
		rs.next();
		
		responsabileAziendale.setIdResponsabile(rs.getString("idResponsabile"));
		responsabileAziendale.setNome(rs.getString("nome"));
		responsabileAziendale.setCognome(rs.getString("cognome"));
		responsabileAziendale.setAziendaRa(rs.getString("aziendaRa"));
		responsabileAziendale.setEmail(rs.getString("email"));
		responsabileAziendale.setPassword(rs.getString("password"));
		responsabileAziendale.setTipoAccount(rs.getInt("tipoAccount"));
		
		rs.close();
		ps.close();
		con.close();
		
		return responsabileAziendale;
	}

	private static final String VISUALIZZA_PF = "SELECT * FROM progetto_formativo WHERE approvazioneRa='0' AND idRa=?";
	
	public static ArrayList<ProgettoFormativo> visualizzaPf(ResponsabileAziendale responsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(VISUALIZZA_PF);
		
		ps.setString(1, responsabileAziendale.getIdResponsabile());
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

	private static final String APPROVA_PF = "UPDATE progetto_formativo SET approvazioneRa='1' WHERE idProgettoFormativo=? AND idRa=?";
	
	public static void approvaPf(ProgettoFormativo progettoFormativo, ResponsabileAziendale responsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(APPROVA_PF);
		
		ps.setString(1, progettoFormativo.getIdProgettoFormativo());
		ps.setString(2, responsabileAziendale.getIdResponsabile());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String RIFIUTA_PF = "UPDATE progetto_formativo SET rifiutato='1' WHERE idProgettoFormativo=? AND approvazioneRa='0' AND idRa=?";
	
	public static void rifiutaPf(ProgettoFormativo progettoFormativo, ResponsabileAziendale responsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(RIFIUTA_PF);
		
		ps.setString(1, progettoFormativo.getIdProgettoFormativo());
		ps.setString(2, responsabileAziendale.getIdResponsabile());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String VISIONA_PF = "SELECT * FROM progetto_formativo WHERE approvazioneRa='1' AND idRa=?";
	
	public static ArrayList<ProgettoFormativo> visionaPf(ResponsabileAziendale responsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//ResponsabileAziendale responsabileAziendale = new ResponsabileAziendale();
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(VISIONA_PF);
		ps.setString(1, responsabileAziendale.getIdResponsabile());
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
