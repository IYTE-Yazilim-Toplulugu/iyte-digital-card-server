package iyteyazilim.projects.digitalcard.entity;

import iyteyazilim.projects.digitalcard.dto.RatedMealDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private Date date;
    private double rate;

    @ElementCollection
    private List<RatedMealDto> singularRates;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
