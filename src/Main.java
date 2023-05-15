import builders.StudentsBuilder;
import entities.Studant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var allStudents = StudentsBuilder.getAllStudents();

        // Agora vamos as atividades


        System.out.println("1. Recupere da lista os alunos que passaram de ano (nota minima 7.0).\n" +
                "            - Exiba os dados nesse formato: <codigo> - <nome> : Media = <nota>");



        // Recupere os alunos que passaram de ano (nota mínima 7.0)
        for (Studant student : allStudents) {
            float average = (student.getTestOne() + student.getTestTwo() + student.getTestThree()) / 3;
            if (average >= 7.0) {
                System.out.println(student.getCode() + " - " + student.getName() + " : Media = " + average);

            }
        }

        System.out.println("---------------------------------");
        System.out.println("2. Recupere da lista os alunos que nao passaram de ano.\n" +
                "            - Exiba os dados nesse formato: <codigo> - <nome> : Media = <media> (Faltou = <nota_faltante>)");


        // Recupere os alunos que não passaram de ano (nota mínima 7.0)
        for (Studant student2 : allStudents) {
            float average2 = (student2.getTestOne() + student2.getTestTwo() + student2.getTestThree()) / 3;
            if (average2 < 7.0) {
                float missingGrade2 = 7.0f - average2;
                System.out.println(student2.getCode() + " - " + student2.getName() + " : Media = " + average2 + " (Faltou = " + missingGrade2 + ")");
            }
        }

        System.out.println("---------------------------------");


        System.out.println("3. Traga os alunos que tiraram a nota maxima (nota 10).\n" +
                "            - Exiba os dados nesse formato: <codigo> - <nome>");
        // Recupere os alunos que tiraram nota máxima (nota 10)
        for (Studant student3 : allStudents) {
            if (student3.getTestOne() == 10.0f && student3.getTestTwo() == 10.0f && student3.getTestThree() == 10.0f) {
                System.out.println(student3.getCode() + " - " + student3.getName());
            }
        }

        System.out.println("---------------------------------");


        System.out.println("4. Traga o aluno que tirou a menor nota, em caso de notas iguais, traga ambos os alunos.\n" +
                "            - Exiba os dados nesse formato: <codigo> - <nome> : Nota = <nota>");

        // Encontre o aluno ou os alunos com a menor nota
        float lowestGrade = Float.MAX_VALUE;
        List<Studant> studentsWithLowestGrade = new ArrayList<>();

        for (Studant student : allStudents) {
            float average = (student.getTestOne() + student.getTestTwo() + student.getTestThree()) / 3;
            if (average < lowestGrade) {
                lowestGrade = average;
                studentsWithLowestGrade.clear();
                studentsWithLowestGrade.add(student);
            } else if (average == lowestGrade) {
                studentsWithLowestGrade.add(student);
            }
        }

        // Exiba os dados do(s) aluno(s) com a menor nota
        for (Studant student : studentsWithLowestGrade) {
            System.out.println(student.getCode() + " - " + student.getName() + " : Nota = " + lowestGrade);
        }

        System.out.println("---------------------------------");

        System.out.println("        5. Faca uma lista com top 3 notas de alunos. Em caso de notas iguais coloque todos na mesma posicao.\n" +
                "            - Ex:\n" +
                "                1 - Fulano : Nota = 10.0;\n" +
                "                   - Beltrano : Nota = 10.0;\n" +
                "                2 - Joaozinho : Nota = 9.0;\n" +
                "                3 - Mariazinha : Nota = 8.9;\n" +
                "            - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>");


        // Crie uma lista com as três melhores notas
        List<Studant> topThreeGrades = new ArrayList<>();
        Collections.sort(allStudents, new Comparator<Studant>() {
            @Override
            public int compare(Studant s1, Studant s2) {
                float average1 = (s1.getTestOne() + s1.getTestTwo() + s1.getTestThree()) / 3;
                float average2 = (s2.getTestOne() + s2.getTestTwo() + s2.getTestThree()) / 3;
                return Float.compare(average2, average1);
            }
        });

        float previousGrade = Float.MAX_VALUE;
        int position = 1;

        for (Studant student : allStudents) {
            float average = (student.getTestOne() + student.getTestTwo() + student.getTestThree()) / 3;
            if (position <= 3 || average == previousGrade) {
                System.out.println(position + "º - " + student.getName() + " : Nota = " + average);
                topThreeGrades.add(student);
                previousGrade = average;
            }
            position++;
        }
        System.out.println("---------------------------------");

        System.out.println("        6. Faça uma lista com as 3 menores notas de alunos. Em caso de notas iguais coloque todos na mesma posição. Exemplo igual a anterior\n" +
                "            - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>");


        // Crie uma nova lista mutável a partir da lista original
        List<Studant> mutableList = new ArrayList<>(allStudents);

        // Ordene a nova lista mutável
        Collections.sort(mutableList, new Comparator<Studant>() {
            @Override
            public int compare(Studant s1, Studant s2) {
                float average1 = (s1.getTestOne() + s1.getTestTwo() + s1.getTestThree()) / 3;
                float average2 = (s2.getTestOne() + s2.getTestTwo() + s2.getTestThree()) / 3;
                return Float.compare(average1, average2);
            }
        });
        // Crie uma lista com as três menores notas
        List<Studant> bottomThreeGrades = new ArrayList<>();
        Collections.sort(allStudents, new Comparator<Studant>() {
            @Override
            public int compare(Studant s1, Studant s2) {
                float average1 = (s1.getTestOne() + s1.getTestTwo() + s1.getTestThree()) / 3;
                float average2 = (s2.getTestOne() + s2.getTestTwo() + s2.getTestThree()) / 3;
                return Float.compare(average1, average2);
            }
        });

        float previousGrade6 = -1.0f;
        int position6 = 1;

        for (Studant student : allStudents) {
            float average = (student.getTestOne() + student.getTestTwo() + student.getTestThree()) / 3;
            if (position6 <= 3 || average == previousGrade6) {
                System.out.println(position6 + "º - " + student.getName() + " : Nota = " + average);
                bottomThreeGrades.add(student);
                previousGrade6 = average;
            }
            position6++;
        }
        System.out.println("---------------------------------");


        System.out.println("        7. Monte a média de todos os alunos e exiba em tela ordenando da maior para a menor nota.\n" +
                "            - Exiba os dados nesse formato: <posicao> - <código> - <nome> : Média = <nota>");

        // Crie uma lista com todas as médias dos alunos
        List<Float> allAverages = new ArrayList<>();
        for (Studant student : allStudents) {
            float average = (student.getTestOne() + student.getTestTwo() + student.getTestThree()) / 3;
            allAverages.add(average);
        }

        // Ordene as médias em ordem decrescente
        Collections.sort(allAverages, Collections.reverseOrder());

        // Exiba as médias ordenadas
        int position7 = 1;
        for (float average : allAverages) {
            for (Studant student : allStudents) {
                float studentAverage = (student.getTestOne() + student.getTestTwo() + student.getTestThree()) / 3;
                if (average == studentAverage) {
                    System.out.println(position7 + "º - " + student.getCode() + " - " + student.getName() + " : Média = " + average);
                    break;
                }
            }
            position7++;
        }


    }
}
