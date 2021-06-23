package online.goudan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

/**
 * @author 刘成龙
 * @date 2021/6/23 10:01
 * @desc Client01
 */
public class Client01 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/Cary/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments( "--disable-gpu", "--hide-scrollbars", "blink-settings=imagesEnabled=false", "--headless");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.baidu.com");


        //当前页句柄
        String primaryHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles.size());
        for (String handel : handles) {
            if (!handel.equals(primaryHandle)) {
                driver.switchTo().window(handel);
                break;
            }
        }


        WebElement element = driver.findElement(By.xpath("//*[@id=\"main_mv\"]/iframe"));
        driver.switchTo().frame(element);
        WebElement source = driver.findElement(By.xpath("/html/body/div[1]/div/video/source"));
        System.out.println("src = " + source.getAttribute("src"));

        driver.quit();
    }

}
