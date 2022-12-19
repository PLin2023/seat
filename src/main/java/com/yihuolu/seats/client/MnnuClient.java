package com.yihuolu.seats.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Var;
import com.yihuolu.seats.client.interceptor.CookieInterceptor;
import com.yihuolu.seats.domain.client.BookHistoryResponse;
import com.yihuolu.seats.domain.client.RoomResponse;
import com.yihuolu.seats.domain.client.SeatResponse;
import com.yihuolu.seats.domain.client.ViolationResponse;

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
    RoomResponse getRooms(@Query("buildingId") Integer buildingId);

    @Get("/libseat-ibeacon/seatdetail?linkSign=activitySeat")
    SeatResponse getSeats(@Query("roomId") Integer roomId, @Query("date") String date, @Query("buildId") Integer buildId);

    @Get("/libseat-ibeacon/saveBook?type=1")
    String saveBook(@Query("seatId") Integer seatId, @Query("date") String date, @Query("start") Integer start, @Query("end") Integer end);


}
