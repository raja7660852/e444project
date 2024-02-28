package practice;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

public class Retryanalyerpracticec {
	
	@Test(retryAnalyzer = genericUtility.RetryAnalyserImplementation.class)
	public void ac()
	{
		Assert.fail();
		System.out.println("hiiii");
	}

}
