package main;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by david_szilagyi on 2017.05.03..
 */
public class Tweet {
    String name;
    String message;
    String date;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public Tweet(String name, String message, Date date) {
        this.name = name;
        this.message = message;
        this.date = sdf.format(date);
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return name + " <" + date + ">: " + message;
    }
}
