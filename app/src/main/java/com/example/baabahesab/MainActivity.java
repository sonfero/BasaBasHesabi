package com.example.baabahesab;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.baabahesap
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

/**
 * This app displays some financial calculation :)
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when calculate button is clicked.
     */

    public void submitCalculate(View view) {

        EditText grossTlField = (EditText) findViewById(R.id.gross_interest_tl_field);
        String grossTlVariable = grossTlField.getText().toString();


        EditText grossDolarField = (EditText) findViewById(R.id.gross_interest_dolar_field);
        String grossDolarVariable = grossDolarField.getText().toString();


        EditText currentDolarField = (EditText) findViewById(R.id.current_dolar_exchange_rate_field);
        String currentDolarRate = currentDolarField.getText().toString();


        String showMessage = createSummary(grossTlVariable, grossDolarVariable, currentDolarRate);
        displayMessage(showMessage);


    }

    /**
     * Calculation Summary
     *
     * @param grossTlVariable    is the gross interest rate of TL given by the Bank.
     * @param grossDolarVariable is the gross interest rate of Dolar given by the Bank.
     * @param currentDolarRate   is the actual Dolar value against TL.
     */


    private String createSummary(String grossTlVariable, String grossDolarVariable, String currentDolarRate) {
        String summaryMessage = "Brüt faiz olarak " + grossTlVariable + " girdiniz";
        double grossTLFinal = Double.parseDouble(grossTlVariable);
        double netTLInterest = (grossTLFinal / 100) * (1 - 0.15);
        summaryMessage += "\nNet TL faiziniz:" + netTLInterest;

        double grossDolarFinal = Double.parseDouble(grossDolarVariable);
        double netDolarInterest = (grossDolarFinal / 100) * (1 - 0.2);
        summaryMessage += "\nNet Dolar faiziniz:" + netDolarInterest;

        summaryMessage += "\n Dolar alış kurunuz " + currentDolarRate;
        double mathDolar = Double.parseDouble(currentDolarRate);
        double fina = (mathDolar * (1 + netTLInterest * 30 / 365) / (1 + netDolarInterest * 30 / 365));
        summaryMessage += "\n 1 aylık başabaş noktanız:" + fina;
        return summaryMessage;
    }


    /**
     * This method displays shows the final calculation on the screen.
     */

    private void displayMessage(String message) {
        TextView hesapOzetiTextView = (TextView) findViewById(R.id.hesap_ozeti_text_view);
        hesapOzetiTextView.setText(message);
    }


}
