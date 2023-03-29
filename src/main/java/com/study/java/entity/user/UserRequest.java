package com.study.java.entity.user;

import com.study.java.data.Name;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private Name name;

    public Center toEntity() {
        return Center.builder()
                .name(name.getName())
                .build();
    }
}
