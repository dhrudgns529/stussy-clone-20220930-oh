package com.stussy.stussyclone20220930oh.dto;

import com.stussy.stussyclone20220930oh.domain.User;
import com.stussy.stussyclone20220930oh.dto.validation.ValidationGroups;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.*;

@Data
public class RegisterReqDto {
    // 한글자 이상 세글자 이하.-size 한글.-Pattern 빈칸 체크-NotBlank
    @NotBlank(message = "이름은 비워 둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class) // message는 기존 메세지를 변경할 수 있음.
    @Size(min = 1, max = 3, message = "이름은 3자까지만 입력 가능합니다", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[가-힣]*$", message = "이름은 한글만 입력 가능합니다", groups = ValidationGroups.PatternCheckGroup.class)
    private String lastName;

    @NotBlank(message = "성은 비워 둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class) // message는 기존 메세지를 변경할 수 있음.
    @Size(min = 1, max = 2, message = "성은 2자까지만 입력 가능합니다", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[가-힣]*$", message = "성은 한글만 입력 가능합니다", groups = ValidationGroups.PatternCheckGroup.class)
    private String firstName;

    @NotBlank(message = "이메일은 비워 둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class)
    @Email
    private String email;

    @NotBlank(message = "비밀번호는 비워 둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 8, max = 16, message = "비밀번호는 8자 이상 16자 이하 입력 가능합니다", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]*$", message = "비밀번호는 특수기호, 영문, 숫자를 모두 포함하여야 합니다.", groups = ValidationGroups.PatternCheckGroup.class)
    private String password;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(new BCryptPasswordEncoder().encode(password)) // 패스워드 암호화
                .name(firstName + lastName)
                .role_id(1)
                .build();
    }
}
