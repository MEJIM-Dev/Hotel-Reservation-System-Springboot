package com.minehotel.App.Services;

import com.minehotel.App.Entity.AppUser;
import com.minehotel.App.Exceptions.UserNotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServiceImplementation userImpl;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) {
        AppUser user = userImpl.getUserByEmail(username);

        if(user==null){
            throw new UserNotFoundException("Username or password incorrect");
        }

        Collection<GrantedAuthority> roles = new ArrayList<>();
        user.getRoles().forEach((role)->{
            roles.add(new SimpleGrantedAuthority(role.getName()) );
        });

        return new User(user.getEmail(),user.getPassword(),roles);
    }
}
