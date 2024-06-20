package ma.fsm.fsmdemospringangularmastermiaad.web;

import ma.fsm.fsmdemospringangularmastermiaad.entities.Payement;
import ma.fsm.fsmdemospringangularmastermiaad.entities.PaymentStatus;
import ma.fsm.fsmdemospringangularmastermiaad.entities.PaymentType;
import ma.fsm.fsmdemospringangularmastermiaad.entities.Student;
import ma.fsm.fsmdemospringangularmastermiaad.repository.PayementRepository;
import ma.fsm.fsmdemospringangularmastermiaad.repository.StudentRepository;
import ma.fsm.fsmdemospringangularmastermiaad.services.PaymentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*") // je donne l'aotorisation
                  // a n'importe qu'il page de n'importe qu'il domaine
                  // de faire appel a ce service  il faut le connaitre

public class PaymentRestController {
    private StudentRepository studentRepository ;
    private PayementRepository payementRepository ;
    private PaymentService paymentService ;

    public PaymentRestController(StudentRepository studentRepository, PayementRepository payementRepository, PaymentService paymentService) {
        this.studentRepository = studentRepository;
        this.payementRepository = payementRepository;
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public List<Payement>  allPayments(){
        return this.paymentService.allPayments() ;
    }
    @GetMapping("/students/{code}/payments")
    public List<Payement>  paymentsByStudents(@PathVariable String code){
        return this.paymentService.getPaymentsByStudent(code) ;
    }

    @GetMapping(path = "/payments/byStatus")
    public List<Payement>  paymentsByStatus(@RequestParam PaymentStatus status){
        return this.paymentService.getPaymentsByStatus(status) ;
    }
    @GetMapping("/payments/byType")
    public List<Payement> getPaymentByType(@RequestParam PaymentType paymentType){
        return this.paymentService.getPaymentsByType(paymentType) ;
    }

    @GetMapping("/payments/{idPayment}")
    public Payement getPaymentById(@PathVariable  Long idPayment){
        return this.paymentService.getPaymentById(idPayment) ;
    }

    @GetMapping("/students")
    public List<Student> allStudent(){
        return this.paymentService.allStudents() ;
    }

    @GetMapping("/students/{codeStudent}")
    public Student getStudentByCode(@PathVariable String codeStudent){
        return this.paymentService.getStudentByCode(codeStudent) ;
    }

    @GetMapping("/studentsByProgrammeId")
    public  List<Student> getStudentsByProgrammeId(@RequestParam String programmeId){
        return this.paymentService.getStudentsByProgramId(programmeId) ;
    }

    @PutMapping("/payments/{idPayment}")
    public Payement updatePaymentStatus(@RequestParam  PaymentStatus status  ,@PathVariable Long idPayment){
        return this.paymentService.updatePaymentStatus(status , idPayment) ;
    }

    @PostMapping(value = "/payments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)// c'est pour gerer les done qui contient des fichier(pdf par exemple)
    public Payement savePayement( @RequestParam MultipartFile file ,
                                 LocalDate date ,
                                 double amount ,
                                 PaymentType paymentType ,
                                 String studentCode) throws IOException {
        return  this.paymentService.savePayment(file , date, amount , paymentType , studentCode) ;

    }

    @GetMapping(path = "/paymentFile/{paymentId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPaymentFile(@PathVariable Long paymentId) throws IOException {
        return  this.paymentService.getPaymentFile(paymentId) ;
    }

}
