package com.lnks.siteautomacaoapi.security.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.lnks.siteautomacaoapi.entities.Profile;
import com.lnks.siteautomacaoapi.enuns.PerfilEnum;

public class JwtUserFactory {

	public static JwtUser create(Profile profile) {
		return JwtUser.builder().id(profile.getId())
				.username(profile.getEmail())
				.password(profile.getPassword())
				.authorities(mapToGrantedAuthorities(profile.getPerfil()))
				.build();
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities (PerfilEnum perfilEnum){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
		return authorities;
	}
	
}
