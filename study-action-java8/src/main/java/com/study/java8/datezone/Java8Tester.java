package com.study.java8.datezone;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Java8Tester {
    public static void main(String args[]){
        Java8Tester java8tester = new Java8Tester();
        java8tester.testZonedDateTime();
    }

    public void testZonedDateTime(){

        // 时间日期解析
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        // 获取当前时间日期
        ZonedDateTime date2 = ZonedDateTime.now();
        System.out.println("date2: " + date2);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZonedDateTime date3 = ZonedDateTime.now(id);
        System.out.println("date3: " + date3);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);

        //System.out.println("所有时区: " + ZoneId.getAvailableZoneIds());
        //ZoneId.getAvailableZoneIds().forEach(System.out::println);

        Iterables.forEach(ZoneId.getAvailableZoneIds(), (index, str) -> System.out.println(index + " -> " + str));
    }
}

class Iterables {

    public static <E> void forEach(
            Iterable<? extends E> elements, BiConsumer<Integer, ? super E> action) {
        Objects.requireNonNull(elements);
        Objects.requireNonNull(action);

        int index = 0;
        for (E element : elements) {
            action.accept(index++, element);
        }
    }
}
