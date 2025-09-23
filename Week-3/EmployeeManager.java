import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeManager {
    private Map<Integer, Employee> employeeData;

    public EmployeeManager() {
        this.employeeData = new HashMap<>();
    }

    public void addNewEmployee(Employee employee) {
        employeeData.put(employee.getId(), employee);
    }

    public Employee getEmployeeById(int id) {
        return employeeData.get(id);
    }

    public ArrayList<Employee> getAllEmployees() {
        return new ArrayList<>(employeeData.values());
    }

    public List<Employee> getEmployeesBySalary(int minSalary) {
        return employeeData.values().stream().filter(emp -> emp.getSalary() >= minSalary).collect(Collectors.toList());
    }

    public List<Employee> sortEmployeesBySalary(){
        return employeeData.values().stream().sorted(Comparator.comparingDouble(emp->emp.getSalary())).collect(Collectors.toList());
    }
}
