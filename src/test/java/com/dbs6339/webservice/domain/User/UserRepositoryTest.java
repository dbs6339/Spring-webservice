package com.dbs6339.webservice.domain.User;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepositrory userRepository;

    @After
    public void cleanup(){
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        userRepository.deleteAll();
    }

    @Test
    public void 유저목록_불러오기() {
        //given
        userRepository.save(User.builder().name("윤은수").passwd("11111111").email("dbs6339@naver.com").active(0).build());

        //when
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);
        assertThat(user.getName(), is("윤은수"));
        assertThat(user.getPasswd(), is("11111111"));
        assertThat(user.getEmail(), is("dbs6339@naver.com"));
        assertThat(user.getActive(), is(0));
    }
        @Test
    public void 유저확인() {
        //given
        userRepository.save(User.builder().name("윤은수").passwd("11111111").email("dbs6339@naver.com").active(0).build());
        String email = "dbs6339@naver.com";
        //when
        User user = userRepository.findByEmail(email);

        //thenS
        assertThat(user.getName(), is("윤은수"));
        assertThat(user.getPasswd(), is("11111111"));
        assertThat(user.getEmail(), is("dbs6339@naver.com"));
        assertThat(user.getActive(), is(0));
    }
    @Test
    public void BaseTimeEntity_등록(){
        //given

        LocalDateTime now = LocalDateTime.now();
        userRepository.save(User.builder().name("윤은수").passwd("11111111").email("dbs6339@naver.com").active(0).build());

        //when
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);
        assertTrue(user.getCreatedDate().isAfter(now));
        assertTrue(user.getModifiedDate().isAfter(now));
    }
}
