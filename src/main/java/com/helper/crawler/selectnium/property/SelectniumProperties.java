package com.helper.crawler.selectnium.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.helper.crawler.selectnium.property.SelectniumProperties.PRE;

/**
 * @Author zhouxingyu
 * @Date 2023/8/25 14:25
 */
@ConfigurationProperties(prefix = PRE)
public class SelectniumProperties {

    public static final String PRE = "selectnium";
}
