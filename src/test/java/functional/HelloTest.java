package functional;

import com.thoughtworks.selenium.SeleneseTestCase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloTest {
    private WebDriver webDriver;

    @Before
    public void setup(){
        webDriver = new ChromeDriver();
    }

    @Test
    public void should_access_hello_page() {
        webDriver.get("http://localhost:8080/functionalTestWithSelenium/hello");
        assertThat(webDriver.getTitle(), is("Hello"));

    }

}
