/*
 * DapLegacyUserDetailsService.java		26/05/2015
 *
 * Copyright (C) 2015 FAPESP. All Rights Reserved.
 */
package br.com.ackta.clinical.application.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.ackta.clinical.model.entity.User;
import br.com.ackta.clinical.model.repository.UserRepository;

public class UserLoginDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public UserLoginDetailsService(UserRepository userRepository1) {
		this.userRepository = userRepository1;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		final List<GrantedAuthority> roleList = getRolesList(user);
		final UserLogin result = new UserLogin(user.getId(), user.getUsername(), user.getPassword(), user.getName(),
				user.isActive(), false, roleList);
		return result;
	}

	/**
	 * @param user
	 * @return
	 */
	private List<GrantedAuthority> getRolesList(User user) {
		List<GrantedAuthority> roleList = new ArrayList<GrantedAuthority>();
		// for (UserLoginRole role : user.getUserLoginRole()) {
		// roleList.add(new SimpleGrantedAuthority(role.getRole().getName()));
		// }
		return roleList;
	}
}
