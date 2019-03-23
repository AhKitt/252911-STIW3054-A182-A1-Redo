public class EffortRate{
    double ef [] = new double[8];
    double er;

    public EffortRate(double ef[]){
        this.ef = ef;
    }

    public double calculate(){
        int count=0;

        for (int i=0; i<=5; i++){
            if(ef[i]<3){
                count++;
            }
        }
        for (int i=6; i<ef.length; i++){
            if(ef[i]>=3){
                count++;
            }
        }
        
        if(count<=2){
            return er=20;
        }

        else if(count>2 && count<=4){
            return er=28;
        }

        else{
            return er=0;
        }
    }
}