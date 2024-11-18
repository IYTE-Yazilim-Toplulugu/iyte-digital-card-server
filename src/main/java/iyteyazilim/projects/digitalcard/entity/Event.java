package iyteyazilim.projects.digitalcard.entity;

import iyteyazilim.projects.digitalcard.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="event")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String image;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    @JsonBackReference
    private Community community;

    @ElementCollection
    private List<UserDto> interestedUsers = new ArrayList<UserDto>();

    @ElementCollection
    private List<UserDto> notInterestedUsers = new ArrayList<UserDto>();

    public Event(Event original, Event updated) {
        this.id = original.getId();  // Keeping the original ID
        this.name = updated.getName() != null ? updated.getName() : original.getName();
        this.image = updated.getImage() != null ? updated.getImage() : original.getImage();
        this.description = updated.getDescription() != null ? updated.getDescription() : original.getDescription();
        this.community = updated.getCommunity() != null ? updated.getCommunity() : original.getCommunity();
        this.interestedUsers = updated.getInterestedUsers() != null ? updated.getInterestedUsers() : original.getInterestedUsers();
        this.notInterestedUsers = updated.getNotInterestedUsers() != null ? updated.getNotInterestedUsers() : original.getNotInterestedUsers();
    }
}
