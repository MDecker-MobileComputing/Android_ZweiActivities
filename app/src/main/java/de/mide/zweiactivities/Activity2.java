package de.mide.zweiactivities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Zweite Activity der App, wird von erster Activity mit einem
 * explizitem Intent geöffnet.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class Activity2 extends Activity
                       implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button button = findViewById(R.id.buttonAufActivity2);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        finish();
    }

}






