

import java.io.File;

/**
 * This class is responsible of the CSVFilterManagment Class test 
 * @author Miguel Rijo
 */

import junit.framework.Assert;
import junit.framework.TestCase;
import model.CSVFileManagment;

public class TestCSVFilterManagment extends TestCase {
	private CSVFileManagment cSVFileManagment = null;

	protected void setUp() throws Exception {
		this.cSVFileManagment = new CSVFileManagment();
		super.setUp();
	}

	/*
	 * This method tests the method startCVSProcess and validates if it creates 
	 * files outputAcceptedFile and outputRejectedFile
	 */

	public void testStartCVSProcess() {
		cSVFileManagment.startCVSProcess("test/Original/test.txt",
				"outputAcceptedFile", "outputRejectedFile", 1);
		File outputAcceptedFile = new File(
				"test/AcceptedCSVFiles/outputAcceptedFile.txt");
		File outputRejectedFile = new File(
				"test/RejectedCSVFiles/outputRejectedFile.txt");
		boolean validate = (!outputAcceptedFile.isFile() || !outputRejectedFile
				.isFile()) ? false : true;
		Assert.assertEquals(true, validate);

	}

}
