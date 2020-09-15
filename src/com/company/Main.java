package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        if(args.length == 0){
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        String filename = args[0];

        MyCPU mycpu = new MyCPU();
        String currentDirectory = new File("").getAbsolutePath();
        LabelProcessor labelProcessor = new LabelProcessor(currentDirectory + "/" + filename);
        labelProcessor.readFileFirstPass();
        labelProcessor.readFileSecondPass();

 //       BufferedReader reader;
 //       reader = new BufferedReader(new FileReader("program.bin"));
 //       String line = reader.readLine();

 //       String[] hexArray = new String[1000];
 //       int count = 0;

 //       while(line != null){
 //           System.out.println(line);
 //           hexArray[count] = line;
 //           count++;
 //           line = reader.readLine();
 //       }

  //      while(!hexArray[mycpu.readPC()].equals("")){
  //          Instruction instruction = new Instruction(hexArray[mycpu.readPC()], mycpu);
  //          mycpu.writePC(mycpu.readPC() + 1);
  //      }
        System.out.println("End of program");
    }
}
