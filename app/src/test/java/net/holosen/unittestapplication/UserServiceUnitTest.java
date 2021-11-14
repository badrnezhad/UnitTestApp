package net.holosen.unittestapplication;

import net.holosen.unittestapplication.services.UserService;
import net.holosen.unittestapplication.models.User;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class UserServiceUnitTest {

    @Test
    public void checkUserEmpty(){
        User user = new User();
        user.setUsername("");
        user.setPassword("123");
        user.setRepeatedPassword("123");
        boolean result = UserService.checkUserPass(user);
        assertThat(result).isFalse();
    }

    @Test
    public void checkUserIsNull(){
        User user = new User();
        user.setPassword("123");
        user.setRepeatedPassword("123");
        boolean result = UserService.checkUserPass(user);
        assertThat(result).isFalse();
    }
    @Test
    public void checkDataIsNull(){
        boolean result = UserService.checkUserPass(null);
        assertThat(result).isFalse();
    }

    @Test
    public void checkValidData(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        user.setRepeatedPassword("123");
        boolean result = UserService.checkUserPass(user);
        assertThat(result).isTrue();
    }

    @Test
    public void checkPasswordNotEqualsToRepeatedPassword(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        user.setRepeatedPassword("1234");
        boolean result = UserService.checkUserPass(user);
        assertThat(result).isFalse();
    }
}
