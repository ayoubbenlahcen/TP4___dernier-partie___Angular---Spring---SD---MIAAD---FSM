package ma.fsm.fsmdemospringangularmastermiaad.repository;

import ma.fsm.fsmdemospringangularmastermiaad.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student , String> {
    Student findByCode(String code) ;
    List<Student> findByProgrammeCode(String programmeCode) ;
}
