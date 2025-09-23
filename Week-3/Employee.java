
public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id,String name,String department,double salary)
    {
        this.id=id;
        this.name=name;
        this.department=department;
        this.salary=salary;
    }

    int getId(){
        return id;
    }

    String getName(){
        return name;
    }

    String getdepartment(){
        return department;
    }

    double getSalary(){
        return salary;
    }

    
    @Override
    public String toString() {
        return "Employee={id : "+this.id+" Name : +"+this.name+" Department : "+department+" Salary : "+this.salary+"}";
    }
}
