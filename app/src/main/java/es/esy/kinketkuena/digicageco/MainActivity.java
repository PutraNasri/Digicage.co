package es.esy.kinketkuena.digicageco;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

public void menuu (View viewi){
    Intent intent = new Intent(MainActivity.this, Menu_utama.class);
    startActivity(intent);
    finish();
}




    public void klik (View view) throws IOException {
        new  loading().execute();

    }
    public  class  loading extends AsyncTask<Void,Void,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();

        }
        @Override
        protected String doInBackground(Void... params) {
            URL url = null;
            String line ="";
            StringBuilder result = new StringBuilder();
            try {
                url = new URL("https://startprint-1304.appspot.com/_ah/api/pemakai/v1/pemakai/periksaLogin?email=zackydzacky%40gmail.com&password=asdf");
                HttpURLConnection Http = (HttpURLConnection) url.openConnection();
                Http.setRequestMethod("GET");
                InputStream in =new BufferedInputStream(Http.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));


                while((line = reader.readLine()) != null) {
                    result.append(line);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return result.toString();
        }
    }
}
