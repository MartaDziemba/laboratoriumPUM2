package com.example.student.aplikacjapogodowa;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Marta on 28.12.2017.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private ArrayList<Place> places = new ArrayList<>();

    PlaceAdapter(ArrayList<Place> places)
    {
        this.places=places;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, null);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setNazwaMiasta(places.get(position).getPlaceName());
        holder.setInformacja(places.get(position).getInformation() + "");

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.NazwaMiasta)
        TextView nazwaMiasta;

        @BindView(R.id.Informacja)
        TextView informacja;

        @OnClick(R.id.WybierzMiejsce)
        void wybierzMiejsce()
        {
            openAlertDialog();
        }

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private  void setNazwaMiasta(String nazwa)
        {
            nazwaMiasta.setText(nazwa);
        }
        private void setInformacja(String info)
        {
            informacja.setText(info);
        }

        private void openAlertDialog()
        {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(itemView.getContext(), android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(itemView.getContext());
            }
            builder.setTitle("Czy na pewno to chciałeś wybrać?")
                    .setMessage("Wybierz jeszcze raz.")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //n
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }
}
