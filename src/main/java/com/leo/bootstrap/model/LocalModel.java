/*
 * Package name:com.leo.bootstrap.model
 * File name:localModel.java
 * Date:2017-06-21 16:30
 * Omni Prime Inc.Copyright (c) 2015-2017 All Rights Reserved.
 *
 */
package com.leo.bootstrap.model;

/**
 * Desc
 *
 * @author leo@fenqi.im
 * @version 1.0.0
 * @since 2017-06-21 16:30
 */
public class LocalModel {
    private String id;
    private String code;
    private String name;
    private String parentcode;
    private int type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}