package ua.com.oliinyk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    HibernateConfig.class
})
public class SpringConfig {
  // just aggregator for other configs
}
