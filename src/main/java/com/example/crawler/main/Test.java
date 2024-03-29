package com.example.crawler.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static List<WebElement> visibleElements;

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zhouxingyu\\Downloads" +
                "\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://krcom.cn/6212569431/episodes/2358773:4311384947948754");

        List<WebElement> webElements = getVisibleElements(driver, By.tagName("video"));
        for (WebElement webElement : webElements) {
            String res = webElement.getAttribute("src");
            System.out.println(res);
        }
        String title = driver.getTitle();
        System.out.printf(title);

        driver.close();
    }

    public static List<WebElement> getVisibleElements(WebDriver driver, By by) {
        visibleElements = new ArrayList<>();
        List<WebElement> allElements = driver.findElements(by);
        for (WebElement element : allElements) {
            if (element.isDisplayed()) {
                visibleElements.add(element);
            }
        }
        return visibleElements;
    }

}
