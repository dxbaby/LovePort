package me.jiangcai.loveport.config;

import me.jiangcai.lib.bracket.BracketSpringConfig;
import me.jiangcai.lib.resource.ResourceSpringConfig;
import me.jiangcai.lib.resource.service.ResourceService;
import me.jiangcai.lib.upgrade.UpgradeSpringConfig;
import me.jiangcai.lib.upgrade.VersionInfoService;
import me.jiangcai.lib.upgrade.VersionUpgrade;
import me.jiangcai.lib.upgrade.service.UpgradeService;
import me.jiangcai.loveport.Version;
import me.jiangcai.loveport.entity.Login;
import me.jiangcai.loveport.entity.SystemString;
import me.jiangcai.loveport.repository.SystemStringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

/**
 * 核心服务 加载者
 *
 * @author CJ
 */
@Configuration
@Import({BracketSpringConfig.class, ResourceSpringConfig.class, UpgradeSpringConfig.class})
@EnableJpaRepositories(basePackages = {"me.jiangcai.loveport.repository"})
public class CoreConfig {

    @Autowired
    private SystemStringRepository systemStringRepository;
    @Autowired
    private UpgradeService upgradeService;
    @Autowired
    private ResourceService resourceService;

    @Bean
    @SuppressWarnings("unchecked")
    public VersionInfoService versionInfoService() {
        final String versionKey = "version.database";
        return new VersionInfoService() {

            @Override
            public <T extends Enum> T currentVersion(Class<T> type) {
                SystemString systemString = systemStringRepository.findOne(versionKey);
                if (systemString == null)
                    return null;
                return (T) Version.valueOf(systemString.getValue());
            }

            @Override
            public <T extends Enum> void updateVersion(T currentVersion) {
                SystemString systemString = systemStringRepository.findOne(versionKey);
                if (systemString == null) {
                    systemString = new SystemString();
                    systemString.setId(versionKey);
                }
                systemString.setValue(currentVersion.name());
                systemStringRepository.save(systemString);
            }
        };
    }

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


        upgradeService.systemUpgrade(new VersionUpgrade<Version>() {
            @Override
            public void upgradeToVersion(Version version) throws Exception {
                System.out.println(version);
            }
        });
    }

}
