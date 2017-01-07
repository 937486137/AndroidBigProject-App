package com.example.skjguan.androidbigproject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by jeyo on 2017/1/7.
 */

public class RemainTimeComparator implements Comparator {

    boolean isAscending = false;

    public RemainTimeComparator(boolean isAscending) {
        this.isAscending = isAscending;
    }

    @Override
    public int compare(Object o1, Object o2) {
        TodoItem item1 = (TodoItem) o1;
        TodoItem item2 = (TodoItem) o2;

        DateFormat inputFormat = new SimpleDateFormat("yyyy.MM.dd");

        try {
            Date date1 = inputFormat.parse(item1.getRemindingTime());
            Date date2 = inputFormat.parse(item2.getRemindingTime());
            return isAscending? date1.compareTo(date2) : -date1.compareTo(date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
