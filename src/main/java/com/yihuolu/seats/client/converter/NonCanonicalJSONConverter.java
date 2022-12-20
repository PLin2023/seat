package com.yihuolu.seats.client.converter;

import com.alibaba.fastjson.JSON;
import com.dtflys.forest.converter.ForestConverter;
import com.dtflys.forest.utils.ForestDataType;

import java.lang.reflect.Type;
import java.nio.charset.Charset;

public class NonCanonicalJSONConverter implements ForestConverter<String> {
    @Override
    public <T> T convertToJavaObject(String s, Type type) {
        s = s.replace("\\", "");
        s = s.substring(1, s.length() - 1);
        return JSON.parseObject(s, type);
    }

    @Override
    public <T> T convertToJavaObject(byte[] bytes, Class<T> aClass, Charset charset) {
        String s = new String(bytes);
        return convertToJavaObject(s, aClass);
    }

    @Override
    public <T> T convertToJavaObject(byte[] bytes, Type type, Charset charset) {
        String s = new String(bytes);
        return convertToJavaObject(s, type);
    }

    @Override
    public ForestDataType getDataType() {
        return ForestDataType.TEXT;
    }
}