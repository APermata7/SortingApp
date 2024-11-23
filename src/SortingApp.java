import java.util.LinkedList;
import java.util.Scanner;

public class SortingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        boolean running = true;
        
        printHeader();
        System.out.println("Aplikasi ini akan membantu Anda mengurutkan angka.");
        System.out.println("Pilih salah satu opsi untuk memulai!");

        while (running) {
            System.out.println("==========================================================");
            System.out.println("1. Input Data");
            System.out.println("2. Pilihan Sort");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    printSeparator();
                    System.out.println("Masukkan elemen ke dalam list (pisahkan dengan spasi): ");
                    String inputLine = scanner.nextLine();
                    String[] inputNumbers = inputLine.split("\\s+");
                    for (String num : inputNumbers) {
                        list.add(Integer.parseInt(num));
                    }
                    printSeparator();
                    System.out.println("Data telah dimasukkan: " + list);
                    break;

                case 2:
                    if (list.isEmpty()) {
                        printSeparator();
                        System.out.println("Data kosong! Silakan masukkan data terlebih dahulu (Opsi 1).");
                        break;
                    }
                    printSeparator();
                    System.out.println("Pilih metode sorting:");
                    System.out.println("1. Bubble Sort");
                    System.out.println("2. Selection Sort");
                    System.out.println("3. Insertion Sort");
                    System.out.print("Masukkan pilihan (1/2/3): ");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();

                    printSeparator();
                    System.out.println("Pilih opsi output:");
                    System.out.println("1. Lihat langkah-langkah");
                    System.out.println("2. Lihat hasil akhir");
                    System.out.print("Masukkan pilihan (1/2): ");
                    int outputChoice = scanner.nextInt();
                    scanner.nextLine();

                    boolean showSteps = outputChoice == 1;

                    LinkedList<Integer> sortedList = new LinkedList<>(list);
                    switch (sortChoice) {
                        case 1:
                            bubbleSort(sortedList, showSteps);
                            if (!showSteps) {
                                System.out.println("\nHasil Bubble Sort: " + sortedList);
                            }
                            break;
                        case 2:
                            selectionSort(sortedList, showSteps);
                            if (!showSteps) {
                                System.out.println("\nHasil Selection Sort: " + sortedList);
                            }
                            break;
                        case 3:
                            insertionSort(sortedList, showSteps);
                            if (!showSteps) {
                                System.out.println("\nHasil Insertion Sort: " + sortedList);
                            }
                            break;
                        default:
                            System.out.println("Pilihan sorting tidak valid!");
                    }
                    break;

                case 3:
                    running = false;
                    printSeparator();
                    System.out.println("Terima kasih telah menggunakan SortingApp");
                    System.out.println("Sampai jumpa!");
                    printSeparator();
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
                    printSeparator();
            }
        }
        scanner.close();
    }

    // Header tampilan aplikasi
    public static void printHeader() {
        System.out.println("==========================================================");
        System.out.println("||                   SORTING APPS                       ||");
        System.out.println("||           Mengurutkan Angka dengan Mudah             ||");
        System.out.println("==========================================================");
    }

    // Garis pemisah
    public static void printSeparator() {
        System.out.println("==========================================================");
    }

    // Bubble Sort dengan proses langkah per langkah
    public static void bubbleSort(LinkedList<Integer> list, boolean showSteps) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (showSteps) {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Proses: Bandingkan " + list.get(j) + " dengan " + list.get(j + 1));
                }
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                    if (showSteps) {
                        System.out.println("Tukar: " + list.get(j + 1) + " dan " + list.get(j));
                    }
                }
            }
            if (showSteps) {
                System.out.println("List setelah langkah " + (i + 1) + ": " + list);
            }

            if (!swapped) {
                break;
            }
        }
    }

    // Selection Sort dengan proses langkah per langkah
    public static void selectionSort(LinkedList<Integer> list, boolean showSteps) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (showSteps) {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Proses: Bandingkan " + list.get(j) + " dengan " + list.get(minIndex));
                }
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
            if (showSteps) {
                System.out.println("Tukar: " + list.get(i) + " dan " + list.get(minIndex));
                System.out.println("List setelah langkah " + (i + 1) + ": " + list);
            }
        }
    }

    // Insertion Sort dengan proses langkah per langkah
    public static void insertionSort(LinkedList<Integer> list, boolean showSteps) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            int key = list.get(i);
            int j = i - 1;

            if (showSteps) {
                System.out.println("----------------------------------------------------------");
                System.out.println("Proses: Bandingkan " + key + " dengan " + list.get(j));
            }
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
                if (showSteps) {
                    System.out.println("Geser: " + list.get(j + 1) + " ke posisi " + (j + 2));
                }
            }
            list.set(j + 1, key);
            if (showSteps) {
                System.out.println("Letakkan " + key + " pada posisi " + (j + 1));
                System.out.println("List setelah langkah " + i + ": " + list);
            }
        }
    }
}