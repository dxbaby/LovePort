package me.jiangcai.loveport;

import me.jiangcai.loveport.web.boot.DispatcherServletInitializer;
import org.luffy.test.SpringWebTest;
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
public abstract class TestBase extends SpringWebTest {

    @Configuration
    @Import({DispatcherServletInitializer.BootConfig.class, DataConfig.LocalDataConfig.class})
    public static class TestConfig {
    }

}
