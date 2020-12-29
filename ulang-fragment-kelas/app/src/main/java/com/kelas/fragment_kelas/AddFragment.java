package com.kelas.fragment_kelas;

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
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public AddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
    // TODO: Rename and change types and number of parameters

    EditText editText_nrp,editText_name;
    RadioGroup radioGroup_gender;
    RadioButton radioButton_male;
    Spinner spinner_major;
    Button button_add;

    OnMhsAddedListener onMhsAddedListener;

    public static AddFragment newInstance() {
        AddFragment fragment = new AddFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    //declare dalem sini setelah semua view nya terbuat
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText_nrp = view.findViewById(R.id.editText_nrp);
        editText_name = view.findViewById(R.id.editText_name);
        radioGroup_gender = view.findViewById(R.id.radioGroup_gender);
        spinner_major = view.findViewById(R.id.spinner_major);
        button_add = view.findViewById(R.id.button_add);

        button_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int selectedId = radioGroup_gender.getCheckedRadioButtonId();
                RadioButton radioButton = view.getRootView().findViewById(selectedId);
                Mahasiswa mhs = new Mahasiswa(Integer.parseInt(editText_nrp.getText().toString()),editText_name.getText().toString(),
                        radioButton.getText().toString(),spinner_major.getSelectedItem().toString());

                if(onMhsAddedListener !=null){
                    onMhsAddedListener.onMhsAdded(mhs);
                }
            }
        });
    }

    public void setOnMhsAddedListener(OnMhsAddedListener onMhsAddedListener) {
        this.onMhsAddedListener = onMhsAddedListener;
    }

    public interface OnMhsAddedListener{
        void onMhsAdded(Mahasiswa mhs);
    }
}