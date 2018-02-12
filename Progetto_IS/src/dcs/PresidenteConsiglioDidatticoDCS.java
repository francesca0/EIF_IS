package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domainClasses.ProgettoFormativo;

public class PresidenteConsiglioDidatticoDCS {

	public PresidenteConsiglioDidatticoDCS(){}
	
	private static final String GET_KEY_BY_EMAIL = "SELECT idPresidenteConsiglioDidattico FROM presidente_consiglio_didattico WHERE email=?";
	public static String getKeyByEmail(String email) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(GET_KEY_BY_EMAIL);
		ps.setString(1, email);
		rs = ps.executeQuery();
		
		
		if(rs.next()){
			String idPresidenteConsiglioDidattico = rs.getString("idPresidenteConsiglioDidattico"); //PK
			System.out.println("PresidenteConsiglioDidattico trovato.");
			
			rs.close();
			ps.close();
			con.close();
			return idPresidenteConsiglioDidattico;
		}
		else{
			System.out.println("PresidenteConsiglioDidattico non presente nel database.");
			rs.close();
			ps.close();
			con.close();
		
			return null;
		}
		
	}
	
		/*private static final String FIND_BY_EMAIL = "SELECT * FROM presidente_consiglio_didattico WHERE email=?";
		public static PresidenteConsiglioDidattico loadByEmail(String email) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(FIND_BY_EMAIL);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			
			if(rs.next()){
				PresidenteConsiglioDidattico presidenteConsiglioDidattico = new PresidenteConsiglioDidattico();
				
				presidenteConsiglioDidattico.setIdPresidenteConsiglioDidattico(rs.getString("idPresidenteConsiglioDidattico")); //PK
				presidenteConsiglioDidattico.setNome(rs.getString("nome"));
				presidenteConsiglioDidattico.setCognome(rs.getString("cognome"));
				presidenteConsiglioDidattico.setPassword(rs.getString("password"));
				presidenteConsiglioDidattico.setTipoAccount(rs.getInt("tipoAccount"));
				
				System.out.println("PresidenteConsiglioDidattico trovato.");
				rs.close();
				ps.close();
				con.close();
				return presidenteConsiglioDidattico;
			}
			else{
				System.out.println("PresidenteConsiglioDidattico non presente nel database.");
				rs.close();
				ps.close();
				con.close();
			
				return null;
			}
			
		}*/
		
		
		private static final String CARICA_PF_PCD = "SELECT * FROM progetto_formativo WHERE approvazioneRa='1' AND firmaPcd='0' AND confermaUst='0' AND annullato='0'";
		public static ArrayList<ProgettoFormativo> caricaProgettiFormativi() throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(CARICA_PF_PCD);

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
	
		
		private static final String CARICA_PF_FIRMATI_PCD = "SELECT * FROM progetto_formativo WHERE firmaPcd='1'";
		public static ArrayList<ProgettoFormativo> caricaProgettiFormativiFirmati() throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(CARICA_PF_FIRMATI_PCD);

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
		
		
		private static final String FIRMA_PF_PCD = "UPDATE progetto_formativo SET firmaPcd='1' WHERE idProgettoFormativo=? AND approvazioneRa='1' AND firmaPcd='0' AND confermaUst='0'";			
		public static void firmaPF(int idProgettoFormativo) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(FIRMA_PF_PCD);
			
			ps.setInt(1, idProgettoFormativo);
			
			ps.executeUpdate();
			ps.close();
			con.close();
		}
}
