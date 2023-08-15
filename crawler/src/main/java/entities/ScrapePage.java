package entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class ScrapePage {

    private String id;

    private String sessionUrl;

    private LocalDateTime created;

    public ScrapePage(String sessionUrl) {
        this.id = UUID.randomUUID().toString();
        this.sessionUrl = sessionUrl;
        this.created = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionUrl() {
        return sessionUrl;
    }

    public void setSessionUrl(String sessionUrl) {
        this.sessionUrl = sessionUrl;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "ScrapePage{" +
                "id='" + id + '\'' +
                ", sessionUrl='" + sessionUrl + '\'' +
                ", created=" + created +
                '}';
    }
}