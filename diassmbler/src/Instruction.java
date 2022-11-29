import java.lang.Enum.EnumDesc;

public class Instruction {
    private String command;
    //TODO generic type to put instuction into : 
    // private <t> object; NEED TO MAKE GENERIC OBJECT

    public Instruction(String ins) {
        findCommand(ins);
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    private void findCommand(String ins) {
        String name = "";
        formats type = formats.NONE;


        while(type == formats.NONE) {
            try {

                if(ins.indexOf("10001011000") == 0){ // ADD
                    type = formats.READ;
                    name = "ADD";
                } else if(ins.indexOf("10001010000") == 0) { // AND
                    type = formats.READ;
                    name = "AND";
                } else if(ins.indexOf("1001000100") == 0) { // ADDI
                    type = formats.IMMEDIATE;
                    name = "ADDI";
                } else if(ins.indexOf("1001001000") == 0) { // ANDI
                    type = formats.IMMEDIATE;
                    name = "ANDI";
                } else if(ins.indexOf("000101") == 0) { // B
                    type = formats.BRANCH;
                    name = "B";
                    //TODO: check branch.cond stuff
                } else if(ins.indexOf("100101") == 0) { // BL
                    type = formats.BRANCH;
                    name = "BL";
                } else if(ins.indexOf("11010110000") == 0) { // BR
                    type = formats.BRANCH;
                    name = "BR";
                } else if(ins.indexOf("10110101") == 0) { // CBNZ
                    type = formats.COMPAREBRANCH;
                    name = "CBNZ";
                } else if(ins.indexOf("10110100") == 0) { // CBZ
                    type = formats.COMPAREBRANCH;
                    name = "CBZ";
                } else if(ins.indexOf("11001010000") == 0) { // EOR
                    type = formats.READ;
                    name = "EOR";
                } else if(ins.indexOf("1101001000") == 0) { // EORI
                    type = formats.IMMEDIATE;
                    name = "EORI";
                } else if(ins.indexOf("11111000010") == 0) { // LDUR
                    type = formats.DATA;
                    name = "LDUR";
                } else if(ins.indexOf("11010011011") == 0) { // LSL
                    type = formats.READ;
                    name = "LSL";
                } else if(ins.indexOf("11010011010") == 0) { // LSR
                    type = formats.READ;
                    name = "LSR";
                } else if(ins.indexOf("10101010000") == 0) { // ORR
                    type = formats.READ;
                    name = "ORR";
                } else if(ins.indexOf("1011001000") == 0) { // ORRI
                    type = formats.IMMEDIATE;
                    name = "ORRI";
                } else if(ins.indexOf("11111000000") == 0) { // STUR
                    type = formats.DATA;
                    name = "STUR";
                } else if(ins.indexOf("11001011000") == 0) { // SUB
                    type = formats.READ;
                    name = "SUB";
                } else if(ins.indexOf("1101000100") == 0) { // SUBI
                    type = formats.IMMEDIATE;
                    name = "SUBI";
                } else if(ins.indexOf("1111000100") == 0) { // SUBIS
                    type = formats.IMMEDIATE;
                    name = "SUBIS";
                } else if(ins.indexOf("11101011000") == 0) { // SUBS
                    type = formats.READ;
                    name = "SUBS";
                } else if(ins.indexOf("10011011000") == 0) { // MUL
                    type = formats.READ;
                    name = "MUL";
                } else if(ins.indexOf("11111111101") == 0) { // PRNT
                    type = formats.READ;
                    name = "PRNT";
                } else if(ins.indexOf("11111111100") == 0) { // PRNTL
                    type = formats.READ;
                    name = "PRNTL";
                } else if(ins.indexOf("11111111110") == 0) { // DUMP
                    type = formats.READ;
                    name = "DUMP";
                } else if(ins.indexOf("11111111111") == 0) { // HALT
                    type = formats.READ;
                    name = "HALT";
                } else {
                    type = formats.UNFOUND;
                    throw new RuntimeException();
                }

            } catch (Exception e) {
                System.out.println("Error: Unexpected instruction: " + ins);
            }
        }

        //creates a Read Instuction
        if (type == formats.READ) {
            readObject object = new readObject(name, ins);
        }

        else if(type == formats.IMMEDIATE) {
            //TODO
        }

        else if(type == formats.DATA) {
            //TODO
        }

        else if(type == formats.BRANCH) {
            //TODO
        }

        else if(type == formats.COMPAREBRANCH) {
            //TODO
        }


        //TO DO command = object.getCommand();
    }



}
