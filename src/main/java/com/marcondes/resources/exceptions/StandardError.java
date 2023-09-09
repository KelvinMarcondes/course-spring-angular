package com.marcondes.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StandardError implements Serializable {

    private Long timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
