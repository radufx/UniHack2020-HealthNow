package com.example.myapplication.ui.Simptome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.ui.Pacienti.PacientiViewModel;

import java.util.ArrayList;

public class SimptomeFragment extends Fragment {

    private SimptomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_simptome, container, false);
        ListView lista_simptome = (ListView) view.findViewById(R.id.lista_simptome);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Ana");
        arrayList.add("are");
        arrayList.add("mere");
        arrayList.add("Ana");
        arrayList.add("are");
        arrayList.add("mere");
        arrayList.add("Ana");
        arrayList.add("are");
        arrayList.add("mere");
        arrayList.add("Ana");
        arrayList.add("are");
        arrayList.add("mere");
        arrayList.add("Ana");
        arrayList.add("are");
        arrayList.add("mere");
        arrayList.add("Ana");
        arrayList.add("are");
        arrayList.add("mere");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayList);

        lista_simptome.setAdapter(arrayAdapter);
        return view;
    }
}





