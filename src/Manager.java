public class Manager extends Staff implements ICalculator {
    // Khai báo field bổ sung cho các đối tượng thuộc lớp Manager
    private String title;

    // Kế thừa và nạp chồng các trình khởi tạo ở superclass
    public Manager() {
        super();
    }
    public Manager(String id, String name, int age, double coefficientSalary, String dateStart, Department department, int vacationDays, String title) {
        super(id, name, age, coefficientSalary, dateStart, department, vacationDays);
        this.title = title;
    }

    // Thêm getter cho lớp Manager
    public String getTitle() {
        return title;
    }

    // Thêm setter cho lớp Manager
    public void setTitle(String title) {
        this.title = title;
    }

    // Thực thi phương thức tính lương từ giao diện (interface) ICalculator
    public int calculateSalary() {
        int salary = 0;
        switch (this.title) {
            case "Business Leader": {
                salary = (int) (this.getCoefficientSalary() * 5000000 + 8000000);
                break;
            }
            case "Project Leader": {
                salary = (int) (this.getCoefficientSalary() * 5000000 + 5000000);
                break;
            }
            case "Technical Leader": {
                salary = (int) (this.getCoefficientSalary() * 5000000 + 6000000);
                break;
            }
        }
        return salary;
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
        System.out.println(" | Title: " + this.title + "]");
    }
}