package com.example.programmers.fyp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Adminpanel extends AppCompatActivity {
String name,strdate,getDateFromedittext;
EditText dateSchedule;
Button load_appointments;
ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> list = new ArrayList<>();
String schedule_url = "http://10.0.2.2/scripts/checkappointments.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpanel);
        Intent intent = this.getIntent();
        name = intent.getExtras().getString("name");
        listView = findViewById(R.id.listviewtimingschedule);
        dateSchedule = findViewById(R.id.dateedittext);
        dateSchedule.setFocusable(false);
        dateSchedule.setClickable(true);
        load_appointments = findViewById(R.id.search_schedule);
        load_appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
list.clear();
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, schedule_url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {

                                JSONArray array = new JSONArray(response);
                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject jsonObject = array.getJSONObject(i);
                                    String checkdates = jsonObject.getString("dtime");
                                    String patient_name = jsonObject.getString("patient_name");
                                    list.add(i + 1 + ". " + patient_name + "           Appointment Time : " + checkdates);
                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            adapter = new ArrayAdapter<String>(Adminpanel.this, android.R.layout.simple_list_item_1, list);

                            listView.setAdapter(adapter);

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("docname", name);
                            params.put("date", getDateFromedittext);
                            return params;
                        }
                    };
                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
                }

        });
        listView = findViewById(R.id.listviewtimingschedule);
        dateSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();


                final DatePickerDialog datePickerDialog = new DatePickerDialog(Adminpanel.this, new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd yyyy");
                        newDate.set(year, monthOfYear, dayOfMonth);
                        strdate = dateFormatter.format(newDate.getTime());


                        dateSchedule.setText(strdate);
                        getDateFromedittext = dateSchedule.getText().toString();

                    }

                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis()-1000);
                datePickerDialog.show();



            }
        });


    }

        @Override
        public void onBackPressed()
        {
            super.onBackPressed(); // this can go before or after your stuff below
            // do your stuff when the back button is pressed
            Intent intent = new Intent(getApplicationContext(), UserandPass.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
