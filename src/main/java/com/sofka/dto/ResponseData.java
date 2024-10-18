package com.sofka.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ResponseData {
    private String status;
    private String message;


    public ResponseData(String error, String s) {
        this.status = error;
        this.message = s;

    }
}
