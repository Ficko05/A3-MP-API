package cph.asffnldg.classservice.webservice;

import cph.asffnldg.classservice.repository.ClassRepository;
import io.spring.guides.gs_producing_web_service.GetAllClassesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetClassRequest;
import io.spring.guides.gs_producing_web_service.GetClassResponse;

@Endpoint
public class ClassService {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClassRequest")
    @ResponsePayload
    public GetClassResponse getClass(@RequestPayload GetClassRequest request) {
        GetClassResponse response = new GetClassResponse();
        response.setSchoolClass(classRepository.findClass(request.getName()));

        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllClassesRequest")
    @ResponsePayload
    public GetAllClassesResponse getAllClasses() {
        GetAllClassesResponse response = new GetAllClassesResponse();
        response.getSchoolClass().addAll(classRepository.getAllClasses());

        return response;
    }

}
