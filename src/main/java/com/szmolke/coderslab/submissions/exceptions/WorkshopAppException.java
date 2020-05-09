package com.szmolke.coderslab.submissions.exceptions;

public class WorkshopAppException extends RuntimeException {
    private String clientMessage;

    public WorkshopAppException(String clientMessage) {
        this.clientMessage = clientMessage;
    }

    public String getClientMessage() {
        return clientMessage;
    }
}
