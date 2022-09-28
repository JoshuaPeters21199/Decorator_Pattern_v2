public class NumberedOutput extends OutputDecorator {

    private int lineNumber = 0;

    public NumberedOutput(Output o) {
        super(o);
    }

    @Override
    public void writeData(String data) {
        lineNumber++;
        String ln = String.format("%5d: ", lineNumber);
        super.writeData(ln + data + "\n");
    }
}