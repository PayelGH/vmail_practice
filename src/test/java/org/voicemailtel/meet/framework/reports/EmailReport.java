package org.voicemailtel.meet.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.voicemailtel.meet.framework.utils.CoreUtils;

public class EmailReport {
     private static EmailReport instance;
     private ExtentReports extentReports;
 private EmailReport() {
      extentReports = new ExtentReports();
      ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(CoreUtils.generateReportFileName());
      extentReports.attachReporter(htmlReporter);
 }

 public static ExtentTest createTest(String testName){
      if(instance== null) {
           instance = new EmailReport();
      }
      return instance.extentReports.createTest(testName);
 }
 public static void closeTest(){
      if(instance!=null){
           instance.extentReports.flush();
      }
 }
}
