/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.ihealthmaven.db;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;

/**
 *
 * @author ceiroa
 */
public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource)
                    //ic.lookup("jdbc/ihealth");  //With GlassFish
                    ic.lookup("java:/comp/env/jdbc/ihealth"); //With Tomcat
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static ConnectionPool getInstance() {

        if(pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        }catch(SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }

    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch(SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
