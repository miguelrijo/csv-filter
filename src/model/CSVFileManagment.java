package model;

import java.util.ArrayList;
import java.util.Collections;

import model.entities.Record;

/**
 * This class is responsible of sending String arrays to CSVWriter class and
 * CSVReader class
 * 
 * @author Miguel Rijo
 * 
 */

public class CSVFileManagment {

	private CSVReader reader = null;
	private CSVWriter writer = null;
	private Record record;
	private ArrayList<Record> recordsAll = null;
	private ArrayList<Record> acceptedRecords = null;
	private ArrayList<Record> rejectedRecords = null;
	private ArrayList<String[]> lines = null;
	private String[] line = null;
	private boolean successful;
	private String relativePathAcceptedFile = "test/AcceptedCSVFiles/";
	private String relativePathRejectedFile = "test/RejectedCSVFiles/";

	/* this method runs the methods involved in the filter Program */

	public boolean startCVSProcess(String inputFilePath,
			String OutputAcceptedFileName, String outputRejectedFileName,
			int mainAtributeIndex) {

		this.writer = new CSVWriter();
		boolean isReadable = filterCSVArray(fileToRecordArray(inputFilePath,
				","));
		this.sortArray(mainAtributeIndex);
		boolean hasBeenWrittenA = writer.stringArrayListToFile( 
				recordArrayListToStringArrayList(this.acceptedRecords, 5),
				relativePathAcceptedFile + OutputAcceptedFileName, ".txt", "",
				"", true);
		boolean hasBeenWrittenF = writer.stringArrayListToFile(
				recordArrayListToStringArrayList(this.rejectedRecords, 5),
				relativePathRejectedFile + outputRejectedFileName, ".txt", ",",
				"\"", false);

		successful = (!isReadable || !hasBeenWrittenA || !hasBeenWrittenF) ? false
				: true;

		return successful;
	}

	/*
	 * This method extracts from a CSV file values ​​(using the method of the
	 * object reader called readArchive)
	 * 
	 * @returns an array with already loaded records called recordsAll
	 */

	private ArrayList<Record> fileToRecordArray(String fileCSVName,
			String delimiter) {
		this.recordsAll = new ArrayList<Record>();
		reader = new CSVReader();
		lines = reader.readArchive(fileCSVName, delimiter);

		for (String[] line : lines) {
			record = new Record();
			if (line.length < 4)
				record.setReasonForRejection("Not enough columns ");
			if (line.length > 0)
				record.setLastName(line[0].trim());
			if (line.length > 1)
				record.setFirstName(line[1].trim());
			if (line.length > 2)
				record.setHiredDate(line[2].trim());
			if (line.length > 3)
				record.setDepartment(line[3].trim());
			recordsAll.add(record);
		}

		return recordsAll;
	}

	/*
	 * This method filters out the matrix elements recordsAll and separating
	 * them into two arrays: rejectedRecords and acceptedRecords according to
	 * the result of the validation process. Returns a boolean depending of the
	 * process success
	 */

	private boolean filterCSVArray(ArrayList<Record> recordsAll) {
		if (recordsAll == null) {
			return false;
		}
		this.acceptedRecords = new ArrayList<Record>();
		this.rejectedRecords = new ArrayList<Record>();

		for (Record record : recordsAll) {
			validateEachValue(record, record.getLastName(), 0);
			validateEachValue(record, record.getFirstName(), 1);
			validateEachValue(record, record.getHiredDate(), 2);

			if (record.isValidated()) {
				this.acceptedRecords.add(record);
				record
						.setLastName(String.format("%-40s", record
								.getLastName()));
				record.setFirstName(String.format("%-30s", record
						.getFirstName()));
				record.setHiredDate(String.format("%-10s", record
						.getHiredDate()));
				record.setDepartment(String.format("%-20s", record
						.getDepartment()));
			} else {
				this.rejectedRecords.add(record);
			}
		}
		return true;
	}

	/*
	 * This method sorts the elements inside of the acceptedRecords array taking
	 * as reference the main Attribute that can
	 * be0-LastName,1-FirstName,2-Department and 3-hiredDate
	 */

	private void sortArray(int mainAtributeIndex) {
		switch (mainAtributeIndex) {
		case 0:
			Collections.sort(this.acceptedRecords, new LastNameComparator());
			break;
		case 1:
			Collections.sort(this.acceptedRecords, new FirstNameComparator());
			break;
		case 2:
			Collections.sort(this.acceptedRecords, new DeparmentComparator());
			break;
		case 3:
			Collections.sort(this.acceptedRecords, new HiredDateComparator());
			break;

		default:
			break;
		}

	}

	/*
	 * This method is responsible for passing the values ​​of the array of
	 * records to an array of strings that will be returned by this method
	 */
	private ArrayList<String[]> recordArrayListToStringArrayList(
			ArrayList<Record> records, int valuesCountsPerLine) {
		this.lines = new ArrayList<String[]>();
		for (Record record : records) {
			this.line = new String[valuesCountsPerLine];
			line[0] = record.getLastName();
			line[1] = record.getFirstName();
			line[2] = record.getHiredDate();
			line[3] = record.getDepartment();
			if (!record.isValidated())
				line[4] = record.getReasonForRejection();
			lines.add(line);
		}

		return lines;
	}

	/*
	 * This method has as input parameter to a register and a value of this and
	 * its function is to validate the value and return the modified record
	 */

	private Record validateEachValue(Record record, String value, int type) {
		switch (type) {
		case 0:
			if (!Validator.verifyLenghtOfString(3, value)) {
				record.setReasonForRejection("Invalid LastName");
			}

			break;
		case 1:
			if (!Validator.verifyLenghtOfString(1, value)) {
				record.setReasonForRejection("Invalid Name");
			}
			break;

		case 2:
			if (!Validator.verifyPattern(Validator.DATEPATTERN, value)
					|| !Validator.verifyDate(value)) {
				record.setReasonForRejection("Invalid Date");
			}
			break;
		default:
			break;
		}
		return record;
	}

}
