package com.example.myapplication.ui.Pacienti;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;

import java.util.ArrayList;

public class PacientiFragment extends Fragment {

    private PacientiViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simptome, container, false);
        ListView lista_simptome = (ListView) view.findViewById(R.id.lista);

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

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_expandable_list_item_1, arrayList);

        lista_simptome.setAdapter(arrayAdapter);

        lista_simptome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), DiscussAddValue.class);
                startActivity(intent);
            }
        });
        return view;
    }
}