package ir.vasl.Utils;

import java.util.Random;

/**
 * Created by HamidReza on 12,January,2019
 * Happy Coding ;)
 */
public class PublicFunctions {

    public static int getNotificationID() {
        return new Random().nextInt(1001) + 1000; // [1000, 2000]
    }

}
