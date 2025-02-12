package model;



import java.time.LocalDateTime;
import java.util.UUID;

public class PetResponse {
    private String transactionId;
    private LocalDateTime dateCreated;
    private Long id;
    private String name;
    private String status;

    public PetResponse(Long id, String name, String status) {
        this.transactionId = UUID.randomUUID().toString();
        this.dateCreated = LocalDateTime.now();
        this.id = id;
        this.name = name;
        this.status = status;
    }


    public String getTransactionId() {
        return transactionId;
    }
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }
}
