package com.lnks.siteautomacaoapi.services.imp;

import java.util.Optional;

import com.lnks.siteautomacaoapi.entities.Profile;
import com.lnks.siteautomacaoapi.repositories.ProfileRepository;
import com.lnks.siteautomacaoapi.services.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProfileServiceImp implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Optional<Profile> buscarPorEmail(String email) {
        log.info("Buscando um profile para o email {}", email);
        return Optional.ofNullable(profileRepository.findByEmail(email));
    }

    @Override
    public Profile salvarProfile(Profile profile) {
        log.info("Salvando profile: {}", profile);
        return profileRepository.save(profile);
    }

    
}