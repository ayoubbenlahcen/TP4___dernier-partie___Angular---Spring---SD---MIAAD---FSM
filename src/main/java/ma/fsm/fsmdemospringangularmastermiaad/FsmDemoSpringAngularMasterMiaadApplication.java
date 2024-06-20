package ma.fsm.fsmdemospringangularmastermiaad;

import ma.fsm.fsmdemospringangularmastermiaad.entities.Payement;
import ma.fsm.fsmdemospringangularmastermiaad.entities.PaymentStatus;
import ma.fsm.fsmdemospringangularmastermiaad.entities.PaymentType;
import ma.fsm.fsmdemospringangularmastermiaad.entities.Student;
import ma.fsm.fsmdemospringangularmastermiaad.repository.PayementRepository;
import ma.fsm.fsmdemospringangularmastermiaad.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class FsmDemoSpringAngularMasterMiaadApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsmDemoSpringAngularMasterMiaadApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository ,
            PayementRepository payementRepository
    ){
        return args -> {
           /* studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString())
                    .firstName("Mohamed")
                    .code("112233")
                    .programmeCode("SDIA")
                    .build() );
            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString())
                    .firstName("Imane")
                    .code("112244")
                    .programmeCode("SDIA")
                    .build() );
            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString())
                    .firstName("Yassmine")
                    .code("112255")
                    .programmeCode("GLSID")
                    .build() );

            studentRepository.save(Student.builder()
                    .id(UUID.randomUUID().toString())
                    .firstName("Najat")
                    .code("112266")
                    .programmeCode("BDCC")
                    .build() );
            PaymentType[] paymentTypes = PaymentType.values() ;
            Random random = new Random() ;
            studentRepository.findAll().forEach(
                    student -> {
                        for (int i= 0 ;  i<10 ; i++){
                            int index =random.nextInt(paymentTypes.length);
                            Payement payement = Payement.builder()
                                    .amount(1000+(int)(Math.random()*2000))
                                    .type(paymentTypes[index])
                                    .status(PaymentStatus.CREATED)
                                    .date(LocalDate.now())
                                    .student(student)
                                    .build() ;
                            payementRepository.save(payement);
                        }
                    }
            ); */
        };
    }

}
