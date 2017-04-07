package com.team6.teamrocket.blizzardboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.github.clans.fab.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {

    private FirebaseListAdapter<HBBulletin> adapter;

    private void displayBulletins() {
        ListView listOfBulletins = (ListView) findViewById( R.id.list_of_bulletins );

        adapter = new FirebaseListAdapter<HBBulletin>(this, HBBulletin.class,
                R.layout.bulletin, FirebaseDatabase.getInstance().getReference( "BulletinsV2" )) {
            @Override
            protected void populateView( View v, HBBulletin model, int position ) {
                // Get references to the views of message.xml
                TextView title = (TextView) v.findViewById( R.id.bulletin_title );
                TextView user = (TextView) v.findViewById( R.id.bulletin_user );
                TextView description = (TextView) v.findViewById( R.id.bulletin_desciption );

                // Set their text
                title.setText( model.getTitle() );
                user.setText( model.getUser() );
                description.setText( model.getDescription() );
            }
        };

        listOfBulletins.setAdapter( adapter );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_home );

        if (FirebaseAuth.getInstance().getCurrentUser() == null ) {
            //If user is not signed in, goto signin.
            Intent signIn = new Intent( Home.this, LoginActivity.class );
            this.startActivity( signIn );
        }
        else {
            //Else display bulletins.
            displayBulletins();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );

        fab.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View view ) {
                Intent addItemForm = new Intent( Home.this, AddItemForm.class );
                startActivity( addItemForm );
            }

        });

    }

}
