package modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	
	private static final SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
	
	public DateTime() {
		
	}
	
	
	public DateTime(String date) throws ParseException {
		this();
		this.date = sdf.parse(date);
	}

	public String getDate() {
		return sdf.format(date);
	}

	public void setDate(String date) throws ParseException {
		this.date = sdf.parse(date);
	}

	
}
