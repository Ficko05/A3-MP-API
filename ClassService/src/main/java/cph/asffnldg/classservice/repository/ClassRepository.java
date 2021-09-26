package cph.asffnldg.classservice.repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.SchoolClass;
import io.spring.guides.gs_producing_web_service.Teacher;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class ClassRepository {
    private static final Map<String, SchoolClass> classes = new HashMap<>();

    @PostConstruct
    public void initData() {
        SchoolClass systemintegration = new SchoolClass();
        systemintegration.setName("System Integration");
        systemintegration.setEcts(15);
        systemintegration.setLanguage("English");

        var dora = new Teacher();
        dora.setName("Dora");
        dora.setEmail("tdi@cphbusiness.dk");
        dora.setAge(38);
        systemintegration.setTeacher(dora);

        classes.put(systemintegration.getName(), systemintegration);

        SchoolClass dls = new SchoolClass();
        dls.setName("Developing Large Systems");
        dls.setEcts(15);
        dls.setLanguage("Danish");

        classes.put(dls.getName(), dls);

        SchoolClass test = new SchoolClass();
        test.setName("Testing");
        test.setEcts(15);
        test.setLanguage("Danish");

        var steffen = new Teacher();
        steffen.setName("Steffen");
        steffen.setEmail("helb@cphbusiness.dk");
        steffen.setAge(36);
        test.setTeacher(steffen);

        classes.put(test.getName(), test);
    }

    public SchoolClass findClass(String name) {
        Assert.notNull(name, "The class's name must not be null");
        return classes.get(name);
    }

    public List<SchoolClass> getAllClasses() {
        return new ArrayList<>(classes.values());
    }
}
