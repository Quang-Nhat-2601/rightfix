package com.app.rightfix.mapper;

import com.app.rightfix.dto.request.PermissionRequest;
import com.app.rightfix.dto.response.PermissionResponse;
import com.app.rightfix.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
