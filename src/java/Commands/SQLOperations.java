package Commands;

import com.Model.Profile;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ADI on 5/25/2017.
 */
public class SQLOperations implements SQLCommands {
    public static Connection getConnection(){
        Connection connection = null;

        try {
            DataSource dataSource =
                    (DataSource) InitialContext.doLookup(DS_SOURCE);
            connection = dataSource.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //insert
    public static boolean addUser (Profile profile, Connection connection){
        try {
            connection.setAutoCommit(false);
            PreparedStatement pstmt = connection.prepareStatement(ADDUser);

            pstmt.setString(1, profile.getId());
            pstmt.setString(2, profile.getFirstname());
            pstmt.setString(3, profile.getLastname());
            pstmt.setString(4, profile.getUsername());
            pstmt.setString(5, profile.getPassword());
            

            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException sqle) {
            System.out.println("SQLException - addUser:"
                    + sqle.getMessage());
            return false;
        }
        return true;
    }

    //checking if studentid is exist
    public static boolean cid(String id){
        boolean status = false;
        Connection conn = SQLOperations.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(SQLOperations.CheckID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            status = rs.next();
        }catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return status;
    }
    

    //checking if username is exist
    public static boolean un(String username){
        boolean status = false;
        Connection conn = SQLOperations.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(SQLOperations.Username);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            status = rs.next();
        }catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return status;
    }
    
}
