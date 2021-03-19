package com.example.springbootdemo.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 *
 * @author LargerBear</ br>
 * date: 2020/11/25 13:47</br>
 * @since JDK 1.8
 */
public class DateSerializer extends JsonSerializer<Date> {


    /**
     * 自定义全局时间处理，将默认毫秒级别修改为秒级别
     *
     * 使用方式（@JsonSerialize(using = DateSerializer.class)）
     * @param date
     * @param jsonGenerator
     * @param serializerProvider
     * @throws IOException
     */
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(date.getTime() / 1000);
    }
}
