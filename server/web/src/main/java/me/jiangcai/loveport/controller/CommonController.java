package me.jiangcai.loveport.controller;

import me.jiangcai.lib.resource.Resource;
import me.jiangcai.lib.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author CJ
 */
@Controller
public class CommonController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 上传文件,客户端应该可以从头信息中获取上传以后的文件url以及资源path
     *
     * @param file 上传的文件
     * @throws IOException
     */
    @RequestMapping(value = "/uploadImage")
    public void uploadImage(MultipartFile file, HttpServletResponse response) throws IOException {
        if (file == null)
            throw new IllegalArgumentException();

        BufferedImage image = ImageIO.read(file.getInputStream());
        if (image == null) {
            throw new IllegalArgumentException();
        }

        String path = "upload/" + UUID.randomUUID().toString() + ".png";
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        ImageIO.write(image, "png", buffer);

        Resource resource = resourceService.uploadResource(path, new ByteArrayInputStream(buffer.toByteArray()));

        response.setHeader("Location", resource.httpUrl().toString());
        response.sendError(302, path);
    }

}
