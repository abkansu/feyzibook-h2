package com.example.ws.authentication;

import com.example.ws.user.Member;
import com.example.ws.user.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Member member = memberRepository.findMemberByUsername(username);
        if (member == null){
            throw new UsernameNotFoundException(username);
        }
        return new MemberUserDetails(member);
    }



}

