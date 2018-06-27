package com.example.programmers.fyp;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserInfo extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    String day,date,time,id,doc_name,country="Pakistan",PatientName;
    String number;
    EditText dob,Pname,Number;
    String dateformat,getDateFromED,genderselect;
    String Book_Appointment = "http://10.0.2.2/scripts/sendInfo.php";
    RadioGroup group;
    RadioButton male,female;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        Intent intent = this.getIntent();
        date = intent.getExtras().getString("date");
        day = intent.getExtras().getString("day");
        time = intent.getExtras().getString("time");
        doc_name = intent.getExtras().getString("name");
        id = intent.getExtras().getString("id");
        Number = findViewById(R.id.Number);
        Pname = findViewById(R.id.EditTextName);
        button = findViewById(R.id.Submit);
        button.setOnClickListener(this);
        dob = findViewById(R.id.Date);
        male = findViewById(R.id.radioMale);
        female = findViewById(R.id.radioFemale);
        group = findViewById(R.id.radioGroup2);
        group.setOnCheckedChangeListener(this);
        dob.setFocusable(false);
        dob.setClickable(true);
        dob.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.Date)
        {
            datepick();
        }
        if(view.getId() == R.id.Submit)
        {
            sendRequest();
        }
    }

    private void sendRequest() {
        number = Number.getText().toString();
        PatientName = Pname.getText().toString();
        if (PatientName.equals("") || number.equals("")  || genderselect.isEmpty() || getDateFromED.equals(null))
        {
            Toast.makeText(this,"Please first fill all fields",Toast.LENGTH_SHORT).show();
        }
        else if(number.length()<10)
        {
            Toast.makeText(this,"Incorrect number length",Toast.LENGTH_SHORT).show();
        }
            else {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Book_Appointment, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("result", response);
                    if(response.equals("success"))
                    {
AlertDialog.Builder builder = new AlertDialog.Builder(UserInfo.this);
builder.setMessage("You Have Successfully Booked Your Appointment")
        .setCancelable(false)
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
           Intent intent = new Intent(UserInfo.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
           startActivity(intent);
           finish();
            }
        });
AlertDialog alertDialog = builder.create();
alertDialog.setTitle("Congratulations...");
alertDialog.show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("id", id);
                    params.put("date", date);
                    params.put("time", time);
                    params.put("name", PatientName);
                    params.put("mobile","92"+number);
                    params.put("dob", getDateFromED);
                    params.put("country", country);
                    params.put("gender", genderselect);
                    params.put("day", day);
                    params.put("docName", doc_name);
                    return params;
                }
            };
            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        }
    }
    private void datepick() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(UserInfo.this, AlertDialog.THEME_HOLO_DARK,new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                newDate.set(year, monthOfYear, dayOfMonth);
                dateformat = dateFormatter.format(newDate.getTime());
                dob.setText(dateformat);
                getDateFromED = dob.getText().toString();

            }

        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(male.isChecked())
        {
            genderselect = "male";
            Log.e("g",genderselect);
        }
        else
        {
            genderselect = "Female";
            Log.e("g",genderselect);
        }

    }
}
