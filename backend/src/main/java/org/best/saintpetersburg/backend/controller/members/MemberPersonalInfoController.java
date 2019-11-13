package org.best.saintpetersburg.backend.controller.members;

import org.best.saintpetersburg.backend.model.MemberPersonalInfo;
import org.best.saintpetersburg.backend.service.httpservice.HttpService;
import org.best.saintpetersburg.backend.service.memberservice.MemberPersonalInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/members/personal")
public class MemberPersonalInfoController {

    private MemberPersonalInfoService memberPersonalInfoService;
    private HttpService httpService;

    MemberPersonalInfoController(MemberPersonalInfoService memberPersonalInfoService1,
                                 HttpService httpService1) {
        this.memberPersonalInfoService = memberPersonalInfoService1;
        this.httpService = httpService1;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getMemberPersonalInfo(@RequestParam("accountid") String accountid) {
        if (memberPersonalInfoService.existsByAccountID(accountid)) {
            return new ResponseEntity<>(memberPersonalInfoService.findByAccountID(accountid), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(httpService.createMessage("Произошла ошибка в получении данных мембера"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> saveMemberPersonalInfo(MemberPersonalInfo memberPersonalInfo) {

        MemberPersonalInfo memberPersonalInfo1 = memberPersonalInfo;

        if (memberPersonalInfoService.existsByAccountID(memberPersonalInfo.getAccountID())) {
            //return new ResponseEntity<>(httpService.createMessage("Такой пользователь уже есть, но ведь это не регистрация!!"), HttpStatus.CONFLICT);
            memberPersonalInfo1.setId(memberPersonalInfoService.findByAccountID(memberPersonalInfo.getAccountID()).getId());
        }

        memberPersonalInfoService.save(memberPersonalInfo1);

        return new ResponseEntity<>(httpService.createMessage("Данные мембера успешно сохранены!"), HttpStatus.OK);
    }
}
