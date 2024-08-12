import java.util.ArrayList;

abstract class Employee{     //abstract class
    private String name;     // access modifiers i.e private
    private int id;

    public Employee(String name, int id){      //constructor
        this.name = name;
        this.id = id;
    }
    public String getName(){             // encapsulation getter and setter methods
        return name;
    }           // encapsulation getter and setter methods
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();    //abstract method so we don't do implementation here..only declare and leave
                                                //we'll do implementation in that cls from we we want to extend or inherit.

    @Override                   //Polymorphism
    public String toString(){
        return "Employee [name=" +name+ ", id=" +id+ ", salary=" +calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{       //inherits Employee class
    private double monthlySalary;
    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);        //when u r in a class and want to use its super or parent class constructor to run then super keyword is used, as name and id is already declared in employee class
        this.monthlySalary = monthlySalary;  // monthly salary is data member of this class only so we will assign value here only
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;

    }
    @Override  //providing implementation to abstract method made in abstract class (it is neccessary to avoid error)
    public double calculateSalary(){
      return hoursWorked * hourlyRate;
    }
}

//ArrayList<Integer> arr = new ArrayList<>();
class PayrollSystem{
    private ArrayList<Employee> employeeList;  // <Employee> iska mtlb hr ek employee as a object store hoga

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){  //ArrayList is of Employee type
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}

public class Main{
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1,70000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Alea",2,40,100);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();
        System.out.println("Removing Employees");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details: ");
        payrollSystem.displayEmployees();
    }
}






