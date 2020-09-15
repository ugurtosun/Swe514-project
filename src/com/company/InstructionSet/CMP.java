package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

public class CMP extends Instruction {

    MyCPU cpu;

    public CMP (int opcode, int addressingMode, int operand, MyCPU cpu) {
        this.opcode = opcode;
        this.operand = operand;
        this.addressingMode = addressingMode;
        this.hasEffectOnCF = true;
        this.hasEffectOnSF = true;
        this.hasEffectOnZF = true;
        this.cpu = cpu;
        operate();
    }

    private void operate(){

        if(addressingMode == 0x0){
            //do nothing
        }
        else if(addressingMode == 0x1){
            switch (operand){
                case 0x0:
                    operand = cpu.readPC();
                    break;
                case 0x1:
                    operand = cpu.readA();
                    break;
                case 0x2:
                    operand = cpu.readB();
                    break;
                case 0x3:
                    operand = cpu.readC();
                    break;
                case 0x4:
                    operand = cpu.readD();
                    break;
                case 0x5:
                    operand = cpu.readE();
                    break;
                case 0x6:
                    operand = cpu.readSP();
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        } else if(addressingMode == 0x2){
            switch (operand){
                case 0x0:
                    operand = cpu.readMemory(cpu.readPC());
                    break;
                case 0x1:
                    operand = cpu.readMemory(cpu.readA());
                    break;
                case 0x2:
                    operand = cpu.readMemory(cpu.readB());
                    break;
                case 0x3:
                    operand = cpu.readMemory(cpu.readC());
                    break;
                case 0x4:
                    operand = cpu.readMemory(cpu.readD());
                    break;
                case 0x5:
                    operand = cpu.readMemory(cpu.readE());
                    break;
                case 0x6:
                    operand = cpu.readMemory(cpu.readSP());
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        }else if(addressingMode == 0x3){
            operand = cpu.readMemory(operand);
        }else{
            System.out.println("CMP: Invalid addressing mode");
            System.exit(0);
        }

        if(cpu.readA() - operand == 0){
            cpu.setZF(true);
            cpu.setSF(false);
            cpu.setCF(false);
        }
        else if(cpu.readA() - operand < 0){
            cpu.setCF(true);
            cpu.setSF(true);
            cpu.setZF(false);
        }
        else{
            cpu.setSF(false);
            cpu.setCF(false);
            cpu.setZF(false);
        }
    }
}
