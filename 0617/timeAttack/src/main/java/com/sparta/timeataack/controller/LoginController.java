package com.sparta.timeataack.controller;

import com.sparta.timeataack.dto.LonginRequestDto;
import com.sparta.timeataack.security.Jwt;
import com.sparta.timeataack.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;
    private final Jwt jwt;
    //로그인 되어 토근이 세팅됬음을 처리
    public static String jwtToken = "";

    @PostMapping("/login")
    public boolean longin(LonginRequestDto requestDto) {
        Long id = loginService.confirmUser(requestDto);
        String jwtToken = null;
        if (id != 0) {
            jwtToken = jwt.makeJwtToken();
            return true;
        }
        return false;
    }
}
