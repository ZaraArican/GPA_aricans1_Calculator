package edu.msu.gpa_sevdenur_calculator;

import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText firstEbx,editText2,editText3,editText4, editText5;
    TextView result;
    Boolean calculated =false;
View v;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        firstEbx =(EditText)findViewById(R.id.firstEbx);
        editText2= (EditText)findViewById(R.id.editText2);
        editText3= (EditText)findViewById(R.id.editText3);
        editText4= (EditText)findViewById(R.id.editText4);
        editText5= (EditText)findViewById(R.id.editText5);

        result=(TextView)findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                calculateSum();
            }
        });
    }
    private void calculateSum()
    {
        if(!calculated)
        {
            try
            {
                if(firstEbx.getText().length() != 0 && editText2.getText().length() != 0 && editText3.getText().length() != 0  && editText4.getText().length() != 0  && editText5.getText().length() != 0 ){
                    double num1 =Integer.parseInt(firstEbx.getText().toString());
                    double num2 =Integer.parseInt(editText2.getText().toString());
                    double num3 =Integer.parseInt(editText3.getText().toString());
                    double num4 =Integer.parseInt(editText4.getText().toString());
                    double num5 =Integer.parseInt(editText5.getText().toString());
                    double sum= (num1+num2+num3+num4+num5)/5;


                    v=this.getWindow().getDecorView();

                    if (sum <= 60) {
                       v.setBackgroundResource(R.color.red);
                    } else if (sum >= 61 && sum <= 79) {
                        v.setBackgroundResource(R.color.yellow);

                    } else if (sum >= 80) {
                        v.setBackgroundResource(R.color.green);

                    }
                    result.setText(" "+sum);

                    button.setText("Clear");
                    calculated =true;
                }else{

                    AlertDialog.Builder builder=new AlertDialog.Builder(this);
                    builder.setTitle("Alert");
                    builder.setMessage("You should fill out all text fields");
                    builder.setPositiveButton("ok",null);
                    builder.create();
                    builder.show();
                }
            }
            catch (Exception ex)
            {
                Toast.makeText(this, ex.getMessage(),Toast.LENGTH_LONG);
            }
        }
        else
        {
            firstEbx.setText("");
            editText2.setText("");
            editText3.setText("");
            editText4.setText("");
            editText5.setText("");
            //result.setBackgroundColor(Color.WHITE);
            v.setBackgroundResource(R.color.white);

            result.setText("");
            button.setText("Compute GPA");
            calculated=false;
        }
    }
}
