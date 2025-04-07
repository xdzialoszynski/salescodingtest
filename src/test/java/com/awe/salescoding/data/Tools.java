package com.awe.salescoding.data;

import java.util.ArrayList;
import java.util.List;

public class Tools {

    public static Input getInput() {
        List<CommandDetail> inputDetailsList = new ArrayList<>();
        inputDetailsList.add(new CommandDetail(false, 1, "book",12.49 ));
        inputDetailsList.add(new CommandDetail(false,1, "music CD",16.49 ));
        inputDetailsList.add(new CommandDetail(false,1, "chocolate bar",0.85 ));
        Input input = new Input(inputDetailsList);
        return input;
    }

    public static Output getOutput() {
        List<CommandDetail> outputDetailsList = new ArrayList<>();
        outputDetailsList.add(new CommandDetail(false,1, "book",12.49 ));
        outputDetailsList.add(new CommandDetail(false,1, "music CD",16.49 ));
        outputDetailsList.add(new CommandDetail(false,1, "chocolate bar",0.85 ));
        Output output = new Output(outputDetailsList, 1.5, 29.83);
        return output;
    }

    public static Output getOutput_1() {
        List<CommandDetail> outputDetailsList = new ArrayList<>();
        outputDetailsList.add(new CommandDetail(false,1, "book",12.49 ));
        outputDetailsList.add(new CommandDetail(false,1, "music CD",16.49 ));
        outputDetailsList.add(new CommandDetail(false,1, "chocolate bar",0.85 ));
        Output output = new Output(outputDetailsList, 1.5, 29.83);
        return output;
    }

    public static Input getInput_1() {
        List<CommandDetail> inputDetailsList = new ArrayList<>();
        inputDetailsList.add(new CommandDetail(false,1, "book",12.49 ));
        inputDetailsList.add(new CommandDetail(false,1, "music CD",14.99 ));
        inputDetailsList.add(new CommandDetail(false,1, "chocolate bar",0.85 ));
        Input input = new Input(inputDetailsList);
        return input;
    }

    public static Input getInput_2() {
        List<CommandDetail> inputDetailsList = new ArrayList<>();
        inputDetailsList.add(new CommandDetail(true,1, "box of chocolates",10.0 ));
        inputDetailsList.add(new CommandDetail(true,1, "bottle of perfume",47.50 ));
        Input input = new Input(inputDetailsList);
        return input;
    }

    public static Output getOutput_2() {
        List<CommandDetail> outputDetailsList = new ArrayList<>();
        outputDetailsList.add(new CommandDetail(true,1, "box of chocolates",10.50 ));
        outputDetailsList.add(new CommandDetail(true,1, "bottle of perfume",54.65 ));
        Output output = new Output(outputDetailsList, 7.65, 65.15);
        return output;
    }

    public static Input getInput_3() {
        List<CommandDetail> inputDetailsList = new ArrayList<>();
        inputDetailsList.add(new CommandDetail(true,1, "bottle of perfume",27.99 ));
        inputDetailsList.add(new CommandDetail(false,1, "bottle of perfume",18.99 ));
        inputDetailsList.add(new CommandDetail(false,1, "packet of headache pills",9.75 ));
        inputDetailsList.add(new CommandDetail(true,1, "box of chocolates",11.25 ));
        Input input = new Input(inputDetailsList);
        return input;
    }

    public static Output getOutput_3() {
        List<CommandDetail> outputDetailsList = new ArrayList<>();
        outputDetailsList.add(new CommandDetail(true,1, "bottle of perfume",32.19 ));
        outputDetailsList.add(new CommandDetail(false,1, "bottle of perfume",20.89 ));
        outputDetailsList.add(new CommandDetail(false,1, "packet of headache pills",9.75 ));
        outputDetailsList.add(new CommandDetail(true,1, "box of chocolates",11.85 ));
        Output output = new Output(outputDetailsList, 6.70, 74.68);
        return output;
    }


}
