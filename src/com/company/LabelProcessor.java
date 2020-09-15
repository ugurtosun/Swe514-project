package com.company;

import java.io.*;
import java.util.Hashtable;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabelProcessor {

    private String actualPath;
    private BufferedReader reader;
    private File fout, fout2, fout3;
    private FileOutputStream fos, fos2, fos3;
    private BufferedWriter bw, bw2, bw3;
    public Hashtable<String, Integer> labelDictionary;

    public LabelProcessor(String actualPath) throws FileNotFoundException {
        this.actualPath = actualPath;
        fout = new File("unlabelledFile.txt");
        fout2 = new File("program.bin");
        fout3 = new File("hexprogram.bin");
        labelDictionary = new Hashtable<String, Integer>();
    }

    public void readFileFirstPass(){
        try {
            createSession();
            reader = new BufferedReader(new FileReader(actualPath));
            String line = reader.readLine();
            int lineCounter = 0;
            while(line != null){
                if(!line.contains(":")){
                    if(line.contains("'")){
                        Pattern pattern = Pattern.compile("'");
                        Matcher matcher = pattern.matcher(line);
                        int count = 0;
                        int[] array = new int[2];
                        while (matcher.find()){
                            try {
                                array[count] = matcher.start();
                                count++;
                            }catch (Exception e){
                                System.out.println("Undefined instruction entered");
                                System.exit(0);
                            }
                        }
                        String subString = line.substring(array[0] + 1, array[1]);
                        line = line.replaceAll(line.substring(array[0],array[1]+1), asciiConversion(subString));
                    }
                    writeLine(line);
                    lineCounter++;
                } else if(line.trim().endsWith(":")){
                    labelDictionary.put(line.trim().substring(0,line.trim().length()-1), lineCounter * 3);
                }
                else{
                    System.out.println("Undefined instruction entered");
                }
                line = reader.readLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("First Pass read file operation failed");
        }
        closeSession();
    }

    public void readFileSecondPass(){
        try {
            createSession2();
            createSession3();
            reader = new BufferedReader(new FileReader("unlabelledFile.txt"));
            String line = reader.readLine();

            while(line != null){
                System.out.println(line);
                Set<String> keys = labelDictionary.keySet();
                for(String key: keys){
                    if(line.contains(key)){
                        line = line.replaceAll(key, Integer.toHexString(labelDictionary.get(key)));
                        break;
                    }
                }
                LineOperations newline = new LineOperations(line);
                newline.splitLine();
                newline.findOpcode();
                newline.findAddressingMode();
                newline.createBinaryForm();
                writeLine2(newline.getBinaryInstruction());
                writeLine3(newline.getHexInstruction().toUpperCase());
                line = reader.readLine();
            }
            reader.close();
            closeSession2();
            closeSession3();
            File myObj = new File("unlabelledFile.txt");
            myObj.delete();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Second pass read file operation failed");
        }
    }

    private void createSession(){
        try {
            fos = new FileOutputStream(fout);
            bw = new BufferedWriter(new OutputStreamWriter(fos));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Create read file session failed");
        }
    }

    private void writeLine(String line)  {
        try {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Write file operation failed");
        }
    }

    private void closeSession(){
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Close session operation failed");
        }
    }

    private void createSession2(){
        try {
            fos2 = new FileOutputStream(fout2);
            bw2 = new BufferedWriter(new OutputStreamWriter(fos2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Create read file session failed");
        }
    }

    private void writeLine2(String line)  {
        try {
            bw2.write(line);
            bw2.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Write file operation failed");
        }
    }

    private void closeSession2(){
        try {
            bw2.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Close session operation failed");
        }
    }

    private void createSession3(){
        try {
            fos3 = new FileOutputStream(fout3);
            bw3 = new BufferedWriter(new OutputStreamWriter(fos3));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Create read file session failed");
        }
    }

    private void writeLine3(String line)  {
        try {
            bw3.write(line);
            bw3.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Write file operation failed");
        }
    }

    private void closeSession3(){
        try {
            bw3.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Close session operation failed");
        }
    }

    private String asciiConversion(String line){

        int asciiCode = (int) line.trim().charAt(0);
        return Integer.toHexString(asciiCode).toUpperCase();
    }
}
