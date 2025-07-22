package br.com.fiap.demospringai.dto;

public class ResponseChat {

    private final String response;

    public ResponseChat(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}
