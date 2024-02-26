/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author nguye
 */
public class KeyboardDAO {
    public String converterNumber(int number) {
        Locale locale = new Locale("en", "EN");
        String pattern = "###,###";
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat
                .getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        String newNumber = decimalFormat.format(number);
        return newNumber;
    }

    public int getPriceBeforeDiscount(int discount, int price) {
        int priceBeforeDiscount = (int) (price / ((100 - discount) / 100.0));

        return priceBeforeDiscount;
    }
}
