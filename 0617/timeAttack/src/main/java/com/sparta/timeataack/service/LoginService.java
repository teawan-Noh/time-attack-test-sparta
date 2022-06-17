package com.sparta.timeataack.service;

import com.sparta.timeataack.dto.LonginRequestDto;
import com.sparta.timeataack.model.User;
import com.sparta.timeataack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long confirmUser(LonginRequestDto requestDto) {

        User user = userRepository.findByEmail(requestDto.getEmail()).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

        return user.getId();
    }
}
