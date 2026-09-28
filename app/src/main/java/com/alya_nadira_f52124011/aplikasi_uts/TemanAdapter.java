package com.alya_nadira_f52124011.aplikasi_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TemanAdapter extends BaseAdapter {

    private Context context;
    private Teman[] data;

    public TemanAdapter(Context context, Teman[] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(
            int position,
            View convertView,
            ViewGroup parent) {

        ViewHolder holder;

        // Membuat view hanya jika belum tersedia
        if (convertView == null) {

            convertView = LayoutInflater
                    .from(context)
                    .inflate(
                            R.layout.item_teman,
                            parent,
                            false
                    );

            holder = new ViewHolder();

            holder.imgFoto =
                    convertView.findViewById(R.id.imgFoto);

            holder.txtNama =
                    convertView.findViewById(R.id.txtNama);

            holder.txtNim =
                    convertView.findViewById(R.id.txtNim);

            holder.txtKelas =
                    convertView.findViewById(R.id.txtKelas);

            holder.txtEmail =
                    convertView.findViewById(R.id.txtEmail);

            convertView.setTag(holder);

        } else {

            holder =
                    (ViewHolder) convertView.getTag();
        }

        // Mengambil data
        Teman teman = data[position];

        // Menampilkan data
        holder.imgFoto.setImageResource(teman.foto);

        holder.txtNama.setText(teman.nama);

        holder.txtNim.setText(teman.nim);

        holder.txtKelas.setText(teman.kelas);

        holder.txtEmail.setText(teman.email);

        return convertView;
    }


    // ViewHolder untuk efisiensi
    static class ViewHolder {

        ImageView imgFoto;

        TextView txtNama;

        TextView txtNim;

        TextView txtKelas;

        TextView txtEmail;
    }
}