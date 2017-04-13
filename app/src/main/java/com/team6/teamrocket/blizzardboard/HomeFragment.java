package com.team6.teamrocket.blizzardboard;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.github.clans.fab.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 *
 * @author Jacob Gould
 */
public class HomeFragment extends Fragment {

    private View homeView;
    private FirebaseListAdapter<HBBulletin> adapter;

    public static final int event = Color.parseColor( "#f0abff" ),
                travel = Color.parseColor( "#00e6ff" ),
                housing = Color.parseColor( "#59ff00" ),
                forSale = Color.parseColor( "#ffea00" );

    private void displayBulletins() {
        ListView listOfBulletins = (ListView) getActivity().findViewById( R.id.list_of_bulletins );

        adapter = new FirebaseListAdapter<HBBulletin>(getActivity(), HBBulletin.class,
                R.layout.bulletin, FirebaseDatabase.getInstance().getReference( "BulletinsV2" )) {
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

                        Intent fullPage = new Intent( getActivity(), BulletinActivity.class );
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeView = inflater.inflate( R.layout.activity_home, container, false );
        return homeView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if ( FirebaseAuth.getInstance().getCurrentUser() == null ) {
            //If user is not signed in, goto signin.
            Intent signIn = new Intent( getActivity(), LoginActivity.class );
            this.startActivity( signIn );
            getActivity().finish();
        }
        else {
            //Else display bulletins.
            displayBulletins();
        }

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById( R.id.fab );

        fab.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View view ) {
                Intent addItemForm = new Intent( getActivity(), AddItemForm.class );
                startActivity( addItemForm );
            }

        });
    }
}
