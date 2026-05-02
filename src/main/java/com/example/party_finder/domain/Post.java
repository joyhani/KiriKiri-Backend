package com.example.party_finder.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate; // 생성 시간 자동 기록 도구
import org.springframework.data.jpa.domain.support.AuditingEntityListener; // 감시자(시간 기록 대기조)

import java.time.LocalDateTime; // 자바의 날짜와 시간 타입

@Entity // 이 클래스는 DB의 테이블과 1:1로 매핑되는 '엔티티'임을 선언
@Getter @Setter // 필드에 대한 Getter/Setter를 자동으로 생성
@EntityListeners(AuditingEntityListener.class) // DB에 저장될 때 "시간 기록" 이벤트를 감지함


public class Post {
    @Id // 이 필드를 테이블의 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 자동 증가 (1, 2, 3...)
    private Long id; // 게시글의 고유 번호

    @Column(nullable = false) // DB 칸을 만들 때 '비어있으면 안 됨(NOT NULL)' 규칙 적용
    private String title; // 게시글 제목

    @Column(columnDefinition = "TEXT", nullable = false) // 일반 글자 칸보다 훨씬 큰 'TEXT' 타입으로 지정
    private String content; // 게시글 본문 내용

    // --- 비회원을 위한 필수 정보 ---

    @Column(nullable = false) // 닉네임 없으면 글 못 씀
    private String author; // 작성자 이름 (유동닉 닉네임)

    @Column(nullable = false) // 비밀번호 없으면 나중에 수정/삭제 못 함
    private String password; // 수정 및 삭제를 위한 비밀번호

    @CreatedDate // 데이터가 처음 저장될 때 현재 시간을 자동으로 꽂아줌
    @Column(updatable = false) // 글을 수정한다고 해서 작성 시간이 바뀌면 안 되므로 '수정 불가' 설정
    private LocalDateTime createdAt; // 글 쓴 시간
}
