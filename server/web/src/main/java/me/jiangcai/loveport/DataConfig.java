package me.jiangcai.loveport;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 可以根据不同的Profile载入不同的数据配置
 *
 * @author CJ
 */
@Configuration
public class DataConfig {

    @Configuration
    @Profile("!container")
    public static class LocalDataConfig {

    }

}
