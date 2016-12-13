package com.bionic.sasha.betterenglish.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bionic.sasha.betterenglish.AddNewWordActivity;
import com.bionic.sasha.betterenglish.R;
import com.bionic.sasha.betterenglish.traineeModes.DirectlyModeActivity;
import com.bionic.sasha.betterenglish.traineeModes.LettersModeActivity;
import com.bionic.sasha.betterenglish.traineeModes.TranslateWordActivity;
import com.bionic.sasha.betterenglish.traineeModes.WordTranslateActivity;

import java.util.ArrayList;

/**
 * Created by SASHA on 10.12.2016.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<String> mDataset;
    private ArrayList<Integer> mImages;
    private ArrayList<Integer> mIcons;
    private ArrayList<Integer> mModes;



    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView wordCount;
        ImageButton ib;
        LinearLayout relativeLayout;
        TextView cardMode;


        public ViewHolder(View v) {
            super(v);
            wordCount = (TextView) v.findViewById(R.id.card_words);
            ib = (ImageButton) v.findViewById(R.id.card_image_button);
            relativeLayout = (LinearLayout) v.findViewById(R.id.card_layout);
            cardMode = (TextView) v.findViewById(R.id.card_mode);
        }
    }


    public MyAdapter(ArrayList myDataset, ArrayList myImages, ArrayList myIcons, ArrayList myModes) {
        mDataset = myDataset;
        mImages = myImages;
        mIcons = myIcons;
        mModes = myModes;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trainee_card, parent, false);


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.wordCount.setText(mDataset.get(position));
        holder.relativeLayout.setBackgroundResource(mImages.get(position));
        holder.ib.setBackgroundResource(mIcons.get(position));
        holder.cardMode.setText(mModes.get(position));


        holder.ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                switch (position){
                    case 0:
                        if (Integer.parseInt(mDataset.get(0)) < 10) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                            builder.setTitle("Warning! You should have at least 10 words to study.")
                                    .setCancelable(false)
                                    .setNegativeButton("ADD",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.cancel();
                                                    Intent intentl = new Intent(view.getContext(), AddNewWordActivity.class);
                                                    view.getContext().startActivity(intentl);
                                                }
                                            });
                            AlertDialog alert = builder.create();
                            alert.show();
                        } else {
                            Intent intent = new Intent(view.getContext(), WordTranslateActivity.class);
                            view.getContext().startActivity(intent);
                        }
                        break;
                    case 1:
                        if (Integer.parseInt(mDataset.get(1)) < 10) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                            builder.setTitle("Warning! You should have at least 10 words to study.")
                                    .setCancelable(false)
                                    .setNegativeButton("ADD",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.cancel();
                                                    Intent intentl = new Intent(view.getContext(), AddNewWordActivity.class);
                                                    view.getContext().startActivity(intentl);
                                                }
                                            });
                            AlertDialog alert = builder.create();
                            alert.show();
                        } else {
                            Intent intent1 = new Intent(view.getContext(), TranslateWordActivity.class);
                            view.getContext().startActivity(intent1);
                        }
                        break;
                    case 2:
                        if (Integer.parseInt(mDataset.get(2)) < 10) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                            builder.setTitle("Warning! You should have at least 10 words to study.")
                                    .setCancelable(false)
                                    .setNegativeButton("ADD",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.cancel();
                                                    Intent intentl = new Intent(view.getContext(), AddNewWordActivity.class);
                                                    view.getContext().startActivity(intentl);
                                                }
                                            });
                            AlertDialog alert = builder.create();
                            alert.show();
                        } else {
                            Intent intent2 = new Intent(view.getContext(), DirectlyModeActivity.class);
                            view.getContext().startActivity(intent2);
                        }

                        break;
                }
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

