package org.best.saintpetersburg.backend.controller.demos;

import org.best.saintpetersburg.backend.model.MemberAccount;
import org.best.saintpetersburg.backend.service.httpservice.HttpService;
import org.best.saintpetersburg.backend.service.memberservice.MemberAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/members")
public class MemberDemoController {

    private MemberAccountService memberAccountService;
    private HttpService httpService;

    MemberDemoController(MemberAccountService memberAccountService, HttpService httpService) {
        this.memberAccountService = memberAccountService;
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
        if (memberAccountService.existsByUsername(membername)) {
            return new ResponseEntity<>(memberAccountService.findByUsername(membername), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(httpService.createMessage("Пользователь с таким логином не найден"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/demo/save")
    @ResponseBody
    public ResponseEntity<?> saveDemo(@RequestParam(defaultValue = "admin") String membername,
                                      @RequestParam(defaultValue = "admin") String memberpwd) {
        MemberAccount memberAccount = new MemberAccount();

        memberAccount.setUsername(membername);
        if (memberAccountService.existsByUsername(memberAccount.getUsername())) {
            return new ResponseEntity<>(httpService.createMessage("Этот логин уже занят"), HttpStatus.CONFLICT);
        }

        memberAccount.setPassword(memberpwd);

        memberAccountService.save(memberAccount);

        return new ResponseEntity<>(httpService.createMessage("Демо пользователь сохранен успешно!"), HttpStatus.CREATED);
    }
}
