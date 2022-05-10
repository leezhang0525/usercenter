package com.zhangsan.impl.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 图形验证码
 */
@Configuration
public class CaptchaConfig {

    @Bean
    public DefaultKaptcha captchaProducer() {
        DefaultKaptcha captchaProducer = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "105,179,90");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "black");
        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "100");
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "45");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "35");
        properties.setProperty(Constants.KAPTCHA_SESSION_CONFIG_KEY, "code");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Arial, Courier");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, "0123456789");
        properties.setProperty(Constants.KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.NoNoise");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "4");
        Config config = new Config(properties);
        captchaProducer.setConfig(config);
        return captchaProducer;
    }
}
