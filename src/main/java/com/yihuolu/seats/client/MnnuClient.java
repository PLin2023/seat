package com.yihuolu.seats.client;

import com.dtflys.forest.annotation.*;
import com.yihuolu.seats.client.converter.NonCanonicalJSONConverter;
import com.yihuolu.seats.client.interceptor.CookieInterceptor;
import com.yihuolu.seats.domain.client.*;

@BaseRequest(
        baseURL = "https://seatwx.mnnu.edu.cn",
        headers = {
                "User-Agent: ${useragent}"
        },
        interceptor = {
                CookieInterceptor.class
        }
)
public interface MnnuClient {

    @Get("/remote/static/phoneIndexByPathOpenId/{openid}")
    void load(@Var("openid") String openid);

    @Get("/libseat-ibeacon/currentBook")
    String home();

    @Get("/libseat-ibeacon/getUserBookHistory")
    BookHistoryResponse getBookHistory();

    @Get("/libseat-ibeacon/getUserViolations")
    ViolationResponse getViolations();

    @Get("/libseat-ibeacon/loadRooms")
    RoomResponse getRooms(@Query("buildId") Integer buildId);

    @Get("/libseat-ibeacon/seats?linkSign=activitySeat")
    SeatResponse getSeats(@Query("buildId") Integer buildId, @Query("roomId") Integer roomId, @Query("date") String date);

    @Get("/libseat-ibeacon/loadStartTime")
    SeatResponse loadStartTime(@Query("seatId") Integer seatId, @Query("date") String date);

    @Get("/libseat-ibeacon/loadEndTimeByStart")
    SeatResponse loadEndTimeByStart(@Query("seatId") Integer seatId, @Query("date") String date, @Query("start") Integer start);

    @Get("/libseat-ibeacon/searchSeats?linkSign=activitySeat")
    SeatResponse searchSeats(@Query("buildId") Integer buildId, @Query("roomId") Integer roomId, @Query("date") String date, @Query("begin") Integer begin, @Query("end") Integer end);

    @Get(value = "/libseat-ibeacon/saveBook?type=1", decoder = NonCanonicalJSONConverter.class)
    SaveBookResponse saveBook(@Query("seatId") Integer seatId, @Query("date") String date, @Query("start") Integer start, @Query("end") Integer end);

    @Get(value = "/libseat-ibeacon/cancleBook", decoder = NonCanonicalJSONConverter.class)
    CancelBookResponse cancelBook(@Query("bookId") Integer bookId);

    @Get(value = "/libseat-ibeacon/stop")
    String stopBook(@Query("bookId") Integer bookId);

    @Get(value = "/rest/v2/checkIn")
    String checkIn();


    @Get(value = "/libseat-ibeacon/cancleBundle?linkSign=currentBook&type=currentBook")
    String cancelBundle();

    @Post(value = "/libseat-ibeacon/bundle",
            data = {
                    "linkSign=currentBook",
                    "type=currentBook",
                    "msg="
            })
    String bundle(@Body("account") String account, @Body("password") String password, @Body("weChat") String weChat);


}
