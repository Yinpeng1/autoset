//package com.yp.autoset.invocation;
//
//import com.yp.autoset.mapper.UserMapper;
//import org.apache.ibatis.session.SqlSession;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.mapper.MapperFactoryBean;
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//
//import java.lang.reflect.Method;
//
//public class MapperProxy implements MethodInterceptor {
//
//
//    @Override
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
////        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
////        bean.setDataSource(dataSource());
////
////        // 添加XML目录
////        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
////
////        bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
////        return bean.getObject();
////
//        MapperFactoryBean mapperFactoryBean = new MapperFactoryBean(UserMapper.class);
//        mapperFactoryBean.getObject();
////        Object ob = methodProxy.invokeSuper();
//        return null;
//    }
//}
