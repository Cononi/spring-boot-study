package com.study.java.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Name {

    private String name;

    @Builder
    public Name(String name) {
        this.name = name;
    }

    public Name() {

    }
}
