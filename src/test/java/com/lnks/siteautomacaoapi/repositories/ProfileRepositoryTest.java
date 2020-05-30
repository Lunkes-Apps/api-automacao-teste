package com.lnks.siteautomacaoapi.repositories;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.lnks.siteautomacaoapi.entities.Profile;
import com.lnks.siteautomacaoapi.utils.PasswordUtils;



@SpringBootTest
@ActiveProfiles("test")
@Slf4j
public class ProfileRepositoryTest {

	
	@Autowired
	private ProfileRepository profileRepository;
	
	@BeforeEach
	public void setUp() throws Exception {
		Profile p = Profile.builder()
		.email("email")
		.nome("nome")
		.password(PasswordUtils.gerarBCrypt("password"))
		.build();
		log.info("Salvando profile com email {}", p.getEmail());
		this.profileRepository.save(p);
	}
	
	@Test
	public void testFindByEmail() throws Exception {
		Profile p = this.profileRepository.findByEmail("email");
		assertEquals("email", p.getEmail(), "Falha ao receber email");
	}
}