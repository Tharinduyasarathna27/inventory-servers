package lk.group1.auth.server;

import lk.group1.auth.server.controller.UserController;
import lk.group1.auth.server.model.Permission;
import lk.group1.auth.server.model.Role;
import lk.group1.auth.server.model.User;
import lk.group1.auth.server.service.UserDetailServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UserControllerTest.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserController userController;

    @Test
    public void testUrl() throws Exception {

        //test
        User user = new User();
        user.setId(1);
        user.setUsername("Waruna");
        user.setPassword("1qaz2wsx@");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setRoles(null);

        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(user);


        mockMvc.perform(MockMvcRequestBuilders.post("/oauth/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(str))
                        .andExpect(MockMvcResultMatchers.status().isOk());

//        Permission permission = new Permission();
//        permission.setId(1);
//        permission.setName("permisson");
//
//
//        Role role = new Role();
//        role.setId(1);
//        role.setName("ADMIN");
////        role.setPermissions();
//
////        User user = new User("Gayan", "123qwe", "wgayan@gmail.com", 1,1,1,1,);
////        this.username = user.getUsername();
////        this.password = user.getPassword();
////        this.email = user.getEmail();
////        this.enabled = user.isEnabled();
////        this.accountNonExpired = user.isAccountNonExpired();
////        this.credentialsNonExpired = user.isCredentialsNonExpired();
////        this.accountNonLocked = user.isAccountNonLocked();
////        this.roles = user.getRoles();
////        User savedUser = userDetailServiceimpl.save(user);
////        assertThat(savedUser.getRegistrationDate()).isNotNull();

    }


}
