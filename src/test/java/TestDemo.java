import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Created by xiaola on 19/4/4.
 */
public class TestDemo {
    WebDriver driver;

    @BeforeTest
    public void init() {
        String url = "http://www.baidu.com";

        //新建一个浏览器句柄
        driver = new Brower().chrome();
        //打开URL
        driver.get(url);
    }

    @Test
    @Parameters("searchWord")
    public void search(String searchWord) throws InterruptedException {
        //输入搜索字符串
        driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys(searchWord);
        //点击[百度一下]按钮
        driver.findElement(By.xpath("//*[@id=\"su\"]")).click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }



}
