package functional;

import com.thoughtworks.selenium.SeleneseTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.omg.CORBA.ServiceInformationHelper.id;

public class HelloTestWithChrome {
    private WebDriver webDriver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/twer/Documents/projects/functionalTestWithWebDriver/chromedriver");
        webDriver = new ChromeDriver();
    }


    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void should_access_hello_page() {
        webDriver.get("http://localhost:8080/functionalTestWithWebDriver");

        assertThat(webDriver.getTitle(), is("hello"));
        assertThat(webDriver.findElement(By.id("message")).getText(), is("Hello world!"));

    }


}
