package behavioral.template;

public class Main {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.process();

        System.out.println();

        DataProcessor jsonProcessor = new JSONDataProcessor();
        jsonProcessor.process();
    }
}

abstract class DataProcessor {
    public final void process() {
        readData();
        processData();
        saveData();
    }

    protected abstract void readData();

    protected abstract void processData();

    protected void saveData() {
        System.out.println("Saving data to default location.");
    }
}

class CSVDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading CSV data.");
    }

    @Override
    protected void processData() {
        System.out.println("Processing CSV data.");
    }
}

class JSONDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading JSON data.");
    }

    @Override
    protected void processData() {
        System.out.println("Processing JSON data.");
    }
}
