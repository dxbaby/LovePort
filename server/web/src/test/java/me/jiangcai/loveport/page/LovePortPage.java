package me.jiangcai.loveport.page;

import me.jiangcai.bracket.test.BracketPage;
import me.jiangcai.loveport.page.model.DataInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 这个站点的所有页面
 *
 * @author CJ
 */
public abstract class LovePortPage extends BracketPage {

    public LovePortPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DataInfo findNursesInfo() {
        return dataInfo("info-nurses");
    }

    private DataInfo dataInfo(String id) {
        WebElement div = webDriver.findElement(By.id(id));
        return new DataInfo(div.findElement(By.tagName("h4")), div.findElement(By.className("chart")));
    }
}
