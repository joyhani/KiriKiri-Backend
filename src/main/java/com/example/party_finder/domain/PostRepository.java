package com.example.party_finder.domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
        // 이제 .save(), .findAll() 같은 메서드를 바로 쓸 수 있습니다.
}