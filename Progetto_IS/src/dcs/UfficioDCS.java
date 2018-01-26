package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domainClasses.ProgettoFormativo;
import domainClasses.Studente;
import domainClasses.Ufficio;

public class UfficioDCS {

	public UfficioDCS(){}
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM ufficio WHERE email=?";
	
	public static Ufficio loadByEmail(String email) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_EMAIL);
		ps.setString(1, email);
		rs = ps.executeQuery();
		
		
		if(rs.next()){
		Ufficio ufficio = new Ufficio();
		
		ufficio.setIdUfficio(rs.getString("idUfficio"));
		ufficio.setEmail(rs.getString("email"));
		ufficio.setPassword(rs.getString("password"));
		ufficio.setTipoAccount(rs.getInt("tipoAccount"));
		
		System.out.println("Ufficio trovato.");
		rs.close();
		ps.close();
		con.close();
		return ufficio;
		}
		else{
		System.out.println("Ufficio non presente nel database.");
		rs.close();
		ps.close();
		con.close();
	
		return null;
		}
	}
	
private static final String CARICA_PF_UFFICIO = "SELECT * FROM progetto_formativo WHERE approvazioneRa='1' AND confermaUst='0'";
	
	public static ArrayList<ProgettoFormativo> caricaProgettiFormativi() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_PF_UFFICIO);
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			ProgettoFormativo progettoFormativo = new ProgettoFormativo();
			
			progettoFormativo.setIdProgettoFormativo(rs.getString("idProgettoFormativo"));
			progettoFormativo.setMatricolaStudente(rs.getString("matricolaStudente"));
			progettoFormativo.setIdTaz(rs.getString("idTaz"));
			progettoFormativo.setIdTirocinio(rs.getString("idTirocinio"));
			progettoFormativo.setIdResponsabileAziendalePF(rs.getString("idRa"));
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
	
private static final String CARICA_PF_CONFERMATI_UFFICIO = "SELECT * FROM progetto_formativo WHERE approvazioneRa='1' AND confermaUst='1'";
	
	public static ArrayList<ProgettoFormativo> caricaProgettiFormativiConfermati() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_PF_CONFERMATI_UFFICIO);
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			ProgettoFormativo progettoFormativo = new ProgettoFormativo();
			
			progettoFormativo.setIdProgettoFormativo(rs.getString("idProgettoFormativo"));
			progettoFormativo.setMatricolaStudente(rs.getString("matricolaStudente"));
			progettoFormativo.setIdTaz(rs.getString("idTaz"));
			progettoFormativo.setIdTirocinio(rs.getString("idTirocinio"));
			progettoFormativo.setIdResponsabileAziendalePF(rs.getString("idRa"));
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
	
	
private static final String CONFERMA_PF_UFFICIO = "UPDATE progetto_formativo SET confermaUst='1' WHERE idProgettoFormativo=? AND approvazioneRa='1' AND firmaTaz='1' AND firmaTac='1' AND (firmaDd='1' OR firmaPcd='1') AND confermaUst='0' AND annullato='0' AND rifiutato='0'";
	public static void confermaPf(String idProgettoFormativo) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CONFERMA_PF_UFFICIO);
		
		ps.setString(1, idProgettoFormativo);
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String ANNULLA_PF_UFFICIO = "UPDATE progetto_formativo SET annullato='1' WHERE idProgettoFormativo=? AND approvazioneRa='1' AND confermaUst='0' AND rifiutato='0' AND annullato='0'";

	public static void annullaPf(String idProgettoFormativo) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(ANNULLA_PF_UFFICIO);
		
		ps.setString(1,idProgettoFormativo);
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	
	private static final String CARICA_ACCOUNT_STUDENTI = "SELECT * FROM studente";
	
	public static ArrayList<Studente> caricaAccountStudenti() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Studente> list = new ArrayList<Studente>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_ACCOUNT_STUDENTI);
		rs = ps.executeQuery();

		while(rs.next()){
			
			Studente studente = new Studente();
			
			studente.setNome(rs.getString("nome"));
			studente.setCognome(rs.getString("cognome"));
			studente.setMatricolaStudente(rs.getString("matricolaStudente"));
			studente.setDataDiNascita(rs.getDate("dataDiNascita"));
			studente.setLuogoDiNascita(rs.getString("luogoDiNascita"));
			studente.setResidenza(rs.getString("residenza"));
			studente.setTelefono(rs.getString("telefono"));
			studente.setTutorAccademico(rs.getString("tutorAccademico"));
			studente.setEmail(rs.getString("email"));
			studente.setPassword(rs.getString("password"));
			studente.setTipoAccount(rs.getInt("tipoAccount"));
		
			list.add(studente);	

		}
		
		rs.close();
		ps.close();
		con.close();
	
		return list;
	}
	
		
}
