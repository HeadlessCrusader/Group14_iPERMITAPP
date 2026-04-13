package edu.mizzou.Group14_iPERMITAPP.repository;

import edu.mizzou.Group14_iPERMITAPP.model.Payment;
import edu.mizzou.Group14_iPERMITAPP.model.PermitRequest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {
	Payment findByPermitRequest(PermitRequest request);
}
