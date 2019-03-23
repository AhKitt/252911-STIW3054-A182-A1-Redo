public class TotalEFactor extends EFactor implements Formula{
    private double total;

    public TotalEFactor(double efactor[]){
        super(efactor);
    }

    public double calculate(){
        double ef [] = {1, 0.5, 1, 0.5, 0, 2, -1, -1};
        double sum;

        for (int i=0; i<efactor.length; i++){
            sum = ef[i] * efactor[i];
            total+=sum;
        }
        return total;
    }
}