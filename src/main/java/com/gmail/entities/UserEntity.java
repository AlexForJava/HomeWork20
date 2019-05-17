package com.gmail.entities;

import com.gmail.annotations.InjectRandomInt;
import com.gmail.listeners.UserEntityListener;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Component
@Scope("prototype")
@Table(name = "users")
@EntityListeners(value = UserEntityListener.class)
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @Column(name = "bithday_date")
    private LocalDate birthdayDate;

    @Column(name = "random_number")
    @InjectRandomInt(min = 20, max = 30)
    private int random;

    @Column
    private String email;
}
