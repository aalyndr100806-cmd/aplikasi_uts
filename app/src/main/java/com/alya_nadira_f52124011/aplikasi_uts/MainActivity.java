package com.alya_nadira_f52124011.aplikasi_uts;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView listTeman;

    private EditText edtSearch;

    private TextView txtJumlah;


    // ==========================================
    // ARRAY DATA TEMAN
    // ==========================================

    private Teman[] dataTeman = {

            new Teman(
                    "Nadila",
                    "F52124028",
                    "Sistem Informasi • SI-A",
                    "nadila@gmail.com",
                    R.drawable.foto1
            ),

            new Teman(
                    "Riski Ananda Putri",
                    "G50124",
                    "Biologi • B-A",
                    "kiki@gmail.com",
                    R.drawable.foto2
            ),

            new Teman(
                    "Azkia Nur Arsyifa",
                    "S005",
                    "TK • -A",
                    "syifa@gmail.com",
                    R.drawable.foto3
            ),

            new Teman(
                    "Belviana Azahra",
                    "S003",
                    "Paud • -A",
                    "zara@gmail.com",
                    R.drawable.foto4
            )
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        // ==========================================
        // MENGHUBUNGKAN KOMPONEN XML
        // ==========================================

        listTeman =
                findViewById(R.id.listTeman);

        edtSearch =
                findViewById(R.id.edtSearch);

        txtJumlah =
                findViewById(R.id.txtJumlah);


        // ==========================================
        // MENAMPILKAN DATA AWAL
        // ==========================================

        tampilkanData(dataTeman);


        // ==========================================
        // FITUR PENCARIAN
        // ==========================================

        edtSearch.addTextChangedListener(
                new TextWatcher() {

                    @Override
                    public void beforeTextChanged(
                            CharSequence s,
                            int start,
                            int count,
                            int after) {
                    }


                    @Override
                    public void onTextChanged(
                            CharSequence s,
                            int start,
                            int before,
                            int count) {

                        cariTeman(
                                s.toString()
                        );
                    }


                    @Override
                    public void afterTextChanged(
                            Editable s) {
                    }
                }
        );
    }


    // ==========================================
    // MENAMPILKAN DATA KE LISTVIEW
    // ==========================================

    private void tampilkanData(
            Teman[] data) {

        TemanAdapter adapter =
                new TemanAdapter(
                        this,
                        data
                );

        listTeman.setAdapter(adapter);


        // Update jumlah data
        txtJumlah.setText(
                data.length + " orang"
        );
    }


    // ==========================================
    // FUNGSI PENCARIAN
    // ==========================================

    private void cariTeman(
            String keyword) {

        keyword =
                keyword.toLowerCase().trim();


        ArrayList<Teman> hasil =
                new ArrayList<>();


        for (Teman teman : dataTeman) {

            if (
                    teman.nama
                            .toLowerCase()
                            .contains(keyword)

                            ||

                            teman.nim
                                    .toLowerCase()
                                    .contains(keyword)
            ) {

                hasil.add(teman);
            }
        }


        // ArrayList → Array
        Teman[] hasilArray =
                hasil.toArray(
                        new Teman[0]
                );


        tampilkanData(hasilArray);
    }
}