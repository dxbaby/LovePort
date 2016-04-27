package me.jiangcai.loveport.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 核心服务 加载者
 *
 * @author CJ
 */
@Configuration
@EnableJpaRepositories(basePackages = {"me.jiangcai.loveport.repository"})
public class CoreConfig {
}
