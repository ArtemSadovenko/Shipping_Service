package project.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import project.enums.UserRole;

import java.util.List;

@Component
public class JwtMapper {
    public UserPrincipal convert(DecodedJWT jwt){
//        var authorityList = getClaimOrEmptyList(jwt, "au").stream()
//                .map(SimpleGrantedAuthority::new)
//                .toList();
//
//        return UserPrincipal.builder()
//                .userId( Long.parseLong(jwt.getSubject()) )
//                .email( jwt.getClaim("e").asString() )
//                .authorities( authorityList )
//                .build();
        return UserPrincipal.builder()
                .userId(Long.valueOf(jwt.getSubject()))
                .email(jwt.getClaim("e").asString())
                .authorities(List.of(
                        UserRole.valueOf(
                                jwt.getClaim("r").asString()
                        )
                ))
                .build();
    }

    private List<String> getClaimOrEmptyList(DecodedJWT jwt, String claim) {
        if (jwt.getClaim(claim).isNull()) return List.of();
        return jwt.getClaim(claim).asList(String.class);
    }

//    private List<SimpleGrantedAuthority> getAuthority(DecodedJWT jwt){
//        var claim = jwt.getClaim("a");
//        if (claim.isNull() || claim.isMissing()) return List.of();
//        return claim.asList(SimpleGrantedAuthority.class);
//    }
}
