package ma.fsm.fsmdemospringangularmastermiaad.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Payement {
    @Id   @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id ;
    private LocalDate date  ;
    private double amount ;
    private PaymentType type ;
    private PaymentStatus status ;
    private String file ;
    @ManyToOne
    private  Student  student ;
}
