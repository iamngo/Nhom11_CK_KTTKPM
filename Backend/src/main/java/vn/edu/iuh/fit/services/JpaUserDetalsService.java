package vn.edu.iuh.fit.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.edu.iuh.fit.models.UserSecurity;
import vn.edu.iuh.fit.repositories.AccountRepository;

@Service
public class JpaUserDetalsService implements UserDetailsService{

    private final AccountRepository userRepository;

    public JpaUserDetalsService(AccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByStudentCode(username)
        .map(UserSecurity::new)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    
}
