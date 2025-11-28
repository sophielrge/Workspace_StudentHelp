
package fr.insa.StudentHelp.StudentManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.insa.StudentHelp.StudentManager.mapper.StudentMapper;
import fr.insa.StudentHelp.StudentManager.model.StudentEntity;
import fr.insa.StudentHelp.StudentManager.model.Student;
import fr.insa.StudentHelp.StudentManager.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;
    
    @Autowired
    private StudentMapper mapper;


    public void delete(Long id) {
        repo.deleteById(id);
    }


    public Student save(Student dto) {
        StudentEntity s = mapper.toEntity(dto);
        StudentEntity saved = repo.save(s);
        return mapper.toDTO(saved);
    }

    public List<Student> getAll() {
        return repo.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Student get(Long id) {
        return repo.findById(id)
                   .map(mapper::toDTO)
                   .orElse(null);
    }
    
    public Student update(Long id, Student student) {
        return repo.findById(id)
            .map(entity -> {
            	entity.setFirstname(student.getFirstname());
            	entity.setLastname(student.getLastname());
            	entity.setEmail(student.getEmail());
            	entity.setSpeciality(student.getSpeciality());
                entity.setSkills(student.getSkills());
                entity.setAvailability(student.getAvailability());
                return mapper.toDTO(repo.save(entity));
            })
            .orElse(null);
    }
    
    public Student add_review(Long id, int review) {
    	return repo.findById(id)
                .map(entity -> {
                	int new_counter = entity.getCounter()+1;
                	double new_rate = (entity.getRating()*entity.getCounter()+review)/(new_counter);
                	entity.setRating(new_rate);
                	entity.setCounter(new_counter);
                    return mapper.toDTO(repo.save(entity));
                })
                .orElse(null);
    }
    
    public Student getByEmail(String email) {
        return repo.findByEmail(email)
                .map(entity -> mapper.toDTO(entity))
                .orElse(null);
    }

}
