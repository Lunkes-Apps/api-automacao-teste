package com.lnks.siteautomacaoapi.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.lnks.siteautomacaoapi.entities.Profile;

// @Transactional(readOnly= true)
public interface ProfileRepository extends JpaRepository<Profile, Long>{
    
    Profile findByEmail(String email);
	
}
