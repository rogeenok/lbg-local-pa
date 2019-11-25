package org.best.saintpetersburg.backend.controller.auth;

import org.best.saintpetersburg.backend.model.MemberAccount;
import org.best.saintpetersburg.backend.service.httpservice.HttpService;
import org.best.saintpetersburg.backend.service.memberservice.MemberAccountService;
import org.best.saintpetersburg.backend.service.memberservice.MemberPersonalInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private MemberAccountService memberAccountService;
    private MemberPersonalInfoService memberPersonalInfoService;
    private HttpService httpService;
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    AuthController(MemberAccountService memberAccountService,
                   HttpService httpService,
                   MemberPersonalInfoService memberPersonalInfoService) {
        //this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.httpService = httpService;
        this.memberAccountService = memberAccountService;
        this.memberPersonalInfoService = memberPersonalInfoService;
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> registration(MemberAccount memberAccount) {

        if (memberAccountService.existsByUsername(memberAccount.getUsername())) {
            return new ResponseEntity<>(httpService.createMessage("Имя пользователя занято"), HttpStatus.CONFLICT);
        }

        //memberAccount.setPassword(bCryptPasswordEncoder.encode(memberAccount.getPassword()));
        memberAccountService.save(memberAccount);

        return new ResponseEntity<>(httpService.createMessage("Регистрация прошла успешно!"), HttpStatus.OK);
    }

    // метод должен отдавать просто сообщение и "ОК" при успешном логине, и при последующем запросе уже какие-то данные пользователя
    // на данный момент отдаем личные данные

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(MemberAccount memberAccount) {

        if (!memberAccountService.existsByUsername(memberAccount.getUsername())) {
            return new ResponseEntity<>(httpService.createMessage("Неверный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(memberPersonalInfoService.findByAccountID(memberAccount.getUsername()), HttpStatus.OK);
    }
}
