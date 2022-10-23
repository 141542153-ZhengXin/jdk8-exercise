package com.geek.optional;

import com.sun.istack.internal.Nullable;
import lombok.SneakyThrows;

import java.util.Optional;

/**
 * @version V1.0
 * @description: OptionalUtil
 * @author: geek
 * @date 2022/10/16
 **/
public class OptionalUtil {
    /**
     * empty():返回空的0ptional对象
     * isPresent():返回对象是否存在值,存在返回true,不存在返回false
     * isEmpty():函数用法与isPresent()相反,java11中才可使用
     *
     * @param optional
     */
    public static void empty(Optional optional) {
        System.out.printf("[dto is empty]=%s%n", optional.isPresent());
    }

    /**
     * of():构造Optional对象,空值则抛出异常
     *
     * @param optional
     */
    public static void of(@Nullable Optional optional) {
        System.out.printf("[dto is not empty]=%s%n", optional.isPresent());
    }

    /**
     * ofNullable():构造Optional对象,可传空值,返回空对象
     * get():返回包装的对象
     * orElse():空值则返回默认值/函数接口的返回值(注意:无论是否空值,都会默认创建对象)
     * orElseGet():空值则返回函数接口的返回值
     * orElseThrow():空值则抛出异常
     *
     * @param optional
     */
    @SneakyThrows
    public static void ofNullable(Optional optional) {
        System.out.println("orElse using");
        System.out.printf("dto!=null,optionalDTO=%s%n", Optional.ofNullable(optional.get()).orElse(getDefaultValue()));
        System.out.println("orElseGet using");
        System.out.printf("dto!=null,optionalDTO=%s%n", Optional.ofNullable(optional.get()).orElseGet(OptionalUtil::getDefaultValue));

        System.out.printf("dto==null,optionalDTO=%s%n", Optional.ofNullable(null).orElse(optional.get()));
        System.out.printf("dto==null,optionalDTO=%s%n", Optional.ofNullable(null).orElseGet(() -> OptionalDTO.builder().id("1").name("optional").content("hello").build()));
        System.out.printf("dto==null,optionalDTO=%s%n", Optional.ofNullable(null).orElseThrow(Exception::new));
    }

    public static OptionalDTO getDefaultValue() {
        final OptionalDTO optionalDTO = OptionalDTO.builder().id("2").name("optional2").content("hello").build();
        System.out.println("default optionalDTO is building");
        return optionalDTO;
    }

    /**
     * ifPresent():optional对象非空值,则执行函数
     *
     * @param optional
     */
    public static void ifPresent(Optional optional) {
        optional.ifPresent(v -> System.out.printf("optional!=null%n"));
    }

    /**
     * map():转换函数
     *
     * @param optional
     */
    public static void map(Optional<OptionalDTO> optional) {
        final Integer contentLength = optional.map(OptionalDTO::getContent).map(String::length).get();
        System.out.printf("content length = %s%n", contentLength);
    }

    /**
     * flatMap():转换函数(可获取嵌套对象)
     *
     * @param optional
     */
    public static void flatMap(Optional<OptionalDTO> optional) {
        final String opName = optional.flatMap(OptionalDTO::getOpName).get();
        final String opName2 = optional.map(OptionalDTO::getOpName).get().get();
        System.out.printf("flatMap opName = %s%n", opName);
        System.out.printf("map opName = %s%n", opName2);
    }

    /**
     * filter():对包装的值运行内联测试
     *
     * @param optional
     */
    public static void filter(Optional<OptionalDTO> optional) {
        boolean present = optional.map(OptionalDTO::getContent).filter(v -> "hello".equals(v)).isPresent();
        System.out.printf("content == hello is %s%n", present);
        present = optional.map(OptionalDTO::getContent).filter(v -> !"hello".equals(v)).isPresent();
        System.out.printf("content != hello is %s%n", present);
    }
}
