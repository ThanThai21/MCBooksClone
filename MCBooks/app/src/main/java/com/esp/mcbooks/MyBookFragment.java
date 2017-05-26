package com.esp.mcbooks;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MyBookFragment extends Fragment {
    GridView gridView;
    BookAdapter bookAdapter;
    Button addNewButton;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mybook, container, false);
        gridView = (GridView)view.findViewById(R.id.content_book_grid_view);
        bookAdapter = new BookAdapter(getContext(), R.layout.book_item);
        addNewButton = (Button) view.findViewById(R.id.mybook_add_item_button);
        getBooklist();
        gridView.setAdapter(bookAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView)view.findViewById(R.id.item_title_text_view);
                Toast.makeText(getContext(), textView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        addNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ScanQRCodeActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    void getBooklist() {
        bookAdapter.add(new Book("Title 1", "Description 1"));
        bookAdapter.add(new Book("Title 2", "Description 2"));
        bookAdapter.add(new Book("Title 3", "Description 3"));
        bookAdapter.add(new Book("Title 4", "Description 4"));
        bookAdapter.add(new Book("Title 5", "Description 5"));
        bookAdapter.add(new Book("Title 6", "Description 6"));
        bookAdapter.add(new Book("Title 7", "Description 7"));
    }
}
