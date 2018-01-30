package dcs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProgettoFormativoDCS {

	public ProgettoFormativoDCS() {}

	private static final String INVIO_PROGETTO_FORMATIVO= "SELECT * FROM tirocinio WHERE idResponsabileAziendale IN(SELECT idResponsabileAziendale FROM responsabile_aziendale WHERE idAzienda=?)";
	public static void inviaProgettoFormativo(int idAzienda) throws ClassNotFoundException, SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		con = ConnectionManager.getConnection();
		ps = con.prepareStatement(INVIO_PROGETTO_FORMATIVO);
		ps.setInt(1, idAzienda);
		
		ps.executeUpdate();
				
		ps.close();
		con.close();
		
	}
}
