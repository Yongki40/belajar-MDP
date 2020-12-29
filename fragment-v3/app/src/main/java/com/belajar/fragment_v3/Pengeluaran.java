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
 * Use the {@link Pengeluaran#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pengeluaran extends Fragment {


    ArrayList<DataTrans> dataTrans = new ArrayList<>();
    public Pengeluaran() {
        // Required empty public constructor
    }


    public static Pengeluaran newInstance(ArrayList<DataTrans> dataTrans) {
        Pengeluaran fragment = new Pengeluaran();
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
        return inflater.inflate(R.layout.fragment_pengeluaran, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView lv = view.findViewById(R.id.lv);

        ArrayList<DataTrans> lPengeluaran = new ArrayList<>();
        for (DataTrans data:
             dataTrans) {
            if(data.jenis.equals("Pengeluaran")){
                lPengeluaran.add(data);
            }
        }

        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,lPengeluaran);
        lv.setAdapter(adapter);

        TextView tvSaldo = view.findViewById(R.id.tvSaldo);

        int saldo = 0;
        for (DataTrans data:
             lPengeluaran) {
            saldo += data.nilai;
        }

        tvSaldo.setText(saldo+"");
        tvSaldo.setTextColor(Color.RED);
    }
}