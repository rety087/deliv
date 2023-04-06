package com.example.deliv;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Information extends AppCompatActivity {


    Connection connect;
    String connectionResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infsmena);
        Button button = (Button) findViewById(R.id.button7);
        Button button1 = (Button) findViewById(R.id.button8);
        Button button2 = (Button) findViewById(R.id.button7);
        Button button3 = (Button) findViewById(R.id.button8);


        {
            TextView textView = (TextView) findViewById(R.id.textView7);

            try {
                ConnectionHelper connectionHelper = new ConnectionHelper();
                connect = connectionHelper.connclass();
                if (connect != null) {
                    String query = "select [login] from [users] where  [login]= 'userdeliv'";
                    Statement statement = connect.createStatement();
                    ResultSet rs = statement.executeQuery(query);
                    while (rs.next()) {
                        textView.setText(rs.getString(1));

                    }
                } else {
                    connectionResult = "ewee";
                }


            } catch (Exception ex) {
                Log.e("error", ex.getMessage());
            }
        }



        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sdf.format(Calendar.getInstance().getTime());
        String polz = "5C3102F7-EDAE-4F70-BD56-ABCDA5B5A06B";


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView7);

                try {
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    connect = connectionHelper.connclass();
                    if (connect != null) {
                        String query = " Insert into workshift([id],[dadd],[id_deliv],[status]) values ( newid(),"+date.toString();
                        "," + polz.toString()
                        String s1 = ",'Y')";
                        Statement statement = connect.createStatement();
                        ResultSet rs = statement.executeQuery(query);
                        while (rs.next()) {
                            textView.setText(rs.getString(1));

                        }
                    } else {
                        connectionResult = "ewee";
                    }


                } catch (Exception ex) {
                    Log.e("error", ex.getMessage());
                }
            }




        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                v.setEnabled(false);
                button.setEnabled(true);
            }
        });

    }




}







