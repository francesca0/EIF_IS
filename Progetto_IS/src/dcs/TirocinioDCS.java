package dcs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domainClasses.Tirocinio;

public class TirocinioDCS {

	public TirocinioDCS(){}
	
	private static final String CARICA_TIROCINI_RICERCA_DATA= "SELECT * FROM tirocinio WHERE dataInizio BETWEEN >= ? AND ?";
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
			
			tirocinio.setIdTirocinio(rs.getString("idTirocinio"));
			tirocinio.setIdResponsabileAziendaleTrc(rs.getString("idResponsabileAziendaleTrc"));
			tirocinio.setIdTutorAziendale(rs.getString("idTutorAziendale"));
			tirocinio.setDescrizione(rs.getString("descrizione"));
			tirocinio.setTematica(rs.getString("tematica"));
			tirocinio.setNote(rs.getString("note"));
			tirocinio.setDataInizio(rs.getDate("dataInizio"));
			tirocinio.setDataFine(rs.getDate("dataFine"));
			
			list.add(tirocinio);	
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return list;
	}
	
	
	private static final String CARICA_TIROCINI_DA_AZIENDA= "SELECT * FROM tirocinio WHERE idResponsabileAziendaleTrc IN(SELECT idResponsabileAziendale FROM responsabile_aziendale WHERE aziendaRa=?)";
	public static ArrayList<Tirocinio> caricaTirociniDaAzienda(String idAzienda) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Tirocinio> list = new ArrayList<Tirocinio>();
		
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_TIROCINI_DA_AZIENDA);
		ps.setString(1, idAzienda);
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			Tirocinio tirocinio = new Tirocinio();
			
			tirocinio.setIdTirocinio(rs.getString("idTirocinio"));
			tirocinio.setIdResponsabileAziendaleTrc(rs.getString("idResponsabileAziendaleTrc"));
			tirocinio.setIdTutorAziendale(rs.getString("idTutorAziendale"));
			tirocinio.setDescrizione(rs.getString("descrizione"));
			tirocinio.setTematica(rs.getString("tematica"));
			tirocinio.setNote(rs.getString("note"));
			tirocinio.setDataInizio(rs.getDate("dataInizio"));
			tirocinio.setDataFine(rs.getDate("dataFine"));
			
			list.add(tirocinio);	
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return list;
	}
	
}
