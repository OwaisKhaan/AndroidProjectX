package com.example.programmers.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserandPass extends AppCompatActivity implements View.OnClickListener {

    Button login;
    EditText username,password;
    String strusermail,strpassword,strname;
    String url = "http://10.0.2.2/scripts/checkuserandpass.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
        setContentView(R.layout.activity_userand_pass);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.Loginpassuser);
        login.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        strusermail = username.getText().toString();
        strpassword = password.getText().toString();
        if(strusermail.equals(null) && strpassword.equals(null))
        {
            Toast.makeText(this,"First Fill All Fields",Toast.LENGTH_SHORT).show();
        }
        else
        {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("response",response.toString());
                    if(response.equals("fail"))
                    {
                        Toast.makeText(getApplicationContext(),"Username and Password are Incorect",Toast.LENGTH_LONG).show();
                        username.setText("");
                        password.setText("");
                    }
                    else
                    {
                        try {
                            JSONArray array = new JSONArray(response);
                            for(int i = 0 ; i < response.length() ; i++)
                            {
                                JSONObject jsonObject = array.getJSONObject(i);
                                strname = jsonObject.getString("name");
Log.e("owasi",strname);
                                Intent intent = new Intent(UserandPass.this,Adminpanel.class);
                                intent.putExtra("name",strname);
                                startActivity(intent);
                            }

                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }


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
                    params.put("usermail",strusermail);
                    params.put("password",strpassword);
                    return params;
                }
            };
            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        }

    }
}
