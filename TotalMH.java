public class TotalMH extends ReportMH implements Formula{

    private double total=0;

    public TotalMH(int quantity[], int average[]){
        super(quantity, average);
    }

    public double calculate(){
        double sum;

        for (int i=0; i<quantity.length; i++){
            sum = quantity[i] * average[i];
            total+=sum;
        }
        return total;
    }
}