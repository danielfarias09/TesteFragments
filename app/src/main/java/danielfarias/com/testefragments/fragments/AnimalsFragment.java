package danielfarias.com.testefragments.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import danielfarias.com.testefragments.R;

public class AnimalsFragment extends Fragment {
    private static final String URL_ANIMALS = "http://lorempixel.com/400/200/animals/";
    private int position = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflando o Layout para este fragmento
        View view =  inflater.inflate(R.layout.fragment_animals, container, false);

        SimpleDraweeView draweeView = (SimpleDraweeView) view.findViewById(R.id.drawee_animals);

        draweeView.setImageURI(Uri.parse(URL_ANIMALS + position + ""));

        return view;
    }

    public void forwardImage(){
        position++;
        if(position > 9){
            position = 0;
        }
        SimpleDraweeView draweeView = (SimpleDraweeView) getView().findViewById(R.id.drawee_animals);
        draweeView.setImageURI(Uri.parse(URL_ANIMALS + position + ""));

    }

    public void backImage(){
        position--;
        if(position < 0){
            position = 9;
        }
        SimpleDraweeView draweeView = (SimpleDraweeView) getView().findViewById(R.id.drawee_animals);
        draweeView.setImageURI(Uri.parse(URL_ANIMALS + position + ""));

    }

}
