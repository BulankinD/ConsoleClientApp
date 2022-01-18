package dto;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Bulankin_D
 * @created : 18.01.2022, вторник
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    public String id;

    public String userName;

    public String password;

    public Integer difficultyLevel;

}
