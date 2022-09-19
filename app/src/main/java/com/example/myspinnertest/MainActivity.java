package com.example.myspinnertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Spinner spin1,spin2, spin3, spin4;
    Integer actual1,actual2,actual3,actual4, previo1, previo2, previo3, previo4;

    Set<Spinner> miSet= new LinkedHashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin1 = findViewById(R.id.spinner);
        spin2 = findViewById(R.id.spinner2);
        spin3 = findViewById(R.id.spinner3);
        spin4 = findViewById(R.id.spinner4);

        actual1 = (int)spin1.getSelectedItemId();
        actual2 = (int)spin2.getSelectedItemId();
        actual3 = (int)spin3.getSelectedItemId();
        actual4 = (int)spin4.getSelectedItemId();

        miSet.add(spin1);
        miSet.add(spin2);
        miSet.add(spin3);
        miSet.add(spin4);



        Iterator<Spinner> recorreSpinners = miSet.iterator();

        Integer indexRecorre = 0;

        while (recorreSpinners.hasNext()) {
            recorreSpinners.next().setSelection(indexRecorre);
            indexRecorre++;
        }

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                previo1 = actual1;
                actual1 = (int) parent.getSelectedItemPosition();

                SeteaSpinners(actual1,  previo1,  0);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                previo2 = actual2;
                actual2 = (int) parent.getSelectedItemPosition();

                SeteaSpinners(actual2,  previo2,  1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                previo3 = actual3;
                actual3 = (int) parent.getSelectedItemPosition();

                SeteaSpinners(actual3,  previo3,  2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                previo4 = actual4;
                actual4 = (int) parent.getSelectedItemPosition();

                SeteaSpinners(actual4,  previo4,  3);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void SeteaSpinners(int nuevoValor, int viejoValor, int spinIndex) {

        Iterator<Spinner> recorreSpinners = miSet.iterator();

        Integer index = 0;

        while (recorreSpinners.hasNext()) {

            if(recorreSpinners.next().getSelectedItemPosition() == nuevoValor && index != spinIndex ) {
                recorreSpinners.next().setSelection(viejoValor);

            }
            index ++;

        }



    }

}