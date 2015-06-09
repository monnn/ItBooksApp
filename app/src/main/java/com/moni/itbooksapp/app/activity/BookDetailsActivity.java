package com.moni.itbooksapp.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.moni.itbooksapp.R;
import com.moni.itbooksapp.app.net.BookDetailsFetcher;
import com.moni.itbooksapp.net.WebFetcher;


/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class BookDetailsActivity extends AppCompatActivity {

    private BookDetailsFetcher bookDetailsFetcher = BookDetailsFetcher.newInstance()
            .withContext(this);

     public final WebFetcher.LoadImage imageLoader = WebFetcher.LoadImage.newInstance()
            .withDefaultImage(R.drawable.no_image)
            .withErrorImage(R.drawable.error_image);

    private ImageView bookCoverView;

    private Button downloadButton;

    private ExpandableListView bookDetailsExpListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        downloadButton = (Button) findViewById(R.id.download_button);
        bookCoverView = (ImageView) findViewById(R.id.book_cover_details);
        bookDetailsExpListView = (ExpandableListView) findViewById(R.id.book_details_exp_list);

        Bundle bundle = getIntent().getExtras();
        String clickedBookId = bundle.getString(BooksGridActivity.BOOK_COVER_ID);
        String clickedBookCoverUrl = bundle.getString(BooksGridActivity.BOOK_COVER_IMAGE_URL);

        /**
         * Load book cover thumbnail for the book details view
         */
        imageLoader
                .withImageView(bookCoverView)
                .withImageUrl(clickedBookCoverUrl)
                .configure()
                .load();


        bookDetailsFetcher.withTargetView(bookDetailsExpListView)
                .withUrl("http://it-ebooks-api.info/v1/book/" + clickedBookId)
                .execute();
    }
}
