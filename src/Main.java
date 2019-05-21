import java.sql.*;
public class Main {
    private final static String url = "jdbc:postgresql://localhost:5432/2019-05-20-pm-cw";
    private final static String user = "student";
    private final  static String password = "C0d3Cr3w";

    public static java.sql.Connection connect() {
        java.sql.Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = java.sql.DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.\n");
            System.out.println("Exercise 1");
            selectEmployees(conn);
            System.out.println("\n Exercise 2");
            selectDevelopers(conn,"Developer");
            System.out.println("\n Exercise 3");
            over50000(conn,50000);
//            System.out.println("\n Exercise 4");
//            newEngineer(conn,"Thomas","Tank","Engineer",50000);
//            System.out.println("\nExercise 5");
//            updateEllen(conn,42000);
//            System.out.println("\nExercise 7");
//            deleteSam(conn);
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void selectEmployees(Connection conn)
    {
//        String SQL = "Insert into employees(first_name, last_name, position, salary) Values('Chuck','Jones','Manager',100000)";
//        String SQL = "Insert into employees(first_name, last_name, position, salary) Values('Marty', 'Krofft', 'Engineer', 80000)";
//        String SQL = "Insert into employees(first_name, last_name, position, salary) Values('Peter', 'Barker', 'Developer', 50000)";
//        String SQL = "Insert into employees(first_name, last_name, position, salary) Values('Ellen', 'Musk', 'Developer', 38000)";
//        String SQL = "Insert into employees(first_name, last_name, position, salary) Values('Sam', 'Sham', 'Developer', 35000)";


        String SQL = "Select * from employees";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //returns element at column index
                System.out.println(rs.getInt(1)+","+rs.getString(2) + ","
                        + rs.getString(3) + ","+rs.getString(4) + ","+rs.getInt(5));
            }
        }

        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public static void selectDevelopers(Connection conn,String job)
    {

        String SQL = "Select * from employees  where position=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,job);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //returns element at column index
                System.out.println(rs.getInt(1)+","+rs.getString(2) + ","
                        + rs.getString(3) + ","+rs.getString(4) + ","+rs.getInt(5));
            }
        }

        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public static void over50000(Connection conn,int money)
    {

        String SQL = "Select * from employees  where salary >?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,money);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //returns element at column index
                System.out.println(rs.getInt(1)+","+rs.getString(2) + ","
                        + rs.getString(3) + ","+rs.getString(4) + ","+rs.getInt(5));
            }
        }

        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public static void newEngineer(Connection conn,String fname, String lname, String job, int salary)
    {

        String SQL = "Insert into employees(first_name, last_name, position, salary) Values('Thomas','Tank','Engineer',75000)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //returns element at column index
                System.out.println(rs.getInt(1)+","+rs.getString(2) + ","
                        + rs.getString(3) + ","+rs.getString(4) + ","+rs.getInt(5));
            }
        }

        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public static void updateEllen(Connection conn,int money)
    {

        String SQL = "Update employees set salary =? where first_name='Ellen' and last_name='Musk' ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,money);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //returns element at column index
                System.out.println(rs.getInt(1)+","+rs.getString(2) + ","
                        + rs.getString(3) + ","+rs.getString(4) + ","+rs.getInt(5));
            }
        }

        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public static void deleteSam(Connection conn)
    {
        String SQL = "Delete from employees  where first_name='Sam' and last_name='Sham' ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //returns element at column index
                System.out.println(rs.getInt(1)+","+rs.getString(2) + ","
                        + rs.getString(3) + ","+rs.getString(4) + ","+rs.getInt(5));
            }
        }

        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }


    public static void main(String[] args) {
        connect();
    }
}
