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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeSelect extends AppCompatActivity implements View.OnClickListener {
EditText ed ;
String alreadybooked = "http://10.0.2.2/scripts/alreadybooked.php";
ArrayList<String> TimeFromDB = new ArrayList<>();
ArrayList<String> MorningTimeForUsers = new ArrayList<>();
ArrayList<String> EveningTimeForUsers  = new ArrayList<>();
String dateformat,id,name,JSONselectedtimeslot,avg_time;
ListView MorningListview,EveningListview;
String getDateFromED,dayOfWeek,URL,checkEdittext,Morning_start,Morning_end,Evening_start,Evening_end,SelectedTime;
Button search;

TextView Morning,Evening,NoMorning,NoEvening;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_select);
        MorningListview = findViewById(R.id.MorningListview);
        EveningListview = findViewById(R.id.EveningListview);
        Evening =findViewById(R.id.E);
        Morning = findViewById(R.id.M);
        NoEvening = findViewById(R.id.NoEvening);
        NoMorning = findViewById(R.id.NoMorning);
        Intent intent = this.getIntent();
        name = intent.getExtras().getString("name");
        id = intent.getExtras().getString("id");
        ed = findViewById(R.id.editText3);
        ed.setOnClickListener(this);
        ed.setFocusable(false);
        ed.setClickable(true);
        search = findViewById(R.id.search);
        search.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.editText3)
        {
            datepicker();
        }
        if(view.getId() == R.id.search)
        {
            requestfortiming();
        }
    }

    private void requestfortiming() {
        checkEdittext = ed.getText().toString();
       if(checkEdittext.matches(""))
       {

           Toast.makeText(this,"Select Date First",Toast.LENGTH_SHORT).show();
       }
       else
       {
           MorningListview.setAdapter(null);
           EveningListview.setAdapter(null);
           MorningListview.setVisibility(View.INVISIBLE);
           EveningListview.setVisibility(View.INVISIBLE);
           Morning.setVisibility(View.INVISIBLE);
           Evening.setVisibility(View.INVISIBLE);
           NoMorning.setVisibility(View.INVISIBLE);
           NoEvening.setVisibility(View.INVISIBLE);
           StringRequest stringRequest = new StringRequest(Request.Method.POST, alreadybooked, new Response.Listener<String>() {
               @Override
               public void onResponse(String response) {
                   Log.e("dateselected",response);

                       try {
                           JSONArray array = new JSONArray(response);
                           for (int i = 0; i < response.length(); i++) {
                               JSONObject object = array.getJSONObject(i);
                               JSONselectedtimeslot = object.getString("dtime");
                               TimeFromDB.add(JSONselectedtimeslot);
                           }

                       } catch (JSONException e) {
                           e.printStackTrace();
                       }
                       int average_Time = Integer.parseInt(avg_time);
      //Morning
                       if(Morning_start.matches("xxxxx") && Morning_end.matches("xxxxx"))
                       {
                           NoMorning.setVisibility(View.VISIBLE);
NoMorning.setText("No Appointments For Morning");
                       }
                       else {
MorningTimeForUsers.clear();
                           Morning.setVisibility(View.VISIBLE);
                           MorningListview.setVisibility(View.VISIBLE);
                           DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
                           LocalTime start = LocalTime.parse(Morning_start, formatter);
                           LocalTime end = LocalTime.parse(Morning_end, formatter);
                           for (; !start.isAfter(end); start = start.plusMinutes(average_Time)) {

                               String str = start.toString();
                               String convert = str.substring(0, 5);
                               if (!TimeFromDB.contains(convert)) {
                                   MorningTimeForUsers.add(convert);
                               }


                           }
                           ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, MorningTimeForUsers);
                           MorningListview.setAdapter(adapter);
                          MorningListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                              @Override
                              public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                  SelectedTime = (String) MorningListview.getItemAtPosition(i);
                                  Intent intent = new Intent(getApplicationContext(),UserInfo.class);
                                  intent.putExtra("date",getDateFromED);
                                  intent.putExtra("day",dayOfWeek);
                                  intent.putExtra("time",SelectedTime);
                                  intent.putExtra("name",name);
                                  intent.putExtra("id",id);
                                  startActivity(intent);
                              }
                          });
                       }
//Evening
                       if(Evening_start.matches("xxxxx") && Evening_end.matches("xxxxx"))
                       {
                           NoEvening.setVisibility(View.VISIBLE);
                           NoEvening.setText("No Appointments For Evening");

                       }
                       else {
                           EveningTimeForUsers.clear();
                           EveningListview.setVisibility(View.VISIBLE);
                           Evening.setVisibility(View.VISIBLE);
                           DateTimeFormatter formatter1 = DateTimeFormat.forPattern("HH:mm");
                           LocalTime start1 = LocalTime.parse(Evening_start, formatter1);
                           LocalTime end1 = LocalTime.parse(Evening_end, formatter1);
                           for (; !start1.isAfter(end1); start1 = start1.plusMinutes(average_Time)) {

                               String str1 = start1.toString();
                               String convert1 = str1.substring(0, 5);
                               if (!TimeFromDB.contains(convert1)) {
                                   EveningTimeForUsers.add(convert1);
                               }


                           }
                           ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, EveningTimeForUsers);
                           EveningListview.setAdapter(adapter1);
                           EveningListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                               @Override
                               public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                   SelectedTime = (String) EveningListview.getItemAtPosition(i);
                                   Intent intent = new Intent(getApplicationContext(),UserInfo.class);
                                   intent.putExtra("date",getDateFromED);
                                   intent.putExtra("day",dayOfWeek);
                                   intent.putExtra("time",SelectedTime);
                                   intent.putExtra("name",name);
                                   intent.putExtra("id",id);
                                   startActivity(intent);
                               }
                           });
                       }


               }
           }, new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError error) {

               }
           })
           {
               @Override
               protected Map<String, String> getParams() throws AuthFailureError {
                   Map<String,String> params = new HashMap<>();
                   params.put("date",getDateFromED);
                   return params;
               }
           }
                   ;
           MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

       }


    }

    private void datepicker() {
        Calendar calendar = Calendar.getInstance();
        final DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd yyyy");
                newDate.set(year, monthOfYear, dayOfMonth);
                dateformat = dateFormatter.format(newDate.getTime());

                SimpleDateFormat simpledateformat = new SimpleDateFormat("EE");
                Date date = new Date(year,monthOfYear,dayOfMonth-1);

                dayOfWeek = simpledateformat.format(date);
                Log.e("day",dayOfWeek);
                ed.setText(dateformat);
                getDateFromED = ed.getText().toString();

                //For Monday
                if(dayOfWeek.matches("Mon"))
                {
                    URL = "http://10.0.2.2/scripts/Schedule_mon.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("owais",response);

                            try {
                                JSONArray array = new JSONArray(response);
                                for (int i = 0 ;i<response.length();i++)
                                {
                                    JSONObject jsonObject = array.getJSONObject(i);
                                    Morning_start = jsonObject.getString("mon_morning_start");
                                    Morning_end = jsonObject.getString("mon_morning_end");
                                    Evening_start = jsonObject.getString("mon_evening_start");
                                    Evening_end = jsonObject.getString("mon_evening_end");
                                    avg_time = jsonObject.getString("avg_time");
                                    Log.e("time",Morning_start);
                                    Log.e("time",Morning_end);
                                    Log.e("time",Evening_start);
                                    Log.e("time",Evening_end);
                                }
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<>();
                            params.put("id",id);
                            return params;
                        }
                    }
                            ;
                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
                }
                //For Tuesday
                if(dayOfWeek.matches("Tue"))
                {
                    URL = "http://10.0.2.2/scripts/Schedule_tue.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("owais",response);

                            try {
                                JSONArray array = new JSONArray(response);
                                for (int i = 0 ;i<response.length();i++)
                                {
                                    JSONObject jsonObject = array.getJSONObject(i);
                                    Morning_start = jsonObject.getString("tue_morning_start");
                                    Morning_end = jsonObject.getString("tue_morning_end");
                                    Evening_start = jsonObject.getString("tue_evening_start");
                                    Evening_end = jsonObject.getString("tue_evening_end");
                                    avg_time = jsonObject.getString("avg_time");
                                    Log.e("time",Morning_start);
                                    Log.e("time",Morning_end);
                                    Log.e("time",Evening_start);
                                    Log.e("time",Evening_end);
                                }
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<>();
                            params.put("id",id);
                            return params;
                        }
                    }
                            ;
                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
                }
                //For Wednesday

                if(dayOfWeek.matches("Wed"))
                {
                    URL = "http://10.0.2.2/scripts/Schedule_wed.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("owais",response);

                            try {
                                JSONArray array = new JSONArray(response);
                                for (int i = 0 ;i<response.length();i++)
                                {
                                    JSONObject jsonObject = array.getJSONObject(i);
                                    Morning_start = jsonObject.getString("wed_morning_start");
                                    Morning_end = jsonObject.getString("wed_morning_end");
                                    Evening_start = jsonObject.getString("wed_evening_start");
                                    Evening_end = jsonObject.getString("wed_evening_end");
                                    avg_time = jsonObject.getString("avg_time");
                                    Log.e("time",Morning_start);
                                    Log.e("time",Morning_end);
                                    Log.e("time",Evening_start);
                                    Log.e("time",Evening_end);
                                }
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<>();
                            params.put("id",id);
                            return params;
                        }
                    }
                            ;
                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
                }
                //For Thursday
                if(dayOfWeek.matches("Thu"))
                {
                    URL = "http://10.0.2.2/scripts/Schedule_thurs.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("owais",response);

                            try {
                                JSONArray array = new JSONArray(response);
                                for (int i = 0 ;i<response.length();i++)
                                {
                                    JSONObject jsonObject = array.getJSONObject(i);
                                    Morning_start = jsonObject.getString("thu_morning_start");
                                    Morning_end = jsonObject.getString("thu_morning_end");
                                    Evening_start = jsonObject.getString("thu_evening_start");
                                    Evening_end = jsonObject.getString("thu_evening_end");
                                    avg_time = jsonObject.getString("avg_time");
                                    Log.e("time",Morning_start);
                                    Log.e("time",Morning_end);
                                    Log.e("time",Evening_start);
                                    Log.e("time",Evening_end);
                                }
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<>();
                            params.put("id",id);
                            return params;
                        }
                    }
                            ;
                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
                }
                //For Friday
                if(dayOfWeek.matches("Fri"))
                {
                    URL = "http://10.0.2.2/scripts/Schedule_fri.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("owais",response);

                            try {
                                JSONArray array = new JSONArray(response);
                                for (int i = 0 ;i<response.length();i++)
                                {
                                    JSONObject jsonObject = array.getJSONObject(i);
                                    Morning_start = jsonObject.getString("fri_morning_start");
                                    Morning_end = jsonObject.getString("fri_morning_end");
                                    Evening_start = jsonObject.getString("fri_evening_start");
                                    Evening_end = jsonObject.getString("fri_evening_end");
                                    avg_time = jsonObject.getString("avg_time");
                                    Log.e("time",Morning_start);
                                    Log.e("time",Morning_end);
                                    Log.e("time",Evening_start);
                                    Log.e("time",Evening_end);
                                }
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<>();
                            params.put("id",id);
                            return params;
                        }
                    }
                            ;
                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
                }
                //For Saturday
                if(dayOfWeek.matches("Sat"))
                {
                    URL = "http://10.0.2.2/scripts/Schedule_sat.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("owais",response);

                            try {
                                JSONArray array = new JSONArray(response);
                                for (int i = 0 ;i<response.length();i++)
                                {
                                    JSONObject jsonObject = array.getJSONObject(i);
                                    Morning_start = jsonObject.getString("sat_morning_start");
                                    Morning_end = jsonObject.getString("sat_morning_end");
                                    Evening_start = jsonObject.getString("sat_evening_start");
                                    Evening_end = jsonObject.getString("sat_evening_end");
                                    avg_time = jsonObject.getString("avg_time");
                                    Log.e("time",Morning_start);
                                    Log.e("time",Morning_end);
                                    Log.e("time",Evening_start);
                                    Log.e("time",Evening_end);
                                }
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<>();
                            params.put("id",id);
                            return params;
                        }
                    }
                            ;
                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
                }
                //For Sunday
                if(dayOfWeek.matches("Sun"))
                {
                    URL = "http://10.0.2.2/scripts/Schedule_sun.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("owais",response);

                            try {
                                JSONArray array = new JSONArray(response);
                                for (int i = 0 ;i<response.length();i++)
                                {
                                    JSONObject jsonObject = array.getJSONObject(i);
                                    Morning_start = jsonObject.getString("sun_morning_start");
                                    Morning_end = jsonObject.getString("sun_morning_end");
                                    Evening_start = jsonObject.getString("sun_evening_start");
                                    Evening_end = jsonObject.getString("sun_evening_end");
                                    avg_time = jsonObject.getString("avg_time");
                                    Log.e("time",Morning_start);
                                    Log.e("time",Morning_end);
                                    Log.e("time",Evening_start);
                                    Log.e("time",Evening_end);
                                }
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<>();
                            params.put("id",id);
                            return params;
                        }
                    }
                            ;
                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
                }


            }

        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis()-1000);
        datePickerDialog.show();



    }
}
