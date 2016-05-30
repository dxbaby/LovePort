package me.jiangcai.loveport.page.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.WebElement;

/**
 * @author CJ
 */
@Data
@AllArgsConstructor
public class DataInfo {

    private WebElement value;
    private WebElement chart;

}
