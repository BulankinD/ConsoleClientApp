import java.io.Serializable;
import java.util.Scanner;
import java.util.SplittableRandom;

import org.springframework.util.StringUtils;

import clients.ServerApiClient;
import dto.User;
import dto.UserDto;
import utils.GameContext;

/**
 * @author : Bulankin_D
 * @created : 18.01.2022, вторник
 **/
public class Application
{
    public static final String WELCOME="Добро пожаловать в игру 'Поле чудес'! \n " +
            "Введите имя пользователя для начала игры \n " +
            "Например, adam \n " +
            "И нажмите Enter";
    public static final String NEW_GAME="Хотите начать новую игру? \n " +
            "Если да, то укажите уровень сложности цифрой от 1 до 3. \n " +
            "Либо укажите 0, тогда уровень игры будет по умолчанию для вашего пользователя" +
            "Не забудьте нажать Enter";
    public static final String INCORRECT_INPUT_FORMAT="Неверный формат ввода \n" +
            "Попробуйте еще раз";
    public static final String INPUT_LETTER_ASKING="Пожалуйста введите произвольную букву от a до z \n" +
            "Регистр учитывается, Буквы на Латинице \n " +
            "Также вы можете попробовать угадать все слово целиком" +
            "Не забудьте нажать Enter";
    public static final String CONGRATULATE="Поздравляем, вы выиграли Автомобиль! \n" +
            "Хотите начать игру заново? \n " +
            "Напишите Y (да) или N (нет)" +
            "Не забудьте нажать Enter";

    public static void main(String[] args) {
        ServerApiClient serverApiClient = new ServerApiClient();
        GameContext gameContext = null;
        Scanner sc = new Scanner(System.in);
        String written;

        while (gameContext == null)
        {
            gameContext = GameContext.builder().build();
            System.out.println(WELCOME);
            written = sc.next();
            gameContext.setUser(serverApiClient.CreateUser(UserDto.builder().userName(written).build()));

            System.out.println(NEW_GAME);
            while (true)
            {
                written = sc.next();
                if (written.length() > 1 | !isNumeric(written))
                {
                    System.out.println(INCORRECT_INPUT_FORMAT);
                }
                else
                {
                    gameContext.setGame(serverApiClient.CreateGame(gameContext.getUser(), Integer.parseInt(written)));
                    break;
                }
            }

            System.out.println(gameContext.getGame().getCurrentState());

            System.out.println(INPUT_LETTER_ASKING);

            while (true)
            {
                written = sc.next();
                gameContext.setGameAnswerDto(serverApiClient.guessLetter(gameContext.getUser(), gameContext.getGame(), written));
                System.out.println(gameContext.getGameAnswerDto().message);
                System.out.println(gameContext.getGameAnswerDto().game.getCurrentState());
                if (gameContext.getGameAnswerDto().game.getCompleted())
                {
                    System.out.println(CONGRATULATE);
                    while (true)
                    {
                        written = sc.next();
                        if ("N".equals(written))
                        {
                            break;
                        }
                        else if ("Y".equals(written))
                        {
                            gameContext = null;
                            break;
                        }
                        else
                            System.out.println(INCORRECT_INPUT_FORMAT);
                    }
                    break;
                }
            }
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
