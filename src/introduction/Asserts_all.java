package introduction;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Asserts_all {

	public static void main(String[] args) {
		//if any of this fail, the test will be interrupt (message will be shown)
		Assert.assertEquals(true, true);
		Assert.assertTrue(true, "FAIL: print some message");
		Assert.assertFalse(false, "FAIL: print some message");
		//Soft assertions
		SoftAssert sa = new SoftAssert();
		System.out.println("Test 1");
		sa.assertTrue(true);
		System.out.println("Test 2");
		sa.assertTrue(false,"FAIL A: some coding error");
		System.out.println("Test 3");
		sa.assertTrue(false,"FAIL B: some coding error");
		System.out.println("Test 4");
		sa.assertTrue(true);
		sa.assertAll();

	}

}
