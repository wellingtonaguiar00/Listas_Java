package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ent.Util;

public class Aplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Util> list = new ArrayList<>();

        System.out.print("Quantos funcionários você deseja registrar? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Funcionário Nº" + (i + 1) + ": ");
            System.out.print("Matrícula: ");
            Integer mat = sc.nextInt();
            while (hasMatricula(list, mat)) {
                System.out.println("Esta matrícula já existe! Tente novamente.");
                mat = sc.nextInt();
            }
            sc.nextLine(); // Limpa o buffer do scanner após a leitura de inteiros
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Salário: ");
            Double salario = sc.nextDouble();

            Util emp = new Util(mat, nome, salario);
            list.add(emp);
        }

        System.out.println();
        System.out.print("Informe a matrícula do funcionário que terá aumento salarial: ");
        int id = sc.nextInt();
        Util emp = list.stream().filter(x -> x.getMatricula() == id).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("Essa matrícula não existe");
        } else {
            System.out.print("Digite a porcentagem do aumento: ");
            double percent = sc.nextDouble();
            emp.aumento_Salario(percent);
        }

        System.out.println();
        System.out.println("Lista de funcionários: ");
        for (Util e : list) {
            System.out.println(e);
        }

        sc.close();
    }

    private static boolean hasMatricula(List<Util> list, Integer mat) {
        for (Util util : list) {
            if (util.getMatricula().equals(mat)) {
                return true;
            }
        }
        return false;
    }
}