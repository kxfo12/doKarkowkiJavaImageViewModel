package com.example.dokarkowki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.dokarkowki.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ImageViewModel imageViewModel;

    ArrayList<Integer> characters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        imageViewModel = new ViewModelProvider(this).get(ImageViewModel.class);

        characters = new ArrayList<>();
        characters.add(R.drawable.changli);
        characters.add(R.drawable.carlotta);
        characters.add(R.drawable.camellya);
        characters.add(R.drawable.encore);
        characters.add(R.drawable.phoebe);
        characters.add(R.drawable.rover);
        characters.add(R.drawable.shorekeeper);
        characters.add(R.drawable.taoqi);
        characters.add(R.drawable.sanhua);
        characters.add(R.drawable.lumi);
        characters.add(R.drawable.danjin);
        characters.add(R.drawable.yinlin);
        characters.add(R.drawable.yangyang);

        imageViewModel.getCurrent().observe(
                this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        binding.imageView.setImageResource(characters.get(integer));
                    }
                }
        );

        binding.prev.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(imageViewModel.takeCurrent() == 0){
                            imageViewModel.setCurrent(characters.size()-1);
                        }
                        else{
                            imageViewModel.decreaseCurrent();
                        }
                    }
                }
        );
        binding.next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(imageViewModel.takeCurrent() == characters.size()-1){
                            imageViewModel.setCurrent(0);
                        }
                        else{
                            imageViewModel.increaseCurrent();
                        }
                    }
                }
        );
    }
}