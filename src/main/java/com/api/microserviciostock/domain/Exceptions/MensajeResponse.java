package com.api.microserviciostock.domain.Exceptions;

import java.io.Serializable;

public class MensajeResponse implements Serializable {
    private String mensaje;
    private Object object;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public MensajeResponse(Object object, String mensaje) {
        this.object = object;
        this.mensaje = mensaje;
    }

    public MensajeResponse() {
    }

    @Override
    public String toString() {
        return "mensajeResponse{" +
                "mensaje='" + mensaje + '\'' +
                ", object=" + object +
                '}';
    }
}