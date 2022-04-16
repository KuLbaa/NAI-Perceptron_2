import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trainer {
    private static boolean iris = false;
    private static String SecondFlawer;
    private String trainset = "";
    private String testset = "";
    private int dimension;
    private Percepton percepton;
    private ArrayList<double[]> AllX;
    private ArrayList<Integer> AllD;

    public Trainer(String trainset, String testset, int dimension){
        this.testset = testset;
        this.trainset = trainset;
        this.dimension = dimension;
        percepton = new Percepton(dimension);
        AllX = new ArrayList<>();
        AllD = new ArrayList<>();

    }
    public void ReadTrainFIle(){
        int d =0;
        try {
            Scanner sc = new Scanner(new File(trainset));
            while(sc.hasNextLine()) {
                String line[] = sc.nextLine().split(",");
                double x[] = new double[dimension];
                for (int l = 0; l < x.length; l++) {
                    x[l] = Double.parseDouble(line[l]);

                }
                try {
                    d = Integer.parseInt(line[dimension]);
                    System.out.println("Liczbaaa");
                }
                catch(NumberFormatException e) {
                    System.out.println("kwiat");
                    iris = true;
                    if(line[dimension] == "setosa"){
                        d= 1;
                    }
                    else{
                        SecondFlawer = line[dimension];
                        d =-1;
                    }

                }
                AllD.add(d);
                AllX.add(x);

            }
            sc.close();
            System.out.println(AllX);
            System.out.println(AllD);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void ReadTestFileAndCompute(){
        int d=0;
        try {
            Scanner scc = new Scanner(new File(testset));
            while(scc.hasNextLine()){
                String lines[] = scc.nextLine().split(",");
                double x[] = new double[dimension];
                for(int i=0; i<x.length; i++){
                    x[i] = Double.parseDouble(lines[i]);
                }
                d = Integer.parseInt(lines[dimension]);
               int y = percepton.Compute(x, d);
                if(iris == true){
                    if(y ==-1){
                        System.out.println("Wynik: " + "setosa");
                    }
                    else
                        System.out.println("Wynik: " + SecondFlawer);
                }
                else
                    System.out.println("Wynik: " + y);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }





    }

    public int ComputeAndLearn(){
        int count=0;
        for(int i=0; i<AllX.size(); i++){
           double x[] = AllX.get(i);
           int d = AllD.get(i);
           int y = percepton.Compute(x, 0);
           if(d !=y){
               count++;
           }
           System.out.println(y);
           percepton.Learn(x, d, y);

        }
            return count;

    }
}
