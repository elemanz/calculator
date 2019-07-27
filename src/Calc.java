import java.util.Scanner;

public class Calc
{
    public static void main(String[] args) {
        Calculator CalcDemo = new Calculator();
        CalcDemo.calculate();
    }
}

class Calculator
{
    static Scanner read = new Scanner(System.in);
    static int countisArabicNumber = 0;
    static int count = 0;

    static String getNum() // получение Числа
    {
        String num = read.next();
        return convert(num);
    }
    static char getOper() // получение Оператора
    {
        char sign = read.next().charAt(0);
        return sign;
    }

    static String convert(String value) // Конвертировние с Римского на Арабский
    {
        String s = value.toUpperCase();
        String[] sArr = s.split("", s.length());
        int len = sArr.length;
        int total = 0;
        for (int i = 0; i < len; i++)
        {
            if (len > 1 && len > i+1 ) {
                if ((sArr[i].equals("I") && sArr[i + 1].equals("V"))) {
                    sArr[i] = "IV";
                }
                if ((sArr[i].equals("I") && sArr[i + 1].equals("X"))) {
                    sArr[i] = "IX";
                }
                if (sArr[i].equals("C") && sArr[i + 1].equals("D")) {
                    sArr[i] = "CD";
                }
                if (sArr[i].equals("C") && sArr[i + 1].equals("M")) {
                    sArr[i] = "CM";
                }
            }
            switch (sArr[i])
            {
                case "M":
                    total += 1000;
                    break;
                case "CM":
                    total += 900;
                    len -= 1;
                    break;
                case "D":
                    total += 500;
                    break;
                case "CD":
                    total += 400;
                    len -= 1;
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
                case "IX":
                    total += 9;
                    len -= 1;
                    break;
                case "V":
                    total += 5;
                    break;
                case "IV":
                    total += 4;
                    len -= 1;
                    break;
                case "I":
                    total += 1;
                    break;
                default:
                    countisArabicNumber += 1;
                    total = Integer.parseInt(s);
            }
        }
        return Integer.toString(total);
    }

    public static int result(int num1, int num2, char sign){ //возвращает результат
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
                break;
            case '/':
                result = num1/num2;
                break;
        }
        return result;
    }

    public static void calculate() { // вычисление
        try {
            int num1 = Integer.parseInt(getNum());
            char ch = getOper();
            int num2 = Integer.parseInt(getNum());
            int result = result(num1, num2, ch);
            if(countisArabicNumber>0)
            {
                count += 1;
            }
            else if (countisArabicNumber == 0){
                count = 0;
            }
            if (count==2 || count==0){
                System.out.println(result);

            }
            else
                System.out.println("Введите только Римское или Арабское число");

        }
        catch (ArithmeticException e){
            System.out.println("деление на ноль нельзя");
        }
        catch (NumberFormatException e){
            System.out.println("Введите правильные числа");
        }

    }
}