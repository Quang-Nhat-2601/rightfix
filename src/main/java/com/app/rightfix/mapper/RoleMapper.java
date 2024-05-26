package com.app.rightfix.mapper;

import com.app.rightfix.dto.request.RoleRequest;
import com.app.rightfix.dto.response.RoleResponse;
import com.app.rightfix.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);
}
