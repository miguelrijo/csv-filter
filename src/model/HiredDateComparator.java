package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import model.entities.Record;



public class HiredDateComparator implements Comparator<Record> {
	private Date secondDate = null;
	private Date firstDate = null;

	/* it is used to compare hiredDate with the purpose of sorting records */
	
	public int compare(Record firstRecord, Record secondRecord) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.firstDate = dateFormat.parse(firstRecord.getHiredDate());
			this.secondDate = dateFormat.parse(secondRecord.getHiredDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result = firstDate.compareTo(secondDate);
		return result;
	}
}