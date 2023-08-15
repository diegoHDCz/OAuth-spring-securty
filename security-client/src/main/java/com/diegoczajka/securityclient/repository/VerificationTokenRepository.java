package com.diegoczajka.securityclient.repository;


import com.diegoczajka.securityclient.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository
        extends JpaRepository<VerificationToken, Long> {

}
