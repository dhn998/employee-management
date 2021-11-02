public class Department {
    private String id;
    private String name;
    private int currentStaffs;

    // Xây dựng các trình khởi tạo
    public Department() {
        super();
    }
    public Department(String id, String name, int currentStaffs) {
        this.id = id;
        this.name = name;
        this.currentStaffs = currentStaffs;
    }

    // Xây dựng các getter
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getCurrentStaffs() {
        return currentStaffs;
    }

    // Xây dựng các setter
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCurrentStaffs(int currentStaffs) {
        this.currentStaffs = currentStaffs;
    }
    public void updateCurrentStaffs() {
        this.currentStaffs += 1;
    }

    // Ghi đè phương thức toString() để hiển thị thông tin về bộ phận
    public String toString() {
        return "[Department ID: " + id + " | Department name: " + name + " | Current number of staffs: " + currentStaffs + "]";
    }
}
