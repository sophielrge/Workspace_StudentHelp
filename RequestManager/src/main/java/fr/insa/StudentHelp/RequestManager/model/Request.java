package fr.insa.StudentHelp.RequestManager.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "requester_id", nullable = false)
    private Long requesterId;

    private String date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ElementCollection
    @CollectionTable(name = "request_keywords", joinColumns = @JoinColumn(name = "request_id"))
    @Column(name = "keyword")
    private List<String> keywords;

    public Request() {}

    public Request(Long id, String title, String description, Long requesterId,
                   String date, Status status, List<String> keywords) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.requesterId = requesterId;
        this.date = date;
        this.status = status;
        this.keywords = keywords;
    }

    public enum Status {
        WAITING,
        IN_PROGRESS,
        DONE,
        ABANDONED,
        CLOSED
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getRequesterId() { return requesterId; }
    public void setRequesterId(Long requesterId) { this.requesterId = requesterId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public List<String> getKeywords() { return keywords; }
    public void setKeywords(List<String> keywords) { this.keywords = keywords; }
}