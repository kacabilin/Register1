/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

/**
 *
 * @author ADI
 */
public interface SQLCommands {
    
    String DS_SOURCE = "java:comp/env/jdbc/postgres";
    String CONNECTION_NOT_FOUND = "Invalid Connection. "
            + "Unable to process request.";

    String ADD_User = "insert into gg_exe(user_id, first_name, last_name, username, password," +
            "values(?,?,?,?,?)";

    String Username = "select * from gg_exe where username=? ";
    
}
