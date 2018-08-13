package ua.com.oliinyk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    BaseSpringConfig.class,
    PersistenceConfig.class,
    HibernateConfig.class
})
public class SpringConfig {
  // just aggregator for other configs
}
