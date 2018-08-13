package com.yp.autoset.invocation;

import com.yp.autoset.annotation.Yinpeng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.ObjectUtils;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.util.*;

public class CglibProxy implements MethodInterceptor {

    private static List<TransactionTemplate> list = new ArrayList<>();

    public TransactionTemplate getTransTemplate(){
        if (ObjectUtils.isEmpty(list)){
            TransactionTemplate transactionTemplate = new TransactionTemplate();
            DataSource dataSource = DataSourceBuilder
                    .create(this.getClass().getClassLoader())
                    .driverClassName("com.mysql.jdbc.Driver")
                    .url("jdbc:mysql://127.0.0.1:3306/test?useSSL=false&characterEncoding=utf8").username("root")
                    .password("123").build();
            DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
            dataSourceTransactionManager.setDataSource(dataSource);
            transactionTemplate.setTransactionManager(dataSourceTransactionManager);
            list.add(transactionTemplate);
        }
        return list.get(0);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        transactionTemplate.execute(new TransactionCallback<Object>() {
//            @Override
//            public Object doInTransaction(TransactionStatus transactionStatus) {
//                try {
//                    methodProxy.invokeSuper(o, objects);
//                } catch (Throwable e){
//                    System.out.println("代理执行错误");
//                }
//                return null;
//            }
//        });
        return getTransTemplate().execute((transactionStatus) ->{
            try {
                return methodProxy.invokeSuper(o, objects);
            }catch (Throwable throwable){
                return null;
            }
        });
    }
}
