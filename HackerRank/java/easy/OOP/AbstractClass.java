// https://www.hackerrank.com/challenges/java-abstract-class/problem
package hackerrank.java.easy.OOP;

import java.util.*;
abstract class Book{
	String title;
	abstract void setTitle(String s);
	String getTitle(){
		return title;
	}
	
}

class MyBook extends Book{
    @Override
    void setTitle(String s){
        this.title = s;
    }
}

public class AbstractClass{
	
	public static void main(String []args){
		//Book new_novel=new Book(); This line prints AbstractClass.java:25: error: Book is abstract; cannot be instantiated
		Scanner sc=new Scanner(System.in);
		String title=sc.nextLine();
		MyBook new_novel=new MyBook();
		new_novel.setTitle(title);
		System.out.println("The title is: "+new_novel.getTitle());
      	sc.close();
		
	}
}