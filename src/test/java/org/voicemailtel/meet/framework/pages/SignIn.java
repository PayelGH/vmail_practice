package org.voicemailtel.meet.framework.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
    private WebDriver driver;

    @FindBy( xpath="//*[@class=\"mat-focus-indicator meetings-menu-item mat-menu-item ng-star-inserted\"]")
    private WebElement signInMenu;

    @FindBy(xpath="//*[@class=\"signin-component-title\"]")
    private WebElement SignInHeading;

    @FindBy(id="mat-input-13")
    private WebElement registeredEmail;

    @FindBy(id="mat-input-14")
    private WebElement registeredPassword;

    @FindBy(xpath="//*[@class=\"submit-button orange-button full-width\"]")
    private WebElement signInOrangeBtn;

    @FindBy(xpath = "//*[@class=\"google-signin-text\"]")
    private WebElement signInGoogleBtn;

    @FindBy( xpath="//*[contains(text(),'Signup')]")
    private WebElement signup;

    @FindBy(xpath= "//*[contains(text(),'Forgot password')]" )
    private WebElement forgetPassword;

    @FindBy(id="mat-input-23")
    private WebElement forgetPasswordEmail;

    @FindBy(xpath="//*[@class=\"submit-button orange-button full-width\"]")
    private WebElement continueBtn;

    @FindBy( id="mat-input-0")
    private WebElement passwordReset;

    @FindBy(id="mat-input-1")
    private WebElement confirmPasswordReset;

    @FindBy(xpath="//*[@class=\"submit-button blue-button full-width\"]")
    private WebElement resetBtn;

    @FindBy(xpath="//*[@class=\"material-icons menu-icon\"]")
    private WebElement hamburgerMenuBtn;

    @FindBy(xpath="//*[contains(text(), 'Sign out')]")
    private WebElement signOut;


    //create page
    public SignIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //generate getter

    public WebElement getSignInMenu() {
        return signInMenu;
    }

    public WebElement getSignInHeading() {
        return SignInHeading;
    }
    public WebElement getRegisteredEmail() {
        return registeredEmail;
    }

    public WebElement getRegisteredPassword() {
        return registeredPassword;
    }

    public WebElement getSignInOrangeBtn() {
        return signInOrangeBtn;
    }

    public WebElement getSignInGoogleBtn() {
        return signInGoogleBtn;
    }

    public WebElement getSignup() {
        return signup;
    }

    public WebElement getForgetPassword() {
        return forgetPassword;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getForgetPasswordEmail() {
        return forgetPasswordEmail;
    }

    public WebElement getContinueBtn() {
        return continueBtn;
    }

    public WebElement getPasswordReset() {
        return passwordReset;
    }

    public WebElement getConfirmPasswordReset() {
        return confirmPasswordReset;
    }

    public WebElement getResetBtn() {
        return resetBtn;
    }

    public WebElement getHamburgerMenuBtn() {
        return hamburgerMenuBtn;
    }

    public WebElement getSignOut() {
        return signOut;
    }

    //methods
    public  SignIn signInMenu () {
        this.signInMenu.click();
        return new SignIn(driver);
    }
    public SignIn enterRegisteredEmail(String email) {
        this.registeredEmail.clear();
        this.registeredEmail.sendKeys(email);
        return this;
    }
    public SignIn enterRegisteredPassword(String password) {
        this.registeredPassword.clear();
        this.registeredPassword.sendKeys(password);
        return this;
    }
    public  SignIn signInOrangeBtn () {
        this.signInOrangeBtn.click();
        return new SignIn(driver);
    }
    public  SignIn signInGoogleBtn () {
        this.signInGoogleBtn.click();
        return new SignIn(driver);
    }
    public  SignIn signUp () {
        this.signup.click();
        return new SignIn(driver);
    }
    public  SignIn forgetPassword () {
        this.forgetPassword.click();
        return new SignIn(driver);
    }
    public SignIn forgetPasswordEmail(String forgetPasswordEmail) {
        this.forgetPasswordEmail.clear();
        this.forgetPasswordEmail.sendKeys(forgetPasswordEmail);
        return this;
    }
    public  SignIn continueBtn () {
        this.continueBtn.click();
        return new SignIn(driver);
    }
    public SignIn getPasswordReset(String passwordReset) {
        this.passwordReset.clear();
        this.passwordReset.sendKeys(passwordReset);
        return this;
    }
    public SignIn confirmPasswordReset(String confirmPasswordReset) {
        this.confirmPasswordReset.clear();
        this.confirmPasswordReset.sendKeys(confirmPasswordReset);
        return this;
    }
    public  SignIn resetBtn () {
        this.resetBtn.click();
        return new SignIn(driver);
    }

    public SignIn HamburgerMenu(){
        this.hamburgerMenuBtn.click();
        return new SignIn(driver);
    }
    public SignIn signOut(){
        this.signOut.click();
        return new SignIn(driver);
    }

}
