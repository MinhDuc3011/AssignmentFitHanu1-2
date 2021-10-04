package a3_1901040060;

/**
 * @overview  show the PC Report
 */
public class PCReport {

    /**
     * @effects
     *  a tabular report about PC objects is returned and generated in this
     */
    public String displayReport(PC[] objects) {
        int col1 = 3, col2 = 20, col3 = 6,
                col4 = 20, col5 = 50;
        String str = "";
        int count = 1;
        for(int i=0;i<99;i++){
            str+="-";
        }
        str+="\n";
        str += "                                           PCPROG REPORT\n";
        for(int i=0;i<99;i++){
            str+="-";
        }
        str+="\n";
        for (PC pc : objects) {
            str += String.format("%" + col1 + "s", count + " ");
            str += String.format("%" + col2 + "s", pc.getModel() + " ");
            str += String.format("%" + col3 + "s", pc.getYear() + " ");
            str += String.format("%" + col4 + "s", pc.getManufacturer() + " ");
            str += String.format("%" + col5 + "s%n", pc.getComps().toArrayString ());
            count++;
        }
        for(int i=0;i<99;i++){
            str+="-";
        }
        str+="\n";
        return str;
    }

}