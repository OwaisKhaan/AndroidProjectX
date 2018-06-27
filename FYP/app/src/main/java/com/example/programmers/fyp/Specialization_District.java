package com.example.programmers.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Specialization_District extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroup;
    RadioButton radioButton;
    ArrayList<String> arrayList;
    ImageView imageView;
    TextView RESET;
    String radioButtonSelection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialization_location);
        radioGroup = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.back_image);
        imageView.setOnClickListener(this);
        Specialization();
    }

    private void Specialization() {

        final String url = "http://10.0.2.2/scripts/specialization.php";

        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {



                for(int i = 0; i < jsonArray.length(); i++) {

                    try {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String SpecializationDoctor = jsonObject.getString("name");

                        Log.d("owais",SpecializationDoctor);
                        arrayList.add(SpecializationDoctor);
                        radioButton = new RadioButton(getApplicationContext());
                        radioButton.setText(arrayList.get(i));



                    }




                    catch(JSONException e) {



                    }
                    radioGroup.addView(radioButton);

                    radioButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int id = radioGroup.getCheckedRadioButtonId();
                            View radio = radioGroup.findViewById(id);
                            int radioid = radioGroup.indexOfChild(radio);
                            RadioButton btn = (RadioButton) radioGroup.getChildAt(radioid);
                            radioButtonSelection = btn.getText().toString();

                            Toast.makeText(getApplicationContext(),radioButtonSelection,Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        arrayList = new ArrayList<>();
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.back_image)
        {


           if(radioButtonSelection==null)
           {
               Intent intent = new Intent(this,MainActivity.class);
               startActivity(intent);
           }
           else
           {
               Intent intent = new Intent();
               intent.putExtra("specialization",radioButtonSelection);
               setResult(RESULT_OK,intent);
               finish();
           }


        }
    }
}

