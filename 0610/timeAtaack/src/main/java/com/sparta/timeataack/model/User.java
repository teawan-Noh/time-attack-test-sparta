package com.sparta.timeataack.model;

import com.sparta.timeataack.dto.SignupRequestDto;
import com.sparta.timeataack.dto.UserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User {

    public User(String name, String email, int age, int gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int age ;

    @Column(nullable = false)
    private int gender;

    public void updateInfo(UserRequestDto requestDto) {
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender();
    }
}
