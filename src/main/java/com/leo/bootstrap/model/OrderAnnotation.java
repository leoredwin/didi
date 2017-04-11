package com.leo.bootstrap.model;

import java.lang.annotation.*;

/**
 * @author tanlw
 * @version $ID: OrderAnnotation.java, v 0.1 2016-10-11 16:03
 * @ Email: tanlw@fenqi.im
 * @ Copyright (C), 上海秦苍信息科技有限公司
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OrderAnnotation {
    /**
     * 序号
     *
     * @return
     */
    int id() default -1;

    /**
     * 字段名
     *
     * @return
     */
    String name() default "";

    /**
     * 是否需要
     *
     * @return
     */
    boolean require() default false;
}
