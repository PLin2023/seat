package com.yihuolu.seats.service;

import com.yihuolu.seats.domain.User;
import com.yihuolu.seats.domain.client.Book;
import com.yihuolu.seats.domain.client.ClientUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestMnnuService {

    @Resource
    private MnnuService mnnuService;

    @Test
    public void testGetClientUser() {
        User user = new User();
        user.setOpenId("o1IyJt23rmG4VDAQL2XrIzLsqZ7g");
        mnnuService.load(user);
        ClientUser clientUser = mnnuService.getClientUser();
        System.out.println(clientUser);
    }
    @Test
    public void testGetBookInfo() {
        User user = new User();
        user.setOpenId("o1IyJt23rmG4VDAQL2XrIzLsqZ7g");
        mnnuService.load(user);
        Book bookInfo = mnnuService.getBookInfo();
        System.out.println(bookInfo);
    }

}
