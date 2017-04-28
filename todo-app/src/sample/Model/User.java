package sample.Model;

/**
 * Created by watarumaeda on 2017/04/28.
 */
import java.util.*;

public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static void main(String ... args) {

        Map<String, String> myMap = new HashMap<>();

        myMap.put("misterA","qwer1234");
        myMap.put("misterB","asdf1234");
        myMap.put("misterC","zxcv1234");
        System.out.println("map:"+myMap.toString());
        myMap.remove("misterB","asdf1234");

        System.out.println("map:"+myMap.toString());
//        map:{misterB=asdf1234, misterC=zxcv1234, misterA=qwer1234}
//        map:{misterC=zxcv1234, misterA=qwer1234}

    }
}
