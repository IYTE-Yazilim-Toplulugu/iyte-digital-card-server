package iyteyazilim.projects.digitalcard.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CommunityDto {
    private String email;
    private String password;
}
