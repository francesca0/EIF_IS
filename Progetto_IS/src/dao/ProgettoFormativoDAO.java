package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dcs.ConnectionManager;
import domainClasses.ProgettoFormativo;

public class ProgettoFormativoDAO {

	public ProgettoFormativoDAO() {
	}
	
private static final String INSERT_SQL = "INSERT INTO progetto_formativo VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static void insert(ProgettoFormativo progettoFormativo) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setInt(1, progettoFormativo.getIdProgettoFormativo());
		ps.setString(2, progettoFormativo.getMatricolaStudente());
		ps.setInt(3, progettoFormativo.getIdTirocinio());
		ps.setInt(4, progettoFormativo.getIdTutorAziendale());
		ps.setInt(5, progettoFormativo.getIdResponsabileAziendale());
		ps.setString(6, progettoFormativo.getMatricolaTutorAccademico());
		ps.setInt(9, progettoFormativo.getFirmaTaz());
		ps.setInt(10, progettoFormativo.getApprovazioneRa());
		ps.setInt(11, progettoFormativo.getFirmaTac());
		ps.setInt(12, progettoFormativo.getFirmaDd());
		ps.setInt(13, progettoFormativo.getFirmaPcd());
		ps.setInt(14, progettoFormativo.getConfermaUst());
		ps.setString(15, progettoFormativo.getNomeFile());
		ps.setInt(16, progettoFormativo.getRifiutato());
		ps.setInt(17, progettoFormativo.getAnnullato());

		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM progetto_formativo WHERE idProgettoFormativo=?";
	
	public static void load(ProgettoFormativo progettoFormativo) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setInt(1, progettoFormativo.getIdProgettoFormativo());
		rs = ps.executeQuery();
		if(rs.next()){

		progettoFormativo.setIdProgettoFormativo(rs.getInt("idProgettoFormativo"));
		progettoFormativo.setMatricolaStudente(rs.getString("matricolaStudente"));
		progettoFormativo.setIdTirocinio(rs.getInt("idTirocinio"));
		progettoFormativo.setIdTutorAziendale(rs.getInt("idTutorAziendale"));
		progettoFormativo.setIdResponsabileAziendale(rs.getInt("idResponsabileAziendale"));
		progettoFormativo.setMatricolaTutorAccademico(rs.getString("matricolaTutorAccademico"));
		progettoFormativo.setFirmaTaz(rs.getInt("firmaTaz"));
		progettoFormativo.setApprovazioneRa(rs.getInt("approvazioneRa"));
		progettoFormativo.setFirmaTac(rs.getInt("firmaTac"));
		progettoFormativo.setFirmaDd(rs.getInt("firmaDd"));
		progettoFormativo.setFirmaPcd(rs.getInt("firmaPcd"));
		progettoFormativo.setConfermaUst(rs.getInt("confermaUst"));
		progettoFormativo.setNomeFile(rs.getString("nomeFile"));
		progettoFormativo.setRifiutato(rs.getInt("rifiutato"));
		progettoFormativo.setAnnullato(rs.getInt("annullato"));
		
		}
		
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE progetto_formativo SET matricolaStudente=?, idTirocinio=?, idTutorAziendale=?, idResponsabileAziendale=?, matricolaTutorAccademico=?, firmaTaz=?, approvazioneRa=?, firmaTac=?, firmaDd=?, firmaPcd=?, confermaUst=?, nomeFile=?, rifiutato=?, annullato=? WHERE idProgettoFormativo=?";
	
	public static void update(ProgettoFormativo progettoFormativo) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setInt(15, progettoFormativo.getIdProgettoFormativo());
		ps.setString(1, progettoFormativo.getMatricolaStudente());
		ps.setInt(2, progettoFormativo.getIdTirocinio());
		ps.setInt(3, progettoFormativo.getIdTutorAziendale());
		ps.setInt(4, progettoFormativo.getIdResponsabileAziendale());
		ps.setString(5, progettoFormativo.getMatricolaTutorAccademico());
		ps.setInt(8, progettoFormativo.getFirmaTaz());
		ps.setInt(9, progettoFormativo.getApprovazioneRa());
		ps.setInt(10, progettoFormativo.getFirmaTac());
		ps.setInt(11, progettoFormativo.getConfermaUst());
		ps.setString(12, progettoFormativo.getNomeFile());
		ps.setInt(13, progettoFormativo.getRifiutato());
		ps.setInt(14, progettoFormativo.getAnnullato());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM progetto_formativo WHERE idProgettoFormativo=?";
	
	public static void delete(ProgettoFormativo progettoFormativo) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		ps.setInt(1, progettoFormativo.getIdProgettoFormativo());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	
}
