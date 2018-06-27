package com.example.programmers.fyp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.programmers.fyp.MainRecycler.MainRecyclerItems;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Doctor_Profile extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView,backimage ;
    TextView name,location,specialization,id,more_info,getDirection,Doct_addresstextview,fees;
    RelativeLayout relativeLayout;
    String LocationURL = "http://10.0.2.2/scripts/getLocation.php";
    String longtitude,latitude,doc_address;
    double dlatitude,dlongtitude;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__profile);

fees = findViewById(R.id.fees);
        relativeLayout = findViewById(R.id.address);
        Doct_addresstextview = findViewById(R.id.address_doctor);
        getDirection = findViewById(R.id.get_directions);
        getDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f?z=17&q=%f,%f", dlatitude,dlongtitude,dlatitude,dlongtitude);
Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(uri));
Intent chooser = Intent.createChooser(i,"Launch Maps");
startActivity(chooser);


            }
        });

        more_info = findViewById(R.id.moreinfo);
        more_info.setOnClickListener(this);


        backimage = findViewById(R.id.backuserinfo);
        backimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        imageView = findViewById(R.id.circleImageView);
        name = findViewById(R.id.docName);
        id = findViewById(R.id.Docid);
        specialization = findViewById(R.id.docSpecialization);
        location = findViewById(R.id.doclocation);
        if(getIntent().getSerializableExtra("MainRecyclerItems")!=null)
        {
            MainRecyclerItems mainRecyclerItems = (MainRecyclerItems) getIntent().getSerializableExtra("MainRecyclerItems");
            String FullUrl = "http://10.0.2.2/"+ mainRecyclerItems.getPic();
            Picasso.with(this)
                    .load(FullUrl)
                    .placeholder(R.drawable.aaa)
                    .into(imageView);
            id.setText(Integer.toString(mainRecyclerItems.id));
            fees.setText(Integer.toString(mainRecyclerItems.fee));
            name.setText(mainRecyclerItems.name);
            location.setText(mainRecyclerItems.address);
            specialization.setText(mainRecyclerItems.specialization);




        }
        button = findViewById(R.id.book_appointment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TimeSelect.class);
               intent.putExtra("name",name.getText().toString());
               intent.putExtra("id",id.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        relativeLayout.setVisibility(View.VISIBLE);
StringRequest stringRequest = new StringRequest(Request.Method.POST, LocationURL, new Response.Listener<String>() {
    @Override
    public void onResponse(String response) {
        Log.e("location",response);
        try {
            JSONArray array = new JSONArray(response);
            for (int i = 0 ;i < response.length();i++ )
            {
                JSONObject object = array.getJSONObject(i);
latitude = object.getString("lat");
longtitude = object.getString("lng");
dlatitude = Double.parseDouble(latitude);
dlongtitude = Double.parseDouble(longtitude);
doc_address = object.getString("details");
Doct_addresstextview.setText(doc_address);
            }
        } catch (JSONException e) {
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
        params.put("id",id.getText().toString());
        return params;
    }
}
        ;
MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
}
