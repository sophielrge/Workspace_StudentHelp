@Service
public class RequestService {

    @Autowired
    private RequestRepository repo;

    @Autowired
    private StudentClient studentClient;

    public Request save(Request req) {
        return repo.save(req);
    }

    public List<StudentDTO> recommend(Request req) {
        List<StudentDTO> all = studentClient.getAll();
        return all.stream()
                .filter(s -> s.skills.stream()
                        .anyMatch(req.keywords::contains))
                .toList();
    }
}