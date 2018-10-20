package ua.com.oliinyk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = {
    "ua.com.oliinyk"
})
public class PersistenceConfig {

  /**
   * JpaVendorAdapter implementation for Hibernate EntityManager.
   * @return JpaVendorAdapter
   */
  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    jpaVendorAdapter.setDatabasePlatform("hibernate.dialect");
    jpaVendorAdapter.setGenerateDdl(false);
    jpaVendorAdapter.setShowSql(false);
    return jpaVendorAdapter;
  }

  @Bean
  PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager tm = new JpaTransactionManager();
    tm.setEntityManagerFactory(entityManagerFactory);
    return tm;
  }

}
