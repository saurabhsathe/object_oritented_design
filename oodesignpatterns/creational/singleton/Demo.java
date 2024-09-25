import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        s1.printTime();
        Singleton s2 = Singleton.getInstance();
        s2.printTime();
    }
}


class Singleton{
    private static Singleton oneInstance;
    String formatted;

    private Singleton(){
    formatted = new SimpleDateFormat("yyyy-mm-dd").format(new Date(System.currentTimeMillis()));
    }
    public static Singleton getInstance(){
        if(oneInstance==null){
            oneInstance = new Singleton();

        }
        return oneInstance;
    }

    public void printTime(){
        System.out.println(this.formatted);
    }
}

