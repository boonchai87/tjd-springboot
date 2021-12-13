package com.thaiitwork.service;

import com.thaiitwork.exception.ResourceNotFoundException;
import com.thaiitwork.model.User;
import com.thaiitwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws ResourceNotFoundException {
        User account = userRepository.findByUserName(username);
        System.out.println("Account= " + account);
        if (account == null) {
            throw new ResourceNotFoundException(User.class.getName(),"username",username);
        }
        // EMPLOYEE,MANAGER,..
        String role = account.getUserRole();

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        // ROLE_EMPLOYEE, ROLE_MANAGER
        GrantedAuthority authority = new SimpleGrantedAuthority(role);

        grantList.add(authority);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(account.getUserName(), //
                account.getPassword(), enabled, accountNonExpired, //
                credentialsNonExpired, accountNonLocked, grantList);

        return userDetails;
    }

}