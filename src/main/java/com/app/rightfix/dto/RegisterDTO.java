package com.app.rightfix.dto;

import com.app.rightfix.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String fullName;
    private Gender gender;
    private LocalDate dob;
    private String email;
    private String username;
    private String password;
}
