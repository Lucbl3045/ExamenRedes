package com.example.examenprogramacion;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Logged extends AppCompatActivity {
    private TextView Info1;
    private TextView Info2;
    private ImageView Imaged;
    private Button Check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
        Info1 = (TextView) findViewById(R.id.text1);
        Info2 = (TextView) findViewById(R.id.Text2);
        Imaged = (ImageView) findViewById(R.id.Images);
        //Drawable godim = (R.drawable.bad_image);
        Check = (Button) findViewById(R.id.check_Login);
        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NuevaContra = Info1.getText().toString();
                String VerifacionNuevaContra = Info2.getText().toString();

                    boolean condition1pass = ContainsUpper(NuevaContra,8);
                    boolean condition1user = ContainsUpper(VerifacionNuevaContra,8);

                    if (condition1user = true && condition1pass == true && NuevaContra.equals(VerifacionNuevaContra)){

                        Imaged.setImageResource(R.drawable.good_image);
                    }
                    else {
                        Imaged.setImageResource(R.drawable.bad_image);
                    }
            }

        });


    }
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


    //Old Conditional
                    /* char[] info = NuevaContra.toCharArray();
                   char[] preg = VerifacionNuevaContra.toCharArray();for (char con: info) {
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
                    }*/
}