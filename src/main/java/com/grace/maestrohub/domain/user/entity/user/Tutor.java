package com.grace.maestrohub.domain.user.entity.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tutor")
public class Tutor {
    @Id
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 100)
    private String major;

    @Column(nullable = false)
    private int careerYears;

    @Column(length = 500)
    private String introduction;

    public Tutor(User user, String major, int careerYears, String introduction) {
        this.user = user;
        this.major = major;
        this.careerYears = careerYears;
        this.introduction = introduction;

        user.setTutor(this);
    }
}
