package com.anuj.FirstSpringBootProject.service;

import com.anuj.FirstSpringBootProject.entity.User;
import com.anuj.FirstSpringBootProject.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTest {
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserService userService;
//
//    @Test
//    void loadUserByUsernameTest() {
//        when(userRepository.findByUserName(anyString()))
//                .thenReturn(User.builder().userName("A").roles(List.of("USER")).password("A").build());
//
//        User user = userService.findByUserName("A");
//        User user2 = userService.findByUserName("B");
//
//        verify(userRepository,times(2)).findByUserName(anyString());
//    }

}
