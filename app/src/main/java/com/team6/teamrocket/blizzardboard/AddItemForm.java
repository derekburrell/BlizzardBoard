package com.team6.teamrocket.blizzardboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddItemForm extends AppCompatActivity {

    private EditText mTitleView;
    private EditText mDescriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_form);

        //push the post to the Firebase
        Button mSubmitButton = (Button) findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //post a bulletin to Firebase
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference postRef = database.getReference("Bulletins");

                //grab info from text fields
                mTitleView = (EditText) findViewById(R.id.titleText);
                mDescriptionView = (EditText) findViewById(R.id.descriptionText);
                String title = mTitleView.getText().toString();
                String desc = mDescriptionView.getText().toString();

                //create bulletin and post it
                Bulletin bulletin = new EventBulletin();
                bulletin.setTitle(title);
                bulletin.setAuthor(FirebaseAuth.getInstance().getCurrentUser().getEmail());
                bulletin.setDesc(desc);
                DatabaseReference bullRef = postRef.push();
                bullRef.setValue(bulletin.toMap());

                //go back to the navigation screen
                startActivity(new Intent(AddItemForm.this, Navigation.class));
            }
        });
    }
}
