package kr.co.saramin.api.developer.dto;

import kr.co.saramin.api.developer.domain.Developer;
import lombok.Data;

@Data
public class LoginResponse {

    private String email;
    private String name;
    private String company_nm;

    public LoginResponse(Developer user) {
        this.name = user.getName();
        this.company_nm = user.getCompany_nm();
        this.email = user.getEmail();
    }

}
