package com.example.examenprogramacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Creating Elements
    private Button Login_check;
    private TextView Validate;
    private EditText user;
    private EditText pwd;

    //setting password
    private String saved_user = "Patoss";
    private String saved_Password = "Cuacksss";
    public Integer intentos = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Associating Elements
        Login_check = (Button) findViewById(R.id.Login_Button);
        Validate = (TextView) findViewById(R.id.Check);
        user = (EditText) findViewById(R.id.user_Login);
        pwd = (EditText) findViewById(R.id.password_Login);


        //Setting on click
        Login_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text_User = user.getText().toString();
                String text_Password = pwd.getText().toString();
                boolean condition1user = ContainsUpper(text_User,6);
                boolean condition1pass = ContainsUpper(text_Password,8);
                if (condition1pass == true && condition1user == true){
                    if (text_User.equals(saved_user) && text_Password.equals(saved_Password)){
                        Intent changeweb = new Intent(getApplicationContext(),Logged.class);
                        startActivity(changeweb);
                    }
                    else {
                        intentos = intentos - 1;
                        if (intentos == 0) {
                            Validate.setText("Usuario o contraseña incorrectos. Se Deshabilita el Boton");
                            Login_check.setEnabled(false);
                        } else {
                            Validate.setText("Usuario o contraseña incorrectos. Quedan " + intentos + " Intentos");
                        }
                    }
                }
                else {
                    Validate.setText("El usuario o la contraseña no cumplen la condiciones necesarias");
                }

            }
        });

        };
    private Boolean ContainsUpper (String valuetocheck, Integer Amountminofcharacters){
        if (valuetocheck.length() < Amountminofcharacters){
            return false;
        }
        else {
            boolean pass = false;
            for (char con: valuetocheck.toCharArray()) {
                if (String.valueOf(con).equals(String.valueOf(con).toUpperCase()))
                {
                    pass = true;
                    break;
                }
            }
            return pass;
        }
    }

    //Old Pass

                    /*if (text_User.length() >= 6 && text_Password.length() >=8) {
                    char[] info = text_Password.toCharArray();
                    char[] preg = text_User.toCharArray();
                    boolean condition1pass = false;
                    boolean condition1user = false;
                    //if (text_User.matches("[A-Z]")) {
                      //  Log.d("HASM+", text_User);
                    //}
                    for (char con: info) {
                        //Log.d("LogAs",  String.valueOf(con));
                        if (String.valueOf(con).equals(String.valueOf(con).toUpperCase())){

                            condition1pass = true;
                            break;
                        }
                    }
                    for (char user: preg) {
                        if (String.valueOf(user).equals(String.valueOf(user).toUpperCase())){
                            condition1user = true;
                            break;
                        }
                    }
                    if(condition1user == true && condition1pass == true){
                        if (text_User.equals(saved_user) && text_Password.equals(saved_Password)){
                            Intent changeweb = new Intent(getApplicationContext(),Logged.class);
                            startActivity(changeweb);
                        }
                        else {
                            intentos = intentos - 1;
                            if (intentos ==0){
                                Login_check.setWidth(0);
                                Login_check.setEnabled(false);
                            }
                            else {
                                Validate.setText("Usuario o contraseña incorrectos. Quedan "+intentos+" Intentos");
                            }


                        }

                    }
                    else {
                        Validate.setText("El usuario o la contraseña no cumplen la condiciones necesarias");
                    }
                }
                else {
                    Validate.setText("El Usuario o la contraseña no llegan al tamaño deseado");
                }
*/
}
