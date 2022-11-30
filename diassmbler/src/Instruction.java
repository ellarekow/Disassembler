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
                //ADD
                if(ins.indexOf("10001011000") == 0){
                    type = formats.READ;
                    name = "add";
                }

                //AND
                else if(ins.indexOf("10001010000") == 0) {
                    type = formats.READ;
                    name = "and";
                }

                //Opcode not found
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
            command = object.getInstruct();
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
