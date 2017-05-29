package quy.android.smartdevlession2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import quy.android.smartdevlession2.Data;
import quy.android.smartdevlession2.R;
import quy.android.smartdevlession2.adapter.RecyclerAdapter;

/**
 * Created by iamme on 17/05/28.
 */

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;
    private EditText editName;

    private List<Data> listData = new ArrayList<Data>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        // connect views.
        editName = (EditText) findViewById(R.id.edit_name);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        // If the size of views will not change as the data changes.
        recyclerView.setHasFixedSize(true);

        // Setting the LayoutManager.
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Setting the adapter.
        recyclerAdapter = new RecyclerAdapter(listData);
        recyclerView.setAdapter(recyclerAdapter);

        // set listener for button add
        ((Button) findViewById(R.id.btn_add)).setOnClickListener(this);
    }

    // Called when add button is clicked.
    public void addItem() {

        // get data.
        Data dataToAdd = new Data(editName.getText().toString());

        // Update adapter.
        recyclerAdapter.addItem(listData.size(), dataToAdd);
    }

    @Override
    public void onClick(View v) {
        addItem();
    }
}
