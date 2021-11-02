import java.util.*;
import java.text.NumberFormat;
public class HumanResources {
    static Scanner input = new Scanner(System.in);
    // Tạo định dạng số giúp hiển thị tiền lương cho dễ nhìn
    NumberFormat en = NumberFormat.getInstance(new Locale("en","EN"));
    // Do không có tài nguyên ban đầu nên cần tạo dữ liệu cho công ty
    // Danh sách bộ phận hiện có trong công ty
    Department administration = new Department("ADM", "Administration", 2);
    Department business = new Department("BUS", "Business", 2);
    Department technique = new Department("TEC", "Technique", 2);
    Department project = new Department("PRO", "Project", 2);
    Department accounting = new Department("ACC", "Accounting", 1);
    Department marketing = new Department("MAR", "Marketing", 2);
    // Tạo mảng để lưu các bộ phận (vì số lượng bộ phận trong công ty nói chung là cố định, ít thay đổi)
    Department[] departments = {administration, business, technique, project, accounting, marketing};

    // Danh sách các nhân viên hiện có trong công ty
    Employee staff1 = new Employee("FX-ADM-0001", "Nguyễn Văn A", 50, 3.98, "01/01/2000", administration, 12, 4);
    Employee staff2 = new Employee("FX-ADM-0002", "Huỳnh Thị B", 41, 2.99, "03/02/2004", administration, 7, 2);
    Manager staff3 = new Manager("FX-BUS-0003", "Trần Văn H", 45, 3.45, "06/05/2008", business, 10, "Business Leader");
    Employee staff4 = new Employee("FX-BUS-0004", "Châu Văn E", 36, 2.67, "19/11/2010", business, 7, 4);
    Manager staff5 = new Manager("FX-TEC-0005", "Võ Văn C", 49, 3.14, "25/03/2002", technique, 10, "Technical Leader");
    Employee staff6 = new Employee("FX-TEC-0006", "Châu Văn E", 29, 2.44, "28/02/2014", technique, 5, 3);
    Manager staff7 = new Manager("FX-PRO-0007", "Trịnh Thành D", 39, 3.11, "06/12/2002", project, 9, "Project Leader");
    Employee staff8 = new Employee("FX-PRO-0008", "Phan Chí T", 32, 2.86, "08/11/2014", project, 5, 3);
    Employee staff9 = new Employee("FX-ACC-0009", "Phạm Hồng N", 40, 3.86, "23/10/2004", accounting, 11, 2);
    Employee staff10 = new Employee("FX-MAR-0010", "Trần Thủy T", 29, 2.13, "31/08/2016", marketing, 5, 3);
    Employee staff11 = new Employee("FX-MAR-0011", "Cao Văn S", 26, 2.0, "23/10/2018", marketing, 5, 2);
    // Tạo danh sách quản lí tất cả nhân viên
    ArrayList<Staff> list = new ArrayList<>(Arrays.asList(staff1, staff2, staff3, staff4, staff5, staff6, staff7, staff8, staff9, staff10, staff11));

