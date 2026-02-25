package com.grace.maestrohub.domain.user.entity.user;

import com.grace.maestrohub.common.entity.BaseEntity;
import com.grace.maestrohub.domain.user.enums.Status;
import com.grace.maestrohub.domain.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "phone", nullable = false, length = 30)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @Column(name = "region", nullable = false, length = 150)
    private String region;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Student student;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Tutor tutor;

    @Builder
    private User(String email, String password, String username, String phone, UserRole role, String region) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.phone = phone;
        this.role = role;
        this.region = region;
        this.status = Status.INACTIVE;
    }

    public void activate() {
        this.status = Status.ACTIVE;
    }

    void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    void setStudent(Student student) {
        this.student = student;
    }
}

