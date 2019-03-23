public abstract class ReportMH{
    int quantity[] = new int[3];
    int average[] = new int[3];

    protected ReportMH(int quantiy[], int average[]){
        this.quantity = quantiy;
        this.average = average;
    }
}