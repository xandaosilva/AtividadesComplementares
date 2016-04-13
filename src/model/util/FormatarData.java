package model.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatarData extends Exception{

	private static final long serialVersionUID = 1L;
	
	private Date data;
	
	public FormatarData(Date data) {
		this.data = data;
	}
	
	public Date formatar(Date data) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		this.data = sdf.parse(sdf.format(data));
		return this.data;
	}
}