package kz.bitlab.techboot.gentleman.mapper;

import kz.bitlab.techboot.gentleman.dto.UserDTO;
import kz.bitlab.techboot.gentleman.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "email", target = "email")
    UserDTO toDto(User user);

    @Mapping(source = "email", target = "email")
    User toModel(UserDTO userDTO);

    List<UserDTO> toDtoList(List<User> userList);
    List<User> toModelList(List<UserDTO> userList);
}
