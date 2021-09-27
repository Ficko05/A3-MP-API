package as.ff.nl.a3mpapi.Rest.controller;

import as.ff.nl.a3mpapi.Rest.exceptions.SubjectNotFoundException;
import as.ff.nl.a3mpapi.Rest.model.Student;
import as.ff.nl.a3mpapi.Rest.model.Subject;
import as.ff.nl.a3mpapi.Rest.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectRepository repo;

    @GetMapping("/all")
    public List<Subject> retrieveAllSubjects()
    {
        return repo.findAll();
    }

    // This is the only method, which returns hyperlinks, for now
    // If the resource is found, a link to its 'family' is appended to its native load
    @GetMapping("/{id}")
    public EntityModel<Subject> retrieveSubject(@PathVariable long id)

    {
        Optional<Subject> subject = repo.findById(id);
        if (!subject.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ENTITY NOT FOUND");

        EntityModel<Subject> resource = EntityModel.of(subject.get()); 						// get the resource
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllSubjects()); // get link
        resource.add(linkTo.withRel("all-subjects"));										// append the link

        Link selfLink = linkTo(methodOn(this.getClass()).retrieveSubject(id)).withSelfRel(); //add also link to self
        resource.add(selfLink);
        return resource;
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable long id) {
        repo.deleteById(id);
    }

    // Create a new resource and remember its unique location in the hypermedia
    @PostMapping("/")
    public ResponseEntity<Object> createSubject(@RequestBody Subject subject)
    {
        Subject savedSubject = repo.save(subject);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedSubject.getSubject_id()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSubject(@RequestBody Subject subject, @PathVariable long id)
    {
        Optional<Subject> subjectOptional = repo.findById(id);
        if (!subjectOptional.isPresent())
            return ResponseEntity.notFound().build();
        subject.setSubject_id(id);
        repo.save(subject);
        return ResponseEntity.noContent().build();
    }
}
