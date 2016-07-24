package com.bryonnicoson.okhttptest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();
    Book book;
    Center center;

    @BindView(R.id.tv_title) TextView tvTitle;
    @BindView(R.id.tv_author) TextView tvAuthor;
    @BindView(R.id.tv_published) TextView tvPublished;
    @BindView(R.id.tv_fiction) TextView tvFiction;
    @BindView(R.id.tv_setting) TextView tvSetting;
    @BindView(R.id.tv_characters) TextView tvCharacters;
    @BindView(R.id.tv_latitude) TextView tvLatitude;

    private class HerokuCall extends AsyncTask<String, Void, Book> {

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
            tvTitle.setText(book.getTitle());
            tvAuthor.setText(book.getAuthor());
            tvPublished.setText(Integer.toString(book.getYearPublished()));
            tvFiction.setText(Boolean.toString(book.getFiction()));
            tvSetting.setText(book.getSetting());
            tvCharacters.setText(book.getCharacterString());
            tvLatitude.setText(Double.toString(center.getLatitude()));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new HerokuCall().execute();
    }
}