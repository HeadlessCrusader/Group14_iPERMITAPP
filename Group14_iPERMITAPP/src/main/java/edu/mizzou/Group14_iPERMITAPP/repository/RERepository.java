package edu.mizzou.Group14_iPERMITAPP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.mizzou.Group14_iPERMITAPP.model.RE;

public interface RERepository extends JpaRepository<RE, Long> {
    RE findByEmail(String email);
}