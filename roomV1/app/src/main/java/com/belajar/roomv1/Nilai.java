package com.belajar.roomv1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class Nilai extends Fragment {

    ArrayList<NilaiPrak> nilaiPraks = new ArrayList<>();
    public Nilai() {
        // Required empty public constructor
    }


    public static Nilai newInstance(ArrayList<NilaiPrak> nilaiPraks) {
        Nilai fragment = new Nilai();
        Bundle args = new Bundle();
        args.putParcelableArrayList("nilaiPraks",nilaiPraks);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.nilaiPraks = getArguments().getParcelableArrayList("nilaiPraks");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nilai, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvAbsen = view.findViewById(R.id.tvAbsen);
        final Spinner spMinggu = view.findViewById(R.id.spMinggu);

        String[] minggus = {
                "Minggu 1",
                "Minggu 2",
                "Minggu 3",
                "Minggu 4",
                "Minggu 5",
                "Minggu 6",
                "Minggu 7",
                "Ta",
        };
        ArrayAdapter adapter;
        adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_dropdown_item,minggus);
        spMinggu.setAdapter(adapter);

        tvAbsen.setText("Absen: "+nilaiPraks.get(spMinggu.getSelectedItemPosition()).getAbsen());
    }
}