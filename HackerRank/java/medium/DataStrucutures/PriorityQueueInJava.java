// https://www.hackerrank.com/challenges/java-priority-queue/problem
package hackerrank.java.medium.DataStrucutures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;

class Student{
    private int id;
    private String name;
    private double cgpa;
    
    public Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;     
    }
    
    int getID(){
        return this.id;
    }
    
    String getName(){
        return this.name;
    }
    
    double getCGPA(){
        return this.cgpa;
    }
}

class Priorities{
    List<Student> getStudents(List<String> events){
        
        String[] splitLine;
        Comparator<Student> c = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2){
                if(s1.getCGPA() != s2.getCGPA()){
                    if(s1.getCGPA() > s2.getCGPA()) return -1;
                    return 1;
                }
                if(!s1.getName().equals(s2.getName())){
                    return s1.getName().compareTo(s2.getName());
                }
                return s1.getID() - s2.getID();
            }
        };
        PriorityQueue<Student> studentQueue = new PriorityQueue<>(c);
        List<Student> studenList = new ArrayList<>();
        for(String str : events){
            splitLine = str.split(" ");
            if(splitLine[0].equals("ENTER")){
                studentQueue.add(new Student(Integer.parseInt(splitLine[3]), splitLine[1], Double.parseDouble(splitLine[2])));
            }
            else{
                studentQueue.poll();
            }
        }
        Iterator itr = studentQueue.iterator();
        while(itr.hasNext()){
            studenList.add(studentQueue.poll());
        }
        return studenList;
    }
}

public class PriorityQueueInJava {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}