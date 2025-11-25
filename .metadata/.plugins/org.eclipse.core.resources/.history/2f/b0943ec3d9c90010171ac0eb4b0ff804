@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService service;

    @PostMapping
    public Map<String, Object> create(@RequestBody Request req) {
        Request saved = service.save(req);

        List<StudentDTO> recommended = service.recommend(req);

        return Map.of(
                "request", saved,
                "recommended", recommended
        );
    }

    @GetMapping
    public List<Request> getAll() {
        return service.repo.findAll();
    }
}
