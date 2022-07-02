package com.example.demo.web.controller;

import com.example.demo.repository.dto.MemberMapperDto;
import com.example.demo.service.MemberServcie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/basic")
public class BasicController {

    private final MemberServcie memberServcie;

    @GetMapping
    public String basic() {

        return "basic is good";
    }

    @GetMapping("memberSave")
    public String memberSave(@RequestParam String name) {
        System.out.println("[BasicController][memberSave] name= "+ name);
        memberServcie.memberSave(name);

        return "memberSave is OK";
    }

    @GetMapping("memberSelect")
    public List<String> memberSelect() {

        List<MemberMapperDto> listMember = memberServcie.memberSelect();

        return listMember.stream()
                .map(m -> m.getMember_name())
                .collect(Collectors.toList());
    }

}
