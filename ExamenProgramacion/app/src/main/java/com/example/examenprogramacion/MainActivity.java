package com.example.examenprogramacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/*
1)
Realizar un programa que tenga un activity con 2 input text, 2 text view y un boton. El 1er input corresponde a un usuario y el 2do a una contraseña y al hacer el click en el boton, se debe validar el usuario o la contraseña contra un elemento guardado en el codigo. Previamente se debe verificar que usuario y contraseña cumplan con las siguientes condicones:
-El Usuario debe tener una mayuscula y no menos de 6 caracteres
-La contraseña debe cumplir lo mismo pero con 8 caracteres.
-En caso de coincidir debe de ir a un acitivity
-En caso de no coincidir debe mostrar un texto rojo en un textview, el textview rojo debe permanecer oculto mientras no se haga el login que diga que quedan 3 intentos, disminuyendo por cada intento fallido.
Cuando salte al activity de ingreso corecto, ese activity debe de tener 1 imagen, 2 input, 1 boton y 2 textview, al hacer click en el boton debe verificar si el contenido de los inputs es igual, si es asi debe mostrar una imagen y sino otra
*/
public class MainActivity extends AppCompatActivity {
    //Creating Elements
    private Button Login_check;
    private TextView Validate;
    private EditText user;
    private EditText pwd;

    //setting password
    private String saved_user = "Patoss1";
    private String saved_Password = "Cuacksss1";
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
            boolean Num = false;
            for (char con: valuetocheck.toCharArray()) {
                if (String.valueOf(con).equals(String.valueOf(con).toUpperCase()))
                {
                    pass = true;
                }
                try {
                    Integer.parseInt(String.valueOf(con));
                    Num = true;
                }
                catch (Exception Error){

                }
            }
            if (pass == true && Num == true){
                return true;
            }
            else {
                return false;
            }

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
