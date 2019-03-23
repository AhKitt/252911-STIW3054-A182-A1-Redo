public class WeightTFactor extends TFactor implements Formula{
    
    private double total=0;

    public WeightTFactor(double tfactor[]){
        super(tfactor);
    }

    public double calculate(){
        double tf [] = {2, 1, 1, 1, 1, 0.5, 0.5, 2, 1, 1, 1, 1, 1};
        double sum;

        for (int i=0; i<tfactor.length; i++){
            sum = tf[i] * tfactor[i];
            total += sum;
        }
        return total;
    }
}