package com.example.party_finder;

import com.example.party_finder.domain.User;
import com.example.party_finder.domain.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // 1. 이게 없으면 스프링이 이 파일을 무시한다.
public class DataInitializer implements CommandLineRunner { // 2. 서버 켜지자마자 실행하라는 약속

    private final UserRepository userRepository;

    // 3. 생성자를 통해 User의 Repository를 데려온다.
    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        // 4. 저장할 유저 정보를 담은 객체를 만든다.
        User user = new User();
        user.setUsername("test_user");
        user.setPassword("1234");
        user.setNickname("test_nickname");

        // 5. 비서에게 이 유저를 DB에 저장하라고 시킨다.
        if (userRepository.findByUsername("test_user").isEmpty()) {
            userRepository.save(user);
        }
        System.out.println("유저 데이터 DB입력 작동 여부 확인");
    }
}