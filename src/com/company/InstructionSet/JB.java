package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

public class JB extends Instruction {

    MyCPU cpu;

    public JB (int opcode, int addressingMode, int operand, MyCPU cpu) {
        this.opcode = opcode;
        this.operand = operand;
        this.addressingMode = addressingMode;
        this.hasEffectOnCF = false;
        this.hasEffectOnSF = false;
        this.hasEffectOnZF = false;
        this.cpu = cpu;
        operate();
    }

    private void operate(){

        if(addressingMode == 0x0){
            if(cpu.isCF())
                cpu.writePC(operand);
        }else{
            System.out.println("JB: Invalid addressing mode");
            System.exit(0);
        }
    }
}
