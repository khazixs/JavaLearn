package com.Dandelion.Learn;

public class TestEquals {
    public static void main(String[] args) {
        Object obj;
        String str;

        User u1 = new User(1, "zdk", "123");
        User u2 = new User(2, "zdk1", "1234");
        System.out.println(u1 == u2);
        System.out.println(u1.equals(u2));

        String str1 = new String("sos");
        String str2 = new String("sos");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
}

class User {
    int id;
    String name;
    String pwd;

    public User(int id, String name, String pwd) {
        super();
        this.id = id;
        this.name = name;
        this.pwd = pwd;

    }
}