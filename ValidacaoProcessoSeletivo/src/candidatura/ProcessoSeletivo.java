package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        /*
         * Exemplo de chamada dos métodos. Estes métodos simulam a análise de candidatos
         * com base no salário pretendido e tentativas de contato telefônico.
         *
         * Para ativar, basta descomentar.
         */

        // analisarCandidato(1900.0);
        // analisarCandidato(2200.0);
        // analisarCandidato(2000.0);

        // Exemplo de simulação de tentativas de contato com os candidatos.
        // String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        // for (String candidato: candidatos) {
        //     entrandoEmContato(candidato);
        // }

    }

    /**
     * Metodo que simula tentativas de contato com um candidato.
     * A tentativa é feita até que o candidato atenda ou o número máximo de tentativas (3) seja alcançado.
     *
     * @param candidato O nome do candidato.
     */
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        // Tenta até 3 vezes para contactar o candidato
        do {
            atendeu = atender(); // Simula se o candidato atendeu ou não
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
        } while (continuarTentando && tentativasRealizadas < 3);

        // Exibe o resultado final de acordo com o número de tentativas
        if (atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA TENTATIVA " + tentativasRealizadas);
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " , NÚMERO MÁXIMO DE TENTATIVAS " + tentativasRealizadas);
    }

    /**
     * Metodo que simula se o candidato atendeu ou não. A chance é aleatória.
     *
     * @return true se o candidato atendeu, false caso contrário.
     */
    static boolean atender() {
        // Simula aleatoriamente se o candidato atende (1 em 3 chances)
        return new Random().nextInt(3) == 1;
    }

    /**
     * Metodo que imprime a lista de candidatos selecionados.
     * Inclui a impressão do índice do candidato e utiliza duas abordagens para iterar sobre o array.
     */
    static void imprimirSelecionados() {
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");

        // Percorre a lista de candidatos e imprime com base no índice
        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de N° " + (indice + 1) + " é o " + candidatos[indice]);
        }

        // Forma abreviada de iteração usando for-each
        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    /**
     * Metodo que simula a seleção de candidatos com base no salário pretendido.
     * A seleção ocorre até que 5 candidatos sejam escolhidos ou todos os candidatos tenham sido avaliados.
     */
    static void selecaoCandidatos() {
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0; // Contador de candidatos selecionados
        int candidatoAtual = 0;         // Índice do candidato atual sendo analisado
        double salarioBase = 2000.0;    // Salário base oferecido pela vaga

        // Enquanto menos de 5 candidatos forem selecionados e houver candidatos a analisar
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido(); // Gera um salário pretendido aleatório

            System.out.println("Candidato(a) " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if (salarioBase > salarioPretendido) {
                System.out.println("Candidato(a) " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++; // Incrementa o número de candidatos selecionados
            }

            candidatoAtual++; // Passa para o próximo candidato
        }
    }

    /**
     * Metodo que gera um valor aleatório para o salário pretendido de um candidato.
     * O valor varia entre 1800 e 2200.
     *
     * @return Um valor aleatório entre 1800 e 2200.
     */
    static double valorPretendido() {
        // Gera um valor de salário aleatório entre 1800 e 2200
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    /**
     * Metodo que analisa um candidato com base no salário pretendido.
     * Compara o salário pretendido com o salário base e define a ação a ser tomada.
     *
     * @param salarioPretendido O valor do salário pretendido pelo candidato.
     */
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0; // Salário base oferecido pela vaga

        // Verifica a comparação entre salário pretendido e salário base
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA CANDIDATO(A)"); // Salário pretendido é menor que o base
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO(A) COM CONTRA PROPOSTA"); // Salário pretendido é igual ao base
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS"); // Salário pretendido é maior que o base
        }
    }
}
