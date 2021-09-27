# A3-MP-API
Mini Project 1 SI

# Running the services
The services are implemented in separate projects.
Thus each service has to be started individually on it's own port.

Requires port 8080-808? are not in use.

# SOAP server/client
A simple POC of soap client/server in Java, using the classes of the semester.

Soap server can be run on localhost from the ClassService project, and will run on port 8082.
A wsdl can then be found and tested on: http://localhost:8082/ws/classes.wsdl
Sending a POST body consisting of to http://localhost:8082/ws:
```
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <getAllClassesRequest xmlns="http://spring.io/guides/gs-producing-web-service"/>
    </Body>
</Envelope>
``` 

should return:

```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getAllClassesResponse xmlns:ns2="http://spring.io/guides/gs-producing-web-service">
            <ns2:schoolClass>
                <ns2:name>Developing Large Systems</ns2:name>
                <ns2:ects>15</ns2:ects>
                <ns2:language>Danish</ns2:language>
            </ns2:schoolClass>
            <ns2:schoolClass>
                <ns2:name>System Integration</ns2:name>
                <ns2:ects>15</ns2:ects>
                <ns2:language>English</ns2:language>
                <ns2:teacher>
                    <ns2:name>Dora</ns2:name>
                    <ns2:email>tdi@cphbusiness.dk</ns2:email>
                    <ns2:age>38</ns2:age>
                </ns2:teacher>
            </ns2:schoolClass>
            <ns2:schoolClass>
                <ns2:name>Testing</ns2:name>
                <ns2:ects>15</ns2:ects>
                <ns2:language>Danish</ns2:language>
                <ns2:teacher>
                    <ns2:name>Steffen</ns2:name>
                    <ns2:email>helb@cphbusiness.dk</ns2:email>
                    <ns2:age>36</ns2:age>
                </ns2:teacher>
            </ns2:schoolClass>
        </ns2:getAllClassesResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```


A Soap client can be run from the ClassClient project, and will run on port 8083.
It curently sends a request for the "Testing" class and outputs the language to console.

# gRPC server

# Running the services
Runnig gRPC service is in the "main" src folder (src/main/java/as/ff/nl/a3mpapi/grpc)
To start the service run the StudentServer class in the server package.

Requires port 8099 is not in use.

Use BloomRPC to test the service, add the student.proto file.
Example:

 localhost:8099
 
 Editor:
 
 ```
 {
  "id": "103"
}
```

Should return:

```
{
  "id": "103",
  "name": "Caroline",
  "mail": "ca@mail.dk"
}
```

There are 4 id's "101,102,103,104"
Have Fun :)


