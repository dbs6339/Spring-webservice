package com.dbs6339.webservice.dto.User;


import com.dbs6339.webservice.domain.User.User;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class UserMainResponseDto {



    private Long id;
    private String name;
    private String passwd;
    private String email;
    private int active;
    private String modifiedDate;

    public UserMainResponseDto(User entity){
        id = entity.getId();
        name = entity.getName();
        passwd = entity.getPasswd();
        email = entity.getEmail();
        active = entity.getActive();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

    /**
     * Java 7 버전
     */
    private String toStringDateTimeByJava7(LocalDateTime localDateTime){
        if(localDateTime == null){
            return "";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }
}
