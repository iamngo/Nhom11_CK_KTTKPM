package vn.edu.iuh.fit.models;

import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;


public class UserSecurity implements UserDetails{

          private Account user;
      
          public UserSecurity(Account user) {
              this.user = user;
          }
      
          @Override
          public Collection<? extends GrantedAuthority> getAuthorities() {
              
              return List.of();
          }
      
          @Override
          public String getPassword() {
              
             return user.getPassword();
          }
      
          @Override
          public String getUsername() {
              
              return user.getStudentCode();
          }
      
          @Override
          public boolean isAccountNonExpired() {
              
              return true;
          }
      
          @Override
          public boolean isAccountNonLocked() {
              
              return true;
          }
      
          @Override
          public boolean isCredentialsNonExpired() {
              
              return true;
          }
      
          @Override
          public boolean isEnabled() {
              
              return true;
          }
          
      }
      