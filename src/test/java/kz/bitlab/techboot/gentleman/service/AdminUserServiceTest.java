package kz.bitlab.techboot.gentleman.service;

import com.google.common.collect.ImmutableList;
import kz.bitlab.techboot.gentleman.dto.UserDTO;
import kz.bitlab.techboot.gentleman.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdminUserServiceTest {

    @Mock
    private AdminUserService adminUserService;

    @Test
    public void testGetUsers() {
        //prepare
        when(adminUserService.getUsers()).thenReturn(ImmutableList.of());
        //testing
        List<UserDTO> users = adminUserService.getUsers();
        //validate
        verify(adminUserService).getUsers();
    }


    @Test
    public void testGetBarbers() {
        //prepare
        when(adminUserService.getBarbers()).thenReturn(ImmutableList.of());
        //testing
        List<UserDTO> barbers = adminUserService.getBarbers();
        //validate
        verify(adminUserService).getBarbers();
    }

    @Test
    public void testGetUser() {
        //prepare
        when(adminUserService.getUser(1L)).thenReturn(null);
        //testing
        UserDTO user = adminUserService.getUser(1L);
        //validate
        verify(adminUserService).getUser(1L);
    }


    @Test
    public void testDeleteUser() {
        //prepare
        //testing
        adminUserService.deleteUser(1L);
        //validate
        verify(adminUserService).deleteUser(1L);
    }



    @Test
    public void testAddBarber() {
        User barber = new User();
        //prepare
        when(adminUserService.addBarber(barber)).thenReturn(null);
        //testing
        adminUserService.addBarber(barber);
        //validate
        verify(adminUserService).addBarber(barber);
    }

}
