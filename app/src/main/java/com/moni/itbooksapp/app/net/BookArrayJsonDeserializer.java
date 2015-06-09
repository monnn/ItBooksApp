package com.moni.itbooksapp.app.net;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.moni.itbooksapp.app.model.BookGridItem;

import java.lang.reflect.Type;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class BookArrayJsonDeserializer implements JsonDeserializer<BookGridItem[]> {

    private JsonArray booksArray;

    @Override
    public BookGridItem[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        this.booksArray = (JsonArray) json.getAsJsonObject().get("Books");
        BookGridItem[] bookGridItems = new BookGridItem[booksArray.size()];

        for (int i = 0; i < booksArray.size(); i++) {
            bookGridItems[i] = new BookGridItem(
                    getValueFor("ID", i),
                    getValueFor("Title", i),
                    getValueFor("Image", i));
        }

        return bookGridItems;
    }

    private String getValueFor(String key, int i) {
        return booksArray.get(i)
                .getAsJsonObject()
                .get(key)
                .getAsString();
    }
}
