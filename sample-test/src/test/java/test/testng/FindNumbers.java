package test.testng;

public class FindNumbers {

    public static void main(String[] args) {
        int a1;
        int a2;
        int a3 = 9;
        int b1;
        int b2;
        int b3;
        int c1;
        int c2;
        int c3;

        int n = 100;
        int s = 1;


        for (int ia1 = s; ia1 < n; ia1++) {
            a1 = ia1;
            for (int ia2 = s; ia2 < n; ia2++) {
                a2 = ia2;
                if (a1 + a2 - a3 != 4) {
                    continue;
                }
//                for (int ia3 = s; ia3 < n; ia3++) {
                a3 = 9;
                if (a1 + a2 - a3 != 4) {
                    continue;
                }

                for (int ib1 = s; ib1 < n; ib1++) {
                    b1 = ib1;
                    for (int ib2 = s; ib2 < n; ib2++) {
                        b2 = ib2;
//                        for (int ib3 = s; ib3 < n; ib3++) {
//                            b3 = ib3;
//                            if (b1 - b2 * b3 != 4) {
//                                continue;
//                            }

                        b3 = (b1 - 4) / b2;
//                            for (int ic1 = 1; ic1 < n; ic1++) {
//                                c1 = ic1;
//                                if (a1 + b1 / c1 != 4) {
//                                    continue;
//                                }

                        c1 = (4 - a1) / b1;

                        c2 = (a2 - 4) / b2;
//                                for (int ic2 = s; ic2 < n; ic2++) {
//                                    c2 = ic2;
                        if (a2 - b2 * c2 != 4) {
                            continue;
                        }
//                                    for (int ic3 = s; ic3 < n; ic3++) {
//                                        c3 = ic3;
                        if ((a3 - b3 - 4) != (c1 + c2 - 4)) {
                            continue;
                        }
                        c3 = c1 + c2 - 4;

//
//                                        if (c1 + c2 - c3 != 4) {
//                                            continue;
//                                        }
//                                        if (a3 - b3 - c3 != 4) {
//                                            continue;
//                                        }


                        System.out.println("result" + a1 + "," + a2 + "," + a3 + "," + b1 + "," + b2 + "," + b3 + "," + c1 + "," + c2 + "," + c3);
//                                }
//                                }
//                            }
//                        }
                    }
                }
            }
        }
    }
}

