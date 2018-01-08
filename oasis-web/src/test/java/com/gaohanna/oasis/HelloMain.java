package com.gaohanna.oasis;

import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * something
 *
 * @author keben
 * @date 2017/12/12
 */
public class HelloMain {
    public static void main(String[] args) {
        String time = "2018-01-11";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(time, fmt);
        LocalDateTime date = LocalDateTime.of(dateTime, LocalTime.MIN);

        time = date.format(fmt);

        Long a = 10000000000L;
        long b = 10000000000L;
        System.out.println(a==b);
    }
}
