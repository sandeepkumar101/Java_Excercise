package StreamExample;

public class BinaryToDecimalExample {
    public static int getDecimal(int binary){  
        int decimal = 0;  
        int n = 0;  
        while(true){  
          if(binary == 0){  
            break;  
          } else {  
              int temp = binary%10;  
              decimal += temp*Math.pow(2, n);  
              binary = binary/10;  
              n++;  
           }  
        }  
        return decimal;  
    }  
    public static void main(String args[]){    
        int a=1;    
char c=(char)a;    
System.out.println(c); 
    System.out.println("Decimal of 1010 is: "+getDecimal(1000));  
    System.out.println("Decimal of 10101 is: "+getDecimal(111));  
    System.out.println("Decimal of 11111 is: "+getDecimal(11111));  
    }}    