    public static void main(String[] args) {
        HumanResources control = new HumanResources(); // Khai báo một đối tượng control thuộc class HumanResources để thực thi các phương thức
        System.out.println("This program is used to manage the staffs' information of the company.");
        int repeat;
        // Bắt đầu chương trình và tạo vòng lặp cho người dùng chọn tiếp tục hay không
        do {
            System.out.println();
            // Dùng try-catch để bắt ngoại lệ InputMismatchException khi người dùng nhập sai kiểu dữ liệu
            try {
                // Chạy trình chọn chức năng, tiến hành thực hiện chức năng khi được chọn
                switch (control.functionSelector()) {
                    case 1: control.function1(); break;
                    case 2: control.function2(); break;
                    case 3: control.function3(); break;
                    case 4: control.function4(); break;
                    case 5: control.function5(); break;
                    case 6: control.function6(); break;
                    case 7: control.function7(); break;
                }
                System.out.println();
                System.out.print("Do you want to continue? [Yes(1) || No(0)] ");
                repeat = input.nextInt(); input.nextLine();
            } catch (InputMismatchException err) {
                repeat = 0;
                System.out.println("Invalid input data!!! The program now finishes and exits.");
            }
        } while (repeat == 1);
    }
    // Tạo trình chọn các chức năng
    int functionSelector() {
        System.out.println("Please choose one of following functions to continue:");
        System.out.println("[1] Show the list of current employees in the company");
        System.out.println("[2] Show all department in the company");
        System.out.println("[3] Show the staffs by department");
        System.out.println("[4] Add the information of a new staff to the list");
        System.out.println("[5] Search the information of a staff by name or id");
        System.out.println("[6] Show the payroll of all staffs in descending");
        System.out.println("[7] Show the payroll of all staffs in ascending");
        System.out.println("[Other numbers] Exit the selector");
        System.out.print("Your choice: ");
        int choice = input.nextInt(); input.nextLine();
        return choice;
    }
    // Chức năng hiển thị danh sách nhân viên
    void function1() {
        for (Staff staff : list) {
            staff.displayInformation();
        }
    }
    // Chức năng hiển thị các bộ phận
    void function2() {
        for (Department department : departments) {
            System.out.println(department);
        }
    }
    // Chức năng hiển thị nhân viên theo bộ phận
    void function3() {
        for (Department department : departments) {
            System.out.println(department.getName() + " Department: (" + department.getCurrentStaffs() + " staffs)");
            for (Staff staff : list) {
                if (staff.getDepartment().equals(department)) {
                    System.out.print("\t");
                    staff.displayInformation();
                }
            }
        }
    }
    // Chức năng thêm thông tin nhân viên mới
    void function4() {
        System.out.print("Is the new staff an Employee(1) or a Manager(2)? ");
        int choiceStaff = input.nextInt(); input.nextLine();
        while (choiceStaff != 1 && choiceStaff != 2) {
            System.out.print("Only choose 1 or 2 please! ");
            choiceStaff = input.nextInt(); input.nextLine();
        }
        // Thu thập Staff ID
        System.out.print("\tStaff ID: ");
        String id = (input.next()).toUpperCase(); input.nextLine();
        int count;
        // Tạo vòng lặp kiểm tra ID
        do {
            count = 0;
            for (Staff staff : list) {
                if (staff.getId().substring(staff.getId().length()-4).equals(id.substring(id.length()-4))) {
                    count++;
                    System.out.println("The order number existed, please try again and use another order for ID.");
                    System.out.print("\tStaff ID: ");
                    id = input.next(); input.nextLine();
                    break;
                }
            }
        } while (count != 0);

        // Thu thập tên nhân viên
        System.out.print("\tName: ");
        String name = input.nextLine();
        // Thu thập tuổi nhân viên
        System.out.print("\tAge: ");
        int age = input.nextInt(); input.nextLine();
        // Thu thập hệ số lương
        System.out.print("\tCoefficient salary: ");
        double coefficientSalary = input.nextDouble(); input.nextLine();
        // Thu thập ngày vào làm
        System.out.print("\tDate of starting work (dd/MM/yyyy): ");
        String dateStart = input.nextLine();
        while (!isValidDate(dateStart)) {
            System.out.println("Invalid format of date, please try again.");
            System.out.print("\tDate of starting (dd/MM/yyyy): ");
            dateStart = input.nextLine();
        }

        // Thu thập thông tin bô phận làm việc
        System.out.print("\tDepartment [Administration(1) || Business(2) || Technique(3) || Project(4) || Accounting(5) || Marketing(6)]: ");
        int choiceDepartment = input.nextInt(); input.nextLine();
        while (choiceDepartment < 1 || choiceDepartment > 6) {
            System.out.print("Do not understand. Only choose 1, 2, 3, 4, 5 or 6 please! ");
            choiceDepartment = input.nextInt(); input.nextLine();
        }
        Department department = new Department();
        switch (choiceDepartment) {
            case 1: department = administration; break;
            case 2: department = business; break;
            case 3: department = technique; break;
            case 4: department = project; break;
            case 5: department = accounting; break;
            case 6: department = marketing; break;
        }

        // Thu thập số ngày nghỉ phép
        System.out.print("\tVacation days: ");
        int vacationDays = input.nextInt(); input.nextLine();

        if (choiceStaff == 1) {
            // Thu thập số giờ tăng ca
            System.out.print("\tOvertime hours: ");
            int overtimeHours = input.nextInt(); input.nextLine();
            // Tiến hành thêm nhân viên mới vào danh sách
            Employee newStaff = new Employee(id, name, age, coefficientSalary, dateStart, department, vacationDays, overtimeHours);
            list.add(newStaff);
        }
        if (choiceStaff == 2) {
            // Thu thập chức danh
            System.out.print("\tTitle: ");
            String title = input.nextLine();
            // Tiến hành thêm nhân viên mới vào danh sách
            Manager newStaff = new Manager(id, name, age, coefficientSalary, dateStart, department, vacationDays, title);
            list.add(newStaff);
        }
        department.updateCurrentStaffs(); // Cập nhật về số nhân viên hiện tại trong bộ phận
        System.out.println("Complete!!!");
    }
    // Chức năng tìm kiếm nhân viên theo tên hoặc ID
    void function5() {
        System.out.print("Please type your ID or your name here: ");
        String search = input.nextLine();
        int count = 0;
        for (Staff staff : list) {
            if (search.equalsIgnoreCase(staff.getId()) || search.equalsIgnoreCase(staff.getName())) {
                staff.displayInformation();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("The given information does not exist.");
        }
    }
    // Chức năng hiển thị bảng lương nhân viên theo thứ tự giảm dần
    void function6() {
        // Sắp xếp lương theo thứ tự giảm dần
        for (int i=0; i<list.size()-1; i++) {
            for (int j=i+1; j<list.size(); j++) {
                int iSalary = ((ICalculator) list.get(i)).calculateSalary();
                int jSalary = ((ICalculator) list.get(j)).calculateSalary();
                if (iSalary < jSalary) {
                    Staff temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
            System.out.print("[Staff ID: " + list.get(i).getId());
            System.out.print(" | Name: " + list.get(i).getName());
            if (list.get(i) instanceof Employee) {
                System.out.print(" | Overtime hours: " + ((Employee) list.get(i)).getOvertimeHours());
            }
            if (list.get(i) instanceof Manager) {
                System.out.print(" | Tile: " + ((Manager) list.get(i)).getTitle());
            }
            System.out.println(" | Salary: " + en.format(((ICalculator) list.get(i)).calculateSalary()) + " VND]");
        }
    }
    // Chức năng hiển thị bảng lương nhân viên theo thứ tự tăng dần
    void function7() {
        // Sắp xếp lương theo thứ tự tăng dần
        for (int i=0; i<list.size()-1; i++) {
            for (int j=i+1; j<list.size(); j++) {
                int iSalary = ((ICalculator) list.get(i)).calculateSalary();
                int jSalary = ((ICalculator) list.get(j)).calculateSalary();
                if (iSalary > jSalary) {
                    Staff temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
            System.out.print("[Staff ID: " + list.get(i).getId());
            System.out.print(" | Name: " + list.get(i).getName());
            if (list.get(i) instanceof Employee) {
                System.out.print(" | Overtime hours: " + ((Employee) list.get(i)).getOvertimeHours());
            }
            if (list.get(i) instanceof Manager) {
                System.out.print(" | Tile: " + ((Manager) list.get(i)).getTitle());
            }
            System.out.println(" | Salary: " + en.format(((ICalculator) list.get(i)).calculateSalary()) + " VND]");
        }
    }
    // Tạo hàm xác định ngày tháng năm hợp lệ dùng trong chức năng 4 lúc nhập dữ liệu
    boolean isValidDate(String s) {
        if (s.length() != 10 || s.indexOf('/') != 2 || s.lastIndexOf('/') != 5) return false;
        try {
            int d = Integer.parseInt(s.substring(0,2));
            int m = Integer.parseInt(s.substring(3,5));
            int y = Integer.parseInt(s.substring(6));
            if (m < 1 || m > 12 || d < 1 || d > 31 || y < 1980 || y > 2021) return false;
            if ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30) return false;
            if (m == 2 && d > 29) return false;
            if (m == 2 && d == 29 && y%100 == 0 && y%400 != 0) return false;
            if (m == 2 && d == 29 && y%4 != 0) return false;
        } catch (NumberFormatException err) {
            return false;
        }
        return true;
    }
}