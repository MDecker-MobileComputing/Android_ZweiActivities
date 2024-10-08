package de.mide.zweiactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Zweite Activity der App, wird von erster Activity mit einem
 * explizitem Intent geöffnet.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class Activity2 extends Activity
                       implements View.OnClickListener {

    /** UI-Element zur Anzeige von Text, der auf Activity1 eingegeben wurde. */
    protected TextView _textView = null;

    /** UI-Element für Eingabe von Text, der an Activity1 zurückgegeben werden soll. */
    protected EditText _editText = null;


    /**
     * Lifecycle-Methode zur Initialisierung des Activity-Objekts.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        setTitle(R.string.titel_activity_2);

        _textView = findViewById(R.id.textViewAufActivity2);

        _editText = findViewById(R.id.editTextAufActivity2);

        Button button = findViewById(R.id.buttonAufActivity2);
        button.setOnClickListener(this);

        // Auslesen von String, der von Activity 1 als "Extra" mitgegeben wurde.
        Intent intent = getIntent();
        String textVonActivity1 = intent.getStringExtra("data_von_1_zu_2");

        _textView.setText(textVonActivity1);
    }


    /**
     * Button-Event-Handler-Methode: Es wird zur Activity1 zurückgesprungen.
     *
     * @param view Button, der Event ausgelöst hat.
     */
    @Override
    public void onClick(View view) {

        String derText = _editText.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("data_von_2_zu_1", derText);
        setResult(RESULT_OK, intent);
        //setResult(RESULT_CANCELED, intent);

        finish();
    }

}