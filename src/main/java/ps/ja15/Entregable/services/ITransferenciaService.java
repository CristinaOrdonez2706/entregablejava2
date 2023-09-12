package ps.ja15.Entregable.services;

import ps.ja15.Entregable.model.Transferencia;

import java.util.List;

public interface ITransferenciaService {

    Transferencia save(Transferencia transferencia)throws Exception;

    Transferencia update(Transferencia transferencia)throws Exception;

    Transferencia findById(Long id)throws Exception;

    List<Transferencia> findByAll() throws Exception;
}
