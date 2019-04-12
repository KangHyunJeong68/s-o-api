package kr.co.saramin.api.developer.dto;

import lombok.Data;

@Data
public class DefaultResponse {
    private boolean isSuccess;

    private String errorMsg;
}
