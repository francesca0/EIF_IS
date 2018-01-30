package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domainClasses.DirettoreDipartimento;
import domainClasses.ProgettoFormativo;

public class DirettoreDipartimentoDCS {

	public DirettoreDipartimentoDCS(){}
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM direttore_dipartimento WHERE email=?";
	
	public static DirettoreDipartimento loadByEmail(String email) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_EMAIL);
		ps.setString(1, email);
		rs = ps.executeQuery();
		
		
		if(rs.next()){
		DirettoreDipartimento direttoreDipartimento = new DirettoreDipartimento();
		
		direttoreDipartimento.setIdDirettoreDipartimento(rs.getString("idDirettoreDipartimento"));
		direttoreDipartimento.setNome(rs.getString("nome"));
		direttoreDipartimento.setCognome(rs.getString("cognome"));
		direttoreDipartimento.setPassword(rs.getString("password"));
		direttoreDipartimento.setTipoAccount(rs.getInt("tipoAccount"));
		
		System.out.println("DirettoreDipartimento trovato.");
		rs.close();
		ps.close();
		con.close();
		return direttoreDipartimento;
		}
		else{
		System.out.println("DirettoreDipartimento non presente nel database.");
		rs.close();
		ps.close();
		con.close();
	
		return null;
		}
	}
	
	
	private static final String CARICA_PF_DD = "SELECT * FROM progetto_formativo WHERE approvazioneRa='1' AND firmaDd='0' AND confermaUst='0'";
	public static ArrayList<ProgettoFormativo> caricaProgettiFormativi() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_PF_DD);

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

	
	private static final String CARICA_PF_FIRMATI_DD = "SELECT * FROM progetto_formativo WHERE firmaDd='1'";
	public static ArrayList<ProgettoFormativo> caricaProgettiFormativiFirmati() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_PF_FIRMATI_DD);

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
	
	
	private static final String FIRMA_PF_DD = "UPDATE progetto_formativo SET firmaDd='1' WHERE idProgettoFormativo=? AND approvazioneRa='1' AND firmaDd='0' AND confermaUst='0'";			
	public static void firmaPF(int idProgettoFormativo) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIRMA_PF_DD);
		
		ps.setInt(1, idProgettoFormativo);
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	
}
