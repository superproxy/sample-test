package test.junit;

public class Fibonacci {

    //    F0=0，F1=1，Fn=F(n-1)+F(n-2)（
    public static int compute(int fInput) {

        if (fInput < 0) {
            throw new UnsupportedOperationException("fInput is less than zero");
        }


        int f0 = 0;
        if (fInput == 0) {
            return f0;
        }

        int f1 = 1;
        if (fInput == 1) {
            return f1;
        }

        int next = 0;
        for (int n = 2; n <= fInput; n++) {
            next = f0 + f1;
            f0 = f1;
            f1 = next;
        }
        return next;
    }



//    public static int fibonacci(int n){
//        if(n <= 2){
//            return 1;
//        }else{
//            return fibonacci(n-1) + fibonacci(n-2);
//        }
//    }
}
