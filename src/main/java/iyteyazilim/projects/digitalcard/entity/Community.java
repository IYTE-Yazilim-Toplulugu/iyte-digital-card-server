package iyteyazilim.projects.digitalcard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="community")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String logo;
    private String coverImage;
    private String email;

    @ManyToMany
    private List<User> followers = new ArrayList<User>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "community")
    private List<Event> events = new ArrayList<Event>();
    public Community(Community original, Community updated) {
        this.id = original.getId();  // Keeping the original ID
        this.name = updated.getName() != null ? updated.getName() : original.getName();
        this.description = updated.getDescription() != null ? updated.getDescription() : original.getDescription();
        this.coverImage = updated.getCoverImage() != null ? updated.getCoverImage() : original.getCoverImage();
        this.email = updated.getEmail() != null ? updated.getEmail() : original.getEmail();
        this.password = updated.getPassword() != null ? updated.getPassword() : original.getPassword();
        this.followers = updated.getFollowers() != null ? updated.getFollowers() : original.getFollowers();
        this.events = updated.getEvents() != null ? updated.getEvents() : original.getEvents();
    }
}
