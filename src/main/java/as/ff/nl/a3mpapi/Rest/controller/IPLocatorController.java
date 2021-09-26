package as.ff.nl.a3mpapi.Rest.controller;

import as.ff.nl.a3mpapi.Rest.exceptions.StudentNotFoundException;
import as.ff.nl.a3mpapi.Rest.ipsoapservice.GeoIPServiceLocator;
import as.ff.nl.a3mpapi.Rest.ipsoapservice.GeoIPServiceSoap_PortType;
import as.ff.nl.a3mpapi.Rest.model.Student;
import as.ff.nl.a3mpapi.Rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/iplocator")
public class IPLocatorController {


    @GetMapping("/{ip}")
    public String ipLocatorResponse(@PathVariable String ip) {
        String country = "";
        try {
            GeoIPServiceLocator locator = new GeoIPServiceLocator();
            GeoIPServiceSoap_PortType service = locator.getGeoIPServiceSoap();

            country = service.getIpLocation(ip);
            System.out.println(country);
            System.out.println("Success");
            System.out.println(ip);
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        } catch (java.rmi.RemoteException ex) {
            ex.printStackTrace();
        }
        return country;
    }
}
