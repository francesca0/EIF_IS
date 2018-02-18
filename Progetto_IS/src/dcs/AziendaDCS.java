package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domainClasses.Azienda;
import utility.ConnectionManager;

public class AziendaDCS {

	public AziendaDCS(){}
	
	private static final String CARICA_AZIENDA_BY_ID = "SELECT * FROM azienda WHERE idAzienda=?";	
	public static Azienda caricaAzienda(int idAzienda) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_AZIENDA_BY_ID);
		
		ps.setInt(1, idAzienda);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			Azienda azienda= new Azienda();
			
			azienda.setIdAzienda(rs.getInt("idAzienda"));
			azienda.setNomeAzienda(rs.getString("nomeAzienda"));
			azienda.setIndirizzoAzienda(rs.getString("indirizzoAzienda"));
			azienda.setLocalitaAzienda(rs.getString("localitaAzienda"));
			
			rs.close();
			ps.close();
			con.close();
			
			return azienda;
		}
		else {
			rs.close();
			ps.close();
			con.close();
			return null;
		}
	}
	
		private static final String CARICA_TUTTE_LE_AZIENDE = "SELECT * FROM azienda";
		public static ArrayList<Azienda> loadAll() throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Azienda> list = new ArrayList<Azienda>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_TUTTE_LE_AZIENDE);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Azienda azienda= new Azienda();
			
			azienda.setIdAzienda(rs.getInt("idAzienda"));
			azienda.setNomeAzienda(rs.getString("nomeAzienda"));
			azienda.setIndirizzoAzienda(rs.getString("indirizzoAzienda"));
			azienda.setLocalitaAzienda(rs.getString("localitaAzienda"));
		
			list.add(azienda);
		}
		
		rs.close();
		ps.close();
		con.close();
		return list;
	}
		
		private static final String CARICA_AZIENDA_RICERCA_NOME = "SELECT * FROM azienda WHERE nomeAzienda like ?";
		public static ArrayList<Azienda> caricaAziendeDaNome(String nomeAzienda) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Azienda> list = new ArrayList<Azienda>();
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_AZIENDA_RICERCA_NOME);


		ps.setString(1, "%"+nomeAzienda+"%");

		rs = ps.executeQuery();
		
		while(rs.next()) {
			Azienda azienda= new Azienda();
			
			azienda.setIdAzienda(rs.getInt("idAzienda"));
			azienda.setNomeAzienda(rs.getString("nomeAzienda"));
			azienda.setIndirizzoAzienda(rs.getString("indirizzoAzienda"));
			azienda.setLocalitaAzienda(rs.getString("localitaAzienda"));
		
			list.add(azienda);
		}
		
		rs.close();
		ps.close();
		con.close();
		return list;
	}
		
		private static final String CARICA_AZIENDA_RICERCA_LOCALITA = "SELECT * FROM azienda WHERE localitaAzienda like ?";
		public static ArrayList<Azienda> caricaAziendeDaLocalita(String localitaAzienda) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Azienda> list = new ArrayList<Azienda>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_AZIENDA_RICERCA_LOCALITA);
		
		ps.setString(1, "%"+localitaAzienda+"%");
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Azienda azienda= new Azienda();
			
			azienda.setIdAzienda(rs.getInt("idAzienda"));
			azienda.setNomeAzienda(rs.getString("nomeAzienda"));
			azienda.setIndirizzoAzienda(rs.getString("indirizzoAzienda"));
			azienda.setLocalitaAzienda(rs.getString("localitaAzienda"));
		
			list.add(azienda);
		}
		
		rs.close();
		ps.close();
		con.close();
		return list;
	}
		
		private static final String CARICA_AZIENDA_RICERCA_NOME_E_LOCALITA = "SELECT * FROM azienda WHERE nomeAzienda like ? AND localitaAzienda like ?";
		public static ArrayList<Azienda> caricaAziendeDaNomeELocalita(String nomeAzienda, String localitaAzienda) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Azienda> list = new ArrayList<Azienda>();
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(CARICA_AZIENDA_RICERCA_NOME_E_LOCALITA);

		ps.setString(1, "%"+nomeAzienda+"%");
		ps.setString(2, "%"+localitaAzienda+"%");
		rs = ps.executeQuery();
		
		Azienda azienda=null;
		
		while(rs.next()) {
			azienda= new Azienda();
			
			azienda.setIdAzienda(rs.getInt("idAzienda"));
			azienda.setNomeAzienda(rs.getString("nomeAzienda"));
			azienda.setIndirizzoAzienda(rs.getString("indirizzoAzienda"));
			azienda.setLocalitaAzienda(rs.getString("localitaAzienda"));
		
			list.add(azienda);
		}
		rs.close();
		ps.close();
		con.close();
		return list;
	}
		
}
