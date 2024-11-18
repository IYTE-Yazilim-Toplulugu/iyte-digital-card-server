package iyteyazilim.projects.digitalcard.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class RatedMealDto {

    private Long id;
    private String name;
    private double rate;

    public RatedMealDto(RatedMealDto other){
        this.id = other.getId();
        this.name = other.getName();
        this.rate = other.getRate();
    }
}
