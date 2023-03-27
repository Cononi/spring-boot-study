package com.study.java;

import com.study.java.entity.user.Center;
import com.study.java.entity.user.UserRepository;
import com.study.java.entity.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainContoller {

    @Autowired
    private ApplicationContext applicationContext;
    private final UserRepository userRepository;

    @GetMapping("/context")
    public String iocContainerTest() {

        return "hello" + applicationContext.getBean(UserRepository.class);
    }

    @GetMapping("/user")
    public String userFind() {
        Center user = Center
                .builder()
                .name("hongwoo")
                .build();
        userRepository.save(user);
        UserResponse userResponse = UserResponse.from(userRepository.findById(1L).get());
        return "hello " +userResponse.getName().getName();
    }
}
