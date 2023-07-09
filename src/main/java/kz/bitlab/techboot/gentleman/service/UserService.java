package kz.bitlab.techboot.gentleman.service;

import kz.bitlab.techboot.gentleman.dto.UserDTO;
import kz.bitlab.techboot.gentleman.mapper.UserMapper;
import kz.bitlab.techboot.gentleman.model.Permission;
import kz.bitlab.techboot.gentleman.model.User;
import kz.bitlab.techboot.gentleman.repository.PermissionRepository;
import kz.bitlab.techboot.gentleman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;


public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user != null){
            return user;
        }else{
            throw new UsernameNotFoundException("User Not Found");
        }
    }

    public UserDTO addUser(User user){
        User checkUser = userRepository.findByEmail(user.getEmail());
        if(checkUser == null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Permission userPermission = permissionRepository.findByRole("ROLE_USER");
            user.setPermissions(Collections.singletonList(userPermission));

            return userMapper.toDto(userRepository.save(user));
        }
        return null;
    }

    public UserDTO updateProfile(String fullName,String newPassword, String oldPassword){

        User currentUser = getCurrentSessionUser();
        if(passwordEncoder.matches(oldPassword, currentUser.getPassword())){
            currentUser.setFullName(fullName);
            currentUser.setPassword(passwordEncoder.encode(newPassword));
            return userMapper.toDto(userRepository.save(currentUser));
        }
        return null;
    }

    public User getCurrentSessionUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User user = (User) authentication.getPrincipal();
            if(user != null)  {
                return user;
            }
        }
        return null;
    }
}
