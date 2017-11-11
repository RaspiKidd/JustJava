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
import android.widget.TextView;

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
       int price = calculatePrice();
       displayMessage(createOrderSummary(price));
    }

    /**
     * Calculates the price of the order
     * @return
     */
    private int calculatePrice() {

        return quantity * 5;
    }

    /**
     * Creating the order summary
     * @param price
     * @return
     */
    private String createOrderSummary(int price) {
        String priceMessage = "Name: Kerry";
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: £" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method makes the quantity increase by 1
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method makes the quantity decrese by 1
     */
    public void decrement(View view) {
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