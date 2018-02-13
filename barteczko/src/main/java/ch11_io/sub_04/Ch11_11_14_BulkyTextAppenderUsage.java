package ch11_io.sub_04;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Ch11_11_14_BulkyTextAppenderUsage {

    public static void main(String[] args) {
        List<String> fnames = Arrays.asList( "barteczko\\A.txt", "barteczko\\B.txt" );
        Ch11_11_13_BulkTextAppender app = null;
        try(Ch11_11_13_BulkTextAppender appender = new Ch11_11_13_BulkTextAppender(fnames)) {
            app = appender;
            appender.append("ala ma kota\n");
        } catch (Exception exc) {
            System.out.println("Exc while processing: " + exc);
            if (exc.getSuppressed().length > 0)
                System.out.println("Exc while closing: " + exc.getSuppressed()[0]);
        }
        if (!app.isAllAppended()) {
            System.out.println("Retrying op for unwritten files:");
            System.out.println(app.getNamesOfUnappendedFiles());
            try(Ch11_11_13_BulkTextAppender appender =
                        new Ch11_11_13_BulkTextAppender(app.getNamesOfUnappendedFiles())) {
                appender.append(app.getTextToAppend());
                app = appender;
            } catch (IOException exc) {
                System.out.println("Exc while processing: " + exc);
                if (exc.getSuppressed().length > 0)
                    System.out.println("Exc while closing: " + exc.getSuppressed()[0]);
                System.out.println("Retry failed");
                System.out.println("Unwritten files: " + app.getNamesOfUnappendedFiles());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (app.isAllAppended()) System.out.println("All written");
        }
        else System.out.println("All written");
    }

}
