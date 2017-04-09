package com.team6.teamrocket.blizzardboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.github.clans.fab.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 *
 * @author Jacob Gould
 */
public class MyPostsFragment extends Fragment {

    private View profleView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profleView = inflater.inflate( R.layout.activity_profile, container, false );
        return profleView;
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
            //displayBulletins();
        }
    }
}
