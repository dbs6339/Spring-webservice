package com.dbs6339.webservice.domain.User;


import com.dbs6339.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name="user_name", columnDefinition = "TEXT", nullable = false)
    private String name;

    @Column(name="user_passwd", columnDefinition = "TEXT", nullable = false)
    private String passwd;

    @Column(name="user_email", columnDefinition = "TEXT", nullable = false)
    private String email;

    @Column(name="user_active", nullable = false)
    private int active;

    @Builder
    public User(String name, String passwd, String email) {
        this.name = name;
        this.passwd = passwd;
        this.email = email;
        this.active = 0;
    }
}
