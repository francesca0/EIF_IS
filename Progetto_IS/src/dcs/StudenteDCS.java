 package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domainClasses.ProgettoFormativo;
import domainClasses.Studente;

public class StudenteDCS {

	public StudenteDCS(){}
	
		private static final String FIND_BY_EMAIL = "SELECT * FROM studente WHERE email=?";
		
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
		}
		
		private static final String VISIONA_PF = "SELECT * FROM progetto_formativo WHERE matricolaStudente=? AND annullato='0' AND rifiutato='0'";
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
		
	
}
