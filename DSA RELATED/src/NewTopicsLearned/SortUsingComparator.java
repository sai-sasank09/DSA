package NewTopicsLearned;
import java.io.*;
import java.util.*;

public class SortUsingComparator {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        List<Student> students= new ArrayList<Student>();
        
        for (int i=0;i<n;i++){
            int id=sc.nextInt();
            String name= sc.next();
            double CGPA=sc.nextDouble();
            
            students.add(new Student(id,name,CGPA));
        }
        students.sort(new StudentComparator());
        
        for (Student std: students){
            System.out.println(std.getName());
        }        
        
    }
}

 class Student{
    
    String name;
    int ID;
    double CGPA;
    public Student(int ID, String name, double CGPA){
        this.ID= ID;
        this.name=name;
        this.CGPA=CGPA;
    }
    
    public String getName(){
        return name;
    }
    public int getID(){
        return ID;
    }
    public double getCGPA(){
        return CGPA;
    }
} 

class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2){
        if(Double.compare(s2.getCGPA(),s1.getCGPA()) !=0){
            return Double.compare(s2.getCGPA(),s1.getCGPA());
        }
          else if (!s1.getName().equals(s2.getName())) {
            return s1.getName().compareTo(s2.getName());
        }
        else{
            return Integer.compare(s2.getID(),s1.getID());
        }
        
    }
}



