package iyteyazilim.projects.digitalcard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="chatroom")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String image;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Message> messages = new ArrayList<Message>();

    @ManyToMany
    private List<User> followings = new ArrayList<User>();

}
