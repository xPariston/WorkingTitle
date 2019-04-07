package com.example.worldx;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class mapview extends AppCompatActivity {

    private static final String TAG = "mapview";
    private Spinner regionviewer;
    private String[] regionlist;
    private ArrayAdapter<String> adapter;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference myRef = db.collection ("PublicRead");

    DocumentReference regions = myRef.document("Regions");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDocument();


        setContentView(R.layout.activity_mapview);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        regionviewer = findViewById(R.id.regionviewer);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, regionlist);
        this.db

        regionviewer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void getDocument()
    {


        regions.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());

                        try {
                            HashMap<String, Object> map = (HashMap<String, Object>) document.getData();

                            regionlist = new String[map.size()];
                            int Counter = 0;
                            for (Object i : map.values())
                            {

                                HashMap<String, Object> newmap = (HashMap<String, Object>) i;
                                Log.d(TAG, (String) newmap.get("Name"));
                                regionlist[Counter] = (String) newmap.get("Name");
                                Counter++;
                            }
                            adapter = new ArrayAdapter<String>(this ,android.R.layout.simple_list_item_1, regionlist);

                            regionviewer.setAdapter(adapter);

                        }catch (Exception e)
                        {
                            Log.d(TAG, e.toString());
                        }

                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

    }

}
