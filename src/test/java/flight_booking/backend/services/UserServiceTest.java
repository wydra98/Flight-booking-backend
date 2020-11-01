package flight_booking.backend.services;

import flight_booking.backend.models.User;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {


    @Test
    public void findById() {
        //given
        UserService userService = mock(UserService.class);
        User user = User.builder()
                .name("Adrian")
                .surname("Wydra")
                .email("adek868@interia.eu")
                .password("wydra98")
                .role("ROLE_USER")
                .build();
        //when
        when(userService.findById(anyLong())).thenReturn(Optional.of(user));
        //then
        User user2 = userService.findById(anyLong()).get();
        assertEquals(user, user2);
    }


    @Test
    public void findAll() {
        //given
        UserService UserService = mock(UserService.class);
        //when
        when(UserService.findAll()).thenReturn(prepareMockData());
        //then
        assertThat(UserService.findAll(), Matchers.hasSize(1));
    }

    private List<User> prepareMockData() {
        List<User> user = new ArrayList<>();
        user.add(User.builder()
                .name("Adrian")
                .surname("Wydra")
                .email("adek868@interia.eu")
                .password("wydra98")
                .role("ROLE_USER")
                .build());
        return user;
    }
}
