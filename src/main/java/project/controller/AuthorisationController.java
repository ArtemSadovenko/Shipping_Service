package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.dto.LoginDto;
import project.dto.TokenDto;
import project.enums.UserRole;
import project.security.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthorisationController {

    @Autowired
    private JwtService jwtService;


    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginDto dto) {
        return TokenDto.builder()
                .token(jwtService.createToken(1L, dto.getEmail(), UserRole.CUSTOMER))
                .build();
    }
}
