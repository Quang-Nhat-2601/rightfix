package com.app.rightfix.dto.request;
import java.time.LocalDate;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.validation.constraints.Size;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    @Size(min = 4, message = "USERNAME_INVALID")
    String username;

    @Size(min = 6, message = "INVALID_PASSWORD")
    String password;

    String fullName;

    LocalDate dob;
}
