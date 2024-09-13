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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String logo;
    private String coverImage;
    private String email;
    private String password;

    @ManyToMany
    private List<User> followers = new ArrayList<User>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "community")
    private List<Event> events = new ArrayList<Event>();
}
