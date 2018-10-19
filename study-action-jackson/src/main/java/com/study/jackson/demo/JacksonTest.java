package com.study.jackson.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson:对象和字符串及其数组对象和字符串相互转换
 *   
 * @author zhengxy
 * @date 2018年10月19日 上午11:22:41  
 *
 */
public class JacksonTest {
    
    public static void main(String[] args) throws IOException {
        User user=new User();
        user.setAge(11);
        user.setBirthday(new Date());
        user.setEmail("123456");
        user.setmName("jesse1");

        ObjectMapper mapper = new ObjectMapper();
        
        // Convert object to JSON string
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        // Convert Json string to Object
        User user2=mapper.readValue(json, User.class);
        System.out.println(user2);

        User user3=new User();
        user3.setAge(33);
        user3.setBirthday(new Date());
        user3.setEmail("123456");
        user3.setmName("jesse3");


        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user3);

        // Convert List<object> to JSON string
        String json3 = mapper.writeValueAsString(users);
        System.err.println(json3);

        //多行输出
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users));
        
        // Convert Json string to List<Object>
        List<User> users3=mapper.readValue(json3, new TypeReference<List<User>>() {
        });
        for (int i = 0; i < users3.size(); i++) {
            System.out.println(users3.get(i));
        }
        
        //反序列化时,遇到未知属性(那些没有对应的属性来映射的属性,并且没有任何setter或handler来处理这样的属性)时是否引起结果失败(通过抛JsonMappingException异常).  
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        
        String json4 = "{\"mName\":\"jesse4\",\"birthday\":\"2018-10-19\",\"mail\":\"123456\",\"sex\":\"1\"}";
        User user4=mapper.readValue(json4, User.class);
        System.out.println(user4);
        
        System.out.println(JsonUtils.encode(user4));
        
        String json5 = "{\"mName\":\"jesse5\",\"birthday\":\"2018-10-19\",\"mail\":\"123456\",\"sex\":\"1\"}";
        User user5= JsonUtils.decode(json5, User.class);
        System.out.println(user5);
        
        List<User> users6 = JsonUtils.decode(json3, new TypeReference<List<User>>(){});
        for (User user0:users6) {
            System.out.println(user0);
        }
    }
    
}
