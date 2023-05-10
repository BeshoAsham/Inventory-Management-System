package com.project.pr.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.Length;
import com.project.pr.enums.status;
import com.project.pr.enums.type;

import static com.project.pr.enums.status.INACTIVE;
import static com.project.pr.enums.type.SUPERVISOR;

@Entity
@Data
@NoArgsConstructor
@DynamicInsert
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11)
    private Integer id;

    @Length(max = 15)
    @Column(unique = true)
    private String username;

    @Column(unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    @Length(min = 8)
    private String password;
    @Length(min = 11)
    private String phone;
    @Column
    @ColumnDefault("'INACTIVE'")
    @Enumerated(EnumType.STRING)
    private status status;
    @Column
    @ColumnDefault("'SUPERVISOR'")
    @Enumerated(EnumType.STRING)
    private type type;

    public user(String username, String email, String password, String phone, type type, status status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.type = type;
        this.status = status;

    }
}
