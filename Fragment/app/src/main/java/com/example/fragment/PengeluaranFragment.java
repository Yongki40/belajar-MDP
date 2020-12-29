package com.example.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PengeluaranFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PengeluaranFragment extends Fragment {
    private ArrayList<User> listuser = new ArrayList<>();
    private ArrayList<User> listpengeluaran = new ArrayList<>();
    ListView lvpemasukan;
    TextView tvsaldo;
    int uang=0;

    public PengeluaranFragment() {

    }

    // TODO: Rename and change types and number of parameters
    public static PengeluaranFragment newInstance(ArrayList<User>listuser) {
        PengeluaranFragment fragment = new PengeluaranFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("listuser", listuser);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listuser = getArguments().getParcelableArrayList("listuser");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pengeluaran, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvpemasukan = view.findViewById(R.id.lvpemasukan);
        tvsaldo = view.findViewById(R.id.tvsaldo);


        uang =0;
        for (User users:listuser) {
            if(users.getJenis().equals("pengeluaran")){
                uang+=users.getSaldo();
            }
        }
        tvsaldo.setText(Math.abs(uang)+"");
        tvsaldo.setTextColor(Color.RED);
        ArrayAdapter<User> userAdapter;

        for (int i = 0; i < listuser.size(); i++) {
            if(listuser.get(i).getJenis().equals("pengeluaran")){
                User pemasukan = new User(listuser.get(i).getNama(),listuser.get(i).getJenis(),listuser.get(i).getSaldo());
                listpengeluaran.add(pemasukan);
            }
        }
        userAdapter = new ArrayAdapter<User>(
                getActivity(),
                android.R.layout.simple_list_item_1
                ,listpengeluaran);
        lvpemasukan.setAdapter(userAdapter);

    }
}