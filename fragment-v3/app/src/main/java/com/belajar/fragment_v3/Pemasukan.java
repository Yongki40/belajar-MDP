package com.belajar.fragment_v3;

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
 * Use the {@link Pemasukan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pemasukan extends Fragment {

    ArrayList<DataTrans> dataTrans = new ArrayList<>();

    public Pemasukan() {
        // Required empty public constructor
    }


    public static Pemasukan newInstance(ArrayList<DataTrans> dataTrans) {
        Pemasukan fragment = new Pemasukan();
        Bundle args = new Bundle();
        args.putParcelableArrayList("dataTrans",dataTrans);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           this.dataTrans = getArguments().getParcelableArrayList("dataTrans");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pemasukan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<DataTrans> lPemasukan = new ArrayList<>();
        for (DataTrans data :
                dataTrans) {
            if(data.jenis.equals("Pemasukan")){
                lPemasukan.add(data);
            }
        }
        ListView listView = view.findViewById(R.id.lv);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,lPemasukan);
        listView.setAdapter(adapter);

        int saldo = 0;
        for (DataTrans pemasukan:
             lPemasukan) {
            saldo += pemasukan.nilai;
        }
        TextView tvSaldo = view.findViewById(R.id.tvSaldo);
        tvSaldo.setText(saldo+"");
        tvSaldo.setTextColor(Color.GREEN);
    }
}