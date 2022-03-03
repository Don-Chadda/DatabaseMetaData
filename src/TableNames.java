import java.sql.*;

public class TableNames
{
    public static void main(String[] args)
    {
        try {
            /*Initialize and load type 4 driver*/
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            /*Establish a connection with the database*/
            try (Connection con = DriverManager.getConnection("jdbc:sqlserver://sqlserver01;databaseName=Library;sa;password=DonChadda");)
            {
                /*Create a DatabaseMetaData object*/
                DatabaseMetaData dbmd = con.getMetaData();
                String[] tabTypes ={"TABLE"};
                /*Retrieve the names of database tables*/
                System.out.println("");
                System.out.println("Tables Names");
                System.out.println("-------------------");
                ResultSet tablesRS = dbmd.getTables(null, null, null, tabTypes);
                while (tablesRS.next()) /*Display the names of database tables*/
                {
                    System.out.println(tablesRS.getString("TABLE_NAME"));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
    }
} 
