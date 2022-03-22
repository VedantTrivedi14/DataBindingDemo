package com.tatvasoftassignment.databindingdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.tatvasoftassignment.databindingdemo.databinding.FragmentMainBinding;


public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    public MainFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main,container,false);
        binding.btnSubmit.setOnClickListener( v->{
            if(isValidate())
                binding.txtOutput.setText(binding.etText.getText().toString());
        });
        return  binding.getRoot();
    }
    private Boolean isValidate(){
        boolean valid = true;
        if(binding.etText.getText().toString().length() == 0){
            Toast.makeText(getContext(), R.string.text, Toast.LENGTH_SHORT).show();
            valid = false;
        }
        return valid;
    }
}