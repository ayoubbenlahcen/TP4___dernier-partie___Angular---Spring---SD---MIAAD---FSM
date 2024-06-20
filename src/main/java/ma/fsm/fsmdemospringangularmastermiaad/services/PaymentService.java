package ma.fsm.fsmdemospringangularmastermiaad.services;

import ma.fsm.fsmdemospringangularmastermiaad.entities.Payement;
import ma.fsm.fsmdemospringangularmastermiaad.entities.PaymentStatus;
import ma.fsm.fsmdemospringangularmastermiaad.entities.PaymentType;
import ma.fsm.fsmdemospringangularmastermiaad.entities.Student;
import ma.fsm.fsmdemospringangularmastermiaad.repository.PayementRepository;
import ma.fsm.fsmdemospringangularmastermiaad.repository.StudentRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

@Service
@Transactional
public class PaymentService {
    private StudentRepository studentRepository;
    private PayementRepository paymentRepository;


    public PaymentService(StudentRepository studentRepository, PayementRepository paymentRepository) {
        this.studentRepository = studentRepository;
        this.paymentRepository = paymentRepository;

    }

    public List<Payement> allPayments() {
        return paymentRepository.findAll();
    }

    public List<Payement> getPaymentsByStudent(String code) {
        return paymentRepository.findByStudentCode(code);
    }

    public List<Payement> getPaymentsByStatus(PaymentStatus status) {
        return paymentRepository.findByStatus(status);
    }

    public List<Payement> getPaymentsByType(PaymentType type) {
        return paymentRepository.findByType(type);
    }

    public Payement getPaymentById(Long id) {
        return paymentRepository.findById(id).get();
    }

    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByCode(String code) {
        return studentRepository.findByCode(code);
    }

    public List<Student> getStudentsByProgramId(String programId) {
        return studentRepository.findByProgrammeCode(programId);
    }

    public Payement updatePaymentStatus(PaymentStatus status, Long id){
        Payement payment= paymentRepository.findById(id).get();
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }
    public Payement savePayment(MultipartFile file, LocalDate date, double amount,
                               PaymentType type, String studentCode) throws IOException {
        Path folderPath = Paths.get(System.getProperty("user.home"), "fsm-data", "payments");
        if(!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }
        String fileName= UUID.randomUUID().toString();
        Path filePath = Paths.get(System.getProperty("user.home"), "fsm-data", "payments", fileName+".pdf");
        Files.copy(file.getInputStream(), filePath);
        Student student = studentRepository.findByCode(studentCode);
        Payement payment = Payement.builder()
                .date(date).type(type).student(student).amount(amount)
                .file(filePath.toUri().toString())
                .status(PaymentStatus.CREATED).build();
        return paymentRepository.save(payment);

    }
    public byte[] getPaymentFile(Long paymentId) throws IOException {
        Payement payment= paymentRepository.findById(paymentId).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }
}
