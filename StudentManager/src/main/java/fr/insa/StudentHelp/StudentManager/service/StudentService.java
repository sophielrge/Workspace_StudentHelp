@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student save(Student s) {
        return repo.save(s);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Optional<Student> get(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public StudentDTO toDTO(Student s) {
        return new StudentDTO(
                s.getId(),
                s.getFirstname(),
                s.getLastname(),
                s.getEmail(),
                s.getEstablishment(),
                s.getField(),
                s.getSkills(),
                s.getAvailability(),
                s.getRating()
        );
    }

    public Student toEntity(StudentDTO dto) {
        Student s = new Student();
        s.setId(dto.getId());
        s.setFirstname(dto.getFirstname());
        s.setLastname(dto.getLastname());
        s.setEmail(dto.getEmail());
        s.setEstablishment(dto.getEstablishment());
        s.setField(dto.getField());
        s.setSkills(dto.getSkills());
        s.setAvailability(dto.getAvailability());
        s.setRating(dto.getRating());
        return s;
    }
}
