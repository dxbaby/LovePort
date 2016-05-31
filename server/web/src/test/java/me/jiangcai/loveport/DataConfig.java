package me.jiangcai.loveport;

import me.jiangcai.lib.test.config.H2DataSourceConfig;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 可以根据不同的Profile载入不同的数据配置
 *
 * @author CJ
 */
//@Configuration
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

    //    @Configuration
//    @Profile("!container")
    public static class LocalDataConfig extends H2DataSourceConfig {

        @Bean
        public DataSource dataSource() throws IOException {
            return dataSource("loveport");
        }

    }

//    @Configuration
//    @Profile("container")
//    public static class ContainerDataConfig {
//        @Bean
//        public Object dataSource() {
//            JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
//            bean.setJndiName("jdbc/LovePort");
//            bean.setResourceRef(true);
//            return bean;
//        }
//    }

}
