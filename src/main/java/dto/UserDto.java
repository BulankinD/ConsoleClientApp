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
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto
{
    String userName;
}
