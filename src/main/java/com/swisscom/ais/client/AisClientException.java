package com.swisscom.ais.client;

public class AisClientException extends RuntimeException {

    public AisClientException(String message) {
        super(message);
    }

    public AisClientException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
