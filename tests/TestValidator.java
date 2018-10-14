

import junit.framework.Assert;
import junit.framework.TestCase;
import model.Validator;

/**
 * This class is responsible of the Validator Class test 
 * @author Miguel Rijo
 */

public class TestValidator extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
		
	/*this tests verifyLenghtOfString method*/
	
	public void testVerifyLenghtOfString() {
		String lastName = "al";
		boolean result = Validator.verifyLenghtOfString(3, lastName);
		Assert.assertEquals(false, result);
	}

	/*this tests verifyDate method*/
	
	public void testVerifyDate() {
		boolean result =Validator.verifyDate("2011-02-29");
		Assert.assertEquals(false,result );
		
	}

	/*this tests transformHyphenToSlash method */
	
	public void testTransformHyphenToSlash() {
		String expected = "2000/02/01";
		String result = Validator.transformHyphenToSlash("2000-02-01");
		Assert.assertEquals(expected,result );
	}
	
	/*this tests verifyPattern method*/
	
	public void testVerifyPattern() {
		boolean expected = false; 
		boolean result = Validator.verifyPattern(Validator.DATEPATTERN,"2000-02333333-01");
		Assert.assertEquals(expected,result );
	}

}
