package me.jiangcai.loveport.service;

import me.jiangcai.lib.bracket.auth.AuthenticateService;
import me.jiangcai.lib.resource.service.ResourceService;
import me.jiangcai.lib.upgrade.VersionUpgrade;
import me.jiangcai.lib.upgrade.service.UpgradeService;
import me.jiangcai.loveport.Version;
import me.jiangcai.loveport.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author CJ
 */
@Service
public class InitService {

    @Autowired
    private UpgradeService upgradeService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private AuthenticateService<Login> loginService;

    @PostConstruct
    public void init() throws IOException {
        // 投放默认资源
        Resource resource = resourceService.getResource(Login.DEFAULT_IMAGE_PATH);
        if (!resource.exists()) {
            Resource src = new ClassPathResource("loggeduser.png");
            try (InputStream inputStream = src.getInputStream()) {
                resourceService.uploadResource(Login.DEFAULT_IMAGE_PATH, inputStream);
            }
        }

        try {
            loginService.loadUserByUsername("CJ");
        } catch (UsernameNotFoundException ex) {
            Login login = loginService.createUser(false, Login.ROLE_MANAGER);
            login.setUsername("CJ");
            loginService.changePassword(login, "onlyRoot");
        }

        upgradeService.systemUpgrade(new VersionUpgrade<Version>() {
            @Override
            public void upgradeToVersion(Version version) throws Exception {
                System.out.println(version);
            }
        });
    }
}
