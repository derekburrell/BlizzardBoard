package com.team6.teamrocket.blizzardboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseListAdapter<HBBulletin> adapter;

    private void displayBulletins( String user ) {
        ListView listOfBulletins = (ListView) findViewById( R.id.list_of_bulletins );

        adapter = new FirebaseListAdapter<HBBulletin>( this, HBBulletin.class,
                R.layout.bulletin, FirebaseDatabase.getInstance().getReference( "BulletinsV2" ).orderByChild("user").equalTo(user) ) {
            @Override
            protected void populateView( View v, HBBulletin model, int position ) {
                // Get references to the views of bulletin.xml
                TextView title = (TextView) v.findViewById( R.id.bulletin_title );
                TextView user = (TextView) v.findViewById( R.id.bulletin_user );
                TextView date = (TextView) v.findViewById( R.id.bulletin_date );
                TextView description = (TextView) v.findViewById( R.id.bulletin_desciption );
                TextView subject = (TextView) v.findViewById( R.id.bulletin_subject );

                // Set their text
                title.setText( model.getTitle() );
                user.setText( model.getUser() );
                date.setText( DateFormat.format("dd-MM-yyyy (HH:mm:ss)", model.getPostTime()) );
                description.setText( model.getDescription() );
                subject.setText( model.getSubject() );

                // Set background color
                String subj = model.getSubject();
                if ( subj == null ) {
                    //do nothing
                }
                else if ( subj.equals( "Event" ) ) {
                    v.setBackgroundColor( HomeFragment.event );
                }
                else if ( subj.equals( "Travel" ) ) {
                    v.setBackgroundColor( HomeFragment.travel );
                }
                else if ( subj.equals( "Housing" ) ) {
                    v.setBackgroundColor( HomeFragment.housing );
                }
                else if ( subj.equals( "For Sale" ) ) {
                    v.setBackgroundColor( HomeFragment.forSale );
                }

                // Set click to open full page view of bulletin
                v.setOnClickListener( new View.OnClickListener() {

                    @Override
                    public void onClick( View view ) {
                        // Get references to the views of bulletin.xml
                        TextView title = (TextView) view.findViewById( R.id.bulletin_title );
                        TextView user = (TextView) view.findViewById( R.id.bulletin_user );
                        TextView date = (TextView) view.findViewById( R.id.bulletin_date );
                        TextView description = (TextView) view.findViewById( R.id.bulletin_desciption );
                        TextView subject = (TextView) view.findViewById( R.id.bulletin_subject );

                        Intent fullPage = new Intent( ProfileActivity.this, BulletinActivity.class );
                        fullPage.putExtra( "postTitle", title.getText() );
                        fullPage.putExtra( "postUser", user.getText() );
                        fullPage.putExtra( "postDate", date.getText() );
                        fullPage.putExtra( "postDescription", description.getText() );
                        fullPage.putExtra( "postSubject", subject.getText() );
                        startActivity( fullPage );
                    }

                });
            }
        };

        listOfBulletins.setAdapter( adapter );
    }

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_profile );

        if ( FirebaseAuth.getInstance().getCurrentUser() == null ) {
            //If user is not signed in, goto signin.
            Intent signIn = new Intent( ProfileActivity.this, LoginActivity.class );
            this.startActivity( signIn );
            this.finish();
        }
        else {
            TextView user = (TextView) findViewById( R.id.curUser );
            user.setText( getIntent().getStringExtra( "user" ) );

            ImageView iconImage = (ImageView) findViewById( R.id.userIcon );
            iconImage.setImageResource( R.mipmap.icon_350226_640 );

            displayBulletins( user.getText().toString() );
        }
    }

}
