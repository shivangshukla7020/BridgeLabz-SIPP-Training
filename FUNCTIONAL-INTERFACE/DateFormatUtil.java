import java.text.SimpleDateFormat;
import java.util.Date;

interface DateFormatUtil {
    static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}

class InvoiceGenerator {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println("Formatted date: " + DateFormatUtil.formatDate(now, "dd-MM-yyyy"));
    }
}