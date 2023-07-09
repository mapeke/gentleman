package kz.bitlab.techboot.gentleman.service;

import kz.bitlab.techboot.gentleman.dto.UserDTO;
import kz.bitlab.techboot.gentleman.mapper.UserMapper;
import kz.bitlab.techboot.gentleman.model.Permission;
import kz.bitlab.techboot.gentleman.model.User;
import kz.bitlab.techboot.gentleman.repository.OrderRepository;
import kz.bitlab.techboot.gentleman.repository.PermissionRepository;
import kz.bitlab.techboot.gentleman.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminUserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PermissionRepository permissionRepository;
    private final OrderRepository orderRepository;


    public List<UserDTO> getUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public List<UserDTO> getBarbers(){

        List<UserDTO> barbers = getUsers().stream()
                .filter(user -> user.getPermissions().stream().anyMatch(permission -> permission.getRole().equals("ROLE_BARBER")))
                .collect(Collectors.toList());
        return barbers;
    }

    public UserDTO getUser(Long id){
        return userMapper.toDto(userRepository.findById(id).orElse(new User()));
    }

    public void deleteUser(Long id){
        orderRepository.deleteByBarberId(id);
        orderRepository.deleteByClientId(id);
        userRepository.deleteAllPermissionsById(id);
        userRepository.deleteById(id);
    }

    public UserDTO addBarber(User user){
        User checkUser = userRepository.findByEmail(user.getEmail());
        if(checkUser == null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Permission userPermission = permissionRepository.findByRole("ROLE_USER");
            Permission barberPermission = permissionRepository.findByRole("ROLE_BARBER");
            List<Permission> permissions = new ArrayList<>();
            permissions.add(userPermission);
            permissions.add(barberPermission);
            user.setPermissions(permissions);
            return userMapper.toDto(userRepository.save(user));
        }
        return null;
    }
}
