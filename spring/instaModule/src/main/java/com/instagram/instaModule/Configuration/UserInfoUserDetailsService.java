package com.instagram.instaModule.Configuration;

import com.instagram.instaModule.model.SignUp;
import com.instagram.instaModule.model.Users;
import com.instagram.instaModule.repository.SignUpRepository;
//import com.instagram.instaModule.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private SignUpRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SignUp> signUpOptional = Optional.ofNullable(repository.getUserByUserNameInSignUp(username));
        return signUpOptional.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}