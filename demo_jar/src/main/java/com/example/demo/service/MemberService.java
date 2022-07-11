package com.example.demo.service;

import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.dto.MemberMapperDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void memberSave(String name) {
        memberRepository.save1(new MemberMapperDto(name));
    }

    @Transactional
    public List<MemberMapperDto> memberSelect() {
        return memberRepository.select1();
    }
}
