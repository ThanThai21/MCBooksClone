package com.esp.mcbooks;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 20/5/2017.
 */

public class BookAdapter extends ArrayAdapter{

    private List<Book> bookList;

    public BookAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        bookList = new ArrayList<Book>();
    }

    @Nullable
    @Override
    public Book getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    public void add(Book book) {
        bookList.add(book);
    }

    public void remove(Book book) {
        bookList.remove(book);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.book_item, null);
        }

        Book book = bookList.get(position);

        TextView title = (TextView)view.findViewById(R.id.item_title_text_view);
        TextView description = (TextView)view.findViewById(R.id.item_description_text_view);

        title.setText(book.getTitle());
        description.setText(book.getDescription());

        return view;
    }
}
