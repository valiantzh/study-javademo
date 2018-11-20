package com.study.basis.designpattern.builder;

/*
 * 构造器模式实例
 * https://www.cnblogs.com/iCanhua/p/8636085.html
 * 
 * 1、希望类属性不可变
 * 
 * User的构造器是私有的，这就意味着客户端不能直接创建实例。
 * 这个类是不可变的。所有属性都是final类型并且他们由构造器设置值。此外，我们只提供getter操作。
 * 建造者使用流式接口习语来让客户端代码更易读
 * 建造者的构造器只接受两个必须的参数，并且这两个属性是仅有的被设置为final类型的，这样就能保证这些属性在构造器中是被赋值的。
 */
public class User {
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional
   
    private User(UserBuilder builder) {
      this.firstName = builder.firstName;
      this.lastName = builder.lastName;
      this.age = builder.age;
      this.phone = builder.phone;
      this.address = builder.address;
    }
   
    public String getFirstName() {
      return firstName;
    }
   
    public String getLastName() {
      return lastName;
    }
   
    public int getAge() {
      return age;
    }
   
    public String getPhone() {
      return phone;
    }
   
    public String getAddress() {
      return address;
    }
    
    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;
     
        public UserBuilder(String firstName, String lastName) {
          this.firstName = firstName;
          this.lastName = lastName;
        }
     
        public UserBuilder age(int age) {
          this.age = age;
          return this;
        }
     
        public UserBuilder phone(String phone) {
          this.phone = phone;
          return this;
        }
     
        public UserBuilder address(String address) {
          this.address = address;
          return this;
        }
     
        public User build() {
            User user = new User(this);
            if (user.getAge() > 120) {
                throw new IllegalStateException("Age out of range"); // thread-safe
            }
            return user;
        }
     
      }
}
