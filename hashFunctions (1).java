// Name: Rashmi Wagde
// Class: CS 3305/Section#04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 8
// IDE Name: IntelliJ
import java.util.Scanner;

class hashFunctions {
    static int SIZE = 50;

    public static void HF1(int key, int hashTable[][]) {
        int n = key % SIZE;
        int probes = 0;
        int i = n;
        do {
            if (hashTable[i][0] == -1) {
                hashTable[i][0] = key;
                hashTable[i][1] = probes;
                return;
            }
            probes++;
            i = (i + 1) % SIZE;
        } while (i != n);
        System.out.println("Unable to hash key " + key + " to the table");
    }

    public static void HF2(int key, int hashTable[][]) {
        int n = key % SIZE;
        int probes = 0;
        int i = n, k = 1;
        do {
            if (hashTable[i][0] == -1) {
                hashTable[i][0] = key;
                hashTable[i][1] = probes;
                return;
            }
            probes++;
            i = (n + k * k) % SIZE;
            k++;
        } while (probes != SIZE);
        System.out.println("Unable to hash key " + key + " to the table");
    }

    public static void HF3(int key, int hashTable[][]) {
        int n = key % SIZE;
        int k = 30 - key % 25;
        int probes = 0;
        int i = n;
        int j = 1;
        do {
            if (hashTable[i][0] == -1) {
                hashTable[i][0] = key;
                hashTable[i][1] = probes;
                return;
            }
            probes++;
            i = (n + j * k) % SIZE;
            j++;
        } while (probes != SIZE);
        System.out.println("Unable to hash key " + key + " to the table");
    }

    public static void HF4(int key, int hashTable[][]) {
        int sum = 0, m = key;
        while (m != 0) {
            sum += m % 100;
            m = m / 100;
        }
        int n = sum % SIZE;
        int k = 30 - key % 25;
        int probes = 0;
        int i = n;
        int j = 1;
        do {
            if (hashTable[i][0] == -1) {
                hashTable[i][0] = key;
                hashTable[i][1] = probes;
                return;
            }
            probes++;
            i = (n + j * k) % SIZE;
            j++;
        } while (probes != SIZE);
        System.out.println("Unable to hash key " + key + " to the table");
    }

    public static int sumProbes(int table[][]) {
        int probes = 0;
        for (int i = 0; i < SIZE; i++) {
            probes += table[i][1];
        }
        return probes;
    }

    public static void displayTable(int table[][]) {
        int probes = sumProbes(table);
        System.out.println("Index     Key       probes");
        System.out.println("----------------------------");
        for (int i = 0; i < table.length; i++) {
            if (table[i][0] != -1)
                System.out.printf("%-10d%-10d%d\n", i, table[i][0], table[i][1]);
            else
                System.out.printf("%-10d%-10s\n", i, "-- Empty --");
        }
        System.out.println("----------------------------");
        System.out.println("Sum of probe values = " + probes + " probes\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                      5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                      5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                      5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                      5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};
        int[][] table = new int[SIZE][2];
        while (true) {
            System.out.println("-----MAIN MENU---------------------------------");
            System.out.println("1.  Run HF1 (Division method with Linear Probing)");
            System.out.println("2.  Run HF2 (Division method with Quadratic Probing)");
            System.out.println("3.  Run HF3 (Division method with Double Hashing)");
            System.out.println("4.  Run HF4 (Student-Designed HF)");
            System.out.println("5.  Exit Program\n");
            System.out.print("Enter option number: ");
            int op = sc.nextInt();
            if (op == 5) break;
            for (int i = 0; i < SIZE; i++) {
                table[i][0] = -1;
                table[i][1] = 0;
            }
            switch (op) {
                case 1:
                    for (int i = 0; i < keys.length; i++) {
                        HF1(keys[i], table);
                    }
                    System.out.println("\nHash table resulted from HF1:\n");
                    displayTable(table);
                    break;
                case 2:
                    for (int i = 0; i < keys.length; i++) {
                        HF2(keys[i], table);
                    }
                    System.out.println("\nHash table resulted from HF2:\n");
                    displayTable(table);
                    break;
                case 3:
                    for (int i = 0; i < keys.length; i++) {
                        HF3(keys[i], table);
                    }
                    System.out.println("\nHash table resulted from HF3:\n");
                    displayTable(table);
                    break;
                case 4:
                    for (int i = 0; i < keys.length; i++) {
                        HF4(keys[i], table);
                    }
                    System.out.println("\nHash table resulted from HF4:\n");
                    displayTable(table);
            }
            System.out.println();
        }
    }
}
