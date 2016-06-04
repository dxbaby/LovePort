package me.jiangcai.loveport.controller;

import me.jiangcai.bracket.test.auth.LoginAs;
import me.jiangcai.lib.resource.Resource;
import me.jiangcai.lib.resource.service.ResourceService;
import me.jiangcai.loveport.TestBase;
import me.jiangcai.loveport.entity.Login;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author CJ
 */
@LoginAs(Login.ROLE_CHARGE)
public class CommonControllerTest extends TestBase {

    @Autowired
    private ResourceService resourceService;

    @Test
    public void uploadImage() throws Exception {

        String prefix = "http://localhost:8080/_resources/";

        String href = mockMvc.perform(fileUpload("/uploadImage")
                .file(new MockMultipartFile("image", new ClassPathResource("loggeduser.png").getInputStream()))
                .session(session)
        )
                .andExpect(status().isFound())
                .andReturn().getResponse().getRedirectedUrl();

        String path = href.substring(prefix.length());

        Resource resource = resourceService.getResource(path);
        assertThat(resource.exists())
                .isTrue();

        resourceService.deleteResource(path);

        resource = resourceService.getResource(path);
        assertThat(resource.exists())
                .isFalse();
    }

}