package project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import project.mapper.UserMapper;
import project.service.UserService;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService service;
    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        return UserMapper.UserToPrincipal(service.getByEmail(username));
    }
}
