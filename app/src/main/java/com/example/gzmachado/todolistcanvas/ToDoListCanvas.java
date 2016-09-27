package com.example.gzmachado.todolistcanvas;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ToDoListCanvas extends AppCompatActivity  implements
        NewItemFragment.OnNewItemAddedListener {
    public ArrayAdapter<String> aa;
    public ArrayList<String> todoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list_canvas);

        // Get references to the Fragment
        FragmentManager fm = getFragmentManager();
        ToDoListFragment todoListFragment = (ToDoListFragment) fm.findFragmentById(R.id.TodoListFragment);

        todoItems = new ArrayList<>();

        aa = new ArrayAdapter<>(this, R.layout.todo_list_item, todoItems);

        todoListFragment.setListAdapter(aa);
    }

    public void onNewItemAdded(String newItem) {
        todoItems.add(newItem);
        aa.notifyDataSetChanged();
    }
}