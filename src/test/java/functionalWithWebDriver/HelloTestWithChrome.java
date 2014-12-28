package functionalWithWebDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloTestWithChrome {
    private WebDriver webDriver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/twer/Documents/projects/functionalTestWithSelenium/chromedriver");
        webDriver = new ChromeDriver();
    }


    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void should_access_hello_page() {
        webDriver.get("http://localhost:8080/functionalTestWithSelenium");
        assertThat(webDriver.getTitle(), is("hello"));

        webDriver.findElement(By.id("newWindowButton")).click();

        String windowHandle = webDriver.getWindowHandle();

        Set<String> windowHandles = webDriver.getWindowHandles();
        int i = 0;
        while(windowHandles.size() == 1){
            windowHandles = webDriver.getWindowHandles();
            System.out.println(i++);
        }

        for(String handle: windowHandles){
            if (!windowHandle.equals(handle)){
                webDriver.switchTo().window(handle);
                break;
            }
        }

        assertThat(webDriver.getTitle(), is("newWindow"));
    }


}
