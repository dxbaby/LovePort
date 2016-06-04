package me.jiangcai.loveport.controller;

import me.jiangcai.lib.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author CJ
 */
@Controller
public class CommonController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/uploadImage")
    public String uploadImage(MultipartFile image) throws IOException {
        if (image == null)
            throw new IllegalArgumentException();
        return "redirect:" + resourceService.uploadResource("domamd.png", image.getInputStream()).httpUrl();
    }

}
