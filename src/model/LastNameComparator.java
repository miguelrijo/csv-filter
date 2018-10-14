package model;

import java.util.Comparator;

import model.entities.Record;



public class LastNameComparator implements Comparator<Record> {

	/* it is used to compare lastName with the purpose of sorting records */

	public int compare(Record firstRecord, Record seconRecord) {
		int result = (firstRecord.getLastName().toLowerCase())
				.compareTo(seconRecord.getLastName().toLowerCase());
		return result;
	}

}