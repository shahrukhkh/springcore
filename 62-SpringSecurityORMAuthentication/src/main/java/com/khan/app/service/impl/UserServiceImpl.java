package com.khan.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.khan.app.entity.User;
import com.khan.app.repo.UserRepo;
import com.khan.app.service.UserService;
@Service
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Override
	public Integer saveUser(User user) {
		user.setUserPassword(encoder.encode(user.getUserPassword()));
		User save = userRepo.save(user);
		return save.getUserId();
	}
	@Override
	public Optional<User> getOneUser(Integer id) {
		return userRepo.findById(id);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = userRepo.findByUserEmail(username);
		
		if(user.isEmpty())
		{
			throw new UsernameNotFoundException("User Not Found : "+ username);
		}
		User user1= user.get();
		/*
		List<GrantedAuthority> roles= new ArrayList<>();
		for(String role: user1.getUserRoles())
		{
			roles.add(new SimpleGrantedAuthority(role));
		}
		*/
		
		// by stream api
		List<SimpleGrantedAuthority> roles = 
				user1.getUserRoles()
				.stream()
				.map(SimpleGrantedAuthority::new)
				.toList(); 
		return new org.springframework.security.core.userdetails
				.User(username,user1.getUserPassword(),roles);
	}

}
