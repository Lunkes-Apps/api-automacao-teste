package com.lnks.siteautomacaoapi.repositories;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.lnks.siteautomacaoapi.entities.Profile;
import com.lnks.siteautomacaoapi.utils.PasswordUtils;



@SpringBootTest
@ActiveProfiles("test")
public class ProfileRepositoryTest {

	
	@Autowired
	private ProfileRepository profileRepository;
	
	@BeforeEach
	public void setUp() throws Exception {
		Profile p = new Profile();
		p.setEmail("email");
		p.setNome("nome");
		p.setPassword(PasswordUtils.gerarBCrypt("password"));
		this.profileRepository.save(p);
	}
	
	@Test
	public void testFindByEmail() throws Exception {
		Profile p = this.profileRepository.findByEmail("email");
		assertEquals("email", p.getEmail(), "Falha ao receber email");
	}
}