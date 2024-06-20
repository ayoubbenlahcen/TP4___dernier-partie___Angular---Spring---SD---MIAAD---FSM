package ma.fsm.fsmdemospringangularmastermiaad.repository;

import ma.fsm.fsmdemospringangularmastermiaad.entities.Payement;
import ma.fsm.fsmdemospringangularmastermiaad.entities.PaymentStatus;
import ma.fsm.fsmdemospringangularmastermiaad.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayementRepository extends JpaRepository<Payement , Long> {
    List<Payement> findByStudentCode(String codeStudent) ;
    List<Payement>  findByStatus(PaymentStatus status) ;
    List<Payement> findByType (PaymentType paymentType) ;
}
