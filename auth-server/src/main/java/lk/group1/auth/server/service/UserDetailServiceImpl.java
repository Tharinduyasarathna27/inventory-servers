package lk.group1.auth.server.service;

import lk.group1.auth.server.model.AuthUserDetails;
import lk.group1.auth.server.model.User;
import lk.group1.auth.server.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser=userDetailsRepository.findByUsername(name);

        optionalUser.orElseThrow(()-> new UsernameNotFoundException("username or password wrong"));

        UserDetails userDetails=new AuthUserDetails(optionalUser.get());

        new AccountStatusUserDetailsChecker().check(userDetails);

        return userDetails;
    }
}
