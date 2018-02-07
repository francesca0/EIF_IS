package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dcs.ConnectionManager;
import domainClasses.Azienda;

public class AziendaDAO {

	public AziendaDAO(){
		
	}
	
	private static final String INSERT_SQL = "INSERT INTO azienda VALUES(?, ?, ?, ?)";
	
	public static void insert(Azienda azienda) throws ClassNotFoundException, SQLException{
			
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setInt(1, azienda.getIdAzienda());
		ps.setString(2, azienda.getNomeAzienda());
		ps.setString(3, azienda.getIndirizzoAzienda());
		ps.setString(4, azienda.getLocalitaAzienda());
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM azienda WHERE idAzienda=?";
	
	public static void load(Azienda azienda) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setInt(1, azienda.getIdAzienda());
		rs = ps.executeQuery();
		
		if(rs.next()){

		azienda.setIdAzienda(rs.getInt("idAzienda"));
		azienda.setNomeAzienda(rs.getString("nomeAzienda"));
		azienda.setIndirizzoAzienda(rs.getString("indirizzoAzienda"));
		azienda.setLocalitaAzienda(rs.getString("localitaAzienda"));
		}
		
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE azienda SET nomeAzienda=?, indirizzoAzienda=?, localitaAzienda=?  WHERE idAzienda=?";
	
	public static void update(Azienda azienda) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setInt(4, azienda.getIdAzienda());
		ps.setString(1, azienda.getNomeAzienda());
		ps.setString(2, azienda.getIndirizzoAzienda());
		ps.setString(3, azienda.getLocalitaAzienda());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM azienda WHERE idAzienda=?";
	
	public static void delete(Azienda azienda) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		ps.setInt(1, azienda.getIdAzienda());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
}
