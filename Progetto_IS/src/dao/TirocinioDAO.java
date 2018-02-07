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
	
private static final String INSERT_SQL = "INSERT INTO tirocinio VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static void insert(Tirocinio tirocinio) throws ClassNotFoundException, SQLException{
			
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);

		ps.setInt(1, tirocinio.getIdResponsabileAziendale());
		ps.setInt(2, tirocinio.getIdTutorAziendale());
		ps.setString(3, tirocinio.getDescrizione());
		ps.setString(4, tirocinio.getTematica());
		ps.setString(5, tirocinio.getNote());
		ps.setDate(6, tirocinio.getDataInizio());
		ps.setDate(7, tirocinio.getDataFine());
		ps.setInt(8, tirocinio.getTotaleOre());
		ps.setInt(9, tirocinio.getNumeroMesi());
		
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
		
		ps.setInt(1, tirocinio.getIdTirocinio());
		rs = ps.executeQuery();
		if(rs.next()){

		tirocinio.setIdTirocinio(rs.getInt("idTirocinio"));
		tirocinio.setIdResponsabileAziendale(rs.getInt("idResponsabileAziendale"));
		tirocinio.setIdTutorAziendale(rs.getInt("idTutorAziendale"));
		tirocinio.setDescrizione(rs.getString("descrizione"));
		tirocinio.setTematica(rs.getString("tematica"));
		tirocinio.setNote(rs.getString("note"));
		tirocinio.setDataInizio(rs.getDate("dataInizio"));
		tirocinio.setDataFine(rs.getDate("dataFine"));
		tirocinio.setTotaleOre(rs.getInt("totaleOre"));
		tirocinio.setNumeroMesi(rs.getInt("numeroMesi"));
		}
		
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE tirocinio SET idResponsabileAziendale=?, idTutorAziendale=?, descrizione=?, tematica=?, note=?, dataInizio=?, dataFine=?, totaleOre=?, numeroMesi=?  WHERE idTirocinio=?";
	
	public static void update(Tirocinio tirocinio) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setInt(10, tirocinio.getIdTirocinio());
		ps.setInt(1, tirocinio.getIdResponsabileAziendale());
		ps.setInt(2, tirocinio.getIdTutorAziendale());
		ps.setString(3, tirocinio.getDescrizione());
		ps.setString(4, tirocinio.getTematica());
		ps.setString(5, tirocinio.getNote());
		ps.setDate(6, tirocinio.getDataInizio());
		ps.setDate(7, tirocinio.getDataFine());
		ps.setInt(8, tirocinio.getTotaleOre());
		ps.setInt(9, tirocinio.getNumeroMesi());
		
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
		
		ps.setInt(1, tirocinio.getIdTirocinio());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	
}
