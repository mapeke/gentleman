package kz.bitlab.techboot.gentleman.service;

import kz.bitlab.techboot.gentleman.dto.UserDTO;
import kz.bitlab.techboot.gentleman.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        //prepare
        when(userService.addUser(user)).thenReturn(null);
        //testing
        userService.addUser(user);
        //validate
        verify(userService).addUser(user);
    }



    @Test
    public void testUpdateProfile() {
        String fullName = "Test Name";
        String newPassword = "$2a$10$AEy/qVLBR1IEBqXzv4BmkemJCHCi1GDdVzlzEKrrEk.SM7dsuXE72";
        String oldPassword = "$2a$10$2lWt7XrmOLBYpLkCFcPRAOC0t9tR.67VKdKzWTr5oKeaWrNuL7aCS";
        //prepare
        when(userService.updateProfile(fullName, newPassword, oldPassword)).thenReturn(null);
        //testing
        UserDTO user = userService.updateProfile(fullName, newPassword, oldPassword);
        //validate
        verify(userService).updateProfile(fullName, newPassword, oldPassword);
    }


    @Test
    public void testGetCurrentSessionUser() {
        //prepare
        when(userService.getCurrentSessionUser()).thenReturn(null);
        //testing
        User user = userService.getCurrentSessionUser();
        //validate
        verify(userService).getCurrentSessionUser();
    }
}
