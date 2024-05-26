package com.app.rightfix.mapper;

import com.app.rightfix.dto.request.UserRequest;
import com.app.rightfix.dto.request.UserUpdateRequest;
import com.app.rightfix.dto.response.UserResponse;
import com.app.rightfix.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest request);
    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
