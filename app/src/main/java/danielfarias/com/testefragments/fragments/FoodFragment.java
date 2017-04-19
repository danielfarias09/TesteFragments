package danielfarias.com.testefragments.fragments;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import danielfarias.com.testefragments.R;


public class FoodFragment extends Fragment {
    private static final String URL_FOOD = "http://lorempixel.com/400/200/food/";
    private int position = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food, container, false);

        SimpleDraweeView draweeView = (SimpleDraweeView) view.findViewById(R.id.drawee_food);
        draweeView.setImageURI(Uri.parse(URL_FOOD + position + ""));
        return view;
    }

    public void forwardImage(){
        position++;
        if(position > 9){
            position = 0;
        }
        SimpleDraweeView draweeView = (SimpleDraweeView) getView().findViewById(R.id.drawee_food);
        draweeView.setImageURI(Uri.parse(URL_FOOD + position + ""));

    }

    public void backImage(){
        position--;
        if(position < 0){
            position = 9;
        }
        SimpleDraweeView draweeView = (SimpleDraweeView) getView().findViewById(R.id.drawee_food);
        draweeView.setImageURI(Uri.parse(URL_FOOD + position + ""));

    }
}
