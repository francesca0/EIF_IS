package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dcs.ConnectionManager;
import domainClasses.Tirocinio;

public class TirocinioDAO {

public TirocinioDAO(){
		
	}
	
private static final String INSERT_SQL = "INSERT INTO tirocinio VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static void insert(Tirocinio tirocinio) throws ClassNotFoundException, SQLException{
			
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setString(1, tirocinio.getIdTirocinio());
		ps.setString(2, tirocinio.getIdResponsabileAziendaleTrc());
		ps.setString(3, tirocinio.getIdTutorAziendale());
		ps.setString(4, tirocinio.getDescrizione());
		ps.setString(5, tirocinio.getTematica());
		ps.setString(6, tirocinio.getNote());
		ps.setDate(7, tirocinio.getDataInizio());
		ps.setDate(8, tirocinio.getDataFine());
	
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM tirocinio WHERE idTirocinio=?";
	
	public static void load(Tirocinio tirocinio) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setString(1, tirocinio.getIdTirocinio());
		rs = ps.executeQuery();
		rs.next();

		tirocinio.setIdTirocinio(rs.getString("idTirocinio"));
		tirocinio.setIdResponsabileAziendaleTrc(rs.getString("idResponsabileAziendaleTrc"));
		tirocinio.setIdTutorAziendale(rs.getString("idTutorAziendale"));
		tirocinio.setDescrizione(rs.getString("descrizione"));
		tirocinio.setTematica(rs.getString("tematica"));
		tirocinio.setNote(rs.getString("note"));
		tirocinio.setDataInizio(rs.getDate("dataInizio"));
		tirocinio.setDataFine(rs.getDate("dataFine"));
	
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE tirocinio SET idResponsabileAziendaleTrc=?, idTutorAziendale=?, descrizione=?, tematica=?, note=?, dataInizio=?, dataFine=?  WHERE idTirocinio=?";
	
	public static void update(Tirocinio tirocinio) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setString(8, tirocinio.getIdTirocinio());
		ps.setString(1, tirocinio.getIdResponsabileAziendaleTrc());
		ps.setString(2, tirocinio.getIdTutorAziendale());
		ps.setString(3, tirocinio.getDescrizione());
		ps.setString(4, tirocinio.getTematica());
		ps.setString(5, tirocinio.getNote());
		ps.setDate(6, tirocinio.getDataInizio());
		ps.setDate(7, tirocinio.getDataFine());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM tirocinio WHERE idTirocinio=?";
	
	public static void delete(Tirocinio tirocinio) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		ps.setString(1, tirocinio.getIdTirocinio());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	
}
