public class WeightUC extends UseCase implements Formula{
    private double total = 0;

    public WeightUC(int usecase[]){
        super(usecase);
    }

    public double calculate(){
        int usecaseW [] = {5, 10, 15};
        double sum;

        for (int i=0; i<usecase.length; i++){
            sum = usecase[i] * usecaseW[i];
            total+=sum;
        }
        return total;
    }
}
