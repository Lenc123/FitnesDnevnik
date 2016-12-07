package com.example.lenc.fitnesdnevnik;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.ViewHolder>{

    private  DataAll mDataset;
    Activity ac;

    //private android.support.v4.app.Fragment mFragment;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public View v;

        public TextView txtVaja;
        public LinearLayout layout;

        public ViewHolder(View v){
            super(v);
            txtVaja = (TextView) v.findViewById(R.id.textViewVaja);
            layout=(LinearLayout)v.findViewById(R.id.layout);
        }
    }
    public AdapterActivity(DataAll myDataset, Activity ac){
        this.ac = ac;
        mDataset=myDataset;
    }
    @Override
    public AdapterActivity.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.txtVaja.setText(mDataset.getKardio().get(position).getNazivKardio());
        final String whateverIDO=holder.txtVaja.getText().toString();
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dva = new Intent(ac,ActivityCasKardio.class);
                dva.putExtra("Vaja",whateverIDO);
                ac.startActivity(dva);
            }
        });
        holder.layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                mDataset.zbrisiKardio(position);
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
        return mDataset.getKardio().size();
    }


}
