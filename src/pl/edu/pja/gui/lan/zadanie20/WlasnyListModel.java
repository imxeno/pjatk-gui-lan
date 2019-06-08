package pl.edu.pja.gui.lan.zadanie20;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

public class WlasnyListModel extends AbstractListModel<String> {

    @Override
    public int getSize() {
        return LocalDate.now().getMonth().length(LocalDate.now().isLeapYear());
    }

    @Override
    public String getElementAt(int index) {
        return "" + (index + 1) + " - " + LocalDate.now()
                .minusDays(1 - LocalDate.now().getDayOfMonth())
                .plusDays(index).getDayOfWeek()
                .getDisplayName(TextStyle.FULL, new Locale("PL")).toString();
    }
}
