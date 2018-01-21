 package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
}
