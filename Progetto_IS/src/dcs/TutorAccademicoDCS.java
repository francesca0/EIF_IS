package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
