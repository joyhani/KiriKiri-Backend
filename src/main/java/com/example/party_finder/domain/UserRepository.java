package com.example.party_finder.domain;
import org.springframework.data.jpa.repository.JpaRepository;

//DB에 데이터를 저장하거나 조회하는 '심부름꾼'


// <엔티티 클래스명, ID의 타입>을 적어준다.
public interface UserRepository extends JpaRepository<User, Long> {
    // 이제 .save(), .findAll() 같은 메서드를 바로 쓸 수 있습니다.
}