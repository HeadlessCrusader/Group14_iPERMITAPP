package edu.mizzou.Group14_iPERMITAPP.repository;

import edu.mizzou.Group14_iPERMITAPP.model.PermitRequest;
import edu.mizzou.Group14_iPERMITAPP.model.RE;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PermitRequestRepository extends JpaRepository<PermitRequest, String> {
	List<PermitRequest> findByRe(RE re);
}
