package iyteyazilim.projects.digitalcard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="announcements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String image;
    private Integer orderNumber;
    private String url;
    private boolean isActive;
    private Date createdAt;

    public Announcement(Announcement original, Announcement updatedAnnouncement) {
        this.id = original.getId();  // Keeping the original ID
        this.name = updatedAnnouncement.getName() != null ? updatedAnnouncement.getName() : original.getName();
        this.image = updatedAnnouncement.getImage() != null ? updatedAnnouncement.getImage() : original.getImage();
        this.orderNumber = updatedAnnouncement.getOrderNumber() != null ? updatedAnnouncement.getOrderNumber() : original.getOrderNumber();
        this.url = updatedAnnouncement.getUrl() != null ? updatedAnnouncement.getUrl() : original.getUrl();
        this.isActive = updatedAnnouncement.isActive();
        this.createdAt = updatedAnnouncement.getCreatedAt() != null ? updatedAnnouncement.getCreatedAt() : original.getCreatedAt();
    }
}
