package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer {
	
	int count=0;
	int retrycount=3;

	public boolean retry(ITestResult result) {
		
		while(count<retrycount)
		{
			count++;
			return true;//retry//retry //retry
		}
		
		return false;//stop
	
	}

}
