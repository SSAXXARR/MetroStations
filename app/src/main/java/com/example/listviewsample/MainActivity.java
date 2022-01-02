package com.example.listviewsample;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {
    String[] mStationsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStationsArray = getResources().getStringArray(R.array.stations); //вызываем объект ресурс
        // затем у этого объекта уже получаем ресурс в массив строк.

        ArrayAdapter<String> aa = new ArrayAdapter<>(this,
                R.layout.list_item, mStationsArray); //создается массив с элементами stations.
        getListView().setAdapter(aa);
        //ListView представляет собой прокручиваемый список элементов.
        //затем устанавливаем в него наш адаптер ArrayAdapter.
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //родительский адаптер который у нас есть(аа).
        //view конкретный item по которому кликнули
        //i - позиция внутри списка
        //l обычно совпадает с позицией, это id.

        //вытаскиваем текст из нашего элемента и делаем тост
        Toast.makeText(this, ((TextView) view).getText(), Toast.LENGTH_SHORT).show();



    }
}