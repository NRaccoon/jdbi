package user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jdbi.v3.core.enums.EnumByOrdinal;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    @EnumByOrdinal
    public static enum Gender {
        FEMALE,
        MALE
    }

    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private Gender gender;
    private LocalDate dob;
    private boolean enabled;
}
