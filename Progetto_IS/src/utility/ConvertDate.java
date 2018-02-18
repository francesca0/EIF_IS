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
	
	public static boolean checkValidDate(String input){
		if (input.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")){
		    return true;
		}
		else{
		   return false;
		}
	}
		
}
