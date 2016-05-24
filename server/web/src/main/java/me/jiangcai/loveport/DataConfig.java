package me.jiangcai.loveport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 可以根据不同的Profile载入不同的数据配置
 *
 * @author CJ
 */
@Configuration
public class DataConfig {

//
//    @Configuration
//    public static class EntityManagerFactoryConfig{
//        @Configuration
//        @Profile("container")
//        public static class ContainerConfig{
//            @Bean
//            public Object bean(){
//                Persistence.
//            }
//        }
//    }

    @Configuration
    @Profile("!container")
    public static class LocalDataConfig {

        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://dev.mysql.loveport.jiangcai.me/loveport_dev?useUnicode=true" +
                    "&characterEncoding=UTF8");
            dataSource.setUsername("loveport_dev");
            dataSource.setPassword("loveport_dev");
            return dataSource;
        }

    }

    @Configuration
    @Profile("container")
    public static class ContainerDataConfig {
//        @Bean
//        public Object dataSource() {
//            JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
//            bean.setJndiName("jdbc/LovePort");
//            bean.setResourceRef(true);
//            return bean;
//        }
    }

}
