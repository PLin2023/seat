package com.yihuolu.seats.client.interceptor;

import com.dtflys.forest.http.ForestCookie;
import com.dtflys.forest.http.ForestCookies;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.interceptor.Interceptor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CookieInterceptor implements Interceptor {

    private final Map<String, List<ForestCookie>> cookieCache = new ConcurrentHashMap<>();

    @Override
    public void onSaveCookie(ForestRequest request, ForestCookies cookies) {
        String host = request.getURI().getHost();
        cookieCache.put(host, cookies.allCookies());
    }

    @Override
    public void onLoadCookie(ForestRequest request, ForestCookies cookies) {
        String host = request.getURI().getHost();
        List<ForestCookie> cookieList = cookieCache.get(host);
        cookies.addAllCookies(cookieList);
    }
}
