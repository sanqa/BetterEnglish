package com.bionic.sasha.betterenglish.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bionic.sasha.betterenglish.R;
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;

import java.util.ArrayList;

/**
 * Created by SASHA on 09.01.2017.
 */

public class ArrayWordsAdapter extends RecyclerView.Adapter<ArrayWordsAdapter.ViewHolder> {

    private ArrayList<String> words;
    private ArrayList<String> translates;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView wordRu;

        public ViewHolder(View v) {
            super(v);
            wordRu = (TextView) v.findViewById(R.id.array_word);

        }
    }

    public ArrayWordsAdapter(ArrayList<String> words) {
        this.words = words;
    }

    @Override
    public ArrayWordsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.array_words_card, parent, false);


        ArrayWordsAdapter.ViewHolder vh = new ArrayWordsAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ArrayWordsAdapter.ViewHolder holder, int position) {
        holder.wordRu.setText(words.get(position));
    }

    @Override
    public int getItemCount() {
        return words.size();
    }
}
