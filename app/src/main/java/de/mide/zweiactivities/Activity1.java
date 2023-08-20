package de.mide.zweiactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Main-Activity (wird beim Start der App zuerst angezeigt).
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class Activity1 extends Activity
        implements View.OnClickListener {

    /** UI-Elemente zur Eingabe von Text durch den Nutzer. */
    protected EditText _editText = null;

    /** UI-Element zur Anzeige von Text, der von Activity2 zurückgegeben wird. */
    protected TextView _textView = null;


    /**
     * Lifecycle-Methode zur Initialisierung des Activity-Objekts.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        setTitle(R.string.titel_activity_1);

        _editText = findViewById(R.id.editTextAufActivity1);

        _textView = findViewById(R.id.textViewAufActivity1);

        Button button = findViewById(R.id.buttonAufActivity1);
        button.setOnClickListener(this);
    }


    /**
     * Button-Event-Handler-Methode. Es wird zu Activity2 gesprungen.
     *
     * @param view Button, der Event ausgelöst hat.
     */
    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, Activity2.class);

        // String in Variable textToTransfer als "Extra"
        // für die Empfänger-Activity mitgeben.
        String derText = _editText.getText().toString();
        intent.putExtra("data_von_1_zu_2", derText);

        //startActivity(intent);
        startActivityForResult(intent, 123);

        //Log.i("ZweiActivities", "Intent abgeschickt");
    }


    /**
     * Callback-Methode für Rückkehr der Activity 2. Damit diese Methode aufgerufen wird,
     * muss der Intent zum Aufruf der Activity 2 mit "startActivityForResult()" statt mit
     * "startActivity()" abgesetzt werden.
     *
     * @param requestCode  Code, anhand dem wir verschiedene "Rückkehrer" unterscheiden können
     *                     (in diesem Beispiel gibt es aber nur einen Rückkehrer).
     *
     * @param resultCode   Code an dem wir erkennen können, ob die aufgerufene Activity erfolgreich
     *                     beendet wurde.
     *
     * @param intent       Intent-Objekt, das von Activity 2 erzeugt wurde und den "Rückgabe-Wert"
     *                     enthält.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (resultCode != RESULT_OK) {

            _textView.setText("Activity 2 wurde abgebrochen");
            return;
        }

        String textEmpfangen = intent.getStringExtra("data_von_2_zu_1");
        _textView.setText(textEmpfangen);
    }

}