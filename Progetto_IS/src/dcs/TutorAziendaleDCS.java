package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domainClasses.ProgettoFormativo;
import domainClasses.TutorAziendale;

public class TutorAziendaleDCS {

	TutorAziendaleDCS(){}
	
private static final String FIND_BY_EMAIL = "SELECT * FROM tutorAziendale WHERE email=?";
	
	public static TutorAziendale loadByEmail(String email) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_EMAIL);
		ps.setString(1, email);
		rs = ps.executeQuery();
		
		
		if(rs.next()){
		TutorAziendale tutorAziendale = new TutorAziendale();
		
		tutorAziendale.setIdTutorAziendale(rs.getString("idTutorAziendale")); //PK
		tutorAziendale.setNome(rs.getString("nome"));
		tutorAziendale.setCognome(rs.getString("cognome"));
		tutorAziendale.setPassword(rs.getString("password"));
		tutorAziendale.setTipoAccount(rs.getInt("tipoAccount"));
		
		System.out.println("TutorAziendale trovato.");
		rs.close();
		ps.close();
		con.close();
		return tutorAziendale;
		}
		else{
		System.out.println("TutorAziendale non presente nel database.");
		rs.close();
		ps.close();
		con.close();
	
		return null;
		}
	}
	
	private static final String CARICA_PF_TAZ = "SELECT * FROM progetto_formativo WHERE idTutorAziendale=? AND firmaTaz='0' AND approvazioneRa='1' AND confermaUst='0'";
	public static ArrayList<ProgettoFormativo> caricaProgettiFormativi(String idTutorAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_PF_TAZ);
		ps.setString(1, idTutorAziendale);
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			ProgettoFormativo progettoFormativo = new ProgettoFormativo();
			
			progettoFormativo.setIdProgettoFormativo(rs.getString("idProgettoFormativo"));
			progettoFormativo.setMatricolaStudente(rs.getString("matricolaStudente"));
			progettoFormativo.setIdTaz(rs.getString("idTaz"));
			progettoFormativo.setIdTirocinio(rs.getString("idTirocinio"));
			progettoFormativo.setIdResponsabileAziendalePF(rs.getString("idResponsabileAziendalePF"));
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

	
	private static final String CARICA_PF_FIRMATI_TAZ = "SELECT * FROM progetto_formativo WHERE idTutorAziendale=? AND firmaTaz='1'";
	public static ArrayList<ProgettoFormativo> caricaProgettiFormativiFirmati(String idTutorAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_PF_FIRMATI_TAZ);
		ps.setString(1, idTutorAziendale);
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			ProgettoFormativo progettoFormativo = new ProgettoFormativo();
			
			progettoFormativo.setIdProgettoFormativo(rs.getString("idProgettoFormativo"));
			progettoFormativo.setMatricolaStudente(rs.getString("matricolaStudente"));
			progettoFormativo.setIdTaz(rs.getString("idTaz"));
			progettoFormativo.setIdTirocinio(rs.getString("idTirocinio"));
			progettoFormativo.setIdResponsabileAziendalePF(rs.getString("idResponsabileAziendalePF"));
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
	
	
	private static final String FIRMA_PF_TAZ = "UPDATE progetto_formativo SET firmaTaz='1' WHERE idProgettoFormativo=? AND idTutorAziendale=? AND approvazioneRa='1' AND firmaTaz='0' AND confermaUst='0'";			
	public static void firmaPF(String idProgettoFormativo, String idTutorAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIRMA_PF_TAZ);
		
		ps.setString(1, idProgettoFormativo);
		ps.setString(2, idTutorAziendale);
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
}
