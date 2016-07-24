package com.bryonnicoson.okhttptest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;


import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();
    Book book;

    public TextView tvTitle, tvAuthor, tvPublished, tvSetting, tvCharacters, tvFiction;



    private class DogFetchTask extends AsyncTask<String, Void, Book> {

        @Override
        protected Book doInBackground(String... params) {

            String url = "https://bryonnicoson-ruby-book.herokuapp.com";
            // the key needs to be secured and the url constructed via stringbuilder

           // String url = "http://api.petfinder.com/shelter.getPets?id=IL542&format=json&count=1000&key=4f968c74b90183bfb8519a8cf64844f2&callback=?";
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                book = gson.fromJson(response.body().charStream(), Book.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // trim the nonstandard characters: beginning ?(  and ending )
            //String trimmed = result.substring(2, result.length()-1);
            //return trimmed;
            return book;

        }

        protected void onPostExecute(Book book) {

            tvTitle = (TextView) findViewById(R.id.tv_title);
            tvTitle.setText(book.getTitle());
            tvAuthor = (TextView) findViewById(R.id.tv_author);
            tvAuthor.setText(book.getAuthor());
            tvPublished = (TextView) findViewById(R.id.tv_published);
            tvPublished.setText(Integer.toString(book.getYearPublished()));
            tvSetting = (TextView) findViewById(R.id.tv_setting);
            tvSetting.setText(book.getSetting());
            tvCharacters = (TextView) findViewById(R.id.tv_characters);
            tvCharacters.setText(book.getCharacterString());
            tvFiction = (TextView) findViewById(R.id.tv_fiction);
            tvFiction.setText(Boolean.toString(book.getFiction()));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DogFetchTask().execute();
    }
}