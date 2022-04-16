public class Percepton {
    private int dimension;
    private double weight[];
    private double threshold = 0.8;
    private int odchylenie = 1; //odchylenie
    private double learningrate = 0.1;
   public Percepton(int dimension){
       this.dimension = dimension;
       weight = new double[dimension];
       for(int i=0; i<weight.length; i++){

           weight[i] = 1;
       }

   }
   public int Compute(double x[], int d){
       double sum = 0;
       for(int j=0; j< x.length; j++){

           sum+=weight[j]*x[j];

       }
       sum+= odchylenie;
       if(sum >= 0 && d < threshold){
           return 1; //setosa
       }
       else if(sum>0 && d < threshold) {
           return -1; //pozostale kwiaty
       }

   }
   public void Learn(double x[], int d, int y){

       for(int k=0; k< x.length; k++){
           double dw = learningrate*(d-y)*x[k];
           weight[k]+= dw;

       }
       for(int i=0; i< weight.length; i++){
           System.out.print(weight[i]+",");

       }
       System.out.println();

   }




}
