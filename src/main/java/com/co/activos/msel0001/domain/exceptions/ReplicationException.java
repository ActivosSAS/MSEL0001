package com.co.activos.msel0001.domain.exceptions;

public class ReplicationException extends RuntimeException {
    public ReplicationException(String message) {
        super(message);
    }
    public ReplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}

