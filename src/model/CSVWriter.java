package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This class is responsible for everything related to writing CSV files
 * 
 * @author Miguel Rijo
 * 
 */

public class CSVWriter {
	private PrintWriter printWriter = null;
	private FileWriter fileWriter = null;

	/*
	 * This method writes a new file or overwrite one with the String array
	 * called lines .
	 * 
	 * @parameters: String array lines (the matrix with the lines to be
	 * written), String relativePathFile (this is the CSVFile's path),String
	 * fileExtension, String delimiter (example: comma(,) ) Returns a boolean
	 * depending of the process success.
	 * 
	 * @throws IOException
	 */

	public boolean stringArrayListToFile(ArrayList<String[]> lines,
			String relativePathFile, String fileExtension, String delimiter,
			String qualifier, boolean validate) {
		try {
			this.fileWriter = new FileWriter(relativePathFile + fileExtension);
			this.printWriter = new PrintWriter(fileWriter);
			for (String[] lineValues : lines) {
				String line = valuesToLine(lineValues, qualifier, delimiter,
						validate);
				printWriter.write(line);
				printWriter.println();
			}
			
		} catch (IOException e) {
			return false;
		}finally{
			// by this way no matter if an exception occurs, the object is
			// closed
			this.printWriter.close();
		}
		return true;
	}

	/*
	 * This method is responsible for concatenating the values ​of a record into
	 * a line and return it
	 */
	
	private String valuesToLine(String[] lineValues, String qualifier,
			String delimiter, boolean validate) {
		String line = qualifier + lineValues[0] + qualifier;
		line += delimiter + qualifier + lineValues[1] + qualifier;
		line += delimiter + qualifier + lineValues[2] + qualifier;
		line += delimiter + qualifier + lineValues[3] + qualifier;
		if (!validate) {
			line += delimiter + qualifier + lineValues[4] + qualifier;
		}
		return line;
	}
}
