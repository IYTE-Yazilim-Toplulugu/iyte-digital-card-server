package iyteyazilim.projects.digitalcard.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String image;
    private String phoneNumber;
    private boolean isActive;
    private Date joinedAt;

    @ManyToMany
    private List<Community> followingCommunities = new ArrayList<Community>();

    @ManyToMany
    private List<Group> followingGroups = new ArrayList<Group>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Message> messages = new ArrayList<Message>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments = new ArrayList<Comment>();

    public User(String email) {
        this.email = email;
    }
}
