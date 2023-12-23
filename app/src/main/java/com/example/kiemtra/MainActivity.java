package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edttitle, edtcontent,edtdate,edttype;
    Button btnAdd, btnUpdate, btnDelete;
    ListView todoListView;
    ToDoAO toDoAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todoListView = findViewById(R.id.todoListView);
        ToDoDAO todoDAO = new ToDoDAO(this);
        ArrayList<ToDo> list = todoDAO.getListToDo();
        ToDoAdapter toDoAdapter = new ToDoAdapter(this, list);
        todoListView.setAdapter(toDoAdapter);

        edttitle = findViewById(R.id.edttitle);
        edtcontent = findViewById(R.id.edtcontent);
        edtdate = findViewById(R.id.edtdate);
        edttype = findViewById(R.id.edttype);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        toDoAO = new ToDoAO(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDoAO.addToDo(null);
            }
        });
    }
}