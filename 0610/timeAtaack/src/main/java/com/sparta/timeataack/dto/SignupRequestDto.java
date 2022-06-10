package com.sparta.timeataack.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String name;
    private String email;
    private int age;
    private int gender;
}
