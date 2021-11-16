package com.senla.dao.dbconnector;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
//@PropertySource("jdbc.properties")
@EnableAspectJAutoProxy
public class DbConnector {

//    @Value("${database.url}")
//    private String databaseUrl;
//    @Value("${database.username}")
//    private String username;
//    @Value("${database.password}")
//    private String password;
// Не получается через проперти
    @Value("jdbc:postgresql://localhost:5432/AZS")
    private String databaseUrl;
    @Value("postgres")
    private String username;
    @Value("qaz123")
    private String password;

   @Bean(destroyMethod = "close")
   @SneakyThrows
    public Connection connection(){
        return DriverManager.getConnection(databaseUrl,username,password);
   }
}
