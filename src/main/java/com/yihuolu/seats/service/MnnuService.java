package com.yihuolu.seats.service;


import com.alibaba.fastjson.JSON;
import com.yihuolu.seats.client.MnnuClient;
import com.yihuolu.seats.domain.User;
import com.yihuolu.seats.domain.client.Book;
import com.yihuolu.seats.domain.client.ClientUser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MnnuService {

    private User user;
    @Resource
    private MnnuClient mnnuClient;

    public void load(User user) {
        if (this.user == null) {
            this.user = user;
        }
        if (this.user == null) {
            return;
        }
        mnnuClient.load(this.user.getOpenId());
    }

    public ClientUser getClientUser() {
        load(null);
        String s = mnnuClient.home();
        Document doc = Jsoup.parse(s);
        Element inputElement = doc.getElementById("user");
        String value = inputElement.attr("value");
        return JSON.parseObject(value, ClientUser.class);
    }

    public Book getBookInfo() {
        load(null);
        String s = mnnuClient.home();
        Document doc = Jsoup.parse(s);
        Element inputElement = doc.getElementById("book");
        String bookValue = inputElement.attr("value");
        Element qiandaoid = doc.getElementById("qiandaoid");
        String qiandaoidText = qiandaoid.text();
        Book book = JSON.parseObject(bookValue, Book.class);
        book.setQiandaoid(qiandaoidText);
        return book;
    }
}
