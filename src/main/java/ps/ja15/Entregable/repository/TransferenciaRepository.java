package ps.ja15.Entregable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ps.ja15.Entregable.model.Cuenta;
import ps.ja15.Entregable.model.Transferencia;

import java.util.Optional;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    Optional<Transferencia> findByCuentaOrigenId(Cuenta cuentaOrigenId);
    Optional<Transferencia> findByCuentaDestinoId(Cuenta cuentaDestinoId);
}
