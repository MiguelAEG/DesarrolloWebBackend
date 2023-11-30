package com.microservice.oauth.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservice.common.users.entity.Usuario;
import com.microservice.oauth.client.UsuarioFeignClient;

@Service
public class UsuarioService implements UserDetailsService{

	private Logger log = LoggerFactory.getLogger(UsuarioService.class);
	@Autowired
	private UsuarioFeignClient client;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario user = client.findByUsername(username);
		
		if(user==null) {
			log.error("Error en el login, no existe el uuario. "+ username);
			throw new UsernameNotFoundException("Error en el login, no existe el uuario. "+ username);
		}
		
		List<GrantedAuthority> autorities = user.getRoles()
				.stream()
				.map(role-> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority-> log.info("Role:" +authority.getAuthority()))
				.collect(Collectors.toList());
		log.info("Usuario auytentificado: "+ username);
		return new User(user.getUsername(), user.getPassword(), user.getEneable(), true, true, true, autorities);
	}

}
