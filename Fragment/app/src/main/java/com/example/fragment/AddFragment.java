package com.example.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {


    EditText edtnama,edtnilai;
    RadioButton rbtopup,rbpengeluaran,rbpemasukan;
    Button btntambah;
    TextView tvsaldo;
    String jenis="";
    int uang;
    ArrayList<User> luser;

    OnMhsAddedListener onMhsAddedListener;

    public AddFragment() {

    }


    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(ArrayList<User> luser) {
        AddFragment fragment = new AddFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("luser", luser);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            luser = getArguments().getParcelableArrayList("luser");

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtnama = view.findViewById(R.id.edtnama);
        edtnilai = view.findViewById(R.id.edtnilai);
        rbtopup = view.findViewById(R.id.rbtopup);
        rbpengeluaran = view.findViewById(R.id.rbpengeluaran);
        rbpemasukan = view.findViewById(R.id.rbtpemasukan);
        btntambah = view.findViewById(R.id.btntambah);
        tvsaldo = view.findViewById(R.id.tvsaldo);

        uang =0;
        for (User users:luser) {
            if(users.getJenis().equals("pengeluaran")){
                uang-=users.getSaldo();
            }else{
                uang+=users.getSaldo();
            }
        }
        tvsaldo.setText(uang+"");
        tvsaldo.setTextColor(Color.GREEN);
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbtopup.isChecked()){
                    jenis="topup";
                }
                else if(rbpemasukan.isChecked()){
                    jenis="pemasukan";
                }
                else if(rbpengeluaran.isChecked()){
                    jenis="pengeluaran";
                }
                User user = new User(edtnama.getText().toString(),jenis,Integer.parseInt(edtnilai.getText().toString()));
                luser.add(user);
                uang =0;
                for (User users:luser) {
                    if(users.getJenis().equals("pengeluaran")){
                        uang-=users.getSaldo();
                    }else{
                        uang+=users.getSaldo();
                    }
                }

                tvsaldo.setText(Math.abs(uang)+"");
                tvsaldo.setTextColor(Color.GREEN);
                if(uang<0){
                    tvsaldo.setTextColor(Color.RED);
                }
//                if (onMhsAddedListener != null){
//                    onMhsAddedListener.onMhsAdded(user);
//                }

                Toast.makeText(getActivity(),"Data Inserted" , Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    public interface OnMhsAddedListener{
        void onMhsAdded(User user);
    }
    public void setOnMhsAddedListener(OnMhsAddedListener onMhsAddedListener){
        this.onMhsAddedListener = onMhsAddedListener;
    }
}