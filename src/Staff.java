public abstract class Staff {
    // Khai báo các field
    private String id;
    private String name;
    private int age;
    private double coefficientSalary;
    private String dateStart;
    private Department department;
    private int vacationDays;

    // Xây dựng các trình khởi tạo (constructor) để các lớp con (subclass) kế thừa
    public Staff() {
        super();
    }
    public Staff(String id, String name, int age, double coefficientSalary, String dateStart, Department department, int vacationDays) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.coefficientSalary = coefficientSalary;
        this.dateStart = dateStart;
        this.department = department;
        this.vacationDays = vacationDays;
    }

    // Xây dựng các getter
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getCoefficientSalary() {
        return coefficientSalary;
    }
    public String getDateStart() {
        return dateStart;
    }
    public Department getDepartment() {
        return department;
    }
    public int getVacationDays() {
        return vacationDays;
    }

    // Xây dựng các setter
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCoefficientSalary(double coefficient) {
        this.coefficientSalary = coefficient;
    }
    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    // Tạo abstract method để các subclass kế thừa giúp hiển thị thông tin về nhân viên
    abstract void displayInformation();
}
