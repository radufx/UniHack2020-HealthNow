package com.example.myapplication.ui.Pacienti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import DomeniuFireBase.PacientFireBase;

public class PacientiFragmentAdapter extends
        RecyclerView.Adapter<PacientiFragmentAdapter.ViewHolder> {

    @Override
    public PacientiFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.format_pacient, parent, false);

        PacientiFragmentAdapter.ViewHolder viewHolder = new PacientiFragmentAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PacientiFragmentAdapter.ViewHolder holder, int position) {
        PacientFireBase pacient = mPacienti.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        TextView textView2 = holder.nameTextView2;
        TextView textView3 = holder.nameTextView3;
        TextView textView4 = holder.nameTextView4;
        textView.setText(pacient.getNume() + " " + pacient.getPrenume());
        textView2.setText(pacient.getCnp());
        textView3.setText(pacient.getData_nasterii());
        textView4.setText(pacient.getAdresa());
    }

    @Override
    public int getItemCount() {
        return mPacienti.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, nameTextView2, nameTextView3, nameTextView4;

        public ViewHolder(View itemView) {
            super(itemView);


            nameTextView = itemView.findViewById(R.id.txtNumePrenume1);
            nameTextView2 = itemView.findViewById(R.id.txtCNP2);
            nameTextView3 = itemView.findViewById(R.id.txtDataNasterii3);
            nameTextView4 = itemView.findViewById(R.id.txtAdresa4);
        }
    }
    private List<PacientFireBase> mPacienti = new ArrayList<>();

    public PacientiFragmentAdapter(List<PacientFireBase> pacienti) {
        this.mPacienti = pacienti;
    }
}
