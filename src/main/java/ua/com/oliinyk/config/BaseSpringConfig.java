package ua.com.oliinyk.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"ua.com.oliinyk"})
public class BaseSpringConfig {
  @Bean("messageSource")
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("/WEB-INF/i18n/messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }

  @Bean
  public LocaleResolver localeResolver() {
    Locale ruLocale = new Locale.Builder().setLanguage("ru").build();
    SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
    sessionLocaleResolver.setDefaultLocale(ruLocale);
    return sessionLocaleResolver;
  }

//  @Bean
//  public FreeMarkerViewResolver freemarkerViewResolver() {
//    FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//    resolver.setCache(true);
//    resolver.setPrefix("");
//    resolver.setSuffix(".ftl");
//    return resolver;
//  }

  @Bean(name = "mailSender")
  public JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(465);

    mailSender.setUsername("real@gmail.com");
    mailSender.setPassword("realPassword");

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.debug", "true");

    return mailSender;
  }
}
