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
        System.out.println(home );
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
        SeatResponse seatResponse = mnnuClient.getSeats(33, "2020-12-01", 1);
        List<Seat> seats = seatResponse.getSeats();
        seats.forEach(System.out::println);
    }

}
