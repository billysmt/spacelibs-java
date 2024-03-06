/* (C)2024 */
package com.siliconmtn.io.sms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "smsConfig.amazonSMS")
@ConfigurationPropertiesScan
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AmazonSMSConfig implements SMSConfig {

    private String awsRegion;
    private String accessKeyId;
    private String secretAccessKey;
}
