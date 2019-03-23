import java.util.*;

public class RTredo{
    public static Scanner scan;

    public static void main(String[]args){
        System.out.println("                   ==================================");
        System.out.println("                   ||  Software Effort Estimation  ||");
        System.out.println("                   ==================================");
        System.out.println("");
        System.out.println("");
        input();
    }

    public static void input(){
        scan = new Scanner(System.in);

        try{
            //---------------- Calculate Weighted Actors ---------------------
            int actor [] = new int [3];
            System.out.println("1. Weighting Actors for Complexity");
            System.out.println("Please input the quantity for each actor type.");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("[Actor Type |              Description                 | Weight Factor |  Quantity  ]");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print("|  Simple   |              Defined API                 |       1       |     ");
            actor[0] = scan.nextInt();
            System.out.print("|  Average  | Interactive or Protocol driven interface |       2       |     ");
            actor[1] = scan.nextInt();
            System.out.print("|  Complex  |          Graphical User Interface        |       3       |     ");
            actor[2] = scan.nextInt();
            System.out.println("-------------------------------------------------------------------------------------");
            Actor act = new WeightAC(actor);
            WeightAC acw = (WeightAC)act;
            double totalAC = acw.calculate();
            System.out.println("");
            System.out.println("Total Actor Points : " + totalAC);
            System.out.println("=====================================================================================================================");
            System.out.println("");

            //----------- Calculate Weighted Use Cases -----------
            int usecase [] = new int [3];
            System.out.println("2. Weighting Use Cases for Complexity");
            System.out.println("Please input the quantity for each use case type.");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("[Use Case Type |         Description             | Weight Factor |   Quantity  ]");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("|  Simple      |     3 or fewer transactions     |       5       |     ");
            usecase[0] = scan.nextInt();
            System.out.print("|  Average     |       4 to 7 transactions       |       10      |     ");
            usecase[1] = scan.nextInt();
            System.out.print("|  Complex     |   Greater than 7 transactions   |       15      |     ");
            usecase[2] = scan.nextInt();
            System.out.println("--------------------------------------------------------------------------------");
            UseCase uc = new WeightUC(usecase);
            WeightUC ucw = (WeightUC)uc;
            double totalUC = ucw.calculate();
            System.out.println("");
            System.out.println("Total Use Case : " + totalUC);
            System.out.println("=====================================================================================================================");
            System.out.println("");
        
            //--------------- Calculate Unadjusted Use Case Points (UUCP) ------------------
            UUCP uucp = new UUCP(totalAC, totalUC);
            double totaluucp = uucp.calculate();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("| Weighted Actors + Weighted Use Cases = Unadjusted Use Case Points(UUCP) |");
            System.out.println("| Unadjusted Use Case Points : " + totaluucp);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("=====================================================================================================================");
            System.out.println("");

            //====================================================================================================================================

            //--------------- Calculate Technical Factors -----------------------
            double tfactor [] = new double[13];
            System.out.println("3. Weighting Technical Factors");
            System.out.println("Rate each factor from 0 to 5.");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("[ Technical Type  |              Factor Description                   | Weight Factor |  Project Rating (0 to 5) ]");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.print("|       T1        |         Must have a distributed solution          |       2       |            ");
            tfactor[0] = scan.nextDouble();
            System.out.print("|       T2        |  Must respond to specific performance objectives  |       1       |            ");
            tfactor[1] = scan.nextDouble();
            System.out.print("|       T3        |       Must meet end-user efficiency desire        |       1       |            ");
            tfactor[2] = scan.nextDouble();
            System.out.print("|       T4        |           Complex internal processing             |       1       |            ");
            tfactor[3] = scan.nextDouble();
            System.out.print("|       T5        |              Code must be reusable                |       1       |            ");
            tfactor[4] = scan.nextDouble();
            System.out.print("|       T6        |              Must be easy to install              |       .5      |            ");
            tfactor[5] = scan.nextDouble();
            System.out.print("|       T7        |               Must be easy to use                 |       .5      |            ");
            tfactor[6] = scan.nextDouble();
            System.out.print("|       T8        |                 Must be portable                  |       2       |            ");
            tfactor[7] = scan.nextDouble();
            System.out.print("|       T9        |               Must be easy to change              |       1       |            ");
            tfactor[8] = scan.nextDouble();
            System.out.print("|       T10       |             Must allow concurrent users           |       1       |            ");
            tfactor[9] = scan.nextDouble();
            System.out.print("|       T11       |         Includes special security features        |       1       |            ");
            tfactor[10] = scan.nextDouble();
            System.out.print("|       T12       |     Must provide direct access for 3rd parties    |       1       |            ");
            tfactor[11] = scan.nextDouble();
            System.out.print("|       T13       |     Requires special user training facilities     |       1       |            ");
            tfactor[12] = scan.nextDouble();
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            TFactor tf = new WeightTFactor(tfactor);
            WeightTFactor wtf = (WeightTFactor)tf;
            double tFactor = wtf.calculate();
            System.out.println("TFactor : " + tFactor);
            System.out.println("");
            System.out.println("=====================================================================================================================");
            System.out.println("");

            //-------- Calculate Technical Complexity Factor (TCF) & Size of the sofware (Use case)/ (SzUC) -----------------
            double tcf = ((0.01*tFactor)+0.6);
            double szuc = totaluucp*tcf;
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.printf("| Technical Complexity Factor (TCF) : %.2f TCF |\n", tcf);
            System.out.println("|----------------------------------------------|");
            System.out.printf("| Size of the sofware (Use case) : %.2f       |\n", szuc);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("=====================================================================================================================");

            //----------------------- Calculate Experience Factors (EF) --------------------------------
            double efactor [] = new double [8];
            System.out.println("4. Weighting Experience Factors");
            System.out.println("Rate each factor from 0 to 5.");
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.println("[ Experience Factor  |              Factor Description                   | Weight Factor |  Project Rating (0 to 5) ]");
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.print("|         E1         |        Familiar with FPT software process         |       1       |            ");
            efactor[0] = scan.nextDouble();
            System.out.print("|         E2         |              Application experience               |      0.5      |            ");
            efactor[1] = scan.nextDouble();
            System.out.print("|         E3         |              Paradigm experience (OO)             |       1       |            ");
            efactor[2] = scan.nextDouble();
            System.out.print("|         E4         |              Lead analyst capability              |      0.5      |            ");
            efactor[3] = scan.nextDouble(); 
            System.out.print("|         E5         |                    Motivation                     |       0       |            ");
            efactor[4] = scan.nextDouble();
            System.out.print("|         E6         |                Stable Requirements                |       2       |            ");
            efactor[5] = scan.nextDouble();
            System.out.print("|         E7         |                 Part-time workers                 |      -1       |            ");
            efactor[6] = scan.nextDouble();
            System.out.print("|         E8         |        Difficulty of programming language         |      -1       |            ");
            efactor[7] = scan.nextDouble();
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            EFactor ef = new TotalEFactor(efactor);
            TotalEFactor tef = (TotalEFactor)ef;
            double eFactor = tef.calculate();
            System.out.println("Efactor : " + eFactor);
            System.out.println("");
            System.out.println("=====================================================================================================================");
            System.out.println("");

            //----------- Calculate EF & UCP ---------------------
            double exfactor = ((-0.03)*eFactor)+1.4;
            double ucp = szuc*exfactor;   //ucp = size of software(use case)* experience factor
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.printf("| Experience Factor(EF) : %.2f    |\n", exfactor);
            System.out.println("|---------------------------------|");
            System.out.printf("| Use Case Points (UCP) : %.3f  |\n", ucp);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("=====================================================================================================================");
            System.out.println("");
            
            //=================================================================================================

            //------------------- Calculate Man-hours from UCP -----------------------------
            System.out.println("5. Calculating Man-hours from UCP");
            System.out.println("");
            System.out.println("Calculating Effort Rate.....");
            EffortRate eff = new EffortRate(efactor);
            double erate = eff.calculate();
            System.out.println("Effort Rate: " + erate);

            if(erate==0){
                System.out.println("This project is at significant risk of failure with this team. Consider restructuring the project team");
                System.exit(0);
                System.out.println("");
            }

            double totalMH = erate*ucp;  //total man-hours = effort rate * use case point
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("| Effort Rate(ER) * Use Case Points(UCPs) = total man-hours |");
            System.out.println("-------------------------------------------------------------");
            System.out.printf("| Total Man-hours : %.3f                                |\n", totalMH);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("=====================================================================================================================");
            System.out.println("");

            //-------------------- Calculate Adjusted man-hours ------------------------------
            double percent;
            System.out.println("6. Adjusting Man-hours for Risk");
            System.out.println("(i.e. Increase estimate by 5% for a new reuse effort. Coefficient = 0.05)");
            System.out.println("");
            System.out.print("Enter a coefficient as a percentage : ");
            percent = scan.nextDouble();
            double adjustMH = (1.0 + percent)* totalMH; //adjusted man-hours = (1.0 + .xx[%])*total man-hours
            System.out.println("");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.printf("| Adjusted man-hours : %.2f |\n", adjustMH);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("=====================================================================================================================");
            System.out.println("");

            //-------------------- Calculate Report Man-hour Estimate ---------------------
            int Quantity [] = new int[3];
            int Average [] = new int[3];
            System.out.println("7. Weighting Reports for Complexity");
            System.out.println("");
            System.out.println("Report type: Simple");
            System.out.println("--------------------");
            System.out.print("Quantity          : ");
            Quantity[0] = scan.nextInt();
            System.out.print("Average Man-hours : ");
            Average[0] = scan.nextInt();
            System.out.println("");
            System.out.println("");
            System.out.println("Report type: Average");
            System.out.println("---------------------");
            System.out.print("Quantity          : ");
            Quantity[1]= scan.nextInt();
            System.out.print("Average Man-hours : ");
            Average[1] = scan.nextInt();
            System.out.println("");
            System.out.println("");
            System.out.println("Report type: Complex");
            System.out.println("---------------------");
            System.out.print("Quantity          : ");
            Quantity[2] = scan.nextInt();
            System.out.print("Average Man-hours : ");
            Average[2] = scan.nextInt();
            System.out.println("");
            System.out.println("------------------------------");
            System.out.println("");
            TotalMH mh = new TotalMH(Quantity, Average);
            double totalReportMH = mh.calculate();
            System.out.println("Total Report Man-hour Estimate : " + totalReportMH);
            System.out.println("");
            System.out.println("");

            //-------------------- Calculate Total Man-hours ----------------------------
            double totalMh = adjustMH + totalReportMH;   //total man-hours = adjusted man-hours + Reporting man-hours
            System.out.println("==============================");
            System.out.printf("| Total man-hours : %.2f  |\n", totalMh);
            System.out.println("==============================");

        } catch (InputMismatchException e){
            System.out.println("");
            System.out.println("");
            System.out.println("=====================");
            System.out.println("| Input digit only! |");
            System.out.println("=====================");
            System.out.println("");
            input();
        } 
        
    }

    
}