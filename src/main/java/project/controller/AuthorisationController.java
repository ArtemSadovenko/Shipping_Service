package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import project.dto.LoginDto;
import project.dto.TokenDto;
import project.enums.UserRole;
import project.security.JwtService;
import project.security.UserPrincipal;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorisationController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private final AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginDto dto) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPass())
        );

        SecurityContextHolder.getContext().setAuthentication(auth);
        var principal = (UserPrincipal)auth.getPrincipal();

        return TokenDto.builder()
                .token(jwtService.createToken(principal.getUserId(), principal.getEmail()
                        , UserRole.valueOf(principal.getAuthorities().stream().findFirst().toString())))
                .build();
    }

    @GetMapping("/ya")
    public String Hello(@AuthenticationPrincipal UserPrincipal principal){
        return principal.getEmail() +
                " " +
                principal.getUserId();
    }

    @GetMapping("/test")
    public String secure(@AuthenticationPrincipal UserPrincipal principal){
        var pr = principal;
        return principal.getEmail() + " " + principal.getAuthorities().toString();
    }
}
