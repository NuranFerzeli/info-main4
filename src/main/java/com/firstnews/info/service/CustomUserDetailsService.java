package com.firstnews.info.service;

import com.firstnews.info.detail.CustomUserDetails;
import com.firstnews.info.entity.User;
import com.firstnews.info.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user =userRepository.findByUsername(s);
        if(user==null){
            throw new UsernameNotFoundException("UsernotFound");
        }
        return new CustomUserDetails(user);
    }
}
