package com.dbs6339.webservice.dto.User;

import com.dbs6339.webservice.domain.User.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String email;
    private String name;
    private String passwd;
    private int active;


    @Builder
    public void UserSaveRequesterDto(String email, String name, String passwd, int active){
        this.email = email;
        this.name = name;
        this.passwd = passwd;
        this.active = active;


    }
    public User toEntity() {
        return User.builder().email(email).passwd(passwd).name(name).active(active).build();
    }
}
