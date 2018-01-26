package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dcs.ConnectionManager;
import domainClasses.PresidenteConsiglioDidattico;


public class PresidenteConsiglioDidatticoDAO {

	public PresidenteConsiglioDidatticoDAO() {
		
	}
	
private static final String INSERT_SQL = "INSERT INTO presidente_consiglio_didattico VALUES(?, ?, ?, ?, ?, ?)";
	
	public static void insert(PresidenteConsiglioDidattico presidenteConsiglioDidattico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setString(1, presidenteConsiglioDidattico.getIdPresidenteConsiglioDidattico());
		ps.setString(2, presidenteConsiglioDidattico.getNome());
		ps.setString(3, presidenteConsiglioDidattico.getCognome());
		ps.setString(4, presidenteConsiglioDidattico.getEmail());
		ps.setString(5, presidenteConsiglioDidattico.getPassword());
		ps.setInt(6, presidenteConsiglioDidattico.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM presidente_consiglio_didattico WHERE idPresidenteConsiglioDidattico=?";
	
	public static void load(PresidenteConsiglioDidattico presidenteConsiglioDidattico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setString(1, presidenteConsiglioDidattico.getIdPresidenteConsiglioDidattico());
		rs = ps.executeQuery();
		rs.next();

		presidenteConsiglioDidattico.setIdPresidenteConsiglioDidattico(rs.getString("idPresidenteConsiglioDidattico"));
		presidenteConsiglioDidattico.setNome(rs.getString("nome"));
		presidenteConsiglioDidattico.setCognome(rs.getString("cognome"));
		presidenteConsiglioDidattico.setEmail(rs.getString("email"));
		presidenteConsiglioDidattico.setPassword(rs.getString("password"));
		presidenteConsiglioDidattico.setTipoAccount(rs.getInt("tipoAccount"));
		
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE presidente_consiglio_didattico SET nome=?, cognome=?, email=?, password=?, tipoAccount=?  WHERE idPresidenteConsiglioDidattico=?";
	
	public static void update(PresidenteConsiglioDidattico presidenteConsiglioDidattico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setString(6, presidenteConsiglioDidattico.getIdPresidenteConsiglioDidattico());
		ps.setString(1, presidenteConsiglioDidattico.getNome());
		ps.setString(2, presidenteConsiglioDidattico.getCognome());
		ps.setString(3, presidenteConsiglioDidattico.getEmail());
		ps.setString(4, presidenteConsiglioDidattico.getPassword());
		ps.setInt(5, presidenteConsiglioDidattico.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM presidente_consiglio_didattico WHERE idPresidenteConsiglioDidattico=?";
	
	public static void delete(PresidenteConsiglioDidattico presidenteConsiglioDidattico) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		ps.setString(1, presidenteConsiglioDidattico.getIdPresidenteConsiglioDidattico());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	
	
}
