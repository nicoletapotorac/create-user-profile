package pages.demoProfileForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.enums.Gender;
import utils.enums.Scripts;
import utils.PageBase;

import java.io.IOException;

public class DemoPage extends PageBase {

    private static final int WAITING_TIME = 2000;

    @FindBy(id = "cookieChoiceDismiss")
    private WebElement popup;

    @FindBy(name = "firstname")
    private WebElement firstname;

    @FindBy(name = "lastname")
    private WebElement lastname;

    @FindBy(name = "chkbox")
    private WebElement checkbox;

    @FindBy(name = "male")
    private WebElement male;

    @FindBy(name = "female")
    private WebElement female;

    @FindBy(name = "age")
    private WebElement age;

    @FindBy(name = "bday")
    private WebElement birthdate;

    @FindBy(name = "country")
    private WebElement country;

    @FindBy(name = "uploadfile")
    private WebElement uploadFile;

    @FindBy(name = "fullname")
    private WebElement fullname;

    @FindBy(xpath = "//*[@id=\"post-body-5864649494765988891\"]/div[1]/form/select")
    private WebElement idSelect;

    @FindBy(xpath = "//*[contains(text(), '--Select--')]")
    private WebElement selectOption;

    @FindBy(xpath = "//*[contains(text(), 'Download Text File')]")
    private WebElement downloadTextFile;

    public DemoPage(WebDriver driver) {
        super(driver);
        driver.get(readProperties.getBaseURL());
    }

    public String getUploadedFileValue(){
        localWait(WAITING_TIME);
        return uploadFile.getAttribute("value");
    }

    public String getFullNameValue(){
        localWait(WAITING_TIME);
        return fullname.getAttribute("value");
    }

    public String getAgeValue(){
        localWait(WAITING_TIME);
        return age.getAttribute("value");
    }

    public String getBirthDateValue(){
        localWait(WAITING_TIME);
        return birthdate.getAttribute("value");
    }

    public String getCountryValue(){
        localWait(WAITING_TIME);
        return country.getAttribute("value");
    }
    public WebElement selectId(){
        localWait(WAITING_TIME);
        Select id = new Select(idSelect);
        id.selectByIndex(1);
        return id.getFirstSelectedOption();
    }

    public String getSelectedIdValue(){
        localWait(WAITING_TIME);
        return selectId().getText();
    }

    public void uploadFile(Scripts script) throws IOException {
        localWait(WAITING_TIME);
        moveToElement(uploadFile);
        waitUntilElementIsClickable(uploadFile).click();
        localWait(WAITING_TIME);
        Runtime.getRuntime().exec(script.value);
        localWait(WAITING_TIME);
    }

    public void downloadFile(){
        downloadTextFile.click();
        localWait(WAITING_TIME);
    }

    public boolean isGenderButtonEnabled(Gender gender){
        if(gender==Gender.MALE && male.isEnabled()){
        return true;
        }
        return (gender==Gender.FEMALE && female.isEnabled());
    }

    public boolean isDemoPageOpen() {
        localWait(WAITING_TIME);
        driver.getTitle().contains("Sample Web Page To Test ~ Software Testing Place");
        return true;
    }

    public void dismissPopup(){
        waitUntilElementIsClickable(popup).click();
    }

    public void sendFirstNameLastName(){
        waitUntilElementIsVisible(firstname).sendKeys("Ion");
        localWait(WAITING_TIME);
        waitUntilElementIsVisible(lastname).sendKeys("Popescu");
        localWait(WAITING_TIME);
    }

    public void checkBox(){
        checkbox.click();
        localWait(WAITING_TIME);
    }

    public void checkGenderOption(String option){
        if(option.equals("female")){
            female.click();
        }
        else{
            male.click();
            localWait(WAITING_TIME);
        }
    }

    public void selectAge(){
        age.sendKeys("23");
        localWait(WAITING_TIME);
    }

    public void selectBirthdate() {
        birthdate.sendKeys("12/03/1973");
        localWait(WAITING_TIME);
    }

    public void selectCountry(){
        country.sendKeys("Rwanda");
        localWait(WAITING_TIME);
    }
}
