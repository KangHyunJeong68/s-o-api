package kr.co.saramin.api.developer.dto;

import kr.co.saramin.api.developer.domain.Developer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @Autowired PasswordEncoder passwordEncoder;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    public Developer user() {
        Developer user = new Developer();
        user.setEmail(this.email);
//        user.setPassword(passwordEncoder.encode(this.password));
        user.setPassword((this.password));
        return user;
    }

}
