public class main {
    public static void main(String args[])
    {
            Trainer tr = new Trainer("train-set.txt", "test-set.txt", 2);
            tr.ReadTrainFIle();

            int count = tr.ComputeAndLearn();
            for(int i=0; i<50; i++){
                count = tr.ComputeAndLearn();
           }

           tr.ReadTestFileAndCompute();

    }
}
