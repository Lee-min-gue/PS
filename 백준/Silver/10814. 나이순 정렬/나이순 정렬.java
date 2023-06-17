import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfStudent = sc.nextInt();
        ArrayList students = new ArrayList<Student>();
        for (int i = 0; i < numOfStudent; i++) {
            int tempAge = sc.nextInt();
            String tempName = sc.next();
            students.add(new Student(tempAge, tempName,i));
        }
        Collections.sort(students);
        Iterator Iterator= students.iterator();
        while(Iterator.hasNext()){
            System.out.println(Iterator.next());
        }
    }
}
class Student implements Comparable<Student> {
    int age;
    int num;
    String name;

    Student(int age, String name,int num) {
        this.age = age;
        this.name = name;
        this.num=num;
    }
    @Override
    public int compareTo(Student o) {
        if (this.age != o.age) {
            return this.age-o.age;
        }
        else {
            return this.num-o.num;

        }
    }
    @Override
    public String toString() {
        return age + " " + name;
    }
}