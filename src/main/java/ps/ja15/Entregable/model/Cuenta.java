package ps.ja15.Entregable.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Entity
@Data

public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCuenta;
    private BigDecimal saldo;
    private Boolean estado;

}