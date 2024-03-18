/*
    Comp3005 Assignment 3 Q1
    Rhys Martin 101220597

 */

import java.sql.*;

public class main {
    static String url = "jdbc:postgresql://localhost:5432/Assignment3";
    static String user = "postgres";
    static String password = "student";

    public static void main(String[] args) {
        getAllStudents();

        addStudent("Rhys", "Martin", "rhysmartin@cmail.carleton.ca", "2024-03-17");

        getAllStudents();

        updateStudentEmail(6, "notEpicEmail@wompwomp.ca");

        getAllStudents();

        deleteStudent(6);

        getAllStudents();

    }

    public static void getAllStudents(){
        try { // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");
// Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                //System.out.println("Connected to PostgreSQL successfully!");
// Create statement
                Statement stmt = conn.createStatement(); // Execute SQL query
                String SQL = "SELECT * FROM students";
                ResultSet rs = stmt.executeQuery(SQL); // Process the result

                System.out.println("\n\nPrinting Students!\n\n");

                while(rs.next()){
                    int ID = rs.getInt("student_id");
                    String fname = rs.getString("first_name");
                    String lname = rs.getString("last_name");
                    String email = rs.getString("email");
                    String date = String.valueOf(rs.getString("enrollment_date"));
                    System.out.printf("ID: %d, Name: %s %s, Email: %s, Date of Enrollment: %s\n", ID, fname, lname, email, date);


                }
// Close resources
                rs.close();
                stmt.close();
            } else {
                System.out.println("Failed to establish connection.");
            } // Close the connection (in a real scenario, do this in a finally
            conn.close();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //This function generates an INSERT SQL query using the four inputs
    public static void addStudent(String fname, String lname, String email, String date){
        try { // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                //System.out.println("Connected to PostgreSQL successfully!");

                Statement stmt = conn.createStatement(); // Execute SQL query
                String SQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES ('" + fname + "', '" + lname + "', '" + email + "', '" + date + "')";
                stmt.executeUpdate(SQL); // Process the result

                stmt.close();
            } else {
                System.out.println("Failed to establish connection.");
            } // Close the connection (in a real scenario, do this in a finally
            conn.close();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //This function will update the email of an entry using the UPDATE SQL query
    public static void updateStudentEmail(int id, String newEmail){
        try { // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                //System.out.println("Connected to PostgreSQL successfully!");

                Statement stmt = conn.createStatement(); // Execute SQL query
                String SQL = "UPDATE students SET email = '" + newEmail + "'WHERE student_id = " + id;
                stmt.executeUpdate(SQL); // Process the result

                stmt.close();
            } else {
                System.out.println("Failed to establish connection.");
            } // Close the connection (in a real scenario, do this in a finally
            conn.close();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //This function deletes a student entry based on their ID using the DELETE FROM SQL query
    public static void deleteStudent(int id){
        try { // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                //System.out.println("Connected to PostgreSQL successfully!");

                Statement stmt = conn.createStatement(); // Execute SQL query
                String SQL = "DELETE FROM students WHERE student_id = " + id;
                stmt.executeUpdate(SQL); // Process the result

                stmt.close();
            } else {
                System.out.println("Failed to establish connection.");
            } // Close the connection (in a real scenario, do this in a finally
            conn.close();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
