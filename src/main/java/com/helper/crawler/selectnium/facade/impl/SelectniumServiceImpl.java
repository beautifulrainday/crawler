package com.helper.crawler.selectnium.facade.impl;

import com.helper.crawler.selectnium.facade.SelectniumFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhouxingyu
 * @Date 2023/8/25 15:59
 */
public class SelectniumServiceImpl implements SelectniumFacade {

    @PostConstruct
    public void init() {
        System.out.println("I'm SelectniumServiceImpl ,started...");

    }

    @Override
    public void handle() {
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


    public List<WebElement> getVisibleElements(WebDriver driver, By by) {
        List<WebElement> visibleElements = new ArrayList<WebElement>();
        List<WebElement> allElements = driver.findElements(by);
        for (WebElement element : allElements) {
            if (element.isDisplayed()) {
                visibleElements.add(element);
            }
        }
        return visibleElements;
    }
}
