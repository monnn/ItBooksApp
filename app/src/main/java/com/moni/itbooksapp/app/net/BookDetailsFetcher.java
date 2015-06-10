package com.moni.itbooksapp.app.net;

import android.content.Context;
import android.util.Log;
import android.widget.ExpandableListView;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.moni.itbooksapp.app.adapter.BookDetailsExpandableListAdapter;
import com.moni.itbooksapp.app.model.BookDetails;
import com.moni.itbooksapp.abstractapp.WebFetcher;


/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class BookDetailsFetcher extends WebFetcher.JsonRequest<BookDetails> {

    private Context context;

    private ExpandableListView expListView;

    private BookDetailsExpandableListAdapter bookDetailsExpListAdapter;

    private List<AbstractMap.SimpleEntry<String, String>> bookDetailsPairs = new ArrayList<>();

//    private List<String> checkedBookDetailsHeaders = new ArrayList<>();

    public static BookDetailsFetcher newInstance() {
        return new BookDetailsFetcher();
    }

    private void init() {
        withResponseEntity(BookDetails.class);
    }

    public BookDetailsFetcher withContext(Context context) {
        init();
        this.context = context;
        return this;
    }

    public BookDetailsFetcher withTargetView(ExpandableListView gridView) {
        this.expListView = gridView;
        return this;
    }

    @Override
    public Response.Listener<BookDetails> createSuccessListener() {
        return new Response.Listener<BookDetails>() {
            @Override
            public void onResponse(BookDetails bookDetails) {
                populateBookDetailsData(bookDetails);
            }
        };
    }

    @Override
    public Response.ErrorListener createErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError != null)
                    Log.e("BookDetailsActivity", volleyError.getMessage());
            }
        };
    }

    private void populateBookDetailsData(BookDetails bookDetails) {
        List<String> bookDetailsHeaders = new ArrayList<>();
        bookDetailsHeaders.add("Title");
        bookDetailsHeaders.add("Subtitle");
        bookDetailsHeaders.add("Description");
        bookDetailsHeaders.add("ISBN");
        bookDetailsHeaders.add("Author");
        bookDetailsHeaders.add("Publisher");
        bookDetailsHeaders.add("Year");
        bookDetailsHeaders.add("Pages");

        addBookDetailsPair(bookDetailsHeaders.get(0), bookDetails.getTitle());
        addBookDetailsPair(bookDetailsHeaders.get(1), bookDetails.getSubTitle());
        addBookDetailsPair(bookDetailsHeaders.get(2), bookDetails.getDescription());
        addBookDetailsPair(bookDetailsHeaders.get(3), bookDetails.getIsbn());
        addBookDetailsPair(bookDetailsHeaders.get(4), bookDetails.getAuthor());
        addBookDetailsPair(bookDetailsHeaders.get(5), bookDetails.getPublisher());
        addBookDetailsPair(bookDetailsHeaders.get(6), bookDetails.getYear());
        addBookDetailsPair(bookDetailsHeaders.get(7), bookDetails.getNumberOfPages());

        bookDetailsExpListAdapter = new BookDetailsExpandableListAdapter(context, bookDetailsPairs);
        expListView.setAdapter(bookDetailsExpListAdapter);
    }

    private void addBookDetailsPair(String bookDetailsHeader, String bookDetailsValue) {
        if (bookDetailsValue != null) {
            if (!bookDetailsValue.isEmpty())
                bookDetailsPairs.add(new AbstractMap.SimpleEntry<>(bookDetailsHeader, bookDetailsValue));
        }
    }
}
