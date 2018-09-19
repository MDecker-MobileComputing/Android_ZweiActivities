package de.mide.zweiactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Main-Activity (wird beim Start der App zuerst angezeigt).
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class Activity1 extends Activity
                       implements View.OnClickListener {

    protected EditText _editText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        _editText = findViewById(R.id.editTextAufActivity1);

        Button button = findViewById(R.id.buttonAufActivity1);
        button.setOnClickListener(this);
    }


    /**
     * Button-Event-Handler-Methode.
     * Es wird zu Activity2 gesprungen.
     *
     * @param view Button, der Event ausgelöst hat.
     */
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Activity2.class);

        String textToTransfer = _editText.getText().toString();
        intent.putExtra("data_von_1_zu_2", textToTransfer);

        startActivity(intent);
    }

}


