package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dcs.ConnectionManager;
import domainClasses.ProgettoFormativo;
import domainClasses.Ufficio;

public class UfficioDAO {

public UfficioDAO(){
		
	}
	
private static final String INSERT_SQL = "INSERT INTO ufficio VALUES(?, ?, ?, ?)";
	
	public static void insert(Ufficio ufficio) throws ClassNotFoundException, SQLException{
			
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INSERT_SQL);
		
		ps.setString(1, ufficio.getIdUfficio());
		ps.setString(2, ufficio.getEmail());
		ps.setString(3, ufficio.getPassword());
		ps.setInt(4, ufficio.getTipoAccount());
	
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	private static final String FIND_BY_ID = "SELECT * FROM ufficio WHERE idUfficio=?";
	
	public static void load(Ufficio ufficio) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_ID);
		
		ps.setString(1, ufficio.getIdUfficio());
		rs = ps.executeQuery();
		rs.next();

		ufficio.setIdUfficio(rs.getString("idUfficio"));
		ufficio.setEmail(rs.getString("email"));
		ufficio.setPassword(rs.getString("password"));
		ufficio.setTipoAccount(rs.getInt("tipoAccount"));
	
		rs.close();
		ps.close();
		con.close();
		
	}
	
	private static final String UPDATE_BY_ID = "UPDATE ufficio SET email=?, password=?, tipoAccount=? WHERE idUfficio=?";
	
	public static void update(Ufficio ufficio) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(UPDATE_BY_ID);
		
		ps.setString(4, ufficio.getIdUfficio());
		ps.setString(1, ufficio.getEmail());
		ps.setString(2, ufficio.getPassword());
		ps.setInt(3, ufficio.getTipoAccount());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM ufficio WHERE idUfficio=?";
	
	public static void delete(Ufficio ufficio) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(DELETE_BY_ID);
		
		ps.setString(1, ufficio.getIdUfficio());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String FIND_BY_EMAIL = "SELECT * FROM ufficio WHERE email=?";
	
	public static Ufficio findAllByEmail(Ufficio ufficio) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(FIND_BY_EMAIL);
		
		ps.setString(1, ufficio.getEmail());
		rs = ps.executeQuery();
		rs.next();
		
		ufficio.setIdUfficio(rs.getString("idUfficio"));
		ufficio.setEmail(rs.getString("email"));
		ufficio.setPassword(rs.getString("password"));
		ufficio.setTipoAccount(rs.getInt("tipoAccount"));
		
		rs.close();
		ps.close();
		con.close();
		
		return ufficio;
	}
	
	private static final String VISUALIZZA_PF = "SELECT * FROM progetto_formativo WHERE approvazioneRa='1' AND confermaUst='0'";
	
	public static ArrayList<ProgettoFormativo> visualizzaPf() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(VISUALIZZA_PF);
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
	
	private static final String CONFERMA_PF = "UPDATE progetto_formativo SET confermaUst='1' WHERE idProgettoFormativo=? AND approvazioneRa='1' AND firmaTaz='1' AND firmaTac='1' AND (firmaDd='1' OR firmaPcd='1') AND confermaUst='0' AND annullato='0' AND rifiutato='0'";
	
	public static void confermaPf(ProgettoFormativo progettoFormativo) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CONFERMA_PF);
		
		ps.setString(1, progettoFormativo.getIdProgettoFormativo());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String ANNULLA_PF = "UPDATE progetto_formativo SET annullato='1' WHERE approvazioneRa='1' AND firmaTaz='1' AND firmaTac='1' AND (firmaDd='1' OR firmaPcd='1') AND confermaUst='0' AND rifiutato='0' AND annullato='0' AND idProgettoFormativo=?";

	public static void annullaPf(ProgettoFormativo progettoFormativo) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(ANNULLA_PF);
		
		ps.setString(1, progettoFormativo.getIdProgettoFormativo());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	private static final String VISIONA_PF = "SELECT * FROM progetto_formativo WHERE confermaUst='1'";
	
	public static ArrayList<ProgettoFormativo> visionaPf() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(VISIONA_PF);

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
