package me.jiangcai.loveport.web;

import me.jiangcai.loveport.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author CJ
 */
public class IndexTest extends TestBase {


    @Test
    public void index() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print());

        driver.get("http://localhost/");


        driver.findElement(By.id("mainMenu")).findElements(By.tagName("li"))
                .forEach(webElement -> {
                    System.out.println(webElement);
                    System.out.println(webElement.getCssValue("background-color"));
                });

        System.out.println(driver.findElement(By.className("fa-home")));
    }


}
