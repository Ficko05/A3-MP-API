package cph.asffnldg.classclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
@PropertySource("application.properties")
public class SoapClientConfig {

    @Value("${endpoint}")
    String endpoint;


    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("cph.asffnldg.classclient.wsdl");
        return jaxb2Marshaller;
    }

    @Bean
    public ClassClient articleClient(Jaxb2Marshaller jaxb2Marshaller) {
        ClassClient classClient = new ClassClient();
        classClient.setDefaultUri(endpoint);
        classClient.setMarshaller(jaxb2Marshaller);
        classClient.setUnmarshaller(jaxb2Marshaller);
        return classClient;
    }
}