import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> votes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            votes.add(sc.nextInt());
        }

        int dasom = votes.get(0);
        votes.remove(0);

        Collections.sort(votes, Collections.reverseOrder());

        int bribes = 0;
        while (votes.size() > 0 && dasom <= votes.get(0)) {
            dasom++;
            votes.set(0, votes.get(0) - 1);
            bribes++;
            Collections.sort(votes, Collections.reverseOrder());
        }

        System.out.println(bribes);
    }
}
