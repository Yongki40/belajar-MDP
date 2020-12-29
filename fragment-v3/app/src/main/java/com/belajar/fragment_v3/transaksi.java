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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link transaksi#newInstance} factory method to
 * create an instance of this fragment.
 */
public class transaksi extends Fragment {

    ArrayList<DataTrans> dataTrans = new ArrayList<>();

    public transaksi() {
        // Required empty public constructor
    }


    public static transaksi newInstance(ArrayList<DataTrans> dataTrans) {
        transaksi fragment = new transaksi();
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
        return inflater.inflate(R.layout.fragment_transaksi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText ednama = view.findViewById(R.id.edNama);
        final EditText edNilai = view.findViewById(R.id.edNilai);
        final RadioGroup rdJenis = view.findViewById(R.id.rdJenis);
        final TextView tvSaldo = view.findViewById(R.id.tvSaldo);
        Button btn = view.findViewById(R.id.btnTambah);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = rdJenis.getCheckedRadioButtonId();
                RadioButton rd = view.getRootView().findViewById(selected);
                String jenis = rd.getText().toString();
                int nilai = Integer.parseInt(edNilai.getText().toString());
                String nama = ednama.getText().toString();

                DataTrans data = new DataTrans(nama,jenis,nilai);
                dataTrans.add(data);
                Toast.makeText(getActivity(), dataTrans.size()+"", Toast.LENGTH_SHORT).show();

                int saldo = 0;
                for (DataTrans data1 : dataTrans) {
                    if(data1.jenis.equals("Pengeluaran")){
                        saldo -= data1.nilai;
                    }
                    else{
                        saldo += data1.nilai;
                    }
                }


                tvSaldo.setText(saldo+"");
                tvSaldo.setTextColor(Color.GREEN);

                if(saldo <= 0){
                    tvSaldo.setTextColor(Color.RED);
                }
            }
        });

        int saldo = 0;
        for (DataTrans data : dataTrans) {
            if(data.jenis.equals("Pengeluaran")){
                saldo -= data.nilai;
            }
            else{
                saldo += data.nilai;
            }
        }

        tvSaldo.setText(saldo+"");
        tvSaldo.setTextColor(Color.GREEN);

        if(saldo <= 0){
            tvSaldo.setTextColor(Color.RED);
        }
    }

    public void countSaldo(View view){

    }
}