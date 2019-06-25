package com.practice.tarun.notes.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.practice.tarun.notes.Models.note;
import com.practice.tarun.notes.R;

import java.util.ArrayList;


public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder>{

    //this is because we need to tell the view_holder which position is clicked
    onNoteListener monNoteListener;
    private ArrayList<note> mNotes = new ArrayList<>();


    public NotesRecyclerAdapter(ArrayList<note> notes,onNoteListener onNoteListener)
    {
        this.mNotes = notes;
        //here the click is being recorded, which was sent by MainActivity
        //and stored in the global variable monNoteListener.
        this.monNoteListener = onNoteListener;
    }

    //this is the method responsible for creating and instantiating ViewHolder object.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //now it will create the viewholder object and pass it to viewholder class
        //here we are not passing the layout that will hold the list of items, rather we are passing the layout of each list,
        // i.e text and timestamp
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_list_item,viewGroup,false);
        //here the global monNoteListener is being received and passed through constructor
        //to the ViewHolder class
        return new ViewHolder(view,monNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //here we are assign the values to our textviews
        viewHolder.title.setText(mNotes.get(i).getTitle());
        viewHolder.timestamp.setText(mNotes.get(i).getTimestamp());
    }

    @Override
    public int getItemCount() {
        //this returns the number of notes object in the array list
        return mNotes.size();
    }

    //this is the class which is responsible for holding and displaying custom views in the recyclerview
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
         TextView title,timestamp;
         onNoteListener onnotelistener;

         //this constructor receives the global monNoteListener and sets it to
        //onnotelistener(global in this class) through the constructor
        public ViewHolder(@NonNull View itemView,onNoteListener onNotelistener) {
            super(itemView);

            title = itemView.findViewById(R.id.note_title);
            timestamp = itemView.findViewById(R.id.note_timestamp);
            this.onnotelistener = onNotelistener;
            //attaching the onclick listener to the view holder
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //this is where i am sending the adapter position to the interface to capture
            onnotelistener.onNoteClick(getAdapterPosition());
        }
    }

    //interface that will listen to the click and send the position of the item that is clicked
    public interface onNoteListener
    {
        void onNoteClick(int position);
    }
}