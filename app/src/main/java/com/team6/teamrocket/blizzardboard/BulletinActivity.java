package com.team6.teamrocket.blizzardboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

/**
 *
 * @author Jacob Gould
 */
public class BulletinActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bulletin );

        if ( FirebaseAuth.getInstance().getCurrentUser() == null ) {
            //If user is not signed in, goto signin.
            Intent signIn = new Intent( BulletinActivity.this, LoginActivity.class );
            this.startActivity( signIn );
            this.finish();
        }
        else {
            TextView title = (TextView) findViewById( R.id.bulletin_title );
            TextView user = (TextView) findViewById( R.id.bulletin_user );
            TextView date = (TextView) findViewById( R.id.bulletin_date );
            TextView description = (TextView) findViewById( R.id.bulletin_desciption );
            TextView subject = (TextView) findViewById( R.id.bulletin_subject );

            title.setText( getIntent().getStringExtra( "postTitle" ) );
            user.setText( getIntent().getStringExtra( "postUser" ) );
            date.setText( getIntent().getStringExtra( "postDate" ) );
            description.setText( getIntent().getStringExtra( "postDescription" ) );
            subject.setText( getIntent().getStringExtra( "postSubject" ) );

            // Set background color
            String subj = subject.getText().toString();
            if ( subj == null ) {
                //do nothing
            }
            else if ( subj.equals( "Event" ) ) {
                this.findViewById( R.id.sticky_note ).setBackgroundColor( HomeFragment.event );
            }
            else if ( subj.equals( "Travel" ) ) {
                this.findViewById( R.id.sticky_note ).setBackgroundColor( HomeFragment.travel );
            }
            else if ( subj.equals( "Housing" ) ) {
                this.findViewById( R.id.sticky_note ).setBackgroundColor( HomeFragment.housing );
            }
            else if ( subj.equals( "For Sale" ) ) {
                this.findViewById( R.id.sticky_note ).setBackgroundColor( HomeFragment.forSale );
            }

            user.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick( View view ) {
                    // Get references to the views of bulletin.xml
                    TextView user = (TextView) view.findViewById( R.id.bulletin_user );

                    Intent profile = new Intent( BulletinActivity.this, ProfileActivity.class );
                    profile.putExtra( "user", user.getText() );
                    startActivity( profile );
                }

            });
        }
    }

}
