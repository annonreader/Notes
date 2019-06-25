package com.practice.tarun.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.LinearLayout;

import com.practice.tarun.notes.Adapters.NotesRecyclerAdapter;
import com.practice.tarun.notes.Models.note;
import com.practice.tarun.notes.Utils.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NotesRecyclerAdapter.onNoteListener{

    private static final String TAG = "MainActivity";

    //ui
    private RecyclerView mRecyclerView;

    //vars
    private ArrayList<note> mNote = new ArrayList<>();
    private NotesRecyclerAdapter mNotesRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_layout);

        mRecyclerView = findViewById(R.id.recycler_view);
        initRecyclerView();


        //setting up custom toolbar
        setSupportActionBar((Toolbar)findViewById(R.id.tool_bar));
        setTitle("Notes");
    }

    //setting up recyclerview
    private void initRecyclerView()
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //instantiating item decorator
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        //setting up itemdecorator to recycler view
        mRecyclerView.addItemDecoration(itemDecorator);
        //here, when the user clicks, it sends the click to the NoteRecyclerAdapter class through constructor
        mNotesRecyclerAdapter= new NotesRecyclerAdapter(mNote,this);
        mRecyclerView.setAdapter(mNotesRecyclerAdapter);
    }

    //implementing the declared onNoteListener interface and here we will write the logic
    //what happens when we click the list item
    @Override
    public void onNoteClick(int position) {

        Intent intent = new Intent(this,DetailAcitivity.class);
        intent.putExtra("index",mNote.get(position));
        startActivity(intent);
    }
}
