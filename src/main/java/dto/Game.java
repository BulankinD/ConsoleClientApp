package dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Bulankin_D
 * @created : 18.01.2022, вторник
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Game
{
    public String Id;

    private User user;

    private String targetWord;

    private String currentState;

    private Integer attempts;

    private Integer RemainingAttempts = attempts;

    private Boolean completed = false;
}
