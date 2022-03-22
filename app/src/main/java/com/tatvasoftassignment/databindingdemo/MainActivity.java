package com.tatvasoftassignment.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.tatvasoftassignment.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.btnSubmit.setOnClickListener( v->{
           if(isValidate())
            binding.txtOutput.setText(binding.etText.getText().toString());
        });
        Fragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment).commit();

    }
    private Boolean isValidate(){
        boolean valid = true;
        if(binding.etText.getText().toString().length() == 0){
            Toast.makeText(this, R.string.text, Toast.LENGTH_SHORT).show();
            valid = false;
        }
        return valid;
    }
}