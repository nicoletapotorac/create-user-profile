package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected ReadProperties readProperties = new ReadProperties();

    public PageBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitUntilElementIsClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement waitUntilElementIsVisible(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element);
    }


    public void localWait(int waitingTime) {
        try {
            Thread.sleep(waitingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}