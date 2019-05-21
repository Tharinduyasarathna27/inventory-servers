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

    public User save(User user){
        return userDetailsRepository.save(user);
    }


    public  void deteteById(Integer id){
        userDetailsRepository.deleteById(id);
    }


    public Optional<User> findById(Integer id){
        return userDetailsRepository.findById(id);
    }


    public User fetchUsers(User user) {
        Optional<User> optional= userDetailsRepository.findById(user.getId());
        if(optional.isPresent()){
            return optional.get();
        }else{
            return null;
        }
    }
}
