package utils;

import dto.Game;
import dto.GameAnswerDto;
import dto.User;
import lombok.Builder;
import lombok.Data;

/**
 * @author : Bulankin_D
 * @created : 18.01.2022, вторник
 **/
@Builder
@Data
public class GameContext
{
    private User user;

    private Game game;

    private GameAnswerDto gameAnswerDto;

}
