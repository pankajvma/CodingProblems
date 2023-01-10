// https://www.hackerrank.com/challenges/java-singleton/problem
package hackerrank.java.easy.Advanced;

public class Singleton{
    public String str;
    private static Singleton singleInstance;
    
    private Singleton(){}
    
    public static Singleton getSingleInstance(){
        if(singleInstance == null){
            singleInstance = new Singleton();
        }
        return singleInstance;
    }
}