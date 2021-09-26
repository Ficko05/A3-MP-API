package cph.asffnldg.classclient;

import cph.asffnldg.classclient.wsdl.GetClassRequest;
import cph.asffnldg.classclient.wsdl.GetClassResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ClassClient extends WebServiceGatewaySupport{
    public GetClassResponse getSchoolClass(String name){
        GetClassRequest getClassRequest = new GetClassRequest();
        getClassRequest.setName(name);
        return (GetClassResponse) getWebServiceTemplate().marshalSendAndReceive(getClassRequest);
    }
}

