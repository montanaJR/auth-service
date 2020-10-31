package org.montanajr.auth.utils;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtil {

    public static <T> T jsonStrToBean(String jsonStr, Class<T> clazz) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, clazz);
    }

    public static String beanToJsonStr(Object bean) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(bean);
    }
}
