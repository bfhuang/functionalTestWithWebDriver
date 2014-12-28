package functionalWithWebDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloTestWithFireFox {

    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = new FirefoxDriver();
    }


    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void should_access_hello_page() {
        webDriver.get("http://localhost:8080/functionalTestWithWebDriver");
        assertThat(webDriver.getTitle(), is("hello"));

    }


}
