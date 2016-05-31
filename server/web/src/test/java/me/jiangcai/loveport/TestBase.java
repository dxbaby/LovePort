package me.jiangcai.loveport;

import me.jiangcai.bracket.test.auth.AuthenticatedWebTest;
import me.jiangcai.loveport.entity.Login;
import me.jiangcai.loveport.web.boot.DispatcherServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author CJ
 */
@Transactional
@WebAppConfiguration
@ContextConfiguration(classes = TestBase.TestConfig.class)
public abstract class TestBase extends AuthenticatedWebTest<Login> {

    @Configuration
    @Import({DispatcherServletInitializer.BootConfig.class, DataConfig.LocalDataConfig.class})
    public static class TestConfig {
    }

}
