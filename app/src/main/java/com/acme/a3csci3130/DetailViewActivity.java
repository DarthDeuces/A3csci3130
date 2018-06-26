package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailViewActivity extends Activity {

    private EditText nameField, pbusinessField, addrField, provinceField;
    private MyApplicationData appState;
    Contact receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState = ((MyApplicationData) getApplicationContext());
        nameField = (EditText) findViewById(R.id.name);
        pbusinessField = (EditText) findViewById(R.id.pbusiness);
        addrField = (EditText) findViewById(R.id.addr);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            pbusinessField.setText(receivedPersonInfo.pbusiness);
            addrField.setText(receivedPersonInfo.addr);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v){
        String key = appState.firebaseReference.push().getKey();
        Contact contact = new Contact(receivedPersonInfo.uid, receivedPersonInfo.name, receivedPersonInfo.pbusiness, receivedPersonInfo.addr, receivedPersonInfo.province);
        Map<String, Object> contactValues = contact.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/contacts/" + key, contactValues);
        childUpdates.put("/name-contacts/" + receivedPersonInfo.uid + "/" + key, contactValues);

        appState.firebaseReference.updateChildren(childUpdates);
    }

    public void eraseContact(View v)
    {
        DatabaseReference dbNode = FirebaseDatabase.getInstance().getReference().getRoot().child("contacts");
        dbNode.removeValue();
    }
}
