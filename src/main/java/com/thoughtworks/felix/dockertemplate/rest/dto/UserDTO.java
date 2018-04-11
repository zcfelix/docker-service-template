package com.thoughtworks.felix.dockertemplate.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.felix.dockertemplate.domain.User;

public class UserDTO {
    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonCreator
    private UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.createdAt = user.getCreatedAt().toString();
    }
}
