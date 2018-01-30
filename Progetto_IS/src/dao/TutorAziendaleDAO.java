package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dcs.ConnectionManager;
import domainClasses.TutorAziendale;

public class TutorAziendaleDAO {

	public TutorAziendaleDAO(){
		
	}
	
private static final String INSERT_SQL = "INSERT INTO tutor_aziendale VALUES(?, ?, ?, ?, ?, ?)";
	
	public static void insert(TutorAziendale tutorAziendale) throws ClassNotFoundException, SQLException{
			
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setInt(1, tutorAziendale.getIdTutorAziendale());
		ps.setString(2, tutorAziendale.getNome());
		ps.setString(3, tutorAziendale.getCognome());
		ps.setString(4, tutorAziendale.getEmail());
		ps.setString(5, tutorAziendale.getPassword());
		ps.setInt(6, tutorAziendale.getTipoAccount());
	
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM tutor_aziendale WHERE idTutorAziendale=?";
	
	public static void load(TutorAziendale tutorAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setInt(1, tutorAziendale.getIdTutorAziendale());
		rs = ps.executeQuery();
		rs.next();

		tutorAziendale.setIdTutorAziendale(rs.getInt("idTutorAziendale"));
		tutorAziendale.setNome(rs.getString("nome"));
		tutorAziendale.setCognome(rs.getString("cognome"));
		tutorAziendale.setEmail(rs.getString("email"));
		tutorAziendale.setPassword(rs.getString("password"));
		tutorAziendale.setTipoAccount(rs.getInt("tipoAccount"));
	
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE tutor_aziendale SET nome=?, cognome=?, email=?, password=?, tipoAccount=? WHERE idTutorAziendale=?";
	
	public static void update(TutorAziendale tutorAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setInt(6, tutorAziendale.getIdTutorAziendale());
		ps.setString(1, tutorAziendale.getNome());
		ps.setString(2, tutorAziendale.getCognome());
		ps.setString(3, tutorAziendale.getEmail());
		ps.setString(4, tutorAziendale.getPassword());
		ps.setInt(5, tutorAziendale.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM tutor_aziendale WHERE idTutorAziendale=?";
	
	public static void delete(TutorAziendale tutorAziendale) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		ps.setInt(1, tutorAziendale.getIdTutorAziendale());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
}
