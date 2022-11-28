public class readObject {
    private String opcode;
    private String rm;
    private String shamt;
    private String rn;
    private String rd;
    /**
     * Name of the instruction (ie ADD or AND)
     */
    private String name;

    /**
     * 32 bit binary instruction
     */
    private String instruct;

    /**
     *
     * @param instName instruction identified
     * @param ins entire instruction in binary
     */
    public readObject(String instName, String ins) {
       //TODO get substring of each part
        name = instName;
        generateInstuction();
    }

    public String getInstruct() {
        return instruct;
    }

    public void setInstruct(String instruct) {
        this.instruct = instruct;
    }

    private void generateInstuction() {

        instruct = name.toUpperCase();
    }
}
