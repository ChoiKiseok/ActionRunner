package com.buk.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.buk.user.domain.UserInfo;
import com.buk.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void getPasswordEncode() {
        System.out.println("======== test ============");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserInfo users = userRepository.findByUserId("admin");

        log.info("{}", users.toString());
        log.info("{}", encoder.encode("admin"));
        log.info("{}", passwordEncoder.matches("admin", users.getUserPwd()));
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserInfo users = userRepository.findByUserId(userId);

        
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(users.getRole()));
        
        // return new User(users.getUserid(), users.getUserpw(), authorities);
        return new User(users.getUserId(), users.getUserPwd(), authorities);
    }
    
}
