/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.ihealthmaven.model;

import com.ceiroa.ihealthmaven.model.enums.Status;
import com.ceiroa.ihealthmaven.db.AeSimpleMD5;
import com.ceiroa.ihealthmaven.db.UserDB;

/**
 *
 * @author ceiroa
 */
public class AccessController {

    public static User findUser(String username, String password) throws Exception {
        //Find user in database
        User user = UserDB.selectUser(username);
        String encPassword = AeSimpleMD5.MD5(password);
    
        if(user != null && user.getUsername().equals(username)
                && user.getPassword().equals(encPassword)
                && user.getStatus().equals(Status.active)) {
            return user;
        } else {    //If user is not found return null
            return null;
        }
    }
}
