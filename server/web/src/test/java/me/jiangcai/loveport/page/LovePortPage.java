package me.jiangcai.loveport.page;

import me.jiangcai.bracket.test.BracketPage;
import me.jiangcai.loveport.page.model.DataInfo;
import org.assertj.core.api.AbstractCharSequenceAssert;
import org.assertj.core.api.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 这个站点的所有页面
 *
 * @author CJ
 */
public abstract class LovePortPage extends BracketPage {

    public LovePortPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * 应该是某一个菜单被激活
     *
     * @param name 菜单class 比如fa-home
     */
    public void shouldActiveMenuAt(String name) {
        String[] menus = new String[]{
                "fa-home"
                , "fa-suitcase"
                , "fa-users"
                , "fa-lock"
                , "fa-edit"
                , "fa-gears"
        };
        for (String menu : menus) {
            AbstractCharSequenceAssert<?, String> charSequenceAssert =
                    assertThat(findMenuLiByClass(menu).getAttribute("class"))
                            .as("menu " + menu + " bad class");
            if (name.equals(menu))
                charSequenceAssert
                        .contains("active");
            else
                charSequenceAssert
                        .is(new Condition<>(s ->
                                s == null || !s.contains("active")
                                , charSequenceAssert.descriptionText()));
        }

    }

    public DataInfo findNursesInfo() {
        return dataInfo("info-nurses");
    }

    private DataInfo dataInfo(String id) {
        WebElement div = webDriver.findElement(By.id(id));
        return new DataInfo(div.findElement(By.tagName("h4")), div.findElement(By.className("chart")));
    }
}
