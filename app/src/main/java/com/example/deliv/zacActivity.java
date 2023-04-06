package com.example.deliv;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.transform.Result;

public class zacActivity extends AppCompatActivity {
    Connection connect;
    String connectionResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zac_activity);


        {
            TextView textView = (TextView) findViewById(R.id.textView);
            TextView textView1 = (TextView) findViewById(R.id.textView1);
            TextView textView2 = (TextView) findViewById(R.id.textView2);
            TextView textView3 = (TextView) findViewById(R.id.textView3);
            try {
                ConnectionHelper connectionHelper = new ConnectionHelper();
                connect = connectionHelper.connclass();
                if (connect != null) {
                    String query = "select ord.[name], cst.[fio], cst.[address], ord.[dadd] \n" +
                            "from [order] ord \n" +
                            "join [customer] cst on cst.[id] = ord.[id_cust]\n" +
                            "where ord.[id_deliv] = '0bed999b-4e69-46b9-ab1a-24269e41f7e1' and ord.[status] in ('wait', 'on_way')";
                    Statement statement = connect.createStatement();
                    ResultSet rs = statement.executeQuery(query);
                    while (rs.next()) {
                        textView.setText(rs.getString(1));
                        textView1.setText(rs.getString(2));
                        textView2.setText(rs.getString(3));
                        textView3.setText(rs.getString(4));

                    }
                } else {
                    connectionResult = "ewee";
                }


            } catch (Exception ex) {
                Log.e("error", ex.getMessage());
            }
        }


    }
    public void onClickHis(View view) {
        Intent intent = new Intent(this, mainHistory.class);
        startActivity(intent);
    }
    public void onClickLast(View view) {
        Intent intent = new Intent(this, lastActivity.class);
        startActivity(intent);
    }

}




