package com.sparta.timeataack.controller;

import com.sparta.timeataack.dto.SignupRequestDto;
import com.sparta.timeataack.dto.UserRequestDto;
import com.sparta.timeataack.model.User;
import com.sparta.timeataack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 유저 생성
    @PostMapping("/create")
    public User registerUser(SignupRequestDto requestDto) {
        return userService.registerUser(requestDto);
    }

    // 유저 검색
    @GetMapping("/read/{id}")
    public User findUser(@PathVariable Long id){
        return userService.findeUser(id);
    }

    // 유저 정보 업데이트
    @PutMapping("/update/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
        User user = userService.updateUser(id, requestDto);
        return user.getId();
    }

    // 유저 삭제
    @DeleteMapping("/delete/{id}")
    public Long deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
