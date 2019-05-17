package com.gmail.listeners;

import com.gmail.entities.BaseEntity;

import javax.persistence.PrePersist;
import java.time.LocalDate;

/**
 * Created by Space on 17.05.2019.
 */
public class UserEntityListener {
    @PrePersist
    public void prePersist(BaseEntity entity) {
        entity.setDateCreate(LocalDate.now());
    }
}
