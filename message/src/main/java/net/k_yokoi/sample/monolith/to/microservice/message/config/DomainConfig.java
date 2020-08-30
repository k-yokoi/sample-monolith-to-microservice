package net.k_yokoi.sample.monolith.to.microservice.message.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("net.k_yokoi.sample.monolith.to.microservice.message.domain")
@Configuration
public class DomainConfig {
}
