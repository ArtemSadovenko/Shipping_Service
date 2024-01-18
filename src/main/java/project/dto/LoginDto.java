package project.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginDto {
    private String email;
    private String pass;
}
