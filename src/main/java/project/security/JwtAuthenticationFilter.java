package project.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.OptionalDataException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtDecoder decoder;
    private final JwtMapper mapper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        extractToken(request)
                .map(decoder::decode)
                .map(mapper::convert)
                .map(UserPrincipalAuthenticationToken::new)
                .ifPresent(e -> SecurityContextHolder.getContext().setAuthentication(e));

        filterChain.doFilter(request,response);

    }

    private Optional<String>  extractToken(HttpServletRequest request){
        var token = request.getHeader("Authorization");
        if(StringUtils.hasText(token) && token.startsWith("Bearer ")){
            return Optional.of(token.substring(7));
        }
        return Optional.empty();

    }
}
