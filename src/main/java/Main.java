import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final String BLAH = "^(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]) ([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9]),([0-9][0-9][0-9])";

    public static void main(String[] args) {
        File file = new File("C:\\Users\\USER\\Desktop\\логи\\mBank2");
        List<String> logs = new ArrayList<>();


        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String str = sc.nextLine();

                if (beginsWithDate(str)) {
                        logs.add(str);
                }
                else {
                    logs.set(logs.size()-1, logs.get(logs.size()-1) + "\n" + str );
                }
            }

            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String str:logs) {
            System.out.println(str);
            System.out.println("----------");
        }
//        System.out.println(beginsWithDate("11-23 00:04:24,000"));
    }

    private static boolean beginsWithDate(String str) {
        Pattern p = Pattern.compile(BLAH);
        Matcher m = p.matcher(str);
        return (m.find());
    }

}
