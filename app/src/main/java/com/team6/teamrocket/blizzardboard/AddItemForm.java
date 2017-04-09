package com.team6.teamrocket.blizzardboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddItemForm extends AppCompatActivity {

    private EditText mTitleView;
    private EditText mDescriptionView;
    private Spinner mSubjectView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_form);

        //push the post to the Firebase
        Button mSubmitButton = (Button) findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //grab info from text fields
                mTitleView = (EditText) findViewById(R.id.titleText);
                mDescriptionView = (EditText) findViewById(R.id.descriptionText);
                mSubjectView = (Spinner) findViewById( R.id.subject );
                String title = mTitleView.getText().toString();
                String desc = mDescriptionView.getText().toString();
                String subject = mSubjectView.getSelectedItem().toString();

                if ( title.equals("") || desc.equals("") ) {
                    startActivity( new Intent(AddItemForm.this, Home.class ));
                    return;
                }

                //post a bulletin to Firebase
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference postRef = database.getReference( "BulletinsV2" );

                //create bulletin and post it
                String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
                HBBulletin bulletin = new HBBulletin( title, email, desc, subject );

                DatabaseReference bullRef = postRef.push();
                bullRef.setValue( bulletin );

                //sort newest to oldest
                bullRef.setPriority( 0 - bulletin.getPostTime() );

                mTitleView.setText( "" );
                mDescriptionView.setText( "" );

                //go back to the navigation screen
                startActivity( new Intent(AddItemForm.this, Home.class ));

            }
        });
    }
}
