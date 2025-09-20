public class student {
    public String name;
    public int grade;

    student(String name,int grade){
        this.name = name;
        this.grade = grade;
    }

    void print_info(){
        System.out.println(name+" : "+grade);
    }
}
