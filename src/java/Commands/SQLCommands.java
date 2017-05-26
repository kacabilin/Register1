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

    String ADDUser = "INSERT INTO finale (id, firstname, lastname, username, password) values(?,?,?,?,?)";

    String Username = "select * from finale where username=? ";
    
    String CheckID = "select from finale where id =?";
}
