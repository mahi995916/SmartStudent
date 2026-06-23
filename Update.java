package Main.java;
public class Update {

    public static void main(String[] args) {

        Student student = new Student(
                "Rahul",
                "101",
                "CSE",
                "rahul@gmail.com",
                "9876543210",
                88);

        StudentDAO dao = new StudentDAO();

        dao.addStudent(student);

    }

}