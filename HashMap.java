package BeeCrowd;

import java.util.Map;
import java.util.Scanner;

public class HashMap {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, String> ddd = new java.util.HashMap<>();
        ddd.put(61, "Brasilia");
        ddd.put(71, "Salvador");
        ddd.put(11, "Sao Paulo");
        ddd.put(21, "Rio de Janeiro");
        ddd.put(32, "Juiz de Fora");
        ddd.put(19, "Campinas");
        ddd.put(27, "Vitoria");
        ddd.put(31, "Belo Horizonte");

        System.out.printf(ddd.get(n).isEmpty() ? "DDD nao cadastrado" : ddd.get(n));
    }
}