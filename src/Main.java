public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main m1 = new Main();
        System.out.println(m1.fibonacci(7));
        m1.print(4);
        System.out.println(m1.factorial(5));
        System.out.println(m1.sum(11));
        System.out.println(m1.sumDigits(4839));
        System.out.println(m1.productDigit(12345));
        System.out.println(m1.reverse(1234987));

        System.out.println(m1.countZero(1001001100,0));
    }

    public int fibonacci(int n ){
        if(n == 0||n==1 ){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    // fibonacci numbers
    // fib(n) = fib(n-1) + fib(n-2)
    // 0 1 1 2 3 5 8 13 ..
    // 0 1 2 3 4 5 6 7 ..

    public void print(int n ){
        if(n==1){
            System.out.println(n);
            return;

        }
        print(n-1);
        System.out.println(n);
    }

    public int factorial(int n ){

        if(n==0){
            return 1;
        }
        return n *factorial(n-1);
    }

    public int sum(int n ){
        if(n==1){
            return 1;

        }

        return n +sum(n-1);
    }


    public int sumDigits(int n ){
        if(n==0){
            return 0;
        }
        int res = n%10;
        int c =  res + sumDigits(n/10);
        if(c<10){
            return c;
        }else{
            return sumDigits(c);
        }
    }

    public int productDigit(int n ){
        if(n<10){
            return n;
        }

        int x = n%10;
        int c =  x*productDigit(n/10);
        if(c<10){
            return c;
        }else{
            return productDigit(c);
        }

    }

    public int reverse(int n ){
       int digits = (int)(Math.log10(n)) +1;

       return helperRev(n, digits);

    }

    private int helperRev(int n, int digits) {
    if(n%10 == n){
        return n;
    }
    int rem = n%10;
    return rem*(int)(Math.pow(10,digits-1))+helperRev(n/10,digits-1);

    }


    // counting zeroes in  a number

    public int countZero(int n , int count){

        if(n<10 && n != 0 ){
            return count;
        }
        if(n<10 && n == 0 ){
            return count+1;
        }

        int rem = n%10;
        if(rem == 0 ){
            return countZero(n/10,count+1);

        }else{
            return countZero(n/10,count);
        }
    }

}