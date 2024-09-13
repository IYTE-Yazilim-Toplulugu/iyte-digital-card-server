package iyteyazilim.projects.digitalcard.entity;

import iyteyazilim.projects.digitalcard.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private Community community;

    @ElementCollection
    private List<UserDto> interestedUsers = new ArrayList<UserDto>();

    @ElementCollection
    private List<UserDto> notInterestedUsers = new ArrayList<UserDto>();

}
