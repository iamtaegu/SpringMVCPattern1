package com.example.demo.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberMapperDto {

    private Long member_id;
    private String member_email;
    private String member_password;
    private String member_name;

    // 아래 생성자는 회원가입 때 필요한 정보만 모아놓은 생성자로 미리 만들어둡시다 :D
    public MemberMapperDto (String member_name) {
        this.member_name = member_name;
    }
}
