package com.grace.maestrohub.domain.user.entity.user;

import com.grace.maestrohub.domain.user.enums.StudentLevel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "student")
public class Student {
    @Id
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StudentLevel level;

    @Column(nullable = false, length = 50)
    private String preferredInstrument;

    @Column(length = 500)
    private String introduction;

    public Student(User user, StudentLevel level, String preferredInstrument, String introduction) {
        this.user = user;
        this.level = level;
        this.preferredInstrument = preferredInstrument;
        this.introduction = introduction;

        user.setStudent(this);
    }
}
