package com.bionic.sasha.betterenglish.ui;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bionic.sasha.betterenglish.R;
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;

import java.util.ArrayList;

/**
 * Created by SASHA on 09.01.2017.
 */

public class ArrayWordsAdapter extends RecyclerView.Adapter<ArrayWordsAdapter.ViewHolder> {

    private ArrayList<String> words;
    private ArrayList<String> numbers;



    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView wordRu;
        TextView number;
        ImageButton addButton;

        public ViewHolder(View v) {
            super(v);
            wordRu = (TextView) v.findViewById(R.id.array_word);
            number = (TextView) v.findViewById(R.id.array_count_words);
            addButton = (ImageButton) v.findViewById(R.id.array_button_add);
        }



    }

    public ArrayWordsAdapter(ArrayList<String> words, ArrayList<String> numbers) {
        this.words = words;
        this.numbers = numbers;
    }



    @Override
    public ArrayWordsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.array_words_card, parent, false);



        ArrayWordsAdapter.ViewHolder vh = new ArrayWordsAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ArrayWordsAdapter.ViewHolder holder, final int position) {
        holder.wordRu.setText(words.get(position));
        holder.number.setText(numbers.get(position));
        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    default:
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                        builder.setTitle("Add").setMessage("Do you really want to study these words?").setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                        AlertDialog alert = builder.create();
                        alert.show();
                        break;

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return words.size();
    }


}
