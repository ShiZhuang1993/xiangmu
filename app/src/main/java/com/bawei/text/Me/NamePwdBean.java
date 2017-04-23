package com.bawei.text.Me;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/28 13:27
 */
public class NamePwdBean {
    private String id;
    private String name;
    private String pwd;

    public NamePwdBean(String id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
