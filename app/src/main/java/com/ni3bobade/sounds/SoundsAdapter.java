package com.ni3bobade.sounds;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SoundsAdapter extends ArrayAdapter {

    public SoundsAdapter(Activity context, ArrayList<Sounds> sounds) {
        super(context, 0, sounds);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View gridItemView = convertView;
        if (gridItemView == null){
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.sounds_list, parent, false);
        }

        Sounds currentSound = (Sounds) getItem(position);

        ImageView soundsImageView = gridItemView.findViewById(R.id.soundsImageView);
        soundsImageView.setImageResource(currentSound.getSoundImageResourceId());

        TextView soundsNameTextView = gridItemView.findViewById(R.id.soundsNameTextView);
        soundsNameTextView.setText(currentSound.getSoundName());

        return gridItemView;
    }
}
