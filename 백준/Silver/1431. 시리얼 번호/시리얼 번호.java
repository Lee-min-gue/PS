import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] serials = new String[N];
        for (int i = 0; i < N; i++) {
            serials[i] = sc.next();
        }

        Arrays.sort(serials, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 길이가 짧은 순서대로 정렬
                if (o1.length() != o2.length()) {
                    return Integer.compare(o1.length(), o2.length());
                } else {
                    // 길이가 같으면, 숫자의 합이 작은 순서대로 정렬
                    int o1Sum = 0, o2Sum = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (Character.isDigit(o1.charAt(i))) o1Sum += o1.charAt(i) - '0';
                        if (Character.isDigit(o2.charAt(i))) o2Sum += o2.charAt(i) - '0';
                    }
                    if (o1Sum != o2Sum) {
                        return Integer.compare(o1Sum, o2Sum);
                    } else {
                        // 길이도 같고, 숫자의 합도 같으면, 사전 순서대로 정렬
                        return o1.compareTo(o2);
                    }
                }
            }
        });

        for (String serial : serials) {
            System.out.println(serial);
        }
    }
}
