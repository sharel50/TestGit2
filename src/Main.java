import java.util.ArrayList;

/**
 * @author sharel koletkar ID 214132854
 *
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Avraham = king");
        System.out.println(" i believe i can fly");
        System.out.println(" i believe i can fly");
        System.out.println(" lol. not funny");
        jdbc con=new jdbc();
//        con.showData();
//        con.Insert(2,"sharel");
//        con.Update(2,"'zobi'");
//        emou con2=new emou();
//        con2.showData();
//        con2.Insert(5, "womenbel");
//        con2.Update(2,3, "Roi");
        ArrayList<Name> arr =new ArrayList<Name>();
        Name data=new Name();
        arr = data.showData();
        System.out.println(arr);
        // arr=data.Updeta(6,"ariel");
        // System.out.println(arr);

    }

}
