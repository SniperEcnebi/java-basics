import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year



        return staff.stream()
           .filter((e) -> {
               Calendar calendar = Calendar.getInstance();
               calendar.setTime(e.getWorkStart());
               return calendar.get(Calendar.YEAR) == year;
           })
           .max((e1, e2) ->
               e1.getSalary().compareTo(e2.getSalary()))
           .get();

    }
}