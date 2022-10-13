package com.stussy.stussyclone20220930oh.api;

import com.stussy.stussyclone20220930oh.aop.annotation.LogAspect;
import com.stussy.stussyclone20220930oh.dto.CMRespDto;
import com.stussy.stussyclone20220930oh.dto.RegisterReqDto;
import com.stussy.stussyclone20220930oh.dto.validation.ValidationSequence;
import com.stussy.stussyclone20220930oh.exception.CustomValidationException;
import com.stussy.stussyclone20220930oh.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor // 필수생성자
public class AccountApi {

    public final AccountService accountService; // final 기본생성자 x

    @LogAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) throws Exception {

        //데이터 통신순서: 클라이언트 -(dto으로 통신)> api -(dto으로 통신)> 서비스 -(entity로 통신)> 레파지토리 -(entity로 통신)> DB서버

        accountService.duplicateEmail(registerReqDto);
        accountService.register(registerReqDto);

        return ResponseEntity.created(URI.create("/account/login")).body(new CMRespDto<>("회원가입 성공", registerReqDto.getEmail()));
    }
}
