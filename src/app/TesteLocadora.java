
package app;

import java.util.ArrayList;
import java.util.List;

import model.Veiculo;
import model.Carro;
import model.Moto;
import model.CarroEletrico;
import model.Eletrico;

public class TesteLocadora {

    public static void main(String[] args) {

        // Não é possível criar Veiculo diretamente,
        // pois a classe é abstrata.
        // Veiculo v = new Veiculo("ABC-1234", "Genérico", 100.0);

        Carro carro = new Carro("ABC-1234", "Sedan", 150.0);
        Moto moto4 = new Moto("DEF-5678", "CG 160", 80.0);
        Moto moto5 = new Moto("GHI-9012", "Fazer 250", 80.0);

        CarroEletrico eletrico =
                new CarroEletrico("JKL-3456", "Elétrico X", 200.0, 10.0);

        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(carro);
        veiculos.add(moto4);
        veiculos.add(moto5);
        veiculos.add(eletrico);

        int[] diasAluguel = {3, 4, 5, 3};

        System.out.println("=== ALUGUÉIS ===");

        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);

            veiculo.imprimirResumo();

            System.out.printf(
                "Valor do aluguel: R$ %.1f%n",
                veiculo.calcularAluguel(diasAluguel[i])
            );

            System.out.println();
        }

        // Somente veículos que implementam a interface Eletrico.
        List<Eletrico> eletricos = new ArrayList<>();
        eletricos.add(eletrico);

        System.out.println("=== RECARGAS ===");

        for (Eletrico e : eletricos) {
            System.out.printf(
                "Custo da recarga: R$ %.1f%n",
                e.calcularRecarga(3)
            );
        }
    }
}
