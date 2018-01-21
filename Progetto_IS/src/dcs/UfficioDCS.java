package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
}
