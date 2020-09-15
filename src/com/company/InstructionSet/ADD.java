package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

public class ADD extends Instruction {

    MyCPU cpu;
    private boolean resultCF;

    public ADD (int opcode, int addressingMode, int operand, MyCPU cpu) {
        this.opcode = opcode;
        this.operand = operand;
        this.addressingMode = addressingMode;
        this.hasEffectOnCF = true;
        this.hasEffectOnSF = true;
        this.hasEffectOnZF = true;
        this.cpu = cpu;
        operate();
        updateFlags();
    }

    private void operate(){

        if(addressingMode == 0x0){
           resultCF = cpu.writeA(cpu.readA() + operand);
        }
        else if(addressingMode == 0x1){
            switch (operand){
                case 0x0:
                    resultCF = cpu.writeA(cpu.readPC() + cpu.readA());
                    break;
                case 0x1:
                    resultCF = cpu.writeA(cpu.readA() + cpu.readA());
                    break;
                case 0x2:
                    resultCF = cpu.writeA(cpu.readB() + cpu.readA());
                    break;
                case 0x3:
                    resultCF = cpu.writeA(cpu.readC() + cpu.readA());
                    break;
                case 0x4:
                    resultCF = cpu.writeA(cpu.readD() + cpu.readA());
                    break;
                case 0x5:
                    resultCF = cpu.writeA(cpu.readE() + cpu.readA());
                    break;
                case 0x6:
                    resultCF = cpu.writeA(cpu.readSP() + cpu.readA());
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        } else if(addressingMode == 0x2){
            switch (operand){
                case 0x0:
                    resultCF = cpu.writeA(cpu.readMemory(cpu.readPC()) + cpu.readA());
                    break;
                case 0x1:
                    resultCF = cpu.writeA(cpu.readMemory(cpu.readA()) + cpu.readA());
                    break;
                case 0x2:
                    resultCF = cpu.writeA(cpu.readMemory(cpu.readB()) + cpu.readA());
                    break;
                case 0x3:
                    resultCF = cpu.writeA(cpu.readMemory(cpu.readC()) + cpu.readA());
                    break;
                case 0x4:
                    resultCF = cpu.writeA(cpu.readMemory(cpu.readD()) + cpu.readA());
                    break;
                case 0x5:
                    resultCF = cpu.writeA(cpu.readMemory(cpu.readE()) + cpu.readA());
                    break;
                case 0x6:
                    resultCF = cpu.writeA(cpu.readMemory(cpu.readSP()) + cpu.readA());
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        }else if(addressingMode == 0x3){
            resultCF = cpu.writeA(cpu.readMemory(operand) + cpu.readA());
        }else{
            System.out.println("ADD: Invalid addressing mode");
            System.exit(0);
        }
    }

    private void updateFlags(){
        cpu.setCF(resultCF);
        cpu.setZF(cpu.readA() == 0);
        cpu.setSF(cpu.readA() < 0);
    }
}
