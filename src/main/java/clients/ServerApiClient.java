package clients;

import javax.swing.text.ChangedCharSetException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import dto.Game;
import dto.GameAnswerDto;
import dto.User;
import dto.UserDto;

/**
 * @author : Bulankin_D
 * @created : 18.01.2022, вторник
 **/
public class ServerApiClient
{
    RestTemplate restTemplate;

    String serverAddress = "http://127.0.0.1:8080/api/v1";

    public ServerApiClient() {
        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        this.restTemplate = restTemplate;
    }

    public User CreateUser(UserDto userDto) {
        return restTemplate.postForObject(serverAddress + "/user", userDto, User.class);
    }

    public Game CreateGame(User user, Integer level) {
        HttpHeaders headers = new HttpHeaders();

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("level", level.toString());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        return restTemplate.postForObject(serverAddress + "/user/" + user.getId() + "/games", request, Game.class);
    }

    public GameAnswerDto guessLetter(User user, Game game, String letter) {
        HttpHeaders headers = new HttpHeaders();

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("letter", letter);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        return restTemplate.postForObject(
                serverAddress + "/user/" + user.getId() + "/games/" + game.getId(),
                request, GameAnswerDto.class);
    }
}
