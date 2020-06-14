package com.lnks.siteautomacaoapi.security.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lnks.siteautomacaoapi.entities.Profile;
import com.lnks.siteautomacaoapi.services.ProfileService;


@Service
public class JwtUserDetailsServiceImp implements UserDetailsService{
	
	@Autowired
	private ProfileService profileService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Profile> usuario = profileService.buscarPorEmail(username);
		if(usuario.isPresent()) {
			return JwtUserFactory.create(usuario.get());
		}
		throw new UsernameNotFoundException("Email não encontrado.");
	}
	

}
