package com.gmail.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Space on 17.05.2019.
 */
@Data
@Accessors(chain = true)
public class User implements Serializable{
    private Long id;
    private String name;
    private Integer random;
    private LocalDate birthdayDate;
    private String email;
}
