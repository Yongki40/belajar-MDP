package com.belajar.roomv1;

import android.os.AsyncTask;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputNilai#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputNilai extends Fragment {

    ArrayList<NilaiPrak> nilaiPraks = new ArrayList<>();

    AppDatabase db;
    public InputNilai() {
        // Required empty public constructor
    }


    public static InputNilai newInstance(ArrayList<NilaiPrak> nilaiPraks ) {
        InputNilai fragment = new InputNilai();
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
        return inflater.inflate(R.layout.fragment_input_nilai, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Spinner spMinggu = view.findViewById(R.id.spMinggu);
        db = AppDatabase.getAppDatabase(getActivity());
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
        final RadioGroup rdgroup = view.findViewById(R.id.rdJenis);

        final int selected = rdgroup.getCheckedRadioButtonId();
        final EditText edNilai = view.findViewById(R.id.edNilai);
        Button btnSubmit = view.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton rdPilihan = rdgroup.getRootView().findViewById(selected);
                String pilihan = rdPilihan.getText().toString();
                if(pilihan.equals("absen")){
                    int nilai = Integer.parseInt(edNilai.getText().toString());
                    nilaiPraks.get(spMinggu.getSelectedItemPosition()).setAbsen(nilai);
//                    new addNilaiPrakTask().execute(nilaiPraks.get(spMinggu.getSelectedItemPosition()));
                }
                else if(pilihan.equals("tes awal")){
                    int nilai = Integer.parseInt(edNilai.getText().toString());
                    nilaiPraks.get(spMinggu.getSelectedItemPosition()).setTes(nilai);;
                }
                else if(pilihan.equals("materi")){
                    int nilai = Integer.parseInt(edNilai.getText().toString());
                    nilaiPraks.get(spMinggu.getSelectedItemPosition()).setMateri(nilai);;
                }
                else if(pilihan.equals("tugas")){
                    int nilai = Integer.parseInt(edNilai.getText().toString());
                    nilaiPraks.get(spMinggu.getSelectedItemPosition()).setTugas(nilai);;
                }
            }
        });

    }

    private class addNilaiPrakTask extends AsyncTask<NilaiPrak,Void,Void> {
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(NilaiPrak... nilaiPraks) {
            db.nilaiPrak().update(nilaiPraks[0]);
            return null;
        }
    }
}