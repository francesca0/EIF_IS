package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dcs.ConnectionManager;
import domainClasses.Ufficio;

public class UfficioDAO {

public UfficioDAO(){
		
	}
	
private static final String INSERT_SQL = "INSERT INTO ufficio VALUES(?, ?, ?, ?)";
	
	public static void insert(Ufficio ufficio) throws ClassNotFoundException, SQLException{
			
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setString(1, ufficio.getIdUfficio());
		ps.setString(2, ufficio.getEmail());
		ps.setString(3, ufficio.getPassword());
		ps.setInt(4, ufficio.getTipoAccount());
	
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM ufficio WHERE idUfficio=?";
	
	public static void load(Ufficio ufficio) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setString(1, ufficio.getIdUfficio());
		rs = ps.executeQuery();
		rs.next();

		ufficio.setIdUfficio(rs.getString("idUfficio"));
		ufficio.setEmail(rs.getString("email"));
		ufficio.setPassword(rs.getString("password"));
		ufficio.setTipoAccount(rs.getInt("tipoAccount"));
	
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE ufficio SET email=?, password=?, tipoAccount=? WHERE idUfficio=?";
	
	public static void update(Ufficio ufficio) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setString(4, ufficio.getIdUfficio());
		ps.setString(1, ufficio.getEmail());
		ps.setString(2, ufficio.getPassword());
		ps.setInt(3, ufficio.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM ufficio WHERE idUfficio=?";
	
	public static void delete(Ufficio ufficio) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		ps.setString(1, ufficio.getIdUfficio());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}

}
