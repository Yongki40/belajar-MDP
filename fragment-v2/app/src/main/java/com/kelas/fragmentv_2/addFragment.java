package com.kelas.fragmentv_2;

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
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addFragment extends Fragment {

    ArrayList<cart> lCart;

    public addFragment() {
        // Required empty public constructor
    }

    public static addFragment newInstance(ArrayList<cart> listcart) {
        addFragment fragment = new addFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("lCart",listcart);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.lCart=getArguments().getParcelableArrayList("lCart");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText etNama,etHarga;
        final RadioGroup rgJenis;
        final TextView tvSaldo;
        Button btnTambah;
        etNama=view.findViewById(R.id.edtnama);
        etHarga=view.findViewById(R.id.edtnilai);
        rgJenis=view.findViewById(R.id.rgJenis);
        btnTambah=view.findViewById(R.id.btntambah);
        tvSaldo=view.findViewById(R.id.tvsaldo);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedId = rgJenis.getCheckedRadioButtonId();
                RadioButton radioButton = view.getRootView().findViewById(selectedId);
                int harga= Integer.parseInt(etHarga.getText().toString());
                String nama =etNama.getText().toString();
                cart cart = new cart(nama,radioButton.getText().toString(),harga);
                lCart.add(cart);

                int hargas=0;
                for (cart carts:lCart) {
                    if(carts.jenis.equals("Pengeluaran")){
                        hargas-=carts.harga;
                    }else {
                        hargas += carts.harga;
                    }
                }
                tvSaldo.setText(Math.abs(hargas)+"");
                tvSaldo.setTextColor(Color.GREEN);
                if(hargas<0){
                    tvSaldo.setTextColor(Color.RED);
                }
            }
        });

        int harga=0;
        for (cart cart:lCart) {
            if(cart.jenis.equals("Pengeluaran")){
                harga-=cart.harga;
            }else {
                harga += cart.harga;
            }
        }
        tvSaldo.setText(Math.abs(harga)+"");
        tvSaldo.setTextColor(Color.GREEN);
        if(harga<0){
            tvSaldo.setTextColor(Color.RED);
        }
    }
}