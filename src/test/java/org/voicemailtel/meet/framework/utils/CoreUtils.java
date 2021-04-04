package org.voicemailtel.meet.framework.utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.voicemailtel.meet.framework.config.AppConfig;
import org.voicemailtel.meet.framework.drivermanager.DriverManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

//to create directories to store screenshot
public class CoreUtils {
    private static void createDirs(Path path){
        if(! Files.exists(path)){
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //method to add fixed values
    public static String captureScreenshot(String testcaseName, StatusEnum statusEnum ) {
        createDirs(Paths.get(AppConfig.getProperties("screenshot.base.dir")));
        WebDriver driver = DriverManager.getDriver();
        String fileName= null;

        if (StatusEnum.PASS == statusEnum) {
            createDirs(Paths.get(AppConfig.getProperties("pass.dir")));
            fileName = generateFileName(testcaseName);
            File memoryFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(memoryFile.toPath(), Paths.get(AppConfig.getProperties("pass.dir"), fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (StatusEnum.FAIL == statusEnum) {
            createDirs(Paths.get(AppConfig.getProperties("fail.dir")));
            fileName = generateFileName(testcaseName);
            File memoryFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(memoryFile.toPath(), Paths.get(AppConfig.getProperties("fail.dir"), fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileName;
    }
    public static String generateFileName(String testcaseName){
        String pattern= AppConfig.getProperties("pattern");
        String s[] = pattern.split("_");
        SimpleDateFormat dateFormat = new SimpleDateFormat (s[1]);
        return testcaseName+ "_"+dateFormat.format(new Date())+AppConfig.getProperties("extension");

    }
    public static String generateReportFileName(){
        createDirs(Paths.get(AppConfig.getProperties("report.dir")));
        String pattern= AppConfig.getProperties("pattern");
        String s[] = pattern.split("_");
        SimpleDateFormat dateFormat = new SimpleDateFormat (s[1]);
        String fileName= "RunReport_"+dateFormat.format(new Date())+AppConfig.getProperties("report.extension");
        return Paths.get(AppConfig.getProperties("report.dir"), fileName).toString();
    }
}
