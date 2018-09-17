package de.mide.zweiactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Main-Activity (wird beim Start der App zuerst angezeigt).
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class Activity1 extends Activity
                       implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Button button = findViewById(R.id.buttonAufActivity1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);

        // Anweisung hier würde ausgeführt ohne auf Start
        // zweiter Activity zu warten
    }

}


