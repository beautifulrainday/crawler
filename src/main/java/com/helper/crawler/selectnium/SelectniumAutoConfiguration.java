package com.helper.crawler.selectnium;

import com.helper.crawler.selectnium.facade.SelectniumFacade;
import com.helper.crawler.selectnium.facade.impl.SelectniumServiceImpl;
import com.helper.crawler.selectnium.property.SelectniumProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhouxingyu
 * @Date 2023/8/25 14:11
 */
@Configuration
@EnableConfigurationProperties(SelectniumProperties.class)
public class SelectniumAutoConfiguration {

    static {
        System.out.println("init SelectniumAutoConfiguration");
    }

    @Bean
    public SelectniumFacade selectniumFacade() {
        return new SelectniumServiceImpl();
    }

}


