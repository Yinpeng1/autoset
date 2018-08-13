//package com.yp.autoset.config;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.support.TransactionTemplate;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    public TransactionTemplate init(){
//        TransactionTemplate transactionTemplate = new TransactionTemplate();
//        DataSource dataSource = DataSourceBuilder
//                .create(this.getClass().getClassLoader())
//                .driverClassName("com.mysql.jdbc.Driver")
//                .url("jdbc:mysql://127.0.0.1:3306/test?useSSL=false&characterEncoding=utf8").username("root")
//                .password("123").build();
//        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
//        dataSourceTransactionManager.setDataSource(dataSource);
//        transactionTemplate.setTransactionManager(dataSourceTransactionManager);
//        return transactionTemplate;
//    }
//}
