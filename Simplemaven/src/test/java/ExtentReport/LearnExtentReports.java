package ExtentReport;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LearnExtentReports {
	@Test
	public void createReport( ) {
		
		String timestamp = LocalDateTime.now().toString().replace(":", "-");
		
		
		//step 1: create ExtentSparkReporter object
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_reports/ExtentReport_"+timestamp+".html");
		
		//step 2: create ExtentReport object
		ExtentReports ereport=new ExtentReports();
		
		//step 3: attach ExtentSparkReporter to ExtentReports
		ereport.attachReporter(spark);
		
		//step 4: create ExtentTest object
		ExtentTest test = ereport.createTest("createReporter");
		
		//step 5: call log(status."message")
		test.log(Status.PASS, "message addedin to report");
		
		//step 6:call flush()
		ereport.flush();
	}

}
