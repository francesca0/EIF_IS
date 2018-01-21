package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domainClasses.ResponsabileAziendale;

public class ResponsabileAziendaleDCS {

	public ResponsabileAziendaleDCS(){}
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM responsabileAziendale WHERE email=?";
	
	public static ResponsabileAziendale loadByEmail(String email) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_EMAIL);
		ps.setString(1, email);
		rs = ps.executeQuery();
		
		
		if(rs.next()){
		ResponsabileAziendale responsabileAziendale = new ResponsabileAziendale();
		
		responsabileAziendale.setIdResponsabile(rs.getString("idResponsabile")); //PK
		responsabileAziendale.setNome(rs.getString("nome"));
		responsabileAziendale.setCognome(rs.getString("cognome"));
		responsabileAziendale.setPassword(rs.getString("password"));
		responsabileAziendale.setTipoAccount(rs.getInt("tipoAccount"));
		
		System.out.println("ResponsabileAziendale trovato.");
		rs.close();
		ps.close();
		con.close();
		return responsabileAziendale;
		}
		else{
		System.out.println("ResponsabileAziendale non presente nel database.");
		rs.close();
		ps.close();
		con.close();
	
		return null;
		}
	}
}
