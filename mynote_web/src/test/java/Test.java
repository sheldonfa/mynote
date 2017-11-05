import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author fangxin
 * @date 2017/4/18.
 */

class Father{

    private static String f = "father static field";

    private String g = "father dynamic field";

    {
        System.out.println("father dynamic "+g);
    }

    static{
        System.out.println("father static");
    }

    public Father() {
        System.out.println("father constructor");
    }
}

class Child extends Father {

    private static String f = "father static field";

    private String g = "father dynamic field";

    {
        System.out.println("child dynamic "+g);
    }

    static{
        System.out.println("child static");
    }

    public Child() {
        System.out.println("child constructor");
    }
}



public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        getYearMonthDayHMS();
//        getLastDayOfMonth();
        getLastDayNow();
    }

    public static void getYearMonthDayHMS(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));


    }


    public static void getLastDayOfMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH,2-1);
        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(actualMaximum);
    }

    public static void getLastDayNow(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        System.out.println(calendar.getTime());
    }
}



