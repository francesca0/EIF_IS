package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domainClasses.ProgettoFormativo;
import utility.ConnectionManager;

public class ProgettoFormativoDCS {

	public ProgettoFormativoDCS() {}
	
	private static final String CARICA_PROGETTO_FORMATIVO_BY_MATRICOLA= "SELECT * FROM progetto_formativo WHERE matricolaStudente=?";
	public static ProgettoFormativo loadByMatricola(String matricolaStudente) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_PROGETTO_FORMATIVO_BY_MATRICOLA);
		ps.setString(1, matricolaStudente);
		
		rs = ps.executeQuery();
		
		if(rs.next()){
			
			ProgettoFormativo progettoFormativo = new ProgettoFormativo();
			
			progettoFormativo.setIdProgettoFormativo(rs.getInt("idProgettoFormativo"));
			progettoFormativo.setMatricolaStudente(rs.getString("matricolaStudente"));
			progettoFormativo.setIdTutorAziendale(rs.getInt("idTutorAziendale"));
			progettoFormativo.setIdTirocinio(rs.getInt("idTirocinio"));
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
			
			rs.close();
			ps.close();
			con.close();
			
			return progettoFormativo;		
		}
		else{
		
		
		rs.close();
		ps.close();
		con.close();
		
		return null;
		}
	}
	
	
	/*private static final String GET_LAST_ID_PROGETTO_FORMATIVO = "select (auto_increment-1) as lastId	from information_schema.tables where table_name = 'progetto_formativo' and table_schema = 'isdb'";	
	public static int getLastIdProgettoFormativo() throws ClassNotFoundException, SQLException{
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(GET_LAST_ID_PROGETTO_FORMATIVO);
			rs = ps.executeQuery();
			int lastId=-1;
			if(rs.next()){
				lastId=rs.getInt("lastId");
				
			}
			
			rs.close();
			ps.close();
			con.close();
			
			return lastId;
		}*/
}
