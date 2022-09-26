public class LineOutput extends OutputDecorator {
    public LineOutput(Output o) {
        super(o);
    }

    @Override
    public void writeData(String data) {
        super.writeData(data + "\n");
    }

    // @Override
    // public String readData() {
    //     return super.readData();
    // }

}
