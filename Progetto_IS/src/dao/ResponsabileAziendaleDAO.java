package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dcs.ConnectionManager;
import domainClasses.ResponsabileAziendale;

public class ResponsabileAziendaleDAO {

private ResponsabileAziendaleDAO(){
		
	}
	
	private static final String INSERT_SQL = "INSERT INTO responsabile_aziendale VALUES(?, ?, ?, ?, ?, ?, ?)";
	
	public static void insert(ResponsabileAziendale responsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setString(1, responsabileAziendale.getIdResponsabileAziendale());
		ps.setString(2, responsabileAziendale.getNome());
		ps.setString(3, responsabileAziendale.getCognome());
		ps.setString(4, responsabileAziendale.getAziendaRa());
		ps.setString(5, responsabileAziendale.getEmail());
		ps.setString(6, responsabileAziendale.getPassword());
		ps.setInt(7, responsabileAziendale.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM responsabile_aziendale WHERE idResponsabileAziendale=?";
	
	public static void load(ResponsabileAziendale responsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setString(1, responsabileAziendale.getIdResponsabileAziendale());
		rs = ps.executeQuery();
		rs.next();

		responsabileAziendale.setIdResponsabileAziendale(rs.getString("idResponsabileAziendale"));
		responsabileAziendale.setNome(rs.getString("nome"));
		responsabileAziendale.setCognome(rs.getString("cognome"));
		responsabileAziendale.setAziendaRa(rs.getString("aziendaRa"));
		responsabileAziendale.setEmail(rs.getString("email"));
		responsabileAziendale.setPassword(rs.getString("password"));
		responsabileAziendale.setTipoAccount(rs.getInt("tipoAccount"));
		
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE responsabile_aziendale SET nome=?, cognome=?, aziendaRa=?, email=?, password=?, tipoAccount=?  WHERE idResponsabileAziendale=?";
	
	public static void update(ResponsabileAziendale responsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setString(7, responsabileAziendale.getIdResponsabileAziendale());
		ps.setString(1, responsabileAziendale.getNome());
		ps.setString(2, responsabileAziendale.getCognome());
		ps.setString(3, responsabileAziendale.getAziendaRa());
		ps.setString(4, responsabileAziendale.getEmail());
		ps.setString(5, responsabileAziendale.getPassword());
		ps.setInt(6, responsabileAziendale.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM responsabile_aziendale WHERE idResponsabileAziendale=?";
	
	public static void delete(ResponsabileAziendale responsabileAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		ps.setString(1, responsabileAziendale.getIdResponsabileAziendale());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}

}
