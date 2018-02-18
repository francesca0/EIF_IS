package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domainClasses.ProgettoFormativo;
import domainClasses.TutorAccademico;
import utility.ConnectionManager;

public class TutorAccademicoDCS {

	TutorAccademicoDCS(){}
	
	private static final String GET_KEY_BY_EMAIL = "SELECT matricolaTutorAccademico FROM tutor_accademico WHERE email=?";	
	public static String getKeyByEmail(String email) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(GET_KEY_BY_EMAIL);
		ps.setString(1, email);
		rs = ps.executeQuery();
		
		
		if(rs.next()){
			String matricolaTutorAccademico = rs.getString("matricolaTutorAccademico"); //PK
			
			System.out.println("TutorAccademico trovato.");
			rs.close();
			ps.close();
			con.close();
			return matricolaTutorAccademico;
		}
			else{
				System.out.println("TutorAccademico non presente nel database.");
				rs.close();
				ps.close();
				con.close();
			
				return null;
			}
	}
	
	private static final String CHECK_EXISTENCE = "SELECT * FROM tutor_accademico WHERE matricolaTutorAccademico=?";	
	public static boolean exists(String matricolaTutorAccademico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CHECK_EXISTENCE);
		ps.setString(1, matricolaTutorAccademico);
		rs = ps.executeQuery();
		
		
		if(rs.next()){
			System.out.println("TutorAccademico presente nel database.");
			rs.close();
			ps.close();
			con.close();
			return true;
		}
		else{
				System.out.println("TutorAccademico non presente nel database.");
				rs.close();
				ps.close();
				con.close();
				return false;
		}
	}
	
	/*private static final String FIND_BY_EMAIL = "SELECT * FROM tutor_accademico WHERE email=?";
	
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
			
			tutorAccademico.setMatricolaTutorAccademico(rs.getString("matricolaTutorAccademico")); //PK
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
	*/
	private static final String FIND_BY_MATRICOLA = "SELECT * FROM tutor_accademico WHERE matricolaTutorAccademico=?";
	
	public static TutorAccademico loadByMatricola(String matricolaTutorAccademico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_MATRICOLA);
		ps.setString(1, matricolaTutorAccademico);
		rs = ps.executeQuery();
		
		
		if(rs.next()){
			TutorAccademico tutorAccademico = new TutorAccademico();
			
			tutorAccademico.setMatricolaTutorAccademico(rs.getString("matricolaTutorAccademico")); //PK
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
	
	private static final String CARICA_PF_TAC = "SELECT * FROM progetto_formativo WHERE matricolaTutorAccademico=? AND firmaTac='0' AND approvazioneRa='1' AND confermaUst='0' AND annullato='0'";
	public static ArrayList<ProgettoFormativo> caricaProgettiFormativi(String matricolaTutorAccademico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_PF_TAC);
		ps.setString(1, matricolaTutorAccademico);
		
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

	
	private static final String CARICA_PF_FIRMATI_TAC = "SELECT * FROM progetto_formativo WHERE matricolaTutorAccademico=? AND firmaTac='1'";
	public static ArrayList<ProgettoFormativo> caricaProgettiFormativiFirmati(String matricolaTutorAccademico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_PF_FIRMATI_TAC);
		ps.setString(1, matricolaTutorAccademico);
		
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
	
	
	private static final String FIRMA_PF_TAC = "UPDATE progetto_formativo SET firmaTac='1' WHERE idProgettoFormativo=? AND matricolaTutorAccademico=? AND approvazioneRa='1' AND firmaTac='0' AND confermaUst='0'";			
	public static void firmaPF(int idProgettoFormativo, String matricolaTutorAccademico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIRMA_PF_TAC);
		
		ps.setInt(1, idProgettoFormativo);
		ps.setString(2, matricolaTutorAccademico);
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
}
