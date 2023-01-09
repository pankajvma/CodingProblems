// https://www.hackerrank.com/challenges/java-reflection-attributes/problem
package hackerrank.java.easy.Advanced;

import java.lang.reflect.*;
import java.util.*;

class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

public class ReflectionInJava {

    public static void main(String[] args){            
        try{
            Class student = Student.class;
            Method[] methods = student.getDeclaredMethods();

            ArrayList<String> methodList = new ArrayList<>();
            for(Method method: methods){
                // String[] str = method.toString().split("Student\\.");
                // str = str[str.length - 1].split("\\(");
                // methodList.add(str[0]);
                methodList.add(method.getName());
            }
            Collections.sort(methodList);
            for(String name: methodList){
                System.out.println(name);
            }
        } catch(Exception e){
            System.out.println(e);
        }

    }

}



