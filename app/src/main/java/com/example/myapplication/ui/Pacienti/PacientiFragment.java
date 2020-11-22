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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Inscriere;
import com.example.myapplication.PaginaStartMedic;
import com.example.myapplication.PaginaStartPacient;
import com.example.myapplication.R;
import com.example.myapplication.ui.Simptome.Contact;
import com.example.myapplication.ui.Simptome.ContactsAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import DomeniuFireBase.MedicFireBase;
import DomeniuFireBase.PacientFireBase;
import domain.Pacient;

public class PacientiFragment extends Fragment {

    private DatabaseReference dBase;
    ArrayList<PacientFireBase> pacienti;
    private View view;
    private ListView lista_pacienti;

    public void Executare(View view, final RecyclerView rvPacienti) {
        dBase = FirebaseDatabase.getInstance().getReference();
        dBase.child("pacient").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long nrPacienti = dataSnapshot.getChildrenCount();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    pacienti = new ArrayList<PacientFireBase>();
                    PacientFireBase pacient = snapshot.getValue(PacientFireBase.class);
                    pacienti.add(new PacientFireBase(pacient.getNume(), pacient.getPrenume(), pacient.getAdresa(), pacient.getData_nasterii(), pacient.getCnp()));

                    System.out.println(pacient.getNume() + pacient.getPrenume() + pacient.getCnp() + pacient.getData_nasterii() + pacient.getAdresa());
                    System.out.println(snapshot);
                }
                PacientiFragmentAdapter adapter = new PacientiFragmentAdapter(pacienti);
                // Attach the adapter to the recyclerview to populate items
                rvPacienti.setAdapter(adapter);
                // Set layout manager to position the items
                rvPacienti.setLayoutManager(new LinearLayoutManager(getActivity()));
                // That's all!
                //System.out.println(nrPacienti + "In functie");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_pacienti, container, false);
        RecyclerView rvPacienti = view.findViewById(R.id.recycler2);
        Executare(view, rvPacienti);
        return view;
    }
}