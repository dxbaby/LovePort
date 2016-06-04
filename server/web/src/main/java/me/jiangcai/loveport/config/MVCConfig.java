package me.jiangcai.loveport.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.List;
import java.util.Set;

/**
 * Web MVC 的配置者
 *
 * @author CJ
 */
@Configuration
@ComponentScan({"me.jiangcai.loveport.controller"})
@EnableWebMvc
public class MVCConfig extends WebMvcConfigurerAdapter {

    private static String[] STATIC_RESOURCE_PATHS = new String[]{
            "css", "fonts", "holder.js", "images", "js", "_resources", "localisation", "admin/js", "users/js"
            , "user/js"
    };

    @Autowired
    private ApplicationContext applicationContext;
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Autowired
    private Set<IDialect> dialectSet;
    @Autowired
    private Environment environment;

    String[] staticResourceAntPatterns() {
        String[] ignoring;
        int startIndex = 0;
        if (environment.acceptsProfiles("development")) {
            ignoring = new String[MVCConfig.STATIC_RESOURCE_PATHS.length + 2];
            ignoring[startIndex++] = "/**/*.html";
            ignoring[startIndex++] = "/mock/**/*";
        } else {
            ignoring = new String[MVCConfig.STATIC_RESOURCE_PATHS.length];
        }
        for (String path : MVCConfig.STATIC_RESOURCE_PATHS) {
            ignoring[startIndex++] = "/" + path + "/**/*";
        }
        return ignoring;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);

        registry.addViewController("/login").setViewName("user/signin");
        registry.addViewController("/userSetting").setViewName("user/setting");
    }

    /**
     * for upload
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        for (String path : STATIC_RESOURCE_PATHS) {
            registry.addResourceHandler("/" + path + "/**").addResourceLocations("/" + path + "/");
        }
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        super.addReturnValueHandlers(returnValueHandlers);
    }

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        resolver.setContentType("text/html;charset=UTF-8");
        return resolver;
    }

    //    @Bean
    private TemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        dialectSet.forEach(engine::addDialect);
        engine.addDialect(new SpringSecurityDialect());
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    private ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setCacheable(!environment.acceptsProfiles("test") && !environment.acceptsProfiles("development"));
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }

}
