package com.lnks.siteautomacaoapi.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lnks.siteautomacaoapi.entities.Profile;


public interface ProfileRepository extends JpaRepository<Profile, Long>{
    @Transactional(readOnly= true)
    Profile findByEmail(String email);
	
}
