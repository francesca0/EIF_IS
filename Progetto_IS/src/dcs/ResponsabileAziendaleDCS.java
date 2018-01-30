package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domainClasses.ProgettoFormativo;
import domainClasses.ResponsabileAziendale;
import domainClasses.Tirocinio;

public class ResponsabileAziendaleDCS {

	public ResponsabileAziendaleDCS(){}
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM responsabile_aziendale WHERE email=?";
	
	public static ResponsabileAziendale loadByEmail(String email) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_EMAIL);
		ps.setString(1, email);
		rs = ps.executeQuery();
		
		
		if(rs.next()){
			ResponsabileAziendale responsabileAziendale = new ResponsabileAziendale();
			
			responsabileAziendale.setIdResponsabileAziendale(rs.getInt("idResponsabileAziendale")); //PK
			responsabileAziendale.setNome(rs.getString("nome"));
			responsabileAziendale.setCognome(rs.getString("cognome"));
			responsabileAziendale.setPassword(rs.getString("password"));
			responsabileAziendale.setTipoAccount(rs.getInt("tipoAccount"));
			
			System.out.println("ResponsabileAziendale trovato.");
			rs.close();
			ps.close();
			con.close();
			
			return responsabileAziendale;
		}
		else{
			
			System.out.println("ResponsabileAziendale non presente nel database.");
			rs.close();
			ps.close();
			con.close();
		
			return null;
		}
	}
	
private static final String CARICA_TIROCINI_RA= "SELECT * FROM tirocinio WHERE idResponsabileAziendale=?";
	public static ArrayList<Tirocinio> caricaTirocini(int idResponsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Tirocinio> list = new ArrayList<Tirocinio>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_TIROCINI_RA);
		ps.setInt(1, idResponsabileAziendale);
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			Tirocinio tirocinio = new Tirocinio();
			
			tirocinio.setIdTirocinio(rs.getInt("idTirocinio"));
			tirocinio.setIdResponsabileAziendale(rs.getInt("idResponsabileAziendale"));
			tirocinio.setIdTutorAziendale(rs.getInt("idTutorAziendale"));
			tirocinio.setDescrizione(rs.getString("descrizione"));
			tirocinio.setTematica(rs.getString("tematica"));
			tirocinio.setNote(rs.getString("note"));
			tirocinio.setDataInizio(rs.getDate("dataInizio"));
			tirocinio.setDataFine(rs.getDate("dataFine"));
			
			list.add(tirocinio);	
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return list;
	}
	

	private static final String CARICA_PF_RA = "SELECT * FROM progetto_formativo WHERE idResponsabileAziendale=? AND approvazioneRa='0'";
	public static ArrayList<ProgettoFormativo> caricaProgettiFormativi(int idResponsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_PF_RA);
		ps.setInt(1, idResponsabileAziendale);

		rs = ps.executeQuery();
		
		while(rs.next()){
			
			ProgettoFormativo progettoFormativo = new ProgettoFormativo();
			
			progettoFormativo.setIdProgettoFormativo(rs.getInt("idProgettoFormativo"));
			progettoFormativo.setMatricolaStudente(rs.getString("matricolaStudente"));
			progettoFormativo.setIdTutorAziendale(rs.getInt("idTutorAziendale"));
			progettoFormativo.setIdTirocinio(rs.getInt("idTirocinio"));
			progettoFormativo.setIdResponsabileAziendale(rs.getInt("idResponsabileAziendale"));
			progettoFormativo.setMatricolaTutorAccademico(rs.getString("matricolaTutorAccademico"));
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

	
	private static final String CARICA_PF_APPROVATI_RA = "SELECT * FROM progetto_formativo WHERE idResponsabileAziendale=? AND approvazioneRa='1'";
	public static ArrayList<ProgettoFormativo> caricaProgettiFormativiApprovati(int idResponsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_PF_APPROVATI_RA);
		ps.setInt(1, idResponsabileAziendale);

		rs = ps.executeQuery();
		
		while(rs.next()){
			
			ProgettoFormativo progettoFormativo = new ProgettoFormativo();
			
			progettoFormativo.setIdProgettoFormativo(rs.getInt("idProgettoFormativo"));
			progettoFormativo.setMatricolaStudente(rs.getString("matricolaStudente"));
			progettoFormativo.setIdTutorAziendale(rs.getInt("idTutorAziendale"));
			progettoFormativo.setIdTirocinio(rs.getInt("idTirocinio"));
			progettoFormativo.setIdResponsabileAziendale(rs.getInt("idResponsabileAziendale"));
			progettoFormativo.setMatricolaTutorAccademico(rs.getString("matricolaTutorAccademico"));
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
	
	
	private static final String APPROVA_PF_RA = "UPDATE progetto_formativo SET approvazioneRa='1' WHERE idProgettoFormativo=? AND idResponsabileAziendale=? AND approvazioneRa='0' AND confermaUst='0' AND rifiutato='0'";			
	public static void approvaPF(int idProgettoFormativo, int idResponsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(APPROVA_PF_RA);
		
		ps.setInt(1, idProgettoFormativo);
		ps.setInt(2, idResponsabileAziendale); 
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String RIFIUTA_PF_RA = "UPDATE progetto_formativo SET rifiutato='1' WHERE idProgettoFormativo=? AND idResponsabileAziendale=? AND approvazioneRa='0' AND confermaUst='0' AND rifiutato='0'";			
	public static void rifiutaPF(int idProgettoFormativo, int idResponsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(RIFIUTA_PF_RA);
		
		ps.setInt(1, idProgettoFormativo);
		ps.setInt(2, idResponsabileAziendale); // CHECK DATABASE << ID <<
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
}
