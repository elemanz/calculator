import java.util.Scanner;

public class Calc
{

    static Scanner read = new Scanner(System.in);
    //static String[] str1 = str.split("\\+");

    static String getNum()
    {
        String num = read.next();
        return num;
    }
    static char getOper()
    {
        char sign = read.next().charAt(0);
        return sign;
    }

    static int convert(String value)
    {
        String s = value.toUpperCase();
        String[] sArr = s.split("", s.length());
//        s = s.trim();
        int len = sArr.length;
        int total = 0;
        for (int i = 0; i < len; i++)
        {
            switch (sArr[i])
            {
                case "M":
                    total += 1000;
                    break;
                case "D":
                    total += 500;
                    break;
                case "C":
                    total += 100;
                    break;
                case "L":
                    total += 50;
                    break;
                case "X":
                    total += 10;
                    break;
                case "V":
                    total += 5;
                    break;
                case "I":
                    total += 1;
                    break;
            }
        }
        return total;
    }

    static int calculate(int num1, int num2, char sign){
        int result = 0;
        switch (sign){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;\
            case '/':
                result = num1/num2;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        int num1 = convert(getNum());
        char ch = getOper();
        int num2 = convert(getNum());
        int result = calculate(num1, num2, ch);
        System.out.println(result);

    }
}