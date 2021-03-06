package com.moni.itbooksapp.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.moni.itbooksapp.R;
import com.moni.itbooksapp.app.net.BookGridItemsFetcher;


/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class BooksGridActivity extends AppCompatActivity {

    public static final String BOOK_COVER_ID = "BOOK_COVER_ID";

    public static final String BOOK_COVER_IMAGE_URL = "BOOK_COVER_IMAGE_URL";

    private int currentPage = 1;

    private String bookSearchUrl;

    private GridView gridView;

    private Button nextPageButton;

    private BookGridItemsFetcher bookGridItemsFetcher = BookGridItemsFetcher.newInstance()
            .withContext(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_grid);

        gridView = (GridView) findViewById(R.id.book_covers_grid_view);

        nextPageButton = (Button) findViewById(R.id.next_page_button);

        bookGridItemsFetcher = bookGridItemsFetcher.withTargetView(gridView);

        bookSearchUrl = getIntent().getStringExtra(BookSearchActivity.SEARCH_URL);

        bookGridItemsFetcher
                .withUrl(bookSearchUrl)
                .execute();

        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPage++;
                bookGridItemsFetcher
                        .withUrl(bookSearchUrl + "/page/" + currentPage)
                        .execute();
            }
        });

        gridView.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String clickedItemId = bookGridItemsFetcher.bookList.get(position).getId();
                final String clickedItemBookCoverImageUrl = bookGridItemsFetcher.bookList.get(position).getBookCoverImageUrl();
                Intent intent = new Intent(BooksGridActivity.this, BookDetailsActivity.class);
                intent.putExtra(BOOK_COVER_ID, clickedItemId);
                intent.putExtra(BOOK_COVER_IMAGE_URL, clickedItemBookCoverImageUrl);
                startActivity(intent);
            }
        });
    }

}
