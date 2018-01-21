package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dcs.ConnectionManager;
import domainClasses.ProgettoFormativo;
import domainClasses.TutorAccademico;

public class TutorAccademicoDAO {

	public TutorAccademicoDAO(){
			
		}
		
	private static final String INSERT_SQL = "INSERT INTO tutor_accademico VALUES(?, ?, ?, ?, ?, ?)";
		
		public static void insert(TutorAccademico tutorAccademico) throws ClassNotFoundException, SQLException{
				
			Connection con = null;
			PreparedStatement ps = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(INSERT_SQL);
			
			ps.setString(1, tutorAccademico.getIdTutorAccademico());
			ps.setString(2, tutorAccademico.getNome());
			ps.setString(3, tutorAccademico.getCognome());
			ps.setString(4, tutorAccademico.getEmail());
			ps.setString(5, tutorAccademico.getPassword());
			ps.setInt(6, tutorAccademico.getTipoAccount());
		
			ps.executeUpdate();
			ps.close();
			con.close();
		}
		
		private static final String FIND_BY_ID = "SELECT * FROM tutor_accademico WHERE idTutorAccademico=?";
		
		public static void load(TutorAccademico tutorAccademico) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(FIND_BY_ID);
			
			ps.setString(1, tutorAccademico.getIdTutorAccademico());
			rs = ps.executeQuery();
			rs.next();

			tutorAccademico.setIdTutorAccademico(rs.getString("idTutorAccademico"));
			tutorAccademico.setNome(rs.getString("nome"));
			tutorAccademico.setCognome(rs.getString("cognome"));
			tutorAccademico.setEmail(rs.getString("email"));
			tutorAccademico.setPassword(rs.getString("password"));
			tutorAccademico.setTipoAccount(rs.getInt("tipoAccount"));
		
			rs.close();
			ps.close();
			con.close();
			
		}
		
		private static final String UPDATE_BY_ID = "UPDATE tutor_accademico SET nome=?, cognome=?, email=?, password=?, tipoAccount=? WHERE idTutorAccademico=?";
		
		public static void update(TutorAccademico tutorAccademico) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(UPDATE_BY_ID);
			
			ps.setString(6, tutorAccademico.getIdTutorAccademico());
			ps.setString(1, tutorAccademico.getNome());
			ps.setString(2, tutorAccademico.getCognome());
			ps.setString(3, tutorAccademico.getEmail());
			ps.setString(4, tutorAccademico.getPassword());
			ps.setInt(5, tutorAccademico.getTipoAccount());
			
			ps.executeUpdate();
			ps.close();
			con.close();
			
		}
		
		private static final String DELETE_BY_ID = "DELETE FROM tutor_accademico WHERE idTutorAccademico=?";
		
		public static void delete(TutorAccademico tutorAccademico) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(DELETE_BY_ID);
			
			ps.setString(1, tutorAccademico.getIdTutorAccademico());
			
			ps.executeUpdate();
			ps.close();
			con.close();
			
		}
		
		private static final String FIND_ALL = "SELECT * FROM tutor_accademico";
		
		public static  ArrayList<TutorAccademico> findAll() throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<TutorAccademico> list = new ArrayList<TutorAccademico>();
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(FIND_ALL);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
			TutorAccademico tutorAccademico = new TutorAccademico();
		
			tutorAccademico.setIdTutorAccademico(rs.getString("idTutorAccademico"));
			tutorAccademico.setNome(rs.getString("nome"));
			tutorAccademico.setCognome(rs.getString("cognome"));
			tutorAccademico.setEmail(rs.getString("email"));
			tutorAccademico.setPassword(rs.getString("password"));
			tutorAccademico.setTipoAccount(rs.getInt("tipoAccount"));
			
			list.add(tutorAccademico);	
		
			}
			
			rs.close();
			ps.close();
			con.close();
			
			return list;
		}
		
		
		private static final String FIND_BY_EMAIL = "SELECT * FROM tutor_accademico WHERE email=?";
		
		public static TutorAccademico findAllByEmail(TutorAccademico tutorAccademico) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(FIND_BY_EMAIL);
			
			ps.setString(1, tutorAccademico.getEmail());
			rs = ps.executeQuery();
			rs.next();
			
			tutorAccademico.setIdTutorAccademico(rs.getString("idTutorAccademico"));
			tutorAccademico.setNome(rs.getString("nome"));
			tutorAccademico.setCognome(rs.getString("cognome"));
			tutorAccademico.setEmail(rs.getString("email"));
			tutorAccademico.setPassword(rs.getString("password"));
			tutorAccademico.setTipoAccount(rs.getInt("tipoAccount"));
			
			rs.close();
			ps.close();
			con.close();
			
			return tutorAccademico;
		}
		
		private static final String VISUALIZZA_PF = "SELECT * FROM progetto_formativo WHERE approvazioneRa='1' AND firmaTac='0' AND idTac=?";
		
		public static ArrayList<ProgettoFormativo> visualizzaPf(TutorAccademico tutorAccademico) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(VISUALIZZA_PF);
			ps.setString(1, tutorAccademico.getIdTutorAccademico());
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

		private static final String FIRMA_PF = "UPDATE progetto_formativo SET firmaTac='1' WHERE idProgettoFormativo=? AND approvazioneRa='1' AND firmaTac='0' AND idTac=?";
		
		public static void firmaPf(ProgettoFormativo progettoFormativo, TutorAccademico tutorAccademico) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(FIRMA_PF);
			
			ps.setString(1, progettoFormativo.getIdProgettoFormativo());
			ps.setString(2, tutorAccademico.getIdTutorAccademico());
			
			ps.executeUpdate();
			ps.close();
			con.close();
			
		}
		
		private static final String VISIONA_PF = "SELECT * FROM progetto_formativo WHERE firmaTac='1' AND idTac=?";
		
		public static ArrayList<ProgettoFormativo> visionaPf(TutorAccademico tutorAccademico) throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			//TutorAccademico tutorAccademico = new TutorAccademico();
			ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
			
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(VISIONA_PF);
			ps.setString(1, tutorAccademico.getIdTutorAccademico());
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
}
