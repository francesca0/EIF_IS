package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domainClasses.DirettoreDipartimento;
import utility.ConnectionManager;


public class DirettoreDipartimentoDAO {

	public DirettoreDipartimentoDAO(){
		
	}
	
	private static final String INSERT_SQL = "INSERT INTO direttore_dipartimento VALUES(?, ?, ?, ?, ?, ?)";
	
	public static void insert(DirettoreDipartimento direttoreDipartimento) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setString(1, direttoreDipartimento.getIdDirettoreDipartimento());
		ps.setString(2, direttoreDipartimento.getNome());
		ps.setString(3, direttoreDipartimento.getCognome());
		ps.setString(4, direttoreDipartimento.getEmail());
		ps.setString(5, direttoreDipartimento.getPassword());
		ps.setInt(6, direttoreDipartimento.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM direttore_dipartimento WHERE idDirettoreDipartimento=?";
	
	public static void load(DirettoreDipartimento direttoreDipartimento) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setString(1, direttoreDipartimento.getIdDirettoreDipartimento());
		rs = ps.executeQuery();
		if(rs.next()){

		direttoreDipartimento.setIdDirettoreDipartimento(rs.getString("idDirettoreDipartimento"));
		direttoreDipartimento.setNome(rs.getString("nome"));
		direttoreDipartimento.setCognome(rs.getString("cognome"));
		direttoreDipartimento.setEmail(rs.getString("email"));
		direttoreDipartimento.setPassword(rs.getString("password"));
		direttoreDipartimento.setTipoAccount(rs.getInt("tipoAccount"));
		}
		
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE direttore_dipartimento SET nome=?, cognome=?, email=?, password=?, tipoAccount=?  WHERE idDirettoreDipartimento=?";
	
	public static void update(DirettoreDipartimento direttoreDipartimento) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setString(6, direttoreDipartimento.getIdDirettoreDipartimento());
		ps.setString(1, direttoreDipartimento.getNome());
		ps.setString(2, direttoreDipartimento.getCognome());
		ps.setString(3, direttoreDipartimento.getEmail());
		ps.setString(4, direttoreDipartimento.getPassword());
		ps.setInt(5, direttoreDipartimento.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM direttore_dipartimento WHERE idDirettoreDipartimento=?";
	
	public static void delete(DirettoreDipartimento direttoreDipartimento) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		
		ps.setString(1, direttoreDipartimento.getIdDirettoreDipartimento());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
}