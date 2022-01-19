package com.senla.dao.configuration;


import lombok.SneakyThrows;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;


@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class JpaConfiguration {

    @Value("${database.url}")
    private String databaseUrl;
    @Value("${database.user}")
    private String databaseUser;
    @Value("${database.password}")
    private String databasePassword;
    @Value("#{${database.hibernate}}")
    private Map<String, String> hibernateAdditionalProperties;
    @Value("${hibernate.show_sql}")
    private String showSql;

    @Bean
    @SneakyThrows
    public DataSource dataSource() {
        return new DriverManagerDataSource(
                databaseUrl, databaseUser, databasePassword
        );
    }

    @Bean
    public TransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public FactoryBean<EntityManagerFactory> entityManagerFactory(DataSource dataSource) {
        final LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.senla.entity");
        localContainerEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaProperties(getJpaProperties());
        return localContainerEntityManagerFactoryBean;
    }
    private Properties getJpaProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql",showSql);
        return properties;
    }


}