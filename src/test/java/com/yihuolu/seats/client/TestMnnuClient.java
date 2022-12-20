package com.yihuolu.seats.client;

import com.yihuolu.seats.domain.client.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestMnnuClient {

    @Resource
    private MnnuClient mnnuClient;

    @Test
    public void testLoad() {
        mnnuClient.load("o1IyJt23rmG4VDAQL2XrIzLsqZ7g");
        String home = mnnuClient.home();
        System.out.println(home);
    }

    @Test
    public void testGetBookHistory() {
        mnnuClient.load("o1IyJt23rmG4VDAQL2XrIzLsqZ7g");
        BookHistoryResponse bookHistoryResponse = mnnuClient.getBookHistory();
        List<BookHistory> history = bookHistoryResponse.getHistory();
        history.forEach(System.out::println);
    }

    @Test
    public void testGetViolations() {
        mnnuClient.load("o1IyJt23rmG4VDAQL2XrIzLsqZ7g");
        ViolationResponse violationResponse = mnnuClient.getViolations();
        System.out.println(violationResponse);
    }

    @Test
    public void testGetRooms() {
        mnnuClient.load("o1IyJt23rmG4VDAQL2XrIzLsqZ7g");
        RoomResponse roomResponse = mnnuClient.getRooms(1);
        List<Room> rooms = roomResponse.getRooms();
        rooms.forEach(System.out::println);
    }

    @Test
    public void testGetSeats() {
        mnnuClient.load("o1IyJt23rmG4VDAQL2XrIzLsqZ7g");
        SeatResponse seatResponse = mnnuClient.getSeats(1, 33, "2022-12-20");
        List<Seat> seats = seatResponse.getSeats();
        seats.forEach(System.out::println);
    }

    @Test
    public void testSearchSeats() {
        mnnuClient.load("o1IyJt23rmG4VDAQL2XrIzLsqZ7g");
        SeatResponse seatResponse = mnnuClient.searchSeats(1, 33, "2022-12-20", 480, 1320);
        List<Seat> seats = seatResponse.getSeats();
        seats.forEach(System.out::println);
    }


    @Test
    public void testSaveBook() {
        mnnuClient.load("o1IyJt23rmG4VDAQL2XrIzLsqZ7g");
        SaveBookResponse saveBookResponse = mnnuClient.saveBook(25491, "2022-12-20", 1140, 1200);
        System.out.println(saveBookResponse); // 4613227
    }

    @Test
    public void testCancelBook() {
        mnnuClient.load("o1IyJt23rmG4VDAQL2XrIzLsqZ7g");
        CancelBookResponse cancelBookResponse = mnnuClient.cancelBook(4613227);
        System.out.println(cancelBookResponse); // 4613446
    }

    @Test
    public void testCheckIn() {
        mnnuClient.load("o1IyJt23rmG4VDAQL2XrIzLsqZ7g");
        String s = mnnuClient.checkIn();
        System.out.println(s);
    }

    @Test
    public void testCancelBundle() {
        mnnuClient.load("o1IyJt23rmG4VDAQL2XrIzLsqZ7g");
        String s = mnnuClient.cancelBundle();
        System.out.println(s);
    }

    @Test
    public void testBundle() {
        String s = mnnuClient.bundle("202008190129", "Mme15259649051", "helloworld");
        System.out.println(s);
    }

}
