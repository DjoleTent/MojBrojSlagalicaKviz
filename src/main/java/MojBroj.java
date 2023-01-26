import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class MojBroj {
    public static void main(String[] args) {
        System.out.println("Dobro dosli u igru Moj Broj");

        Scanner s = new Scanner(System.in);
        ArrayList<Integer> sviBrojevi = new ArrayList<Integer>();

        int zadatiBroj = (int) ((Math.random()) * 1000);

        System.out.println("Moj Broj je: " + zadatiBroj);

        int od1do91 = ThreadLocalRandom.current().nextInt(1, 10);
        int od1do92 = ThreadLocalRandom.current().nextInt(1, 10);
        int od1do93 = ThreadLocalRandom.current().nextInt(1, 10);
        int od1do94 = ThreadLocalRandom.current().nextInt(1, 10);

        int[] niz101520 = new int[]{10, 15, 20};
        int biraj = ThreadLocalRandom.current().nextInt(0, 3);
        int od10do20 = niz101520[biraj];

        int[] niz255075100 = new int[]{25, 50, 75, 100};
        int biraj2 = ThreadLocalRandom.current().nextInt(0, 4);
        int od25do100 = niz255075100[biraj2];


        System.out.println("Uz pomoc brojeva: " + od1do91 + ", " + od1do92 + ", " + od1do93 + ", " + od1do94
                + ", " + od10do20 + ", " + od25do100);

        sviBrojevi.add(od1do91);
        sviBrojevi.add(od1do92);
        sviBrojevi.add(od1do93);
        sviBrojevi.add(od1do94);
        sviBrojevi.add(od10do20);
        sviBrojevi.add(od25do100);
        System.out.println(sviBrojevi);

//        int resenje = 0;
        System.out.println("Racunaj: ");
        String input = s.nextLine();
        String[] inputList = input.split(" ");
        Stack<Integer> numbers = new Stack<Integer>();
        Stack<String> operators = new Stack<String>();
        Stack<Integer> numbersReverse = new Stack<Integer>();
        Stack<String> operatorsReverse = new Stack<String>();

        for (int i = 0; i < inputList.length; i++) {
            String token = inputList[i];
            if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
                if (!operators.isEmpty() && (operators.peek().equals("*") || operators.peek().equals("/"))) {
                    String operator = operators.pop();
                    int num2 = numbers.pop();
                    int num1 = numbers.pop();
                    switch (operator) {
                        case "*":
                            numbers.push(num1 * num2);
                            break;
                        case "/":
                            numbers.push(num1 / num2);
                            break;
                    }
                }
                operators.push(token);
            } else {
                numbers.push(Integer.parseInt(token));
            }
        }

        while(!operators.isEmpty()){
            operatorsReverse.push(operators.pop());
        }
        while (!numbers.isEmpty()){
            numbersReverse.push(numbers.pop());
        }

        while (!operatorsReverse.isEmpty()) {
            String operator = operatorsReverse.pop();
            int num1 = numbersReverse.pop();
            int num2 = numbersReverse.pop();

                switch (operator) {
                    case "+":
                        numbersReverse.push(num1 + num2);
                        break;
                    case "-":
                        numbersReverse.push(num1 - num2);
                        break;
                    case "*":
                        numbersReverse.push(num1 * num2);
                        break;
                    case "/":
                        numbersReverse.push(num1 / num2);
                        break;
                }

        }
        if(!numbersReverse.isEmpty()) {
            System.out.println("The result is: " + numbersReverse.pop());
        }


    }
}

