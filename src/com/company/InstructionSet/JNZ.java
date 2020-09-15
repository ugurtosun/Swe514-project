package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

public class JNZ extends Instruction {

    MyCPU cpu;

    public JNZ (int opcode, int addressingMode, int operand, MyCPU cpu) {
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
            if(!cpu.isZF())
                cpu.writePC(operand / 3 - 1);
        }else{
            System.out.println("JNZ: Invalid addressing mode");
            System.exit(0);
        }
    }
}
