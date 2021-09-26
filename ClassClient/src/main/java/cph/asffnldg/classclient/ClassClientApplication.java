package cph.asffnldg.classclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ClassClientApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        ClassClient classClient = annotationConfigApplicationContext.getBean(ClassClient.class);
        System.out.println(classClient.getSchoolClass("Testing").getSchoolClass().getLanguage());


        SpringApplication.run(ClassClientApplication.class, args);
    }

}
