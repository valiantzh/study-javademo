package com.study.netty.tcp.demo2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.netty.tcp.demo2.utils.JacksonUtils;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author valiantzh
 * @version 1.0
 */
public class User {
    private String name;
    private int age;
    private String  UID;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", UID='").append(UID).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        User user = new User();
        user.setAge(20);
        user.setName("xyz");
        user.setUID(UUID.randomUUID().toString());
        user.setBirthday(new Date());
        System.out.println(User.class.getName());
        Class type=Class.forName(User.class.getName());
        ObjectMapper objectMapper = JacksonUtils.getInstanceObjectMapper();
        try {
            String value = objectMapper.writeValueAsString(user);
            System.out.println(value);
            System.out.println(objectMapper.readValue(value.getBytes(),type));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
