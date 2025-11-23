@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private Long requesterId;

    private String date;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        WAITING,
        IN_PROGRESS,
        DONE,
        ABANDONED,
        CLOSED
    }
}
