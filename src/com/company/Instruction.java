package com.company;

import com.company.InstructionSet.*;

public class Instruction {

    String binaryInstruction;
    String binary;
    protected int opcode;
    protected int addressingMode;
    protected int operand;
    protected boolean hasEffectOnZF;
    protected boolean hasEffectOnCF;
    protected boolean hasEffectOnSF;
    MyCPU mycpu;

    public Instruction(String binaryInstruction, MyCPU cpu) {
        this.binaryInstruction = binaryInstruction;
        this.mycpu = cpu;
        print();
    }

    protected Instruction() {
    }

    public void print() {

        binary = binaryInstruction;
        binary = binary.length() == 24 ? binary : "000000000000000000000000".substring(0 ,24 - binary.length()) + binary;
    //    System.out.println(binary);
        findOpcode();
        findAddressingMode();
        findOperand();
        applyInstruction();
    }

    public void findOperand(){
        this.operand = Integer.parseInt(binary.substring(8,24),2);
    }

    public void findAddressingMode(){
        this.addressingMode = Integer.parseInt(binary.substring(6,8),2);
    }

    public void findOpcode(){
        this.opcode = Integer.parseInt(binary.substring(0,6),2);

    }

    public void applyInstruction(){
        switch (opcode){
            case 0x1:
                System.out.println("HALT");
                HALT halt = new HALT(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x2:
                System.out.println("LOAD");
                LOAD load = new LOAD(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x3:
                System.out.println("STORE");
                STORE store = new STORE(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x4:
                System.out.println("ADD");
                ADD add = new ADD(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x5:
                System.out.println("SUB");
                SUB sub = new SUB(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x6:
                System.out.println("INC");
                INC inc = new INC(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x7:
                System.out.println("DEC");
                DEC dec = new DEC(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x8:
                System.out.println("MUL");
                MUL mul = new MUL(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x9:
                System.out.println("DIV");
                DIV div = new DIV(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0xA:
                System.out.println("XOR");
                XOR xor = new XOR(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0xB:
                System.out.println("AND");
                AND and = new AND(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0xC:
                System.out.println("OR");
                OR or = new OR(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0xD:
                System.out.println("NOT");
                NOT not = new NOT(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0xE:
                System.out.println("SHL");
                SHL shl = new SHL(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0xF:
                System.out.println("SHR");
                SHR shr = new SHR(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x10:
                System.out.println("NOP");
                NOP nop = new NOP();
                break;
            case 0x11:
                System.out.println("PUSH");
                PUSH push = new PUSH(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x12:
                System.out.println("POP");
                POP pop = new POP(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x13:
                System.out.println("CMP");
                CMP cmp = new CMP(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x14:
                System.out.println("JMP");
                JMP jmp = new JMP(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x15:
                System.out.println("JZ");
                JZ jz = new JZ(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x16:
                System.out.println("JNZ");
                JNZ jnz = new JNZ(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x17:
                System.out.println("JC");
                JC jc = new JC(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x18:
                System.out.println("JNC");
                JNC jnc = new JNC(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x19:
                System.out.println("JA");
                JA ja = new JA(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x20:
                System.out.println("JAE");
                JAE jae = new JAE(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x21:
                System.out.println("JB");
                JB jb = new JB(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x22:
                System.out.println("JBE");
                JBE jbe = new JBE(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x23:
                System.out.println("READ");
                READ read = new READ(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            case 0x24:
                System.out.println("PRINT");
                PRINT print = new PRINT(this.opcode, this.addressingMode, this.operand, mycpu);
                break;
            default:
                System.out.println("Errorr !!");
                System.exit(0);
        }
    }
}
