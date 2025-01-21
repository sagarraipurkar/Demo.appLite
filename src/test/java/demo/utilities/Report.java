package demo.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {

	public static ExtentReports Reports() {
		String file = "C:\\Eclipse New\\NewWorkSpace\\Demo.appLitool\\Reports\\index.html";
		ExtentSparkReporter extent = new ExtentSparkReporter(file);
		extent.config().setReportName("Sagar Raipurkar");
		extent.config().setTheme(Theme.STANDARD);
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(extent);
		report.setSystemInfo("Enviorment", "QA");
		return report;
	}

}

