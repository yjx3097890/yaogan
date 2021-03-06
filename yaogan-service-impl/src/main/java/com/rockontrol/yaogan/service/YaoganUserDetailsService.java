package com.rockontrol.yaogan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rockontrol.yaogan.dao.IUserDao;
import com.rockontrol.yaogan.model.User;

@Service("yaoganUserDetailsService")
public class YaoganUserDetailsService implements UserDetailsService {

   @Autowired
   private IUserDao userDao;

   @Transactional
   public UserDetails loadUserByUsername(String username)
         throws UsernameNotFoundException {
      User user = userDao.getUserByName(username);
      if (user == null) {
         throw new UsernameNotFoundException(
               "Security::Error in retrieving user(username=" + username + ")");
      }

      Long orgId = user.getOrgId();
      boolean enabled = true;
      boolean acountNonExpired = true;
      boolean credentialsNonExpired = true;
      boolean accountNonLock = true;

      List<GrantedAuthority> authorites = new ArrayList<GrantedAuthority>();
      authorites.add(new SimpleGrantedAuthority(user.getRole().name()));

      IYaoganUserDetails yaoganUserDetails = new YaoganUserDetailsImpl(user.getId(),
            orgId, user.getUserName(), user.getPassword(), enabled, acountNonExpired,
            credentialsNonExpired, accountNonLock, authorites);
      return yaoganUserDetails;

   }
}
