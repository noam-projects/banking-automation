import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtendReportsClass {
    public static ExtentSparkReporter html_reporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    @BeforeTest
    public void report_settings()
    {
        html_reporter=new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports and logs\\extent.html");
        html_reporter.config().setEncoding("utf-8");
        html_reporter.config().setDocumentTitle("SUITE");
        html_reporter.config().setReportName("test results");
        html_reporter.config().setTheme(Theme.STANDARD);
        extent=new ExtentReports();
        extent.attachReporter(html_reporter);
        extent.setSystemInfo("tester name","noam");
        BaseTest.LOGGER.info("extent reporter set up done");
    }
}
