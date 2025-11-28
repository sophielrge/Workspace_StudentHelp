package fr.insa.StudentHelp.RequestManager.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.insa.StudentHelp.RequestManager.model.Request;
import fr.insa.StudentHelp.RequestManager.model.RequestEntity;
import fr.insa.StudentHelp.RequestManager.model.Student;
import fr.insa.StudentHelp.RequestManager.repository.RequestRepository;

@Service
public class RequestService {
	
	@Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RequestRepository repo;

    private final String STUDENT_SERVICE_URL = "http://StudentManager/students";

    public Request save(Long id_user, Request req) {
    	req.setRequesterId(id_user);       
    	return getRepo().save(req);
    }

    public List<Student> getAllStudents() {
        Student[] students = restTemplate.getForObject(STUDENT_SERVICE_URL, Student[].class);
        return Arrays.asList(students);
    }

    public List<Student> recommend( Request req) {
        List<Student> all = getAllStudents();
        return all.stream()
                .filter(s -> s.getSkills().stream()
                        .anyMatch(req.getKeywords()::contains))
                .toList();
    }
    
	public RequestRepository getRepo() {
		return repo;
	}

	public void setRepo(RequestRepository repo) {
		this.repo = repo;
	}
}
