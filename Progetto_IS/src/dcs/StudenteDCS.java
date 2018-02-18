 package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domainClasses.ProgettoFormativo;
import utility.ConnectionManager;

public class StudenteDCS {

	public StudenteDCS(){}
	
		private static final String GET_KEY_BY_EMAIL = "SELECT matricolaStudente FROM studente WHERE email=?";
		
		public static String getKeyByEmail(String email) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(GET_KEY_BY_EMAIL);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			
			if(rs.next()){
			String matricolaStudente = rs.getString("matricolaStudente"); //PK
			
			System.out.println("Studente trovato.");
			
				rs.close();
				ps.close();
				con.close();
				
				return matricolaStudente;
			}
			else{
				System.out.println("Studente non presente nel database.");
				rs.close();
				ps.close();
				con.close();
		
				return null;
			}
		}
	
		/*private static final String FIND_BY_EMAIL = "SELECT * FROM studente WHERE email=?";
		
		public static Studente loadByEmail(String email) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(FIND_BY_EMAIL);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			
			if(rs.next()){
			Studente studente = new Studente();
			
			studente.setMatricolaStudente(rs.getString("matricolaStudente")); //PK
			studente.setNome(rs.getString("nome"));
			studente.setCognome(rs.getString("cognome"));
			studente.setPassword(rs.getString("password"));
			studente.setTipoAccount(rs.getInt("tipoAccount"));
			
			System.out.println("Studente trovato.");
			
				rs.close();
				ps.close();
				con.close();
				
				return studente;
			}
			else{
				System.out.println("Studente non presente nel database.");
				rs.close();
				ps.close();
				con.close();
		
				return null;
			}
		}*/
		
		private static final String VISIONA_PF = "SELECT * FROM progetto_formativo WHERE matricolaStudente=?";
		public static ProgettoFormativo caricaProgettoFormativo(String matricolaStudente) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(VISIONA_PF);
			ps.setString(1, matricolaStudente);
			rs = ps.executeQuery();
			
			if(rs.next()){
				
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
				
				rs.close();
				ps.close();
				con.close();
				return progettoFormativo;
			}
			else {
				rs.close();
				ps.close();
				con.close();
				return null;
			}
			
		}
		
		private static final String CHECK_EXISTENCE_EMAIL = "SELECT * FROM studente WHERE email=?";	
		public static boolean emailExists(String email) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(CHECK_EXISTENCE_EMAIL);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			
			if(rs.next()){
				System.out.println("Email studente presente nel database.");
				rs.close();
				ps.close();
				con.close();
				return true;
			}
			else{
					System.out.println("Email studente non presente nel database.");
					rs.close();
					ps.close();
					con.close();
					return false;
			}
		}
		
		private static final String CHECK_EXISTENCE_MATRICOLA = "SELECT * FROM studente WHERE matricolaStudente=?";	
		public static boolean matricolaExists(String matricola) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(CHECK_EXISTENCE_MATRICOLA);
			ps.setString(1, matricola);
			rs = ps.executeQuery();
			
			
			if(rs.next()){
				System.out.println("Matricola studente presente nel database.");
				rs.close();
				ps.close();
				con.close();
				return true;
			}
			else{
					System.out.println("Matricola studente non presente nel database.");
					rs.close();
					ps.close();
					con.close();
					return false;
			}
		}
		
	
}
