package kr.co.saramin.api.developer.dto;

import kr.co.saramin.api.developer.domain.Developer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    public Developer user() {
        Developer user = new Developer();
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }

}
