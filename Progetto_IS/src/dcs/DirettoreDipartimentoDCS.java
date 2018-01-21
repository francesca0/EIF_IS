package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domainClasses.DirettoreDipartimento;

public class DirettoreDipartimentoDCS {

	public DirettoreDipartimentoDCS(){}
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM direttoreDipartimento WHERE email=?";
	
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
		
		direttoreDipartimento.setIdDirettore(rs.getString("idDirettore"));
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
	
}
