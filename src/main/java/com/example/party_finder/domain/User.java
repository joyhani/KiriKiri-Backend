package com.example.party_finder.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity // 이 클래스는 DB의 테이블과 1:1로 매핑됩니다.
@Getter @Setter // 필드에 대한 Getter/Setter를 자동으로 생성합니다.
public class User {

    @Id // 기본키(Primary Key) 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 자동 증가 (1, 2, 3...)
    private Long id;

    @Column(nullable = false, unique = true) // 비어있으면 안 되고, 중복도 안 됨
    private String username;

    @Column(nullable = false)
    private String password;

    private String nickname;
}

