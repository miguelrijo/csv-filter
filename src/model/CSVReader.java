package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is responsible for everything related to reading CSV files
 * 
 * @author Miguel Rijo
 * 
 */

public class CSVReader {

	private BufferedReader bufferReader = null;
	private FileReader fileReader = null;
	private String line = null;
	private ArrayList<String[]> lines = null;

	/*
	 * This method extracts the comma separated values ​from a CSV file and save
	 * them in a String array called lines which is returned by this method
	 * 
	 * @throws FileNotFoundException,IOException
	 */
	public ArrayList<String[]> readArchive(String inputFileName,
			String delimiter) {
		try {
			lines = new ArrayList<String[]>();
			File archivo = new File(inputFileName);
			fileReader = new FileReader(archivo);
			bufferReader = new BufferedReader(fileReader);
			line = bufferReader.readLine();
			while (line != null) {
				line = line.replace("\"", "");
				lines.add(line.split(delimiter));
				line = bufferReader.readLine();

			}

		} catch (FileNotFoundException s) {
			s.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// by this way no matter if an exception occurs, the object is
				// closed
				bufferReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lines;
	}

}
