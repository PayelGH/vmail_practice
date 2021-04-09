package org.voicemailtel.meet.framework.testcases;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.voicemailtel.meet.framework.data.HomeProvider;
import org.voicemailtel.meet.framework.drivermanager.DriverManager;
import org.voicemailtel.meet.framework.pages.SignIn;
import org.voicemailtel.meet.framework.pages.SignUp;
import org.voicemailtel.meet.framework.reports.EmailReport;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.voicemailtel.meet.framework.reports.EmailReport.createTest;

public class HomeTest {
    private WebDriver driver = DriverManager.getDriver();

    @BeforeSuite
    public void setUp() {
        driver.get("https://meet.voicemailtel.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //----------------------------------------US002------------------------------------------------------//

   @Test
    public void TC_1_3() throws InterruptedException {
        String URL = driver.getCurrentUrl();
        
    // Assert.assertEquals(URL, "https://meet.voicemailtel.com/" );
        System.out.println();
     //if(actualUrl.equalsIgnoreCase(expectedUrl)) { System.out.println("Test passed") } else { System.out.println("Test failed")
    }
   
   @Test
   public void TC_1_4() throws InterruptedException {
       String URL = driver.getCurrentUrl();
      
       
    Assert.assertEquals(URL, "https://meet.voicemailtel.com/" );
    //if(actualUrl.equalsIgnoreCase(expectedUrl)) { System.out.println(â€œTest passedâ€�) } else { System.out.println(â€œTest failedâ€�)
   }

   @Test(dataProvider = "SignUpProvider", dataProviderClass = HomeProvider.class )
    public void TC_2_1(String firstName, String lastName,String email , String password, String confirmPassword ) throws InterruptedException {
        ExtentTest test= EmailReport.createTest("TC_2_1");
        test.log(Status.INFO, "Following data are passed: FirstName: "+firstName + " LastName: "+ lastName+ " EmailAddress: "+email+ " Password: "+password+" ConfirmPassword: "+confirmPassword);

        SignUp addCredentials = new SignUp(driver);
        Assert.assertEquals(addCredentials.getSignUpHeading().getText(),"Sign up" );

        addCredentials.firstName(firstName)
                .lastName(lastName)
                .enterEmail(email)
                .password(password);
        WebElement confirmPwd= driver.findElement(By.id("mat-input-8" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmPwd);//hack to scroll down
                 confirmPwd.sendKeys(confirmPassword);
        addCredentials.getAgreeToTerms().click();
        addCredentials.getSignUpByOrangeBtn().click();
    }

   @Test
    public void TC_2_2() throws InterruptedException {
        ExtentTest test= EmailReport.createTest("TC_2_2");
        test.log(Status.INFO, "Following data are passed: FirstName: Rosy, LastName: James, EmailAddress: rosyjames1299@gmail.com, Password: Rosy1234$, ConfirmPassword: dfg56");
        SignUp addCredentials = new SignUp(driver);
       addCredentials.firstName("Rosy")
               .lastName("James")
               .enterEmail("rosyjames1299@gmail.com")
               .password("Rosy1234$");
        WebElement confirmPwd= driver.findElement(By.id("mat-input-8" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmPwd);//hack to scroll down
        confirmPwd.sendKeys("dfg56");
        addCredentials.getAgreeToTerms().click();
        addCredentials.getSignUpByOrangeBtn().click();
       Assert.assertEquals(addCredentials.getConfirmPasswordInvalid().getText(),"Password pattern is invalid");

    }
     @Test(dataProvider = "IncorrectPasswordSignUp", dataProviderClass = HomeProvider.class )
    public void TC_2_3(String firstName, String lastName,String email , String password, String confirmPassword ) throws InterruptedException {
        ExtentTest test= EmailReport.createTest("TC_2_3");
        test.log(Status.INFO, "Following data are passed: FirstName: "+firstName + " LastName: "+ lastName+ " EmailAddress: "+email+ " Password: "+password+" ConfirmPassword: "+confirmPassword);
        SignUp addCredentials = new SignUp(driver);
        addCredentials.firstName(firstName)
                .lastName(lastName)
                .enterEmail(email)
                .password(password);
        WebElement confirmPwd= driver.findElement(By.id("mat-input-8" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmPwd);//hack to scroll down
                confirmPwd.sendKeys(confirmPassword);
        addCredentials.getAgreeToTerms().click();
        addCredentials.getSignUpByOrangeBtn().click();
         Assert.assertEquals(addCredentials.getConfirmPasswordInvalid().getText(),"Password pattern is invalid");
    }
    @Test
    public void TC_2_4() throws InterruptedException {
        ExtentTest test= EmailReport.createTest("TC_2_4");
        test.log(Status.INFO, "Following data are passed: FirstName: Rosy, LastName: James, EmailAddress: xyz@gmail.com, Password: Rosy12345$, ConfirmPassword: Rosy12345$");
        SignUp addCredentials = new SignUp(driver);
        addCredentials.firstName("Rosy")
                .lastName("James")
                .enterEmail("xyz@gmail.com")
                .password("Rosy12345$");
        WebElement confirmPwd= driver.findElement(By.id("mat-input-8" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmPwd);//hack to scroll down
        confirmPwd.sendKeys("Rosy12345$");
        addCredentials.getAgreeToTerms().click();
        addCredentials.getSignUpByOrangeBtn().click();

    }
     @Test
    public void TC_2_5() throws InterruptedException {
        ExtentTest test= EmailReport.createTest("TC_2_5");
        test.log(Status.INFO, "Following data are passed: FirstName: Rosy, LastName: James, EmailAddress: xyz@gmail.com, Password: xyz123, ConfirmPassword: xyz123");
        SignUp addCredentials = new SignUp(driver);
        Assert.assertEquals(addCredentials.getSignUpHeading().getText(),"Sign up");
        addCredentials.firstName("Rosy")
                .lastName("James")
                .enterEmail("xyz@gmail.com")
                .password("xyz123");
        WebElement confirmPwd= driver.findElement(By.id("mat-input-8" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmPwd);//hack to scroll down
        confirmPwd.sendKeys("xyz123");
        addCredentials.getAgreeToTerms().click();
        addCredentials.getSignUpByOrangeBtn().click();

    }
    //reviewed till here*/
     @Test(dataProvider = "SignUpProvider", dataProviderClass = HomeProvider.class )
    public void TC_2_6(String firstName, String lastName,String email , String password, String confirmPassword ) throws InterruptedException {
        ExtentTest test= EmailReport.createTest("TC_2_6");
        test.log(Status.INFO, "Following data are passed: FirstName: "+firstName + " LastName: "+ lastName+ " EmailAddress: "+email+ " Password: "+password+" ConfirmPassword: "+confirmPassword);
        SignUp addCredentials = new SignUp(driver);
        Assert.assertEquals(addCredentials.getSignUpHeading().getText(),"Sign up");
        addCredentials.firstName(firstName)
                .lastName(lastName)
                .enterEmail(email)
                .password(password);
        WebElement confirmPwd= driver.findElement(By.id("mat-input-8" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmPwd);//hack to scroll down
        confirmPwd.sendKeys("Rosy12345$");
        addCredentials.getAgreeToTerms().click();
        addCredentials.getSignUpByGoogleBtn().click();
         Thread.sleep(4000);
         addCredentials.getIdentificationGoogleTab().getText();
         addCredentials.getGoogleSignEmailTab().sendKeys(email);

         addCredentials.getNext().click();

    }
     @Test(dataProvider = "SignUpProvider", dataProviderClass = HomeProvider.class )
    public void TC_2_7(String firstName, String lastName,String email , String password, String confirmPassword ) throws InterruptedException {
        ExtentTest test= EmailReport.createTest("TC_2_7");
        test.log(Status.INFO, "Following data are passed: FirstName: "+firstName + " LastName: "+ lastName+ " EmailAddress: "+email+ " Password: "+password+" ConfirmPassword: "+confirmPassword);
        SignUp addCredentials = new SignUp(driver);
        Assert.assertEquals(addCredentials.getSignUpHeading().getText(),"Sign up");
        addCredentials.firstName("Rosy")
                .lastName("James")
                .enterEmail("rosyjames1299@gmail.com")
                .password("Rosy12345$");
        WebElement confirmPwd= driver.findElement(By.id("mat-input-8" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmPwd);//hack to scroll down
        confirmPwd.sendKeys("45678dfgh");
        addCredentials.getAgreeToTerms().click();
        addCredentials.getSignUpByGoogleBtn().click();

    }
    @Test(dataProvider = "SignUpProvider", dataProviderClass = HomeProvider.class )
    public void TC_2_8(String firstName, String lastName,String email , String password, String confirmPassword ) throws InterruptedException {
        ExtentTest test= EmailReport.createTest("TC_2_8");
        test.log(Status.INFO, "Following data are passed: FirstName: "+firstName + " LastName: "+ lastName+ " EmailAddress: "+email+ " Password: "+password+" ConfirmPassword: "+confirmPassword);

        SignUp addCredentials = new SignUp(driver);
        Assert.assertEquals(addCredentials.getSignUpHeading().getText(),"Sign up");
        addCredentials.firstName("Rosy")
                .lastName("James")
                .enterEmail("rosyjames1299@gmail.com")
                .password("ROSY@1234$");
        WebElement confirmPwd= driver.findElement(By.id("mat-input-8" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmPwd);//hack to scroll down
        confirmPwd.sendKeys("ROSY@1234$");
        addCredentials.getAgreeToTerms().click();
        addCredentials.getSignUpByGoogleBtn().click(); 
        Thread.sleep(2000);
    }
     @Test(dataProvider = "SignUpProvider", dataProviderClass = HomeProvider.class )
    public void TC_2_9(String firstName, String lastName,String email , String password, String confirmPassword ) throws InterruptedException {
        ExtentTest test= EmailReport.createTest("TC_2_9");
        test.log(Status.INFO, "Following data are passed: FirstName: "+firstName + " LastName: "+ lastName+ " EmailAddress: "+email+ " Password: "+password+" ConfirmPassword: "+confirmPassword);
        SignUp addCredentials = new SignUp(driver);
        Assert.assertEquals(addCredentials.getSignUpHeading().getText(),"Sign up");
        addCredentials.firstName("Rosy")
                .lastName("James")
                .enterEmail("xyz@gmail.com")
                .password("Rosy12345$");
        WebElement confirmPwd= driver.findElement(By.id("mat-input-8" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmPwd);//hack to scroll down
        confirmPwd.sendKeys("Rosy12345$");
        addCredentials.getAgreeToTerms().click();
        addCredentials.getSignUpByGoogleBtn().click();
        Thread.sleep(2000);
    }
    @Test(dataProvider = "SignUpProvider", dataProviderClass = HomeProvider.class )
    public void TC_2_10(String firstName, String lastName,String email , String password, String confirmPassword ) throws InterruptedException {
        ExtentTest test= EmailReport.createTest("TC_2_10");
        test.log(Status.INFO, "Following data are passed: FirstName: "+firstName + " LastName: "+ lastName+ " EmailAddress: "+email+ " Password: "+password+" ConfirmPassword: "+confirmPassword);
        SignUp addCredentials = new SignUp(driver);
        Assert.assertEquals(addCredentials.getSignUpHeading().getText(),"Sign up");
        addCredentials.firstName("Rosy")
                .lastName("James")
                .enterEmail("xyz@gmail.com")
                .password("xyz123");
        WebElement confirmPwd= driver.findElement(By.id("mat-input-8" ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmPwd);//hack to scroll down
        confirmPwd.sendKeys("xyz123");
        addCredentials.getAgreeToTerms().click();
        addCredentials.getSignUpByGoogleBtn().click();
        Thread.sleep(2000);
    }
     @Test
    public void TC_2_11() throws InterruptedException {
         ExtentTest test = EmailReport.createTest("TC_2_10");
         test.log(Status.INFO, "Following data is passed: FirstName: " + "Rosy" + " LastName: " + "James" + " EmailAddress: " + "rosyjam");
         SignUp addCredentials = new SignUp(driver);
         addCredentials.firstName("Rosy")
                 .lastName("James")
                 .enterEmail("rosyjam");

     }//my mic muted. pls relieve control
    //-------------------------------------------US003------------------------------------------------------//

 @Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_1(String email, String password) throws InterruptedException {
     ExtentTest test = EmailReport.createTest("TC_3_1");
     test.log(Status.INFO, "Following data are passed: EmailAddress: " + email + " Password: " + password);

     SignIn signIn = new SignIn(driver);
     signIn.getSignInMenu().click();
     //Assert.assertEquals(signIn.getSignInHeading().getText(),"SIGN IN");
         signIn.enterRegisteredEmail(email)
                 .enterRegisteredPassword(password)
                 .getSignInOrangeBtn().click();
         signIn.getHamburgerMenuBtn().click();
         WebElement signOut= driver.findElement(By.xpath("//*[contains(text(), 'Sign out')]"));
     JavascriptExecutor jse = (JavascriptExecutor)driver;
     jse.executeScript("arguments[0].scrollIntoView()", signOut);
     signOut.click();
 }

   /*@Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_2(String email, String password) throws InterruptedException {
     ExtentTest test= EmailReport.createTest("TC_3_2");
     test.log(Status.INFO, "Following data are passed: EmailAddress: "+email+ " Password: "+password);

        SignIn signIn = new SignIn(driver);
        signIn.getSignInMenu().click();
        Assert.assertEquals(signIn.getSignInHeading().getText(),"Sign in");
        signIn.enterRegisteredEmail("rosyjames1299@gmail.com")
                .enterRegisteredPassword("xyz")
                .getSignInOrangeBtn().click();//not clickable
        Thread.sleep(2000);
    }
   /* @Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_3(String email, String password) throws InterruptedException {
     ExtentTest test = EmailReport.createTest("TC_3_3");
     test.log(Status.INFO, "Following data are passed: EmailAddress: " + email + " Password: " + password);

        SignIn signIn = new SignIn(driver);
        signIn.getSignInMenu().click();
        Assert.assertEquals(signIn.getSignInHeading().getText(),"Sign in");
        signIn.enterRegisteredEmail("xyz@gmail.com")
                .enterRegisteredPassword("Rosy12345$")
                .getSignInOrangeBtn().click();//not clickable
        Thread.sleep(2000);
    }
    @Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_4(String email, String password) throws InterruptedException {
     ExtentTest test = EmailReport.createTest("TC_3_4");
     test.log(Status.INFO, "Following data are passed: EmailAddress: " + email + " Password: " + password);

        SignIn signIn = new SignIn(driver);
        signIn.getSignInMenu().click();
        Assert.assertEquals(signIn.getSignInHeading().getText(),"Sign in");
        signIn.enterRegisteredEmail("xyz@gmail.com")
                .enterRegisteredPassword("xyz")
                .getSignInOrangeBtn().click();//not clickable
        Thread.sleep(2000);
    }
    @Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_5(String email, String password) throws InterruptedException {
     ExtentTest test = EmailReport.createTest("TC_3_5");
     test.log(Status.INFO, "Following data are passed: EmailAddress: " + email + " Password: " + password);

        SignIn signIn = new SignIn(driver);
        signIn.getSignInMenu().click();
        Assert.assertEquals(signIn.getSignInHeading().getText(),"Sign in");
        signIn.enterRegisteredEmail("rosyjames1299@gmail.com");
        signIn.enterRegisteredPassword("Rosy12345$");
        signIn.getSignInGoogleBtn().click();
        Thread.sleep(2000);
    }
    @Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_6(String email, String password) throws InterruptedException {
     ExtentTest test = EmailReport.createTest("TC_3_6");
     test.log(Status.INFO, "Following data are passed: EmailAddress: " + email + " Password: " + password);
    public void TC_3_6() throws InterruptedException {
        SignIn signIn = new SignIn(driver);
        signIn.getSignInMenu().click();
        Assert.assertEquals(signIn.getSignInHeading().getText(),"Sign in");
        signIn.enterRegisteredEmail("rosyjames1299@gmail.com");
        signIn.enterRegisteredPassword("xyz");
        signIn.getSignInGoogleBtn().click();
        Thread.sleep(2000);
    }
    @Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_7(String email, String password) throws InterruptedException {
     ExtentTest test = EmailReport.createTest("TC_3_7");
     test.log(Status.INFO, "Following data are passed: EmailAddress: " + email + " Password: " + password);

        SignIn signIn = new SignIn(driver);
        signIn.getSignInMenu().click();
        Assert.assertEquals(signIn.getSignInHeading().getText(),"Sign in");
        signIn.enterRegisteredEmail("xyz@gmail.com");
        signIn.enterRegisteredPassword("Rosy12345$");
        signIn.getSignInGoogleBtn().click();
        Thread.sleep(2000);
    }
    @Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_8(String email, String password) throws InterruptedException {
     ExtentTest test = EmailReport.createTest("TC_3_8");
     test.log(Status.INFO, "Following data are passed: EmailAddress: " + email + " Password: " + password);

        SignIn signIn = new SignIn(driver);
        signIn.getSignInMenu().click();
        Assert.assertEquals(signIn.getSignInHeading().getText(),"Sign in");
        signIn.enterRegisteredEmail("xyz@gmail.com");
        signIn.enterRegisteredPassword("xyz");
        signIn.getSignInGoogleBtn().click();
        Thread.sleep(2000);
    }
    @Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_9(String email, String password) throws InterruptedException {
     ExtentTest test = EmailReport.createTest("TC_3_9");
     test.log(Status.INFO, "Following data are passed: EmailAddress: " + email + " Password: " + password);

        SignIn signIn = new SignIn(driver);
        signIn.getSignInMenu().click();
        Assert.assertEquals(signIn.getSignInHeading().getText(),"Sign in");
        signIn.getForgetPassword().click();
        signIn.forgetPasswordEmail("rosyjames1299@gmail.com")
              .getContinueBtn().click();
        Thread.sleep(2000);

    }
    @Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_10(String email, String password) throws InterruptedException {
     ExtentTest test = EmailReport.createTest("TC_3_10");
     test.log(Status.INFO, "Following data are passed: EmailAddress: " + email + " Password: " + password);

        SignIn signIn = new SignIn(driver);
        signIn.getSignInMenu().click();
        Assert.assertEquals(signIn.getSignInHeading().getText(),"Sign in");
        signIn.getForgetPassword().click();
        signIn.forgetPasswordEmail("xyz@gmail.com")
                .getContinueBtn().click();
        Thread.sleep(2000);
    }
    @Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_11(String email, String password) throws InterruptedException {
     ExtentTest test = EmailReport.createTest("TC_3_11");
     test.log(Status.INFO, "Following data are passed: EmailAddress: " + email + " Password: " + password);

        SignIn signIn = new SignIn(driver);
        signIn.getSignInMenu().click();
        Assert.assertEquals(signIn.getSignInHeading().getText(),"Sign in");
        signIn.getForgetPassword().click();
        signIn.forgetPasswordEmail("rosyjames1299@gmail.com")
                .getContinueBtn().click();
        Thread.sleep(2000);
        //how to automate the link sent by email to continue:check with Atin ?
        signIn.getPasswordReset().sendKeys("Rosy12345$");
        signIn.getConfirmPasswordReset().sendKeys("Rosy12345$");
        signIn.getResetBtn().click();
        Thread.sleep(2000);
    }
    @Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_12(String email, String password) throws InterruptedException {
     ExtentTest test = EmailReport.createTest("TC_3_12");
     test.log(Status.INFO, "Following data are passed: EmailAddress: " + email + " Password: " + password);

        SignIn signIn = new SignIn(driver);
        signIn.getSignInMenu().click();
        Assert.assertEquals(signIn.getSignInHeading().getText(),"Sign in");
        signIn.getForgetPassword().click();
        signIn.forgetPasswordEmail("rosyjames1299@gmail.com")
                .getContinueBtn().click();
        Thread.sleep(2000);
        //this one has to click password reset sent by email to work??
        signIn.getPasswordReset().sendKeys("Rosy12345$");
        signIn.getConfirmPasswordReset().sendKeys("Rosyy12345$");
        signIn.getResetBtn().click();
        Thread.sleep(2000);
    }
    @Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_13(String email, String password) throws InterruptedException {
     ExtentTest test = EmailReport.createTest("TC_3_13");
     test.log(Status.INFO, "Following data are passed: EmailAddress: " + email + " Password: " + password);

        SignIn signIn = new SignIn(driver);
        signIn.getSignInMenu().click();
        Assert.assertEquals(signIn.getSignInHeading().getText(),"Sign in");
        signIn.getForgetPassword().click();
        signIn.forgetPasswordEmail("rosyjames1299@gmail.com")
                .getContinueBtn().click();
        Thread.sleep(2000);
        //this one has to click password reset sent by email to work??
        signIn.getPasswordReset().sendKeys("ROSY@1234$");
        signIn.getConfirmPasswordReset().sendKeys("ROSY@1234$");
        signIn.getResetBtn().click();
        Thread.sleep(2000);
    }
    @Test (dataProvider = "SignInProvider", dataProviderClass = HomeProvider.class)
    public void TC_3_14(String email, String password) throws InterruptedException {
     ExtentTest test = EmailReport.createTest("TC_3_14");
     test.log(Status.INFO, "Following data are passed: EmailAddress: " + email + " Password: " + password);

        SignIn signIn = new SignIn(driver);
        signIn.getSignInMenu().click();
        signIn.getSignup().click();
        Thread.sleep(2000);
    }*/
    @AfterSuite
        public void tearDown() throws InterruptedException {
            Thread.sleep(4000);
            EmailReport.closeTest();
            driver.quit();
        }
    }
