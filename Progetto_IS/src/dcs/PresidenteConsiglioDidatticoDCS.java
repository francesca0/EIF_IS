package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domainClasses.PresidenteConsiglioDidattico;

public class PresidenteConsiglioDidatticoDCS {

	public PresidenteConsiglioDidatticoDCS(){}
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM presidenteConsiglioDidattico WHERE email=?";
	
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
		
		presidenteConsiglioDidattico.setIdPresidente(rs.getString("idPresidente")); //PK
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
	}
	
}
