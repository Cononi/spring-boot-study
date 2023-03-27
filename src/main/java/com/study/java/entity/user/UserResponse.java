package com.study.java.entity.user;

import com.study.java.data.Name;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {

    private Name name;

    @Builder
    public UserResponse(Name name) {
        this.name = name;
    }

    public static UserResponse from(Center user) {
        return UserResponse.builder()
                .name(new Name(user.getName()))
                .build();
    }
}
