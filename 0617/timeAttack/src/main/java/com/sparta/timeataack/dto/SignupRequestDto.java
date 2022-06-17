package com.sparta.timeataack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SignupRequestDto {
    private String name;
    private String email;
    private int age;
    private int gender;
}
