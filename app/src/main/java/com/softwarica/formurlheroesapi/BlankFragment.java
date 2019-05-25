package com.softwarica.formurlheroesapi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements  View.OnClickListener {
    private Button btnlogin,btnaccount;
    private EditText username, password;
    private GetDataFrag setData;
    public BlankFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_blank, container, false);
        btnlogin = v.findViewById(R.id.btnlogin);
        btnaccount = v.findViewById(R.id.btnaccount);
        username = v.findViewById(R.id.etUsername);
        password = v.findViewById(R.id.etPassword);
        btnlogin.setOnClickListener(this);
        btnaccount.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnlogin){
            if(TextUtils.isEmpty(username.getText())){
                username.setError("Please Enter Username");
                return;
            }

            if(TextUtils.isEmpty(password.getText())){
                password.setError("Please Enter Password");
                return;
            }



        }else if (v.getId() == R.id.btnaccount){

        }
    }

    public interface GetDataFrag {
        void getData(String username, String password);
    }
}
