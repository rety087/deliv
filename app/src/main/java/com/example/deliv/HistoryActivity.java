package com.example.deliv;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryActivity extends AppCompatActivity {

    Connection connect;
    String connectionResult;
    Boolean isSuucess= false;

    public List<Map<String,String>> getlist()
    {
        List<Map<String,String>> data = null;
        data = new ArrayList<Map<String,String>>();
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connclass();
            if (connect != null){
                 String qu = " select [dadd],[name] from[dbo].[order] where [id_deliv] = '0bed999b-4e69-46b9-ab1a-24269e41f7e1'";
                Statement statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery(qu);
                while (resultSet.next()){
                    Map<String,String> dtname = new HashMap<String,String>();
                    dtname.put("dadd",resultSet.getString("dadd"));
                    dtname.put("name",resultSet.getString("name"));
                    data.add(dtname);

                }
                connectionResult = "Sucsess";
                isSuucess= true;
                connect.close();
            }
            else {
                connectionResult = "sdasd";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return  data;
    }


}

