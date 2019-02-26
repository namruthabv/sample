import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.*;
import java.lang.*;

public class HashCodeAndEquals{


    static Map<Employee,String> myMap () {
        Employee e1 = new Employee("A", "june 10th 91");
        Employee e2 = new Employee("B", "april 9th 92");
        Employee e3 = new Employee("C", "oct 23rd 12");
        Employee e4 = new Employee("D", "june 26th 91");
        Map<Employee,String> empMap = new HashMap<>();
        empMap.put(e1, "Arjun");
        empMap.put(e2, "Bhargav");
        empMap.put(e3, "Namu");
        empMap.put(e4, "Nishu");
        return empMap;
    }

    public static void main(String[] args){


        Map<Employee,String> cache =  myMap();
        System.out.println(cache);
        Employee lookup = new Employee("101", "10111992");
        String empName = cache.get(lookup);
        System.out.println("Name of 'B' born on april 9th 92 : " + empName);

        Set<Employee> empset = new HashSet<>();
        Employee e1 = new Employee("A", "june 10th 91");
        Employee e2 = new Employee("B", "april 9th 92");
        Employee e3 = new Employee("C", "oct 23rd 12");
        Employee e4 = new Employee("D", "june 26th 91");
        empset.add(e1);
        empset.add(e2);
        empset.add(e3);
        empset.add(e4);
        System.out.println(empset);

    }
}

class Employee{
    String empId;
    String empDob;

    public Employee(String empId, String empDob){
        this.empId = empId;
        this.empDob = empDob;
    }

    @Override
    public int hashCode(){
        int result = empId != null ? empId.hashCode() : 0;
        result = result * 31 + (empDob != null ? empDob.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o){
        if( this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Employee emp = (Employee) o;
        if(empId !=null ? !empId.equals(emp.empId) : emp.empId != null) return false;
        if(empDob !=null ? !empDob.equals(emp.empDob) : emp.empDob != null) return false;
        return true;
    }

    @Override
    public String toString(){
        return "Employee info : [ employeeID : " + empId + " and employeeDOB : " + empDob + " ] ";
    }

}