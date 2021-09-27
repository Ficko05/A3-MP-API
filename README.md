# A3-MP-API
Mini Project 1 SI

# participants

Allan Bo Simonsen - cph-as484
Nina Lisakowski - cph-nl163
Filip Filipovic - cph-ff37
Daniel Grønbjerg - cph-dg55


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

# RESTful API (with SOAP)
## How to run the service
Running the RESTful API service A3MPAPIapplication class with the main method

Alternatively you can run the Springboot initializer which should also be pointing at the main method

It requires the PORT number 8060 and a functional H2 database should be up and running.
sql scripts are supplied to fill the h2 database.


## Walkthrough of endpoints

### IP Locator
There is one endpoint which is a get endpoint. It is accessed through: 
```
localhost:8060/iplocator/{ip}
```
This endpoint return a string containing the country and state of the supplied IP address.
It is implemented with a SOAP service, which takes the ip and returns the location..
A return example for an IP address "79.142.224.239" could look like this:
```
DK17
```

### Subject
#### GET - all
The endpoint for this GET looks like below:
```
localhost:8060/subjects
```
This endpoint will return all the subjects available like below:
```
{
  "_embedded" : {
    "subjects" : [ {
      "name" : "System Integration",
      "classroom" : "2.62",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8060/subjects/1"
        },
        "subject" : {
          "href" : "http://localhost:8060/subjects/1"
        },
        "students" : {
          "href" : "http://localhost:8060/subjects/1/students"
        }
      }
    }, {
      "name" : "LSD",
      "classroom" : "2.62",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8060/subjects/2"
        },
        "subject" : {
          "href" : "http://localhost:8060/subjects/2"
        },
        "students" : {
          "href" : "http://localhost:8060/subjects/2/students"
        }
      }
    }, {
      "name" : "Test",
      "classroom" : "2.62",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8060/subjects/3"
        },
        "subject" : {
          "href" : "http://localhost:8060/subjects/3"
        },
        "students" : {
          "href" : "http://localhost:8060/subjects/3/students"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8060/subjects"
    },
    "profile" : {
      "href" : "http://localhost:8060/profile/subjects"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 3,
    "totalPages" : 1,
    "number" : 0
  }
}
```
#### GET - Specific subject
The endpoint for finding a specific subject is as below:
```
localhost:8060/subjects/{id}
```
Here you insert a valid ID, this can be either 1, 2 or 3

The endpoint with an ID of 1 will return this:
```
{
  "name" : "System Integration",
  "classroom" : "2.62",
  "_links" : {
    "all-subjects" : {
      "href" : "http://localhost:8060/subjects/all"
    },
    "self" : {
      "href" : "http://localhost:8060/subjects/1"
    }
  }
}
```

If an nonexisting ID is provided an error code NOT FOUND with status 404 will be thrown.

#### DELETE - Specific subject
For deleting a specific subject it is done as below in Postman:
```
localhost:8060/subjects/{id}
```
When providing an existing ID the subject will be deleted successfully and will return a status code 200.
If a nonexisting ID is provided a status code 500 will be thrown.

#### POST
A subject is created in Postman through this endpoint:
```
localhost:8060/subjects/
```
An example for what could be created could be like this:
```
{
    "classroom": "2.02",
    "name": "Testing" 
}
```
When creating a subject then a successful return will look like below and with a status code 200:
```
{
    "name": "Testing",
    "classroom": "2.02",
    "_links": {
        "self": {
            "href": "http://localhost:8060/subjects/4"
        },
        "subject": {
            "href": "http://localhost:8060/subjects/4"
        },
        "students": {
            "href": "http://localhost:8060/subjects/4/students"
        }
    }
}
```

An unsuccessful scenario will appear if you write a wrong name for a wrong field, this will throw a status code 400.

#### PUT - Specific subject
The endpoint for editing a specific subject looks like below:
```
localhost:8060/subjects/{id}
```
When editing a specific subject it is done in Postman with an existing ID. This could be 1, 2 or 3.

An example for what could be edited for any subject with a correct ID looks like below:
```
{
    "classroom": "2.62",
    "name": "TestingEdit" 
}
```
If a nonexisting ID is provided a status code 404 Not Found is thrown.

### Student

#### GET - all
The endpoint for this GET looks like below:
```
localhost:8060/students
```
This endpoint will return all the students available like below:
```
{
  "_embedded" : {
    "students" : [ {
      "name" : "Alice",
      "mail" : "al@mail.dk",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8060/students/101"
        },
        "student" : {
          "href" : "http://localhost:8060/students/101"
        },
        "subjects" : {
          "href" : "http://localhost:8060/students/101/subjects"
        }
      }
    }, {
      "name" : "Bob",
      "mail" : "bo@mail.dk",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8060/students/102"
        },
        "student" : {
          "href" : "http://localhost:8060/students/102"
        },
        "subjects" : {
          "href" : "http://localhost:8060/students/102/subjects"
        }
      }
    }, {
      "name" : "Caroline",
      "mail" : "ca@mail.dk",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8060/students/103"
        },
        "student" : {
          "href" : "http://localhost:8060/students/103"
        },
        "subjects" : {
          "href" : "http://localhost:8060/students/103/subjects"
        }
      }
    }, {
      "name" : "Daniel",
      "mail" : "da@mail.dk",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8060/students/104"
        },
        "student" : {
          "href" : "http://localhost:8060/students/104"
        },
        "subjects" : {
          "href" : "http://localhost:8060/students/104/subjects"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8060/students"
    },
    "profile" : {
      "href" : "http://localhost:8060/profile/students"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 4,
    "totalPages" : 1,
    "number" : 0
  }
}
```
#### GET - Specific student
The endpoint for finding a specific student is as below:
```
localhost:8060/students/{id}
```
Here you insert a valid ID, this can be either 101 , 102, 103, 104, 105, 106, 107, 108 & 109.

The endpoint with an ID of 101 will return this:
```
{
  "name" : "Alice",
  "mail" : "al@mail.dk",
  "_links" : {
    "all-students" : {
      "href" : "http://localhost:8060/students/all"
    },
    "self" : {
      "href" : "http://localhost:8060/students/101"
    }
  }
}
```

If an nonexisting ID is provided an error code NOT FOUND with status 404 will be thrown.

#### DELETE - Specific student
For deleting a specific student it is done as below in Postman:
```
localhost:8060/students/{id}
```
When providing an existing ID the student will be deleted successfully and will return a status code 200.
If a nonexisting ID is provided a status code 500 will be thrown.

#### POST - student
A student is created in Postman through this endpoint:
```
localhost:8060/students/
```
An example for what could be created could be like this:
```
{
    "name": "Dora",
    "email": "dora@email.com" 
}
```
When creating a student then a successful return will look like below and with a status code 200:
```
{
    "name": "Dora",
    "email": "dora@email.com",
    "_links": {
        "self": {
            "href": "http://localhost:8060/students/1"
        },
        "student": {
            "href": "http://localhost:8060/students/1"
        }
    }
}
```

An unsuccessful scenario will appear if you write a wrong name for a wrong field, this will throw a status code 400.

#### PUT - Specific student
The endpoint for editing a specific student looks like below:
```
localhost:8060/students/{id}
```
When editing a specific student it is done in Postman with an existing ID. This could be 101, 102, 103, 104, 105, 106, 107, 108, 109.

An example for what could be edited for any student with a correct ID looks like below:
```
localhost:8060/students/101
{
    "name": "steffen",
    "mail": "steffen@mail.com" 
}
```
If a nonexisting ID is provided a status code 404 Not Found is thrown.
