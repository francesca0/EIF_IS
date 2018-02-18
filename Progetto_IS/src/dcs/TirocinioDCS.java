package dcs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domainClasses.Tirocinio;
import utility.ConnectionManager;

public class TirocinioDCS {

	public TirocinioDCS(){}
	
	private static final String CARICA_TIROCINI_RICERCA_DATA= "SELECT * FROM tirocinio WHERE dataInizio BETWEEN ? AND ?";
	public static ArrayList<Tirocinio> caricaTirociniRicerca(Date dataInizio, Date dataFine) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Tirocinio> list = new ArrayList<Tirocinio>();
		
		// DATA INIZIO E DATA FINE DEVONO AVERE QUESTO FORMATO String s = "aaaa/mm/gg";
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_TIROCINI_RICERCA_DATA);
		ps.setDate(1, dataInizio);
		ps.setDate(2, dataFine);
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			Tirocinio tirocinio = new Tirocinio();
			
			tirocinio.setIdTirocinio(rs.getInt("idTirocinio"));
			tirocinio.setIdResponsabileAziendale(rs.getInt("idResponsabileAziendale"));
			tirocinio.setIdTutorAziendale(rs.getInt("idTutorAziendale"));
			tirocinio.setDescrizione(rs.getString("descrizione"));
			tirocinio.setTematica(rs.getString("tematica"));
			tirocinio.setNote(rs.getString("note"));
			tirocinio.setDataInizio(rs.getDate("dataInizio"));
			tirocinio.setDataFine(rs.getDate("dataFine"));
			tirocinio.setTotaleOre(rs.getInt("totaleOre"));
			tirocinio.setNumeroMesi(rs.getInt("numeroMesi"));
			
			list.add(tirocinio);	
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return list;
	}
	
	
	private static final String CARICA_TIROCINI_DA_AZIENDA= "SELECT * FROM tirocinio WHERE idResponsabileAziendale IN(SELECT idResponsabileAziendale FROM responsabile_aziendale WHERE idAzienda=?)";
	public static ArrayList<Tirocinio> caricaTirociniDaAzienda(int idAzienda) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Tirocinio> list = new ArrayList<Tirocinio>();
		
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_TIROCINI_DA_AZIENDA);
		ps.setInt(1, idAzienda);
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			Tirocinio tirocinio = new Tirocinio();
			
			tirocinio.setIdTirocinio(rs.getInt("idTirocinio"));
			tirocinio.setIdResponsabileAziendale(rs.getInt("idResponsabileAziendale"));
			tirocinio.setIdTutorAziendale(rs.getInt("idTutorAziendale"));
			tirocinio.setDescrizione(rs.getString("descrizione"));
			tirocinio.setTematica(rs.getString("tematica"));
			tirocinio.setNote(rs.getString("note"));
			tirocinio.setDataInizio(rs.getDate("dataInizio"));
			tirocinio.setDataFine(rs.getDate("dataFine"));
			tirocinio.setTotaleOre(rs.getInt("totaleOre"));
			tirocinio.setNumeroMesi(rs.getInt("numeroMesi"));
			
			list.add(tirocinio);	
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return list;
	}
	
	
private static final String GET_LAST_ID_TIROCINIO = "select (auto_increment-1) as lastId	from information_schema.tables where table_name = 'tirocinio' and table_schema = 'isdb'";	
public static int getLastIdTirocinio() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(GET_LAST_ID_TIROCINIO);
		rs = ps.executeQuery();
		int lastId=-1;
		if(rs.next()){
			lastId=rs.getInt("lastId");
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return lastId;
	}
	


}
