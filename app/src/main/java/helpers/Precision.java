package helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by anuda on 3/20/18.
 */

public class Precision {

    public static Double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
