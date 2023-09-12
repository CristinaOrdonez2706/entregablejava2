package ps.ja15.Entregable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ps.ja15.Entregable.model.Cuenta;
import ps.ja15.Entregable.model.Transferencia;
import ps.ja15.Entregable.repository.TransferenciaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService implements ITransferenciaService {

    @Autowired//sirve para instancias la clase
    TransferenciaRepository transferenciaRepository;

    public Transferencia save(Transferencia transferencia) throws Exception {
        Optional<Transferencia> transferenciaExistente = transferenciaRepository.findById(transferencia.getId());
        if (transferenciaExistente.isPresent()) {
            throw new Exception("Ya existe una transferencia con el mismo Id.");
        }
        if (transferencia.getMonto().compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("El monto de la transferebcia no puede ser menor que cero.");
        }
        return transferenciaRepository.save(transferencia);
    }

    public Transferencia update(Transferencia transferencia) throws Exception {
        Optional<Transferencia> transferenciaExistente = transferenciaRepository.findById(transferencia.getId());
        if (transferenciaExistente.isPresent()) {
            Transferencia actualizarTransferencia = transferenciaExistente.get();
            actualizarTransferencia.setMonto(transferencia.getMonto());
            return transferenciaRepository.save(transferencia);
        } else {

            throw new Exception("NO existe la transferencia.");
        }

    }

    @Transactional(readOnly = true)
    public Transferencia findById(Long id) throws Exception {
        return transferenciaRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Transferencia> findByAll() throws Exception {
        return transferenciaRepository.findAll();
    }
}