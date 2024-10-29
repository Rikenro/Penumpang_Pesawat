import java.util.Scanner;

class Passenger {
    String name;
    Passenger next;

    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

class Flight {
    private Passenger head;

    public Flight() {
        head = null;
    }

    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
        System.out.println(name + " telah ditambahkan ke daftar penumpang.");
    }

    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            System.out.println(name + " telah dihapus dari daftar penumpang.");
            return;
        }

        Passenger current = head;
        Passenger previous = null;

        while (current != null && !current.name.equals(name)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
            System.out.println(name + " telah dihapus dari daftar penumpang.");
        } else {
            System.out.println(name + " tidak ditemukan dalam daftar penumpang.");
        }
    }

    public void displayPassengers() {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        System.out.println("Daftar Penumpang:");
        Passenger current = head;
        while (current != null) {
            System.out.println("- " + current.name);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Flight flight = new Flight();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Penumpang");
            System.out.println("2. Hapus Penumpang");
            System.out.println("3. Tampilkan Daftar Penumpang");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi (1-4): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama penumpang: ");
                    String nameToAdd = scanner.nextLine();
                    flight.addPassenger(nameToAdd);
                    break;
                case 2:
                    System.out.print("Masukkan nama penumpang yang ingin dihapus: ");
                    String nameToRemove = scanner.nextLine();
                    flight.removePassenger(nameToRemove);
                    break;
                case 3:
                    flight.displayPassengers();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih lagi.");
            }
        } while (pilihan != 4);

    }
}