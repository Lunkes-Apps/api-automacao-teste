package com.lnks.siteautomacaoapi.services;

import java.util.Optional;

import com.lnks.siteautomacaoapi.entities.Profile;

public interface ProfileService {
    
    /** 
    * Retorna um profile dado um email
    * 
    * @param email
    * @return Optional<Profile>
    */
    Optional<Profile> buscarPorEmail(String email);
    
    /** 
    * Cadastra um profile dado um Profile
    * 
    * @param profile
    * @return Profile
    */
    Profile salvaProfile(Profile profile);    

}