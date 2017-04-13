package com.team6.teamrocket.blizzardboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 *
 * @author Jordan Kielytka
 */
public class CategoriesFragment extends Fragment {

    private View categoryView;
    private FirebaseListAdapter<HBBulletin> adapter;
    private Spinner category;

    private void displayBulletins() {

        ListView listOfBulletins = (ListView) getActivity().findViewById( R.id.list_of_bulletins );

        adapter = new FirebaseListAdapter<HBBulletin>(getActivity(), HBBulletin.class,
                R.layout.bulletin, FirebaseDatabase.getInstance().getReference( "BulletinsV2" ).orderByChild("subject").equalTo(category.getSelectedItem().toString())) {
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

        // Set background color
        String cat = category.getSelectedItem().toString();
        if ( cat == null ) {
            //do nothing
        }
        else if ( cat.equals( "Event" ) ) {
            category.setBackgroundColor( HomeFragment.event );
        }
        else if ( cat.equals( "Travel" ) ) {
            category.setBackgroundColor( HomeFragment.travel );
        }
        else if ( cat.equals( "Housing" ) ) {
            category.setBackgroundColor( HomeFragment.housing );
        }
        else if ( cat.equals( "For Sale" ) ) {
            category.setBackgroundColor( HomeFragment.forSale );
        }

        listOfBulletins.setAdapter( adapter );
    }

    private void getBulletins(){
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
               displayBulletins();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //this will never happen
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        categoryView = inflater.inflate( R.layout.activity_categories, container, false );
        return categoryView;
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
            category = (Spinner) getActivity().findViewById( R.id.category_spinner );
            //Else display bulletins.
            getBulletins();
        }
    }
}
