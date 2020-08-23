package net.k_yokoi.sample.monolith.to.microservice.chat.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("net.k_yokoi.sample.monolith.to.microservice.chat.domain")
@Configuration
public class DomainConfig {
}
