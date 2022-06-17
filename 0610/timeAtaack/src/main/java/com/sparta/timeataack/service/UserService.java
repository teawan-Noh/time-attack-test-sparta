package com.sparta.timeataack.service;

import com.sparta.timeataack.dto.SignupRequestDto;
import com.sparta.timeataack.dto.UserRequestDto;
import com.sparta.timeataack.model.User;
import com.sparta.timeataack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(SignupRequestDto requestDto) {  // void 였으나 통합테스트를 위해 User로 반환

        String name = requestDto.getName();
        String email = requestDto.getEmail();
        int age = requestDto.getAge();
        int gender = requestDto.getGender();

        User user = new User(name, email, age, gender);
        userRepository.save(user);
        return user;
    }

    public User findeUser(Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
                );
        return user;
    }

    @Transactional  // @Transactional 사용 or repository.save 처리
    public User updateUser(Long id, UserRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        System.out.println("service" + requestDto.getName());
        user.updateInfo(requestDto);
        return user;
    }

    public Long deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

        userRepository.deleteById(id);
        return id;
    }
}
