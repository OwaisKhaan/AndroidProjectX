package com.example.programmers.fyp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.programmers.fyp.MainRecycler.MainReyclerItemAdapter;
import com.example.programmers.fyp.MainRecycler.MainRecyclerItems;
import com.kosalgeek.android.json.JsonConverter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public  class MainActivity extends AppCompatActivity implements  View.OnClickListener, AdapterView.OnItemSelectedListener {

    Toolbar toolbar;
Button button;
    public Spinner spinner;
   String data;
    String url= "http://10.0.2.2/scripts/cities.php";
    String Doc_spec= "http://10.0.2.2/scripts/DocAndSpecialization.php";
    String doc = "http://10.0.2.2/scripts/doctors.php";
    ArrayList<MainRecyclerItems> ProductList;
    private RequestQueue queue;
    String selectedspecialization,CityID;
    ImageView imageView,imageX;
    ArrayList<String> arrayList;
    TextView SelectedSpecialization,specialization;
RecyclerView recyclerView;
CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.app_bar);
        spinner = findViewById(R.id.spinner);
        setSupportActionBar(toolbar);
        queue = Volley.newRequestQueue(this);
        recyclerView = findViewById(R.id.recycler);
        SelectedSpecialization= findViewById(R.id.selectedSpecialization);
        specialization = findViewById(R.id.Specialization);
        cardView = findViewById(R.id.card_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        imageX = findViewById(R.id.X);
        imageX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedspecialization = null;
                specialization.setText(null);
                specialization.setVisibility(View.INVISIBLE);
                SelectedSpecialization.setVisibility(View.INVISIBLE);
                imageX.setVisibility(View.INVISIBLE);


            }
        });
button = findViewById(R.id.button);
button.setOnClickListener(this);
        requestJsonObject();
        spinner.setOnItemSelectedListener(this);


imageView = findViewById(R.id.image_view1);
imageView.setOnClickListener(this);





    }



    private void requestJsonObject() {
        JsonArrayRequest requestSpinner = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0;i<response.length();i++)
                {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        String array = object.getString("name");
                        String id = object.getString("district_id");

                        arrayList.add(id +": "+ array);
                    }

                    catch (JSONException e)
                    {

                    }

                }
                ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arrayList);
                spinner.setAdapter(arrayAdapter1);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        arrayList = new ArrayList<>();
       MySingleton.getInstance(getApplicationContext()).addToRequestQueue(requestSpinner);
    }



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.image_view1) {
            Intent intent = new Intent(this, Specialization_District.class);
            startActivityForResult(intent, 1);
        }

        if (view.getId() == R.id.button) {



if(CityID!=null && selectedspecialization==null)
{
recyclerView.setAdapter(null);
    StringRequest request = new StringRequest(Request.Method.POST, doc, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.e("response",response);
            if(response.equals("0"))
            {
                Toast.makeText(getApplicationContext(),"No doctor availabe in this city",Toast.LENGTH_SHORT).show();
                recyclerView.setAdapter(null);
            }
            else {
                 ProductList = new JsonConverter<MainRecyclerItems>().toArrayList(response, MainRecyclerItems.class);
                MainReyclerItemAdapter adapter = new MainReyclerItemAdapter(getApplicationContext(), ProductList);
                recyclerView.setAdapter(adapter);
            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("response",error.toString());
        }
    })
    {
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String,String> params = new HashMap<>();

            params.put("name",CityID);
            Log.e("owais",CityID);
            return  params;
        }
    };
    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
}
 if (CityID!=null && selectedspecialization!=null)
{
    recyclerView.setAdapter(null);
    StringRequest request = new StringRequest(Request.Method.POST, Doc_spec, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.e("response",response);
            if(response.equals("0"))
            {
                Toast.makeText(getApplicationContext(),"No doctor availabe in this city",Toast.LENGTH_SHORT).show();
            }
            else {
                ProductList = new JsonConverter<MainRecyclerItems>().toArrayList(response, MainRecyclerItems.class);
                MainReyclerItemAdapter adapter = new MainReyclerItemAdapter(getApplicationContext(), ProductList);
                recyclerView.setAdapter(adapter);
            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("response",error.toString());
        }
    })
    {
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String,String> params = new HashMap<>();
            params.put("specialization",selectedspecialization);
            params.put("name",CityID);
            Log.e("owais",CityID);
            Log.e("owais",selectedspecialization);
            return  params;
        }
    };
    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
}


        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if (resultCode== RESULT_OK)
            {
                SelectedSpecialization.setVisibility(View.VISIBLE);
                specialization.setVisibility(View.VISIBLE);
                imageX.setVisibility(View.VISIBLE);
                selectedspecialization = data.getStringExtra("specialization");
                specialization.setText(selectedspecialization);

                Log.e("specialization",selectedspecialization);
            }
            else
            {
                SelectedSpecialization.setVisibility(View.INVISIBLE);
                specialization.setVisibility(View.INVISIBLE);
                imageX.setVisibility(View.INVISIBLE);
            }

        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        data = spinner.getSelectedItem().toString();
        CityID = data.substring(0,2);
        Log.e("owais",CityID);

        ((TextView) view).setTextColor(Color.WHITE);
        ((TextView) view).setTextSize(17);
        ((TextView) view).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        ViewGroup.LayoutParams params = spinner.getLayoutParams();
        params.width -= 1;
        spinner.setLayoutParams(params);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


