package com.anuj.FirstSpringBootProject.service;

import com.anuj.FirstSpringBootProject.entity.User;
import com.anuj.FirstSpringBootProject.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
public class UserServiceTests {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserService userService;
//
//    @Disabled
//    @Test
//    public void test() {
////        assertEquals(4,2+1);
////        assertNotEquals(1,1);
//        User user = userRepository.findByUserName("a");
//        assertNotNull(user);
//    }
//
//    @Disabled
//    @ParameterizedTest
//    @ValueSource(strings = {
//            "a",
//            "b",
//            "admin1"
//    })
//    public void test(String name) {
//        assertNotNull(userRepository.findByUserName(name));
//    }
//
//
//    @ParameterizedTest
//    @ArgumentsSource(UserArgumentsProvider.class)
//    public void testSaveUser(User user) {
//        assertTrue(userService.saveNewEntity(user));
//    }
//
//
//    @Disabled
//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2",
//            "2,3,4",
//    })
//    public void test(int a,int b,int expected) {
//        assertEquals(expected,a + b);
//    }
//
//    @BeforeAll
//    public static void setUp() {
//        System.out.println("Starting test");
//    }
}
