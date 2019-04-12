package kr.co.saramin.api.developer.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Developer {

    private Integer idx;
    private String name;
    private String company_nm;
    private String email;
    private String password;

}
