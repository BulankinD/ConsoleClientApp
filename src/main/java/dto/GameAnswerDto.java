package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author : Bulankin_D
 * @created : 18.01.2022, вторник
 **/
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameAnswerDto
{
    public Game game;

    public String message;

    public Integer customResponseCode;
}
