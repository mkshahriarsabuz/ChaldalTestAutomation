package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    AppiumDriver driver;
    WebDriverWait wait;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Search\"]")
    private WebElement searchButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='While using the app']")
    private WebElement locationAllow;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void handleLocationAllow(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locationAllow));
        if (element.isDisplayed()) {
            element.click();
        }

    }
}
