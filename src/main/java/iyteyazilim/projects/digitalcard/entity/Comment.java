package iyteyazilim.projects.digitalcard.entity;

import iyteyazilim.projects.digitalcard.dto.RatedMaleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;
    private Date date;
    private double rate;

    @ElementCollection
    private List<RatedMaleDto> singularRates;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
