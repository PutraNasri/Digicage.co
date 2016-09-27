package es.esy.kinketkuena.digicageco;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu_utama extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
    }
    public void food (View view){
        Intent intent = new Intent(Menu_utama.this, food.class);
        startActivity(intent);

    }
}
