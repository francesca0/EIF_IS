package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		ps.setString(2, tirocinio.getIdResponsabile());
		ps.setString(3, tirocinio.getIdTutorAziendale());
		ps.setString(4, tirocinio.getDescrizione());
		ps.setString(5, tirocinio.getTematica());
		ps.setString(6, tirocinio.getNote());
		ps.setString(7, tirocinio.getDataInizio());
		ps.setString(8, tirocinio.getDataFine());
	
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
		tirocinio.setIdResponsabile(rs.getString("idResponsabile"));
		tirocinio.setIdTutorAziendale(rs.getString("idTutorAziendale"));
		tirocinio.setDescrizione(rs.getString("descrizione"));
		tirocinio.setTematica(rs.getString("tematica"));
		tirocinio.setNote(rs.getString("note"));
		tirocinio.setDataInizio(rs.getString("dataInizio"));
		tirocinio.setDataFine(rs.getString("dataFine"));
	
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE tirocinio SET idResponsabile=?, idTutorAziendale=?, descrizione=?, tematica=?, note=?, dataInizio=?, dataFine=?  WHERE idTirocinio=?";
	
	public static void update(Tirocinio tirocinio) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setString(8, tirocinio.getIdTirocinio());
		ps.setString(1, tirocinio.getIdResponsabile());
		ps.setString(2, tirocinio.getIdTutorAziendale());
		ps.setString(3, tirocinio.getDescrizione());
		ps.setString(4, tirocinio.getTematica());
		ps.setString(5, tirocinio.getNote());
		ps.setString(6, tirocinio.getDataInizio());
		ps.setString(7, tirocinio.getDataFine());
		
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
	
	private static final String FIND_ALL= "SELECT * FROM tirocinio";
	
	public static ArrayList<Tirocinio> findAll() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Tirocinio> list = new ArrayList<Tirocinio>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_ALL);
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			Tirocinio tirocinio = new Tirocinio();
			
			tirocinio.setIdTirocinio(rs.getString("idTirocinio"));
			tirocinio.setIdResponsabile(rs.getString("idResponsabile"));
			tirocinio.setIdTutorAziendale(rs.getString("idTutorAziendale"));
			tirocinio.setDescrizione(rs.getString("descrizione"));
			tirocinio.setTematica(rs.getString("tematica"));
			tirocinio.setNote(rs.getString("note"));
			tirocinio.setDataInizio(rs.getString("dataInizio"));
			tirocinio.setDataFine(rs.getString("dataFine"));
			
			list.add(tirocinio);	
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return list;
	}
}
