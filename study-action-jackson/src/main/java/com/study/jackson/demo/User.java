/**
 * 
 * File: User.java <br/>
 * Package: com.study.jackson.demo <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年10月19日 上午11:09:26
 * @version 1.0
 * 
 */
package com.study.jackson.demo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Jackson提供了一系列注解，方便对JSON序列化和反序列化进行控制，下面介绍一些常用的注解。
 @JsonIgnore 此注解用于属性上，作用是进行JSON操作时忽略该属性。
 @JsonFormat 此注解用于属性上，作用是把Date类型直接转化为想要的格式，如@JsonFormat(pattern = "yyyyMMdd")
 @JsonProperty 此注解用于属性上，作用是把该属性的名称序列化为另外一个名称，如把eMail属性序列化为mail，@JsonProperty("mail")
 */
public class User {
    private String mName;
    
    @JsonIgnore // 不JSON序列化年龄属性
    private int age;
    
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") // 格式化日期属性
    private Date birthday;
    
    @JsonProperty("mail") // 序列化email属性为mail
    private String email;
    
    /**  
     * @return mName  
     */
    public String getmName() {
        return mName;
    }
    /**  
     * @param mName the mName to set
     */
    public void setmName(String mName) {
        this.mName = mName;
    }
    /**  
     * @return age  
     */
    public int getAge() {
        return age;
    }
    /**  
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**  
     * @return birthday  
     */
    public Date getBirthday() {
        return birthday;
    }
    /**  
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    /**  
     * @return email  
     */
    public String getEmail() {
        return email;
    }
    /**  
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
 
    @Override
    public String toString() {
        return "User [mName=" + mName + ", age=" + age + ", birthday="
                + birthday + ", email=" + email + "]";
    }

}
