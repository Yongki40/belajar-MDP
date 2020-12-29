package com.kelas.fragmentv_2;

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
 * Use the {@link pengeluaranFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class pengeluaranFragment extends Fragment {
    ArrayList<cart> lcart;
    public pengeluaranFragment() {
        // Required empty public constructor
    }

    public static pengeluaranFragment newInstance(ArrayList<cart> lcart) {
        pengeluaranFragment fragment = new pengeluaranFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("lCart",lcart);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            lcart=getArguments().getParcelableArrayList("lCart");
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
        ListView lv=view.findViewById(R.id.lvpemasukan);
        TextView tvSaldo=view.findViewById(R.id.tvsaldo);
        ArrayList<cart> lPemasukan=new ArrayList<>();
        for (cart cart:lcart) {
            if(cart.jenis.equals("Pengeluaran")) {
                lPemasukan.add(cart);
            }
        }
        ArrayAdapter adapter = new ArrayAdapter(
                getActivity(),
                android.R.layout.simple_list_item_1,
                lPemasukan
        );
        lv.setAdapter(adapter);

        int harga=0;
        for (cart cart:lcart) {
            if(cart.jenis.equals("Pengeluaran")){
                harga+=cart.harga;
            }
        }
        tvSaldo.setText(Math.abs(harga)+"");
        tvSaldo.setTextColor(Color.RED);
    }
}