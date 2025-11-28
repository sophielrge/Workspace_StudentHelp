package fr.insa.StudentHelp.RequestManager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.StudentHelp.RequestManager.model.Request;
import fr.insa.StudentHelp.RequestManager.model.RequestEntity;
import fr.insa.StudentHelp.RequestManager.model.Student;
import fr.insa.StudentHelp.RequestManager.repository.RequestRepository;
import fr.insa.StudentHelp.RequestManager.service.RequestService;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService service;
    
    @Autowired
    private RequestRepository repo;

    @PostMapping("/{id_user}")
    public Map<String, Object> create(@PathVariable Long id_user, @RequestBody Request req) {
        Request saved = service.save(id_user, req);

        List<Student> recommended = service.recommend(req);

        return Map.of(
                "request", saved,
                "recommended", recommended
        );
    }

    @GetMapping
    public List<Request> getAll() {
        return service.getRepo().findAll();
    }
    
    @GetMapping("/recommend/{id_user}/{id_request}")
    public Map<String, Object> getRecommend(@PathVariable Long id_user, @PathVariable Long id_request) {
    	 Request req = repo.findById(id_request).orElse(null);

         List<Student> recommended = service.recommend(req);

         return Map.of(
                 "request", req,
                 "recommended", recommended
         );
    }
    
    
}
