package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domainClasses.TutorAccademico;
import utility.ConnectionManager;

public class TutorAccademicoDAO {

	public TutorAccademicoDAO(){
			
		}
		
	private static final String INSERT_SQL = "INSERT INTO tutor_accademico VALUES(?, ?, ?, ?, ?, ?)";
		
		public static void insert(TutorAccademico tutorAccademico) throws ClassNotFoundException, SQLException{
				
			Connection con = null;
			PreparedStatement ps = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(INSERT_SQL);
			
			ps.setString(1, tutorAccademico.getMatricolaTutorAccademico());
			ps.setString(2, tutorAccademico.getNome());
			ps.setString(3, tutorAccademico.getCognome());
			ps.setString(4, tutorAccademico.getEmail());
			ps.setString(5, tutorAccademico.getPassword());
			ps.setInt(6, tutorAccademico.getTipoAccount());
		
			ps.executeUpdate();
			ps.close();
			con.close();
		}
		
		private static final String FIND_BY_ID = "SELECT * FROM tutor_accademico WHERE matricolaTutorAccademico=?";
		
		public static void load(TutorAccademico tutorAccademico) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(FIND_BY_ID);
			
			ps.setString(1, tutorAccademico.getMatricolaTutorAccademico());
			rs = ps.executeQuery();
			if(rs.next()){

			tutorAccademico.setMatricolaTutorAccademico(rs.getString("matricolaTutorAccademico"));
			tutorAccademico.setNome(rs.getString("nome"));
			tutorAccademico.setCognome(rs.getString("cognome"));
			tutorAccademico.setEmail(rs.getString("email"));
			tutorAccademico.setPassword(rs.getString("password"));
			tutorAccademico.setTipoAccount(rs.getInt("tipoAccount"));
			
			}
			
			rs.close();
			ps.close();
			con.close();
			
		}
		
		private static final String UPDATE_BY_ID = "UPDATE tutor_accademico SET nome=?, cognome=?, email=?, password=?, tipoAccount=? WHERE matricolaTutorAccademico=?";
		
		public static void update(TutorAccademico tutorAccademico) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(UPDATE_BY_ID);
			
			ps.setString(6, tutorAccademico.getMatricolaTutorAccademico());
			ps.setString(1, tutorAccademico.getNome());
			ps.setString(2, tutorAccademico.getCognome());
			ps.setString(3, tutorAccademico.getEmail());
			ps.setString(4, tutorAccademico.getPassword());
			ps.setInt(5, tutorAccademico.getTipoAccount());
			
			ps.executeUpdate();
			ps.close();
			con.close();
			
		}
		
		private static final String DELETE_BY_ID = "DELETE FROM tutor_accademico WHERE matricolaTutorAccademico=?";
		
		public static void delete(TutorAccademico tutorAccademico) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(DELETE_BY_ID);
			
			ps.setString(1, tutorAccademico.getMatricolaTutorAccademico());
			
			ps.executeUpdate();
			ps.close();
			con.close();
			
		}
		
}
