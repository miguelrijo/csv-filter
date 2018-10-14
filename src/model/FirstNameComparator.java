package model;

import java.util.Comparator;
import model.entities.Record;

public class FirstNameComparator implements Comparator<Record> {

	/* it is used to compare firstName with the purpose of sorting records */
	
	public int compare(Record firstRecord, Record seconRecord) {
		int result = (firstRecord.getFirstName().toLowerCase())
				.compareTo(seconRecord.getFirstName().toLowerCase());
		return result;
	}

}
