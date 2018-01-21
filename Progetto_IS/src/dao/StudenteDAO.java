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
		
		ps.setString(1, studente.getNome());
		ps.setString(2, studente.getCognome());
		ps.setString(3, studente.getMatricolaStudente());
		ps.setString(4, studente.getDataDiNascita());
		ps.setString(5, studente.getLuogoDiNascita());
		ps.setString(6, studente.getResidenza());
		ps.setString(7, studente.getTelefono());
		ps.setString(8, studente.getTutorAccademico());
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
		rs.next();

		studente.setNome(rs.getString("nome"));
		studente.setCognome(rs.getString("cognome"));
		studente.setMatricolaStudente(rs.getString("matricolaStudente"));
		studente.setDataDiNascita(rs.getString("dataDiNascita"));
		studente.setLuogoDiNascita(rs.getString("luogoDiNascita"));
		studente.setResidenza(rs.getString("residenza"));
		studente.setTelefono(rs.getString("telefono"));
		studente.setTutorAccademico(rs.getString("tutorAccademico"));
		studente.setEmail(rs.getString("email"));
		studente.setPassword(rs.getString("password"));
		studente.setTipoAccount(rs.getInt("tipoAccount"));
	
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE studente SET nome=?, cognome=?, dataDiNascita=?, luogoDiNascita=?, residenza=?, telefono=?, tutorAccademico=?, email=?, password=?, tipoAccount=?  WHERE matricolaStudente=?";
	
	public static void update(Studente studente) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setString(11, studente.getMatricolaStudente());
		ps.setString(1, studente.getNome());
		ps.setString(2, studente.getCognome());
		ps.setString(3, studente.getDataDiNascita());
		ps.setString(4, studente.getLuogoDiNascita());
		ps.setString(5, studente.getResidenza());
		ps.setString(6, studente.getTelefono());
		ps.setString(7, studente.getTutorAccademico());
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
	
	/*
	private static final String FIND_ALL = "SELECT * FROM studente";
	
	public static ArrayList<Studente> findAll() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Studente> list = new ArrayList<Studente>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_ALL);
		rs = ps.executeQuery();

		while(rs.next()){
			
			Studente studente = new Studente();
			
			studente.setNome(rs.getString("nome"));
			studente.setCognome(rs.getString("cognome"));
			studente.setMatricolaStudente(rs.getString("matricolaStudente"));
			studente.setDataDiNascita(rs.getString("dataDiNascita"));
			studente.setLuogoDiNascita(rs.getString("luogoDiNascita"));
			studente.setResidenza(rs.getString("residenza"));
			studente.setTelefono(rs.getString("telefono"));
			studente.setTutorAccademico(rs.getString("tutorAccademico"));
			studente.setEmail(rs.getString("email"));
			studente.setPassword(rs.getString("password"));
			studente.setTipoAccount(rs.getInt("tipoAccount"));
		
			list.add(studente);	

		}
		
		rs.close();
		ps.close();
		con.close();
	
		return list;
	}
	*/
	
	
	
	/*
	private static final String VISIONA_PF = "SELECT * FROM progetto_formativo WHERE matricolaStudente=?";
	
	public static ArrayList<ProgettoFormativo> visionaPf(Studente studente) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//Studente studente = new Studente();
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(VISIONA_PF);
		ps.setString(1, studente.getMatricolaStudente());
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			ProgettoFormativo progettoFormativo = new ProgettoFormativo();
			
			progettoFormativo.setIdProgettoFormativo(rs.getString("idProgettoFormativo"));
			progettoFormativo.setMatricolaStudente(rs.getString("matricolaStudente"));
			progettoFormativo.setIdTaz(rs.getString("idTaz"));
			progettoFormativo.setIdTirocinio(rs.getString("idTirocinio"));
			progettoFormativo.setIdRa(rs.getString("idRa"));
			progettoFormativo.setIdTac(rs.getString("idTac"));
			progettoFormativo.setIdDd(rs.getString("idDd"));
			progettoFormativo.setIdPcd(rs.getString("idPcd"));
			progettoFormativo.setFirmaTaz(rs.getInt("firmaTaz"));
			progettoFormativo.setApprovazioneRa(rs.getInt("approvazioneRa"));
			progettoFormativo.setFirmaTac(rs.getInt("firmaTac"));
			progettoFormativo.setFirmaDd(rs.getInt("firmaDd"));
			progettoFormativo.setFirmaPcd(rs.getInt("firmaPcd"));
			progettoFormativo.setConfermaUst(rs.getInt("confermaUst"));
			progettoFormativo.setNomeFile(rs.getString("nomeFile"));
			progettoFormativo.setRifiutato(rs.getInt("rifiutato"));
			progettoFormativo.setAnnullato(rs.getInt("annullato"));
			
			list.add(progettoFormativo);
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return list;
	}
	*/
}
