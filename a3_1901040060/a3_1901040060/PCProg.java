package a3_1901040060;

import java.util.Scanner;
import java.util.Vector;
import static utils.TextIO.getln;
import static utils.TextIO.getlnInt;
import static utils.TextIO.putln;
import static utils.TextIO.writeFile;
import static utils.TextIO.writeStandardOutput;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;
import static utils.TextIO.getlnChar;

/**
 * @overview PCProg is a program that captures data about PC objects and
 * displays a report about them on the console.
 *
 * @attributes objs Set<PC>
 *
 * @object A typical PCProg is {c1,...,cn} where c1,...,cn are pcs
 *
 * @abstract_properties mutable(objs)=true /\ optional(objs)=false
 */
public class PCProg {

    @DomainConstraint(mutable = true, optional = false)
    private Set<PC> objs;

    /**
     * @effects initialise this to have an empty set of PCs
     */
    public PCProg() {
        objs = new Set<>();
    }

    /**
     * @effects if objs is not empty display to the standard console a
     * text-based tabular report on objs return this report else display nothing
     * and return null
     */
    public String displayReport() {
        if (objs.size() > 0) {
            Vector<PC> pcs = objs.getElements();

            PCReport reportObj = new PCReport();
            return reportObj.displayReport(pcs.toArray(new PC[pcs.size()]));
        } else {
            return null;
        }
    }

    /**
     *
     * @effects: return recorded pc
     */
    public Object[] getObjects() {
        return objs.getObjects();
    }

    /**
     * @effects save report to a file pcs.txt in the same directory as the
     * program's
     */
    public void saveReport(String report) {
        String fileName = "pcs.txt";
        writeFile(fileName);
        putln(report);
        writeStandardOutput();
    }

    /**
     * @effect Create set of pc
     */
    public void createObjects() {
        boolean isContinue = true;
        Scanner sc = new Scanner(System.in);
       while(isContinue){
           System.out.println("Enter model: ");
           String model = sc.nextLine();
           System.out.println("Enter year: ");
           int year = Integer.parseInt(sc.nextLine());
           System.out.println("Enter manufacturer: ");
           String manu = sc.nextLine();
           Set<String> comps = new Set<>();
           System.out.println("Enter components: ");
           boolean check = true;
           do{
               comps.insert(sc.nextLine());
               System.out.println("Do you want input more component?(Y/N)");
               String ans = sc.nextLine();
               switch (ans){
                   case "Y":
                   case "y":
                       check = true;
                       break;
                   case "N":
                   case "n":
                       check = false;
                       break;
                   default:
                       check = false;
                       System.out.println("Invalid input!");
                       break;
               }
           }while(check);         
           PC pc = PCFactory.getInstance().createPC(model, year, manu, comps);
           objs.insert(pc);
           System.out.println("Do you want to continue? (Y/N)");
           isContinue = (sc.nextLine().equalsIgnoreCase("Y"))? true:false;
       }
    }

    /**
     * The run method
     *
     * @effects initialise an instance of PCProg create objects from data
     * entered by the user display a report on the objects prompt user to save
     * report to file if user answers "Y" save report else end
     */
    public static void main(String[] args) {
        //
        PCProg prog = new PCProg();

        // create objects
        try {
            prog.createObjects();
            // display report
            String report = prog.displayReport();

            if (report != null) {
                // prompt user to save report
                putln("Save report to file? [Y/N]");
                String toSave = getln();
                if (toSave.equals("Y")) {
                    prog.saveReport(report);
                    putln("report saved");
                }
            }
        } catch (NotPossibleException e) {
            System.err.printf("%s: %s%n", e, e.getMessage());
        }

        putln("~END~");
    }
}
