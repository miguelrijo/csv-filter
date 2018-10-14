package model;

import java.util.Comparator;

import model.entities.Record;

public class DeparmentComparator implements Comparator<Record> {

	/* it is used to compare department with the purpose of sorting records */
	
	public int compare(Record firstRecord, Record seconRecord) {
		int result = (firstRecord.getDepartment().toLowerCase())
				.compareTo(seconRecord.getDepartment().toLowerCase());
		return result;
	}

}