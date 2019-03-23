public class WeightAC extends Actor implements Formula{
    private double total;

    public WeightAC(int []actor){
        super(actor);
    }

    public double calculate(){
        int actorW [] = {1, 2, 3};
        double sum;

        for (int i=0; i<actor.length; i++){
            sum = actor[i] * actorW[i];
            total+=sum;
        }
        return total;
    }
}
    