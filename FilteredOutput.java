public class FilteredOutput extends OutputDecorator {

    public FilteredOutput(Output o) {
        super(o);
    }

    @Override
    public void writeData(String data) {
        super.writeData(data);
    }
}