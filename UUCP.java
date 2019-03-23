public class UUCP implements Formula{
    double totalac;
    double totaluc;
    double total;

    public UUCP(double totalac, double totaluc){
        this.totalac = totalac;
        this.totaluc = totaluc;
    }

    public double calculate(){
        total = totalac + totaluc;
        return total;
    }
}