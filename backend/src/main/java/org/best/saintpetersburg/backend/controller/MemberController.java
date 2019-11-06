package org.best.saintpetersburg.backend.controller;

import org.best.saintpetersburg.backend.model.Member;
import org.best.saintpetersburg.backend.service.httpservice.HttpService;
import org.best.saintpetersburg.backend.service.memberservice.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/members")
public class MemberController {

    private MemberService memberService;
    private HttpService httpService;

    MemberController(MemberService memberService, HttpService httpService) {
        this.memberService = memberService;
        this.httpService = httpService;
    }


    @GetMapping("/demo/status")
    @ResponseBody
    public ResponseEntity<Map<String, String>> getDemo() {
        Map<String, String> map = new HashMap<>();

        map.put("demo status", "works");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/demo/get")
    @ResponseBody
    public ResponseEntity<?> getDemoParams(@RequestParam("membername") String membername) {
        if (memberService.existsByUsername(membername)) {
            return new ResponseEntity<>(memberService.findByUsername(membername), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(httpService.createMessage("Пользователь с таким логином не найден"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/demo/save")
    @ResponseBody
    public ResponseEntity<?> saveDemo(@RequestParam(defaultValue = "admin") String membername,
                                      @RequestParam(defaultValue = "admin") String memberpwd) {
        Member member = new Member();

        member.setLogin(membername);
        if (memberService.existsByUsername(member.getLogin())) {
            return new ResponseEntity<>(httpService.createMessage("Этот логин уже занят"), HttpStatus.CONFLICT);
        }

        member.setPassword(memberpwd);

        memberService.save(member);

        return new ResponseEntity<>(httpService.createMessage("Демо пользователь сохранен успешно!"), HttpStatus.CREATED);
    }
}
