package CEAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CECrossbrowserTesting {

    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void SystemSetup(String browser)
    {
        if (browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "76chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equals("IE"))
        {
            System.setProperty("webdriver.ie.driver","IEDriverServer_Win32_3.14.0/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else if (browser.equals("FireFox"))
        {
            System.setProperty("driver.gecko.driver","geckodriver-v0.21.0-win64/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void Test1()
    {
        //Entering the URL
        driver.get("https://www.linkedin.com");
        System.out.println(driver.getTitle()); // capturing the Title of the page

        WebElement crossbutton = driver.findElement(By.cssSelector("body > nav > section.sign-in-card.show > button > li-icon"));;
        Boolean j = crossbutton.isDisplayed();
        if (j = true)
        {

            driver.findElement(By.cssSelector("body > nav > section.sign-in-card.show > button > li-icon")).click();
        }

        driver.findElement(By.linkText("Join now")).click();
        driver.findElement(By.id("first-name")).clear();
        driver.findElement(By.id("first-name")).sendKeys("Nagabushan");
        driver.findElement(By.id("last-name")).clear();
        driver.findElement(By.id("last-name")).sendKeys("Kashyap");
        driver.findElement(By.id("join-email")).clear();
        driver.findElement(By.id("join-email")).sendKeys("Nagabushan@ce.com");
        driver.findElement(By.id("join-password")).clear();
        driver.findElement(By.id("join-password")).sendKeys("qwerty@1234");

        //Commenting as it will show a validation
        //driver.findElement(By.id("submit-join-form-text")).click();

        //Clicking on "Continue with Facebook"
        driver.findElement(By.cssSelector("#uno-reg-join > div > div > div > div.content-container > div.reg-content-wrapper.single > div.join-form-container.form-container > div.join-form-wrapper.form-wrapper > div.third-party-btn-container > button")).click();

    }

    @AfterMethod
    public void TearDown()
    {

        driver.quit();
    }

}


