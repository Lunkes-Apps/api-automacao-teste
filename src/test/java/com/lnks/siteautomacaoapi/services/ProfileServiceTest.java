package com.lnks.siteautomacaoapi.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import com.lnks.siteautomacaoapi.entities.Profile;
import com.lnks.siteautomacaoapi.repositories.ProfileRepository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ProfileServiceTest {
    
    @MockBean
    private ProfileRepository profileRepository;
    @Autowired
    private ProfileService profileService;

    private static final String EMAIL = "test@test.com";

    @BeforeEach
    public void setUp()throws Exception{
        BDDMockito.given(this.profileRepository.findByEmail(Mockito.anyString())).willReturn(new Profile());
        BDDMockito.given(this.profileRepository.save(Mockito.any(Profile.class))).willReturn(new Profile());
    }

    @Test
    public void testBuscarProfilePorEmail()throws Exception{
        Optional<Profile> profile = this.profileService.buscarPorEmail(EMAIL);
        assertTrue(profile.isPresent());
    } 

}