public class OutputDecorator implements Output {
    private Output wrappee;

    OutputDecorator(Output o) {
        this.wrappee = o;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    // @Override
    // public String readData() {
    //     return wrappee.readData();
    // }
}
