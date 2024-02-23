package com.cos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author luXinYu
 * @create 2024/1/17 10:06
 */

@SpringBootApplication
@MapperScan("com.cos.mapper")
public class CosApplication
{

    public static void main(String[] args) {
        SpringApplication.run(CosApplication.class, args);
    }
}
