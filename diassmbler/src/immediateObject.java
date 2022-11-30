public class immediateObject {
    private String opcode;
    private String alu;
    private String rn;
    private String rd;

    private String name;
    ;
    /**
     * 32 bit binary instruction
     */
    private String instruct;

    public immediateObject(String instName, String ins) {
        name = instName;
        opcode = ins.substring(0, 10);
        alu = ins.substring(10, 22);
        rn = ins.substring(22, 27);
        rd = ins.substring(27, 31);

    }

    public String getInstruct() {
        return instruct;
    }

    public void setInstruct(String instruct) {
        this.instruct = instruct;
    }

    private void generateInstuction() {
        instruct = name.toUpperCase();
        int length = opcode.length() + alu.length() + rn.length() + rd.length();
        instruct += "\nopcode: " + opcode + "\nalu: " + alu + "\nrn: " + rn + "\nrd: " + rd + "LENGTH: " + length;
    }
}
