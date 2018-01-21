package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
