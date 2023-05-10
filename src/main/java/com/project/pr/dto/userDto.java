package com.project.pr.dto;
import com.project.pr.enums.status;
import com.project.pr.enums.type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class userDto {

    private String username;
    private String email;
    private String password;
    private String phone;
    private type type;
    private status status;

}
