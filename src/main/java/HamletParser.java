import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static jdk.nashorn.internal.objects.NativeString.replace;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder(" ");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String replace(String original, String replacement, String data){
        Pattern patternToReplace = Pattern.compile(original);
        Matcher matcher = patternToReplace.matcher(data);
        return matcher.replaceAll(replacement);
    }

    public void changeHamletToLeon(){
        hamletData = replace("Hamlet", "Leon", hamletData);
        hamletData = replace("HAMLET", "LEON", hamletData);
    }

    public void changeHoratioToTariq(){
        hamletData = replace("Horatio", "Tariq", hamletData);
        hamletData = replace("HORATIO", "TARIQ", hamletData);
    }

    public boolean findHamlet(String data){
        Pattern pattern1 = Pattern.compile("Hamlet");
        Pattern pattern2 = Pattern.compile("HAMLET");
        return (pattern1.matcher(data).find() || pattern2.matcher(data).find());
    }

    public boolean findHoratio(String data){
        Pattern pattern1 = Pattern.compile("Horatio");
        Pattern pattern2 = Pattern.compile("HORATIO");
        return (pattern1.matcher(data).find() || pattern2.matcher(data).find());
    }

}
