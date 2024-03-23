package com.ninda.prak1m2;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    int gajiStatus, gajiGolongan;
    RadioGroup golongan;
    CheckBox status;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hitung(View v) {
        EditText nama = (EditText) findViewById(R.id.nama);
        TextView outputNama = (TextView) findViewById(R.id.outputNama);
        TextView outputStatus = (TextView) findViewById(R.id.outputStatus);
        TextView outputGolongan = (TextView) findViewById(R.id.outputGolongan);
        TextView total = (TextView) findViewById(R.id.outputGaji);
        TextView textViewHasilPerhitungan = findViewById(R.id.hasilPerhitungan);

        String hasilPerhitungan = "Hasil Perhitungan";
        textViewHasilPerhitungan.setText(hasilPerhitungan);

        String name = nama.getText().toString();
        outputNama.setText("Nama \t\t\t\t: " + name);

        status = (CheckBox) findViewById(R.id.menikah);
        if (status.isChecked()) {
            gajiStatus = 500000;
            outputStatus.setText("Status \t\t\t\t: Menikah");
        } else {
            gajiStatus = 0;
            outputStatus.setText("Status \t\t\t\t: Belum Menikah");
        }

        golongan = (RadioGroup) findViewById(R.id.rgGolongan);
        int gol = golongan.getCheckedRadioButtonId();
        if (gol == R.id.rbGolongan1) {
            gajiGolongan = 1000000;
            outputGolongan.setText("Golongan \t: Golongan 1");
        } else if (gol == R.id.rbGolongan2) {
            gajiGolongan = 2000000;
            outputGolongan.setText("Golongan \t: Golongan 2");
        }

        int totalGaji = gajiStatus + gajiGolongan;

        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        formatRupiah.setMaximumFractionDigits(0);
        String totalGajiFormatted = formatRupiah.format(totalGaji);

        TextView outputGaji = (TextView) findViewById(R.id.outputGaji);
        outputGaji.setText("Total Gaji \t: " + totalGajiFormatted + ",-");
    }
}