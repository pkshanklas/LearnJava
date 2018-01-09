package com.example.hackerearth;


import java.util.*;


class TestClass {
    public static void solve(long[] arr, int N, long K, long Q) {

        Arrays.sort(arr);

        int step = (int)Math.ceil((double)N/(double)K);
//        System.out.println(step);
        long min = arr[0];


        int i;

        for (i = 1; i < K - 2; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
        }



//        System.out.println("value of i out of loop"+ i);
//        if( i != N-1 && arr[N-1] < min ) {
////            System.out.println("checking last element" + i);
//            min = arr[N-1];
//        }
        if( arr[N-1] < min) {
            min = arr[N-1];
        }

        System.out.println(min);
        System.out.println(min < Q ? min : "NO");

    }

    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();                 // Reading input from STDIN
        while( T-- > 0 ) {
            int N;
            long K, Q;

            N = s.nextInt();
            long[] arr = new long[N];

            K = s.nextLong();
            Q = s.nextLong();

//            System.out.println(N + " " + K + " " + Q);

            for(int i=0; i<N; i++) {
                arr[i] = s.nextLong();
            }

            solve(arr, N, K, Q);
        }

        s.close();
    }
}
