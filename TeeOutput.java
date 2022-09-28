public class TeeOutput extends OutputDecorator {

    public TeeOutput(Output o) {
        super(o);
    }

    @Override
    public void writeData(String data) {
        super.writeData(data);
    }
}