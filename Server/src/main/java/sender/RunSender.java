package sender;

import com.google.protobuf.util.JsonFormat;
import protobuf.run.Run;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RunSender {
    public void sendRun(Run run) {
        try {
            String json = JsonFormat.printer().print(run);
            saveToFile(json, "runJson");
            System.out.println("done");
        } catch (Exception e) {
            System.out.println("something wrong");
        }
    }

    public void saveToFile(String json, String fileName) {
        try {
            String path = fileName + ".json";
            Files.write(Paths.get(path), json.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
