package com.cos.config.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author luXinYu
 * @create 2024/1/18 13:35
 */
@Data
@Component
@ConfigurationProperties(prefix = "api")
public class BaseConf {

    @Value("${api.end-point}")
    private String endpoint;

}
