package it.unicam.cs.ids2223.programmafedelta.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class CLIView implements IView<String> {

    @Override
    public void message(String stringMessage) {
        System.out.println(stringMessage);
    }

    @Override
    public void message(String message, Collection<String> items) {
        message(message);
        items.forEach(System.out::println);
    }

    @Override
    public String ask(String message) {
        message(message);
        return fetch();
    }

    private String fetch() {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public int fetchChoice(String msg, int upperBound) {
        message(msg);
        int input;
        while (true) {
            input = fetchInt();
            if (1 <= input && input <= upperBound)
                break;
            else
                message("Devi inserire un numero che si trova tra 1 e " + upperBound + "(compresi)");
        }
        return input;
    }

    @Override
    public int fetchInt() {
        int result = 0;
        boolean inside = true;
        while (inside) {
            try {
                result = Integer.parseInt(fetch());
                inside = false;
            } catch (NumberFormatException | NullPointerException e) {
                message("Errore: inserire un numero intero");
            }
        }
        return result;
    }

    @Override
    public LocalDateTime fetchDate() {
        LocalDateTime result = LocalDateTime.now();
        boolean inside = true;
        while (inside) {
            try {
                result = LocalDateTime.parse(Objects.requireNonNull(fetch()));
                inside = false;
            } catch (DateTimeParseException e) {
                message("Errore: La data deve essere del formato aaaa-mm-ddThh:mm:ss");
            }
        }
        return result;
    }

    @Override
    public String fetchSingleChoice(Collection<String> items) {
        String input;
        while (true) {
            input = fetch();
            if (!input.isEmpty() && items.contains(input)) {
                break;
            }
            else message("Errore: scegliere uno ed uno solo degli elementi elencati");
        }
        return input;
    }

    @Override
    public Set<String> fetchSubSet(Set<String> superSet) {
        String input;
        Set<String> subSet;
        while (true) {
            input = fetch();
            if (!input.isEmpty()) {
                subSet = Arrays.stream(input.split(",")).collect(Collectors.toSet());
            }
            else return Collections.emptySet();
            if (superSet.containsAll(subSet) || subSet.isEmpty()) break;
            else message("Scegli solo elementi elencati");
        }
        return subSet;
    }

    @Override
    public boolean fetchBool() {
        String input;
        while (true) {
            input = fetch();
            if (input.isEmpty()) return true;
            else if (Arrays.asList("y","Y","Yes","YES","yes").contains(input)) return true;
            else if (Arrays.asList("n","N","No","NO","no").contains(input)) return false;
            else message("Errore di inserimento: le scelte possibili sono [y, Y, Yes, yes] oppure [n, N, No, NO, no]");
        }
    }
}
