package com.example.a1_avaliativo_mobile;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    String[] SELECTION_LIST = new String[] {"Gasolina ou Alcool",
            "Converter Celsius, Kelvin, Fahrenheit",
            "Divisao de compras",
            "Calculo fuso horario",
            "Divisao de contas no bar"};
    ArrayAdapter<String> myArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SELECTION_LIST);
        setListAdapter(myArrayAdapter);

        registerForContextMenu(getListView());
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, GasolineOrEthanol.class));
                //finish();
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, TemperatureConversion.class));
                //finish();
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, SplitBill.class));
                //finish();
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, Timezone.class));
                //finish();
                break;
            case 4:
                startActivity(new Intent(MainActivity.this, BarBill.class));
                //finish();
                break;
        }
    }

}