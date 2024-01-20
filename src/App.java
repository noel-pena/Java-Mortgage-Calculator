import java.text.NumberFormat;
import java.util.Scanner;

//Mortgage Project
public class App {
    public static void main(String[] args) throws Exception {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float annualInterest = 0;
        float monthlyInterest = 0;
        byte years = 0;
        int numberOfPayments = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.print("Principal ($1k - $1M): ");
            principal = scanner.nextInt();
            if(principal >= 1000 && principal <= 1000000 ){
                break;
            } else {
            System.out.println("Enter a number between 1,000 and 1,000,000.");
            }
        }

        while(true){
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
            if(annualInterest > 0 && annualInterest <= 30){
                break;
            } else {
                System.out.println("Enter a value greater than 0 and less than less or equal to 30.");
            }
        }

        while(true){
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            numberOfPayments = years * MONTHS_IN_YEAR;
            if(years >= 1 && years <= 30){
                break;
            } else {
                System.out.println("Enter a value between 1 and 30.");
            }
        }

        double mortgage = principal
                    * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) -1);
        
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        
        System.out.print(mortgageFormatted);
    }
};
