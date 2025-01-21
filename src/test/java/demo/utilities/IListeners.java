package demo.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class IListeners extends Report implements ITestListener{
	
	ExtentReports extent = Report.Reports();
	ExtentTest test;
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();
	
	@Override
    public void onTestStart(ITestResult result) {
        // Code to execute when a test starts
    	test = extent.createTest(result.getMethod().getMethodName());
    	thread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Code to execute when a test passes
    	thread.get().log(Status.PASS, "This test is pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Code to execute when a test fails
    	thread.get().log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Code to execute when a test is skipped
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Code to execute when a test fails but within the success percentage (if defined)
        System.out.println("Test failed but within success percentage: " + result.getName());
    }

    @Override
    public void onStart(org.testng.ITestContext context) {
        // Code to execute before any test starts
        System.out.println("Test suite started: " + context.getName());
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        // Code to execute after all tests in a suite are finished
    	extent.flush();
    }
}
