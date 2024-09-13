package iyteyazilim.projects.digitalcard.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class RatedMaleDto {
    private Integer id;
    private String name;
    private double rate;
}
