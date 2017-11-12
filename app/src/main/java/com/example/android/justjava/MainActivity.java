/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */

 package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This calls the methods calculate price and create order summary and displays
     *  the information to the screen.
     * @param view
     */
    public void submitOrder(View view) {
        // What is the name that has been entered
        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        String name = nameEditText.getText().toString();

        // figure out if the user wants whipped cream topping
       CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
       boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

       // figure out if the user wants chocolate topping
       CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
       boolean hasChocolate = chocolateCheckBox.isChecked();

       int price = calculatePrice(hasWhippedCream,hasChocolate);
       displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate, name));
    }

    /**
     * Calculates the price of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @return total price of order
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        // Price of 1 cup of coffee
        int basePrice = 5;

        // add £1 if the user wants whipped cream
        if(addWhippedCream) {
            basePrice = basePrice + 1;
        }

        // add £2 if the user wants chocolate
        if (addChocolate) {
            basePrice = basePrice + 2;
        }

        // calculate the total order price by multiplying by quantity
        return quantity * basePrice;
    }

    /**
     * Creating the order summary
     * @param price of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @param addName name of the customer
     * @return text summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String addName) {
        String priceMessage = "Name: " + addName;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: £" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method makes the quantity increase by 1
     */
    public void increment(View view) {
        if (quantity==100) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method makes the quantity decrese by 1
     */
    public void decrement(View view) {
        if (quantity==1) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}