package com.example.lenc.fitnesdnevnik;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lenc on 30. 05. 2016.
 */
public class AdapterUtezi extends RecyclerView.Adapter<AdapterUtezi.ViewHolder> {

    private  DataAll mDataset;
    Activity ac;

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtVaja;
        public LinearLayout layout;
        public ViewHolder(View v){
            super(v);
            txtVaja = (TextView) v.findViewById(R.id.textViewVaja);
            layout=(LinearLayout)v.findViewById(R.id.layout);
        }
    }
    public AdapterUtezi(DataAll myDataset, Activity ac){
        this.ac = ac;
        mDataset=myDataset;
    }
    @Override
    public AdapterUtezi.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtVaja.setText(mDataset.getUtezi().get(position).getNazivUtezi());
        final String whateverIDO=holder.txtVaja.getText().toString();
        holder.layout.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                Intent dva = new Intent(ac,ActivityUteziPodatki.class);
                dva.putExtra("Vaja",whateverIDO);
                ac.startActivity(dva);
            }
        });
        holder.layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mDataset.zbrisiUtezi(position);
                notifyDataSetChanged();
                TextView txtVaja = (TextView)v.findViewById(R.id.textViewVaja);
                Toast toast = Toast.makeText(ac.getApplication(),"Izbrisali ste vajo "+txtVaja.getText().toString(),Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.getUtezi().size();
    }

}
