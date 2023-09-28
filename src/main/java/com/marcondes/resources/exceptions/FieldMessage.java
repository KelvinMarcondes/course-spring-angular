package com.marcondes.resources.exceptions;


import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class FieldMessage implements Serializable {

    private String fieldName;
    private String message;

}
