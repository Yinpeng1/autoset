package com.yp.autoset;

import com.yp.autoset.config.ScanAnnotation;
import com.yp.autoset.controller.TestController;
import com.yp.autoset.util.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = "com.yp.autoset")
public class AutosetApplication {

    public static void main(String[] args) throws Exception{
        ApplicationContext app= SpringApplication.run(AutosetApplication.class, args);
        SpringContextUtil.setApplicationContext(app);
        System.out.println(SpringContextUtil.getBean("userMapper"));
        run("11");
    }

//    public static void main(String[] args) {
//        ScanAnnotation scanAnnotation = new ScanAnnotation();
//        try {
//            scanAnnotation.setSingletonInMap();
//            scanAnnotation.autoSet();
//
//            TestController testController = (TestController) ScanAnnotation.map.get(TestController.class);
//            testController.sayHello("yinpeng");
//        } catch (Exception e){
//            e.printStackTrace();
//            System.out.println("实例化失败");
//        }
//    }


    public static void run(String... args) throws Exception {
        ScanAnnotation scanAnnotation = new ScanAnnotation();
        try {
            scanAnnotation.setSingletonInMap();
            scanAnnotation.autoSet();
//            TestController testController = (TestController) ScanAnnotation.map.get(TestController.class);
//            testController.sayHello("yinpeng");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("实例化失败");
        }
    }
}
