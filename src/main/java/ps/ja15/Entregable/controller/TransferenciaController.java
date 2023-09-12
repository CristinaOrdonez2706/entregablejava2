package ps.ja15.Entregable.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ps.ja15.Entregable.controller.model.ApiResponseMessage;
import ps.ja15.Entregable.controller.model.HttpStatusMessages;
import ps.ja15.Entregable.model.Cuenta;
import ps.ja15.Entregable.model.Transferencia;
import ps.ja15.Entregable.services.TransferenciaService;

import java.util.ArrayList;

@RestController
@RequestMapping("/transferencias")

public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping

    public ResponseEntity<?> findByAll(){

        try{
            return ResponseEntity.ok().body(ApiResponseMessage.builder()
                    .status(HttpStatusMessages.OK.getStatusCode())
                    .message(HttpStatusMessages.OK.getStatusMessage())
                    .data(transferenciaService.findByAll()).build());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponseMessage.builder()
                    .status(HttpStatusMessages.BAD_REQUEST.getStatusCode())
                    .message(HttpStatusMessages.BAD_REQUEST.getStatusMessage()+":"+e.getMessage())
                    .data(new ArrayList<Transferencia>()).build());
        }
    }

    @GetMapping("/{id}")

    public ResponseEntity<?> obtenerTransferenciaPorId(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok().body(ApiResponseMessage.builder()
                    .status(HttpStatusMessages.OK.getStatusCode())
                    .message(HttpStatusMessages.OK.getStatusMessage())
                    .data(transferenciaService.findById(id)).build());


        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponseMessage.builder()
                    .status(HttpStatusMessages.BAD_REQUEST.getStatusCode())
                    .message(HttpStatusMessages.BAD_REQUEST.getStatusMessage()+":"+e.getMessage())
                    .data(new ArrayList<Transferencia>()).build());
        }
    }
    @PostMapping
    public ResponseEntity<?> crearTransferencia(@RequestBody Transferencia transferencia) {
        try {
            return ResponseEntity.ok().body(ApiResponseMessage.builder()
                    .status(HttpStatusMessages.OK.getStatusCode())
                    .message(HttpStatusMessages.OK.getStatusMessage())
                    .data(transferenciaService.save(transferencia)).build());


        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponseMessage.builder()
                    .status(HttpStatusMessages.BAD_REQUEST.getStatusCode())
                    .message(HttpStatusMessages.BAD_REQUEST.getStatusMessage()+":"+e.getMessage())
                    .data(new ArrayList<Transferencia>()).build());
        }

    }

    @PutMapping
    public ResponseEntity<?> actualizarTransferencia(@RequestBody Transferencia transferencia) {
        try {
            return ResponseEntity.ok().body(ApiResponseMessage.builder()
                    .status(HttpStatusMessages.OK.getStatusCode())
                    .message(HttpStatusMessages.OK.getStatusMessage())
                    .data(transferenciaService.update(transferencia)).build());


        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponseMessage.builder()
                    .status(HttpStatusMessages.BAD_REQUEST.getStatusCode())
                    .message(HttpStatusMessages.BAD_REQUEST.getStatusMessage()+":"+e.getMessage())
                    .data(new ArrayList<Transferencia>()).build());
        }
    }



}
