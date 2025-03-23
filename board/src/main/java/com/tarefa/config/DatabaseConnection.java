//package com.tarefa.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//@Component
//public class DatabaseConnection {
//
//    @Value("${spring.datasource.url}")
//    private String dbUrl;
//
//    @Value("${spring.datasource.username}")
//    private String dbUsername;
//
//    @Value("${spring.datasource.password}")
//    private String dbPassword;
//
//    public Connection conectar() throws SQLException {
//        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
//    }
//}
