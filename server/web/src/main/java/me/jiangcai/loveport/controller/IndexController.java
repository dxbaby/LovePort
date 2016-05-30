package me.jiangcai.loveport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CJ
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"", "/", "/index.html"})
    public String index() {
        return "index/index";
    }

}
