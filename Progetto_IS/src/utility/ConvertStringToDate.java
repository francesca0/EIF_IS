package utility;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertStringToDate {

	ConvertStringToDate(){}
	
	public static Date convert(String dataDaConvertire) {
		java.util.Date utilDate=null;
		java.sql.Date dataConvertita=null;
		
		try {
			utilDate = new SimpleDateFormat("dd MM yyyy").parse(dataDaConvertire); //Nella stringa c'è il pattern che utilizza il sito
			dataConvertita = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date dataDiNascita=dataConvertita;
		return dataDiNascita;
	}
	
}
