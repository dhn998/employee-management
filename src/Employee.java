public class Employee extends Staff implements ICalculator {
    // Khai báo field bổ sung cho các đối tượng thuộc lớp Employee
    private int overtimeHours;

    // Kế thừa và nạp chồng các trình khởi tạo ở superclass
    public Employee() {
        super();
    }
    public Employee(String id, String name, int age, double coefficientSalary, String dateStart, Department department, int vacationDays, int overtimeHours) {
        super(id, name, age, coefficientSalary, dateStart, department, vacationDays);
        this.overtimeHours = overtimeHours;
    }

    // Thêm getter cho lớp Employee
    public int getOvertimeHours() {
        return overtimeHours;
    }

    // Thêm setter cho lớp Employee
    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    // Thực thi phương thức tính lương từ giao diện (interface) ICalculator
    public int calculateSalary() {
        return (int) (this.getCoefficientSalary() * 3000000 + this.overtimeHours * 200000);
    }
    // Thực thi phương thức hiển thị thông tin kế thừa từ lớp Staff
    public void displayInformation() {
        System.out.print("[Staff ID: " + this.getId());
        System.out.print(" | Name: " + this.getName());
        System.out.print(" | Age: " + this.getAge());
        System.out.print(" | Coefficient salary: " + this.getCoefficientSalary());
        System.out.print(" | Date of starting: " + this.getDateStart());
        System.out.print(" | Department: " + this.getDepartment().getName());
        System.out.print(" | Vacation days: " + this.getVacationDays());
        System.out.println(" | Overtime hours: " + this.overtimeHours + "]");
    }
}