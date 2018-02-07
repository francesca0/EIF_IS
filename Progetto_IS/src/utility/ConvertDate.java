package utility;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertDate {

	ConvertDate(){}
	
	public static Date convertStringToDate(String dataDaConvertire) {
		java.util.Date utilDate=null;
		java.sql.Date dataConvertita=null;
		
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dataDaConvertire); //Nella stringa c'è il pattern che utilizza il sito
			dataConvertita = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date data=dataConvertita;
		return data;
	}
	
	public static String convertDateToString(Date dataDaConvertire) {
			
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
			String data = df.format(dataDaConvertire);  
			return data;
	}
		
}
