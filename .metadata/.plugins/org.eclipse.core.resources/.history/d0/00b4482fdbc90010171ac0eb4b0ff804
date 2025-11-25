@Service
public class RequestService {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private RequestRepository repo;

    private final String STUDENT_SERVICE_URL = "http://StudentManager/students";

    public Request save(Request req) {
        return repo.save(req);
    }

    public List<StudentDTO> getAllStudents() {
        StudentDTO[] students = restTemplate.getForObject(STUDENT_SERVICE_URL, StudentDTO[].class);
        return Arrays.asList(students);
    }

    public List<StudentDTO> recommend(Request req) {
        List<StudentDTO> all = getAllStudents();
        return all.stream()
                .filter(s -> s.getSkills().stream()
                        .anyMatch(req.getKeywords()::contains))
                .toList();
    }
}
