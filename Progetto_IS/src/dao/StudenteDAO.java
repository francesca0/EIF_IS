package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dcs.ConnectionManager;
import domainClasses.Studente;

public class StudenteDAO{

	public StudenteDAO(){
		
	}
	
private static final String INSERT_SQL = "INSERT INTO studente VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static void insert(Studente studente) throws ClassNotFoundException, SQLException{
			
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setString(1, studente.getMatricolaStudente());
		ps.setString(2, studente.getNome());
		ps.setString(3, studente.getCognome());	
		ps.setDate(4, studente.getDataDiNascita());
		ps.setString(5, studente.getLuogoDiNascita());
		ps.setString(6, studente.getResidenza());
		ps.setString(7, studente.getTelefono());
		ps.setString(8, studente.getMatricolaTutorAccademico());
		ps.setString(9, studente.getEmail());
		ps.setString(10, studente.getPassword());
		ps.setInt(11, studente.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM studente WHERE matricolaStudente=?";
	
	public static void load(Studente studente) throws ClassNotFoundException, SQLException{
		
		Connection con = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setString(1, studente.getMatricolaStudente());
		rs = ps.executeQuery();
		if(rs.next()){

		studente.setMatricolaStudente(rs.getString("matricolaStudente"));
		studente.setNome(rs.getString("nome"));
		studente.setCognome(rs.getString("cognome"));	
		studente.setDataDiNascita(rs.getDate("dataDiNascita"));
		studente.setLuogoDiNascita(rs.getString("luogoDiNascita"));
		studente.setResidenza(rs.getString("residenza"));
		studente.setTelefono(rs.getString("telefono"));
		studente.setMatricolaTutorAccademico(rs.getString("matricolaTutorAccademico"));
		studente.setEmail(rs.getString("email"));
		studente.setPassword(rs.getString("password"));
		studente.setTipoAccount(rs.getInt("tipoAccount"));
		}
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE studente SET nome=?, cognome=?, dataDiNascita=?, luogoDiNascita=?, residenza=?, telefono=?, matricolaTutorAccademico=?, email=?, password=?, tipoAccount=?  WHERE matricolaStudente=?";
	
	public static void update(Studente studente) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setString(11, studente.getMatricolaStudente());
		ps.setString(1, studente.getNome());
		ps.setString(2, studente.getCognome());
		ps.setDate(3, studente.getDataDiNascita());
		ps.setString(4, studente.getLuogoDiNascita());
		ps.setString(5, studente.getResidenza());
		ps.setString(6, studente.getTelefono());
		ps.setString(7, studente.getMatricolaTutorAccademico());
		ps.setString(8, studente.getEmail());
		ps.setString(9, studente.getPassword());
		ps.setInt(10, studente.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM studente WHERE matricolaStudente=?";
	
	public static void delete(Studente studente) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		ps.setString(1, studente.getMatricolaStudente());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
}
