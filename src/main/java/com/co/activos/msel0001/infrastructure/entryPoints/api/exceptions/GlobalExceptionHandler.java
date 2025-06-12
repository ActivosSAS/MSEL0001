package com.co.activos.msel0001.infrastructure.entryPoints.api.exceptions;



import com.co.activos.msel0001.domain.exceptions.ReplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ReplicationException.class)
    public ResponseEntity<String> handleReplicationException(ReplicationException ex) {
        logger.error("Replication error: {}", ex.getMessage());
        // Puedes devolver un error HTTP personalizado o simplemente un mensaje
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error de replicación: " + ex.getMessage());
    }

    // Otros manejadores...
}
