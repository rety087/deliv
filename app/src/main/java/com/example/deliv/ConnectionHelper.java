package com.example.deliv;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    ConnectionHelper con;
    String ip,port,db,un,pass;
   // Insert into workshift([id],[dadd],[id_deliv],[status]) values ( newid(),date,polz,'Y')
        String date,polz;
    @SuppressLint("NewApi")
    public Connection connclass()
    {
        ip = "192.168.0.104";
        port = "1433";
        db = "metod";
        un = "ivan";
        pass = "123456";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String connectionURL = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURL= "jdbc:jtds:sqlserver://"+ ip + ":"+ port+";"+ "databasename="+ db+";user="+un+";password="+pass+";";

            connection = DriverManager.getConnection(connectionURL);
        }
        catch (Exception exception)
        {
            Log.e("Ошибка",exception.getMessage());
        }
        return connection;
    }








}


