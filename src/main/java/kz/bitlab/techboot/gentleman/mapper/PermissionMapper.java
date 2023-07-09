package kz.bitlab.techboot.gentleman.mapper;

import kz.bitlab.techboot.gentleman.dto.PermissionDTO;
import kz.bitlab.techboot.gentleman.model.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    @Mapping(source = "role", target = "role")
    PermissionDTO toDto(Permission permission);

    @Mapping(source = "role", target = "role")
    Permission toModel(PermissionDTO permissionDTO);

    List<PermissionDTO> toDtoList(List<Permission> permissionsList);
    List<Permission> toModelList(List<PermissionDTO> permissionList);
}
