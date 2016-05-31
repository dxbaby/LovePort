package me.jiangcai.loveport.page;

import org.openqa.selenium.WebDriver;

/**
 * @author CJ
 */
public class IndexPage extends LovePortPage {

    public IndexPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void validatePage() {

        shouldActiveMenuAt("fa-home");

    }
}
