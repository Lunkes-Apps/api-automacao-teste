package com.lnks.siteautomacaoapi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordUtils {

	/**
	 * 
	 * Função para criptografar a senha
	 * 
	 * @param password
	 * @return String
	 */
	
	public static String gerarBCrypt(String password) {
		if(password == null) {
			return password;
		}
		log.info("gerando hash com o Bcrypt");
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.encode(password);		
	}
	

}
