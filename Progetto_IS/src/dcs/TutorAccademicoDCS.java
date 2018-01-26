package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domainClasses.ProgettoFormativo;
import domainClasses.TutorAccademico;

public class TutorAccademicoDCS {

	TutorAccademicoDCS(){}
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM tutorAccademico WHERE email=?";
	
	public static TutorAccademico loadByEmail(String email) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_EMAIL);
		ps.setString(1, email);
		rs = ps.executeQuery();
		
		
		if(rs.next()){
		TutorAccademico tutorAccademico = new TutorAccademico();
		
		tutorAccademico.setIdTutorAccademico(rs.getString("idTutorAccademico")); //PK
		tutorAccademico.setNome(rs.getString("nome"));
		tutorAccademico.setCognome(rs.getString("cognome"));
		tutorAccademico.setPassword(rs.getString("password"));
		tutorAccademico.setTipoAccount(rs.getInt("tipoAccount"));
		
		System.out.println("TutorAccademico trovato.");
		rs.close();
		ps.close();
		con.close();
		return tutorAccademico;
		}
		else{
		System.out.println("TutorAccademico non presente nel database.");
		rs.close();
		ps.close();
		con.close();
	
		return null;
		}
	}
	
	private static final String CARICA_PF_TAC = "SELECT * FROM progetto_formativo WHERE idTutorAccademico=? AND firmaTac='0' AND approvazioneRa='1' AND confermaUst='0'";
	public static ArrayList<ProgettoFormativo> caricaProgettiFormativi(String idTutorAccademico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_PF_TAC);
		ps.setString(1, idTutorAccademico);
		
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

	
	private static final String CARICA_PF_FIRMATI_TAC = "SELECT * FROM progetto_formativo WHERE idTutorAccademico=? AND firmaTac='1'";
	public static ArrayList<ProgettoFormativo> caricaProgettiFormativiFirmati(String idTutorAccademico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_PF_FIRMATI_TAC);
		ps.setString(1, idTutorAccademico);
		
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
	
	
	private static final String FIRMA_PF_TAC = "UPDATE progetto_formativo SET firmaTac='1' WHERE idProgettoFormativo=? AND idTutorAccademico=? AND approvazioneRa='1' AND firmaTac='0' AND confermaUst='0'";			
	public static void firmaPF(String idProgettoFormativo, String idTutorAccademico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIRMA_PF_TAC);
		
		ps.setString(1, idProgettoFormativo);
		ps.setString(2, idTutorAccademico);
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
}
