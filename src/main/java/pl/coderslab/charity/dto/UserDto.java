package pl.coderslab.charity.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "password")
public class UserDto {
    private String email;
    private String password;
    private String username;
}
