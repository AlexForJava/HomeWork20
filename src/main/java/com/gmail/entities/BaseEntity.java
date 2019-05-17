package com.gmail.entities;

import com.gmail.listeners.UserEntityListener;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

/**
 * Created by Space on 09.05.2019.
 */
@Data
@MappedSuperclass
@NoArgsConstructor
@EntityListeners(value = UserEntityListener.class)
public class BaseEntity {
    @Column
    private LocalDate dateCreate;
}
