package ua.com.oliinyk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("ua.com.oliinyk")})
public class HibernateConfig {

  private static final String DIALECT = "hibernate.dialect";
  private static final String SHOW_SQL = "hibernate.show_sql";
  private static final String FORMAT_SQL = "hibernate.format_sql";
  private static final String HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

  private static final String C3P0_MIN_SIZE = "hibernate.c3p0.min_size";
  private static final String C3P0_MAX_SIZE = "hibernate.c3p0.max_size";
  private static final String C3P0_ACQUIRE_INCREMENT = "hibernate.c3p0.acquire_increment";
  private static final String C3P0_TIMEOUT = "hibernate.c3p0.timeout";
  private static final String C3P0_MAX_STATEMENTS = "hibernate.c3p0.max_statements";
  private static final String C3P0_IDLE_TEST_PERIOD = "hibernate.c3p0.idle_test_period";


  private final Environment environment;

  @Autowired
  public HibernateConfig(Environment environment) {
    this.environment = environment;
  }

  @Bean
  public LocalSessionFactoryBean getSessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan("ua.com.oliinyk");
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(environment.getRequiredProperty("javax.persistence.jdbc.driver"));
    dataSource.setUrl(environment.getRequiredProperty("javax.persistence.jdbc.url"));
    dataSource.setUsername(environment.getRequiredProperty("javax.persistence.jdbc.username"));
    dataSource.setPassword(environment.getRequiredProperty("javax.persistence.jdbc.password"));
    return dataSource;
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();
    // Setting Hibernate properties
    properties.put(DIALECT, environment.getRequiredProperty("hibernate.dialect"));
    properties.put(SHOW_SQL, environment.getRequiredProperty("hibernate.show_sql"));
    properties.put(FORMAT_SQL, environment.getRequiredProperty("hibernate.format_sql"));
    properties.put(HBM2DDL_AUTO, environment.getRequiredProperty("hibernate.hbm2ddl.auto"));

    // Setting C3P0 properties
    properties.put(C3P0_MIN_SIZE, environment.getProperty("hibernate.c3p0.min_size"));
    properties.put(C3P0_MAX_SIZE, environment.getProperty("hibernate.c3p0.max_size"));
    properties.put(C3P0_ACQUIRE_INCREMENT, environment.getProperty("hibernate.c3p0.acquire_increment"));
    properties.put(C3P0_TIMEOUT, environment.getProperty("hibernate.c3p0.timeout"));
    properties.put(C3P0_MAX_STATEMENTS, environment.getProperty("hibernate.c3p0.max_statements"));
    properties.put(C3P0_IDLE_TEST_PERIOD, environment.getProperty("hibernate.c3p0.idle_test_period"));

    return properties;
  }

  @Bean
  public HibernateTransactionManager getTransactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(getSessionFactory().getObject());
    return transactionManager;
  }
}