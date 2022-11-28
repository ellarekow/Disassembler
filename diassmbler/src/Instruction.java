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
        String opcode = ins.substring(0, 11);
        String name = "";
        formats type = formats.NONE;


        while(type == formats.NONE) {
            try {
                // checks all 11 bit opcodes
                if (opcode.length() == 11) {
                    switch (opcode) {
                        //ADD
                        case "10001011000":
                            type = formats.READ;
                            name = "add";
                            break;

                        //AND
                        case "10001010000":
                            type = formats.READ;
                            name = "and";
                            break;

                        default:
                            //removes a bit
                            opcode = opcode.substring(0, 10);
                            break;

                    }
                }

                //Opcode length 10
                else if (opcode.length() == 10) {
                    switch(opcode) {
                        default:
                            opcode = opcode.substring(0, 9);
                            break;
                    }
                }

                //Opcode length 8
                else if (opcode.length() == 8) {
                    switch(opcode) {
                        default:
                            opcode = opcode.substring(0, 7);
                            break;
                    }
                }

                else if(opcode.length() == 6) {
                    switch(opcode) {
                        default:
                            type = formats.UNFOUND;
                            throw new RuntimeException();
                            break;
                    }
                }

                else if(opcode.length() > 6) {
                    opcode = opcode.substring(0, opcode.length() - 1);
                }

                //Opcode not found
                //SHOULD NOT BE IN OUR LIST OF INSTRUCTS
                //TODO is this needed?
                else{
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
