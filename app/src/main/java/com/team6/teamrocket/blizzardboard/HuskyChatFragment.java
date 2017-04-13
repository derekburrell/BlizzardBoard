package com.team6.teamrocket.blizzardboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.github.clans.fab.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

/**
 *
 * @author Jacob Gould
 */
public class HuskyChatFragment extends Fragment {

    private View hcView;
    private FirebaseListAdapter<ChatMessage> adapter;

    private void displayChatMessages() {
        ListView listOfMessages = (ListView) getActivity().findViewById(R.id.list_of_messages);

        adapter = new FirebaseListAdapter<ChatMessage>(getActivity(), ChatMessage.class,
                R.layout.message, FirebaseDatabase.getInstance().getReference( "HCMessages" )) {
            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                // Get references to the views of message.xml
                TextView messageText = (TextView)v.findViewById(R.id.message_text);
                TextView messageUser = (TextView)v.findViewById(R.id.message_user);
                TextView messageTime = (TextView)v.findViewById(R.id.message_time);

                // Set their text
                messageText.setText(model.getMessage());
                messageUser.setText(model.getUser());

                // Set the date text
                String day = DateFormat.format( "dd-MM-yyyy", model.getTime() ).toString();
                String today = DateFormat.format( "dd-MM-yyyy", new Date().getTime() ).toString();
                if ( day == null ) {

                }
                else if ( day.equals( today ) ) {  //Don't display date if it was posted today
                    messageTime.setText( DateFormat.format("HH:mm:ss", model.getTime()) );
                }
                else {
                    messageTime.setText( DateFormat.format("dd-MM-yyyy (HH:mm:ss)", model.getTime()) );
                }
            }
        };

        listOfMessages.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        hcView = inflater.inflate( R.layout.activity_husky_chat, container, false );
        return hcView;
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
            displayChatMessages();
        }

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        fab.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View view ) {
                EditText input = (EditText) getActivity().findViewById( R.id.input );

                if ( input.getText().toString().equals( "" ) ) {
                    return;
                }

                // Read the input field and push a new instance
                // of ChatMessage to the Firebase database
                FirebaseDatabase.getInstance()
                        .getReference( "HCMessages" )
                        .push()
                        .setValue(new ChatMessage(input.getText().toString(),
                                FirebaseAuth.getInstance()
                                        .getCurrentUser()
                                        .getEmail())
                        );

                // Clear the input
                input.setText( "" );
            }

        });
    }
}
