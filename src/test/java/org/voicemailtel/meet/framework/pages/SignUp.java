package org.voicemailtel.meet.framework.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
    private WebDriver driver;

    @FindBy( xpath="//*[@class=\"signup-component-title\"]")
    private WebElement SignUpHeading;

    @FindBy( id="mat-input-4")
    private WebElement firstName;

    @FindBy( id="mat-input-5")
    private WebElement lastName;

    @FindBy(id="mat-input-6")
    private WebElement emailAddress;

    @FindBy( id="mat-input-7" )
    private WebElement password;

    @FindBy(id="mat-input-8" )
    private WebElement confirmPassword;
    //add new elements as suggested by geet

    @FindBy( xpath="//*[@id=\"mat-checkbox-1\"]/label/div")
    private WebElement AgreeToTerms;

    @FindBy( xpath ="//*[@class=\"submit-button orange-button full-width\"]")
    private WebElement SignUpByOrangeBtn;

    @FindBy( xpath = "//*[@class=\"google-signin-text\"]")
    private WebElement SignUpByGoogleBtn;

    //************************************************//

    @FindBy( xpath="//*[contains(text(),'First name is ')]")
    private WebElement FirstNameRequired;

    @FindBy( xpath="//*[contains(text(),' Last name is ')]" )
    private WebElement LastNameRequired;

    @FindBy( xpath="//*[contains(text(),'Email is')]" )
    private WebElement EmailRequired;

    @FindBy(  xpath="//*[contains(text(),'Password is')]" )
    private WebElement PasswordRequired;

    @FindBy(xpath="//*[contains(text(),'Confirm Password is')]" )
    private WebElement ConfirmPasswordRequired;

    @FindBy(xpath="//*[contains(text(),'Terms and Conditions')]")
    private WebElement TermsAndConditionLink;

    @FindBy( xpath="//*[contains(text(),'Email pattern is ')]")
    private WebElement EmailInvalid;

    @FindBy(xpath="//*[contains(text(),'Password pattern is')]")
    private WebElement PasswordInvalid;

    @FindBy(xpath="//*[contains(text(),'Password pattern is')]" )
    private WebElement ConfirmPasswordInvalid;

    @FindBy(xpath="//*[contains(text(),'Passwords must')]")
    private WebElement PasswordsMustMatch;

    @FindBy(  id="identifierId")
    private WebElement IdentificationGoogleTab;

    //hack for google button

    @FindBy(xpath="//*[contains(text(),'Use another account')]")
    private WebElement GoogleSignInAdditionalPage;

    @FindBy(xpath="//*[contains(text(),'Email or phone')]")
    private WebElement GoogleSignEmailTab;

    @FindBy(xpath="//*[@class=\"VfPpkd-RLmnJb\"]")
    private WebElement Next;

    public SignUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getSignUpHeading() {
        return SignUpHeading;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public WebElement getAgreeToTerms() {
        return AgreeToTerms;
    }

    public WebElement getSignUpByOrangeBtn() {
        return SignUpByOrangeBtn;
    }

    public WebElement getSignUpByGoogleBtn() {
        return SignUpByGoogleBtn;
    }

    //****************************

    public WebElement getFirstNameRequired() {
        return FirstNameRequired;
    }

    public WebElement getLastNameRequired() {
        return LastNameRequired;
    }

    public WebElement getEmailRequired() {
        return EmailRequired;
    }

    public WebElement getPasswordRequired() {
        return PasswordRequired;
    }

    public WebElement getIdentificationGoogleTab(String s) {
        return IdentificationGoogleTab;
    }

    public WebElement getConfirmPasswordRequired() {
        return ConfirmPasswordRequired;
    }

    public WebElement getTermsAndConditionLink() {
        return TermsAndConditionLink;
    }

    public WebElement getEmailInvalid() {
        return EmailInvalid;
    }

    public WebElement getPasswordInvalid() {
        return PasswordInvalid;
    }

    public WebElement getConfirmPasswordInvalid() {
        return ConfirmPasswordInvalid;
    }

    public WebElement getPasswordsMustMatch() {
        return PasswordsMustMatch;
    }

    //*************

    public WebElement getIdentificationGoogleTab() {
        return IdentificationGoogleTab;
    }

    public WebElement getGoogleSignInAdditionalPage() {
        return GoogleSignInAdditionalPage;
    }

    public WebElement getGoogleSignEmailTab() {
        return GoogleSignEmailTab;
    }

    public WebElement getNext() {
        return Next;
    }

//methods

    public SignUp firstName(String firstName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        return this;
    }

    public SignUp lastName(String lastName) {
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        return this;
    }
    public SignUp enterEmail(String email) {
        this.emailAddress.clear();
        this.emailAddress.sendKeys(email);
        return this;
    }
    public SignUp password(String password) {
        this.password.clear();
        this.password.sendKeys(password);
        return this;
    }
    public SignUp confirmPassword(String confirmPassword) {
        this.confirmPassword.clear();
        this.confirmPassword.sendKeys(confirmPassword);
        return this;
    }
    public  SignUp AgreeBtn() {
        this.AgreeToTerms.click();
        return new SignUp(driver);
    }
    public  SignUp SignUpByOrangeBtn() {
        this.SignUpByOrangeBtn.click();
        return new SignUp(driver);
    }
    public  SignUp SignUpByGoogleBtn() {
        this.SignUpByGoogleBtn.click();
        return new SignUp(driver);
    }
    public SignUp IdentificationGoogleTab(String IdentificationGoogleTab) {
        this.IdentificationGoogleTab.clear();
        this.IdentificationGoogleTab.sendKeys(IdentificationGoogleTab);
        return this;
    }
//********
public  SignUp IdentificationGoogleTab() {
    this.IdentificationGoogleTab.click();
    return new SignUp(driver);
}
    public  SignUp GoogleSignInAdditionalPage() {
        this.GoogleSignInAdditionalPage.click();
        return new SignUp(driver);
    }
    public  SignUp GoogleSignEmailTab() {
        this.GoogleSignEmailTab.clear();
        this.GoogleSignEmailTab.sendKeys((CharSequence) GoogleSignEmailTab);
        return new SignUp(driver);
    }
    public SignUp GoogleSignEmailTab(String IdentificationGoogleTab) {
        this.IdentificationGoogleTab.clear();
        this.IdentificationGoogleTab.sendKeys(IdentificationGoogleTab);
        return this;
    }
    public  SignUp ClickNext() {
        this.Next.click();
        return new SignUp(driver);
    }

}
