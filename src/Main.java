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
            System.out.println("Connected to the PostgreSQL server successfully.");
            insertEmployees(conn);

        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void insertEmployees(Connection conn)
    {
//        String SQL = "Insert into employees(first_name, last_name, position, salary) Values('Chuck','Jones','Manager',100000)";
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


    public static void main(String[] args) {
        connect();
    }
}
