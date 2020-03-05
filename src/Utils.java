import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Utils {
    public static ArrayList<Player> createAndFillPlayerList() {
        ArrayList<Player> players = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String line = "0";
        while (!line.equals("stop")) {
            System.out.println("Podaj gracza i jego wynik: ");
            line = scanner.nextLine();
            if (!line.equals("stop")) {
                String[] split = line.split(" ");
                double score = Double.parseDouble(split[2]);
                players.add(new Player(split[0], split[1], score));
            }
        }
        return players;
    }

    public static void sortAndAddToCsv(ArrayList<Player> players) throws IOException {
        Collections.sort(players);
        File file = new File("players.csv");
        if (!file.exists())
            file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < players.size(); i++) {
            bufferedWriter.write(toCSV(players.get(i)));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    private static String toCSV(Player player) {
        return player.getFirstName() + ";" + player.getLastName() + ";" + player.getScore();
    }
}

