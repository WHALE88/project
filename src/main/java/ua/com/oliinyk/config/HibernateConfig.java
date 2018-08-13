package ua.com.oliinyk.config;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
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

  private static final String QUERY_CACHE = "hibernate.cache.use_query_cache";
  private static final String FACTORY_CLASS = "hibernate.cache.region.factory_class";
  private static final String SECOND_LEVEL_CACHE = "hibernate.cache.use_second_level_cache";

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


  @Bean(name = "dataSource")
  public DataSource dataSource() {
    MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
    dataSource.setUrl(environment.getRequiredProperty("javax.persistence.jdbc.url"));
    dataSource.setUser(environment.getRequiredProperty("javax.persistence.jdbc.username"));
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

    //todo: add second level cache
//    properties.put(SECOND_LEVEL_CACHE, environment.getRequiredProperty("hibernate.cache.use_second_level_cache"));
//    properties.put(FACTORY_CLASS, environment.getRequiredProperty("hibernate.cache.region.factory_class"));
//    properties.put(QUERY_CACHE, environment.getRequiredProperty("hibernate.cache.use_query_cache"));

    // Setting C3P0 properties
    properties.put(C3P0_MIN_SIZE, environment.getProperty("hibernate.c3p0.min_size"));
    properties.put(C3P0_MAX_SIZE, environment.getProperty("hibernate.c3p0.max_size"));
    properties.put(C3P0_ACQUIRE_INCREMENT, environment.getProperty("hibernate.c3p0.acquire_increment"));
    properties.put(C3P0_TIMEOUT, environment.getProperty("hibernate.c3p0.timeout"));
    properties.put(C3P0_MAX_STATEMENTS, environment.getProperty("hibernate.c3p0.max_statements"));
    properties.put(C3P0_IDLE_TEST_PERIOD, environment.getProperty("hibernate.c3p0.idle_test_period"));

    return properties;
  }

  @Bean(name = "liquibase")
  public SpringLiquibase liquibase(DataSource dataSource) {
    SpringLiquibase liquibase = new SpringLiquibase();
    liquibase.setDataSource(dataSource);
    liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.xml");
    return liquibase;
  }

  @Bean
  @DependsOn("liquibase")
  public EntityManagerFactory entityManagerFactory(
      DataSource dataSource,
      JpaVendorAdapter jpaVendorAdapter
  ) {

    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setDataSource(dataSource);
    factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
    factoryBean.setPackagesToScan(
        "ua.com.oliinyk"
    );
    factoryBean.setJpaProperties(hibernateProperties());
    factoryBean.afterPropertiesSet();

    return factoryBean.getObject();
  }
//
//  @Bean
//  public LocalSessionFactoryBean getSessionFactory() {
//    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//    sessionFactory.setDataSource(dataSource());
//    sessionFactory.setPackagesToScan("ua.com.oliinyk");
//    sessionFactory.setHibernateProperties(hibernateProperties());
//    return sessionFactory;
//  }
//
//  @Bean
//  public HibernateTransactionManager getTransactionManager() {
//    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//    transactionManager.setSessionFactory(getSessionFactory().getObject());
//    return transactionManager;
//  }
}