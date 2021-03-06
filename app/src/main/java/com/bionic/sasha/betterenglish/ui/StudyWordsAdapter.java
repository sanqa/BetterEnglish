package com.bionic.sasha.betterenglish.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bionic.sasha.betterenglish.R;

import java.util.ArrayList;

/**
 * Created by SASHA on 03.01.2017.
 */

public class StudyWordsAdapter extends RecyclerView.Adapter<StudyWordsAdapter.ViewHolder> {

    private ArrayList<String> words;
    private ArrayList<String> translates;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView wordRu;
        TextView wordEn;

        public ViewHolder(View v) {
            super(v);
            wordRu = (TextView) v.findViewById(R.id.learned_word_ru);
            wordEn = (TextView) v.findViewById(R.id.learned_word_en);

        }
    }

    public StudyWordsAdapter(ArrayList words, ArrayList translates){
        this.words = words;
        this.translates = translates;
    }


    @Override
    public StudyWordsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.learned_card, parent, false);


        StudyWordsAdapter.ViewHolder vh = new StudyWordsAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(StudyWordsAdapter.ViewHolder holder, int position) {

        holder.wordRu.setText(words.get(position));
        holder.wordEn.setText(translates.get(position));

    }

    @Override
    public int getItemCount() {
        return words.size();
    }


}
