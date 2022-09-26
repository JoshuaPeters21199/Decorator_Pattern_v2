import java.io.*;

public class StreamOutput implements Output {
    private String writeFileName;
    // private String readFileName;

    public StreamOutput(String writeFileName) {
        this.writeFileName = writeFileName;
        // this.readFileName = readFileName;
    }

    @Override
    public void writeData(String data) {

        FileWriter fw = null;
        BufferedWriter bw = null;
        // PrintWriter pw = null;

        try {
            File mainFile = new File(writeFileName);
            if (mainFile.createNewFile()) {
                FileWriter writeFile = new FileWriter(writeFileName);
                writeFile.write(data);
                writeFile.close();
            } else {
                try {
                    fw = new FileWriter(mainFile, true);
                    bw = new BufferedWriter(fw);
                    // pw = new PrintWriter(bw);

                    bw.write(data);

                } finally {
                    try {
                        bw.close();
                        fw.close();
                    } catch (IOException e) {}
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
