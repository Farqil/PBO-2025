import java.util.Scanner;
import java.util.ArrayList;

public class Menu{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;
        ArrayList<Coffee> menu = new ArrayList<>();
        ArrayList<BuyLog> logs = new ArrayList<>();
        menu.add(new Coffee("Espresso", 15000, 10));
        menu.add(new Coffee("Latte", 20000, 8));
        menu.add(new Coffee("Cappuccino", 25000, 5));
        menu.add(new Coffee("Americano", 18000, 0));
        do{
            System.out.println("--- Coffee Machine ---");
            System.out.println("1. Lihat Menu");
            System.out.println("2. Beli");
            System.out.println("3. Stok (ADMIN)");
            System.out.println("4. Log (ADMIN)");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.print("\n");
                    for(Coffee coffee : menu){
                        System.out.println(coffee.getName() + " - Rp." + coffee.getPrice() + " (Stok: " + coffee.getStock() + ")");
                    }
                    System.out.print("\n");
                    break;

                case 2:
                    System.out.print("\n");
                    for(int i = 0; i < menu.size(); i++){
                        System.out.println(i + 1 + ". " + menu.get(i).getName() + " - Rp." + menu.get(i).getPrice());
                    }
                    System.out.print("Pilih kopi yang ingin dibeli: ");
                    int coffeeChoice = scanner.nextInt();
                    scanner.nextLine();
                    String coffeeName = "";
                    switch(coffeeChoice){
                        case 1:
                            coffeeName = "Espresso";
                            break;
                        case 2:
                            coffeeName = "Latte";
                            break;
                        case 3:
                            coffeeName = "Cappuccino";
                            break;
                        case 4:
                            coffeeName = "Americano";
                            break;
                        default:
                            System.out.println("Pilihan tidak valid");
                            System.out.print("\n");
                            break;
                    }
                    for(Coffee coffee : menu){
                        if(coffee.getName().equals(coffeeName)){
                            if(coffee.getStock() > 0){
                                System.out.print("\n");
                                System.out.println("1. Small");
                                System.out.println("2. Medium (+ Rp.2000)");
                                System.out.println("3. Large (+ Rp.5000)");
                                System.out.print("Pilih size kopi: ");
                                int sizeChoice = scanner.nextInt();
                                scanner.nextLine();
                                String size = "";
                                switch(sizeChoice){
                                    case 1:
                                        size = "Small";
                                        break;
                                    case 2:
                                        size = "Medium";
                                        coffee.setPrice(coffee.getPrice() + 2000);
                                        break;
                                    case 3:
                                        size = "Large";
                                        coffee.setPrice(coffee.getPrice() + 5000);
                                        break;
                                    default:
                                        System.out.println("Pilihan tidak valid");
                                        System.out.print("\n");
                                        break;
                                }
                                System.out.println("Anda memilih " + size + " " + coffee.getName() + " seharga Rp." + coffee.getPrice() + "\n");
                                System.out.println("1. 0% gula");
                                System.out.println("2. 50% gula");
                                System.out.println("3. 100% gula");
                                System.out.println("4. Dengan susu (+ Rp.3000)");
                                System.out.print("Pilih gula dan susu: ");
                                int addOnChoice = scanner.nextInt();
                                scanner.nextLine();
                                switch (addOnChoice){
                                    case 1:
                                        System.out.println("Anda memilih 0% gula");
                                        break;
                                    case 2:
                                        System.out.println("Anda memilih 50% gula");
                                        break;
                                    case 3:
                                        System.out.println("Anda memilih 100% gula");
                                        break;
                                    case 4:
                                        System.out.println("Anda memilih dengan susu");
                                        coffee.setPrice(coffee.getPrice() + 3000);
                                        break;
                                    default:
                                        System.out.println("Pilihan tidak valid");
                                        System.out.print("\n");
                                        break;
                                }
                                System.out.println("\nTotal harga: Rp." + coffee.getPrice());
                                System.out.print("Masukkan jumlah uang: ");
                                int money = scanner.nextInt();
                                scanner.nextLine();
                                if(money < coffee.getPrice()){
                                    System.out.println("\nUang tidak cukup. Pembelian gagal");
                                    System.out.print("\n");
                                    break;
                                }
                                System.out.println("\nKopi " + coffee.getName() + " berhasil dibeli seharga Rp." + coffee.getPrice());
                                coffee.setStock(coffee.getStock() - 1);
                                if(money > coffee.getPrice()){
                                    System.out.println("Kembalian: Rp." + (money - coffee.getPrice()));
                                }
                                System.out.println("Terima kasih telah membeli kopi di myCoffee!");
                                System.out.print("\n");
                                logs.add(new BuyLog(coffee.getName(), coffee.getPrice(), coffee.getStock(), coffee.getPrice()));
                                break;
                            } 
                            else{
                                System.out.println("Maaf, stok kopi " + coffee.getName() + " habis");
                                System.out.print("\n");
                            }
                            break;
                        }
                    }
                    break;
                
                case 3:
                    System.out.println("\nMasukkan password admin: ");
                    String password = scanner.nextLine();
                    if(password.equals("admin123")){
                        System.out.println("Akses stok berhasil");
                        System.out.print("\n");
                        for(Coffee coffee : menu){
                            if(coffee.getStock() <= 3 && coffee.getStock() > 0){
                                System.out.println("PERINGATAN: Stok " + coffee.getName() + " hampir habis!");
                            } else if(coffee.getStock() == 0){
                                System.out.print("\n");
                                System.out.println("PERINGATAN: Stok " + coffee.getName() + " habis!");
                            }
                            System.out.println(coffee.getName() + " - Stok: " + coffee.getStock());
                        }
                        System.out.print("\n");
                    } else{
                        System.out.println("Password salah. Akses ditolak");
                        System.out.print("\n");
                    }
                    break;
                    
                case 4:
                    System.out.println("\nMasukkan password admin: ");
                    String passwordLog = scanner.nextLine();
                    if(passwordLog.equals("admin123")){
                        System.out.println("Akses log berhasil\n");
                        if(logs.isEmpty()){
                            System.out.println("Belum ada pembelian yang dilakukan");
                        } 
                        else{
                            System.out.println("------------ Log Pembelian ------------");
                            for(int i = 0; i < logs.size(); i++){
                                BuyLog log = logs.get(i);
                                System.out.println((i + 1) + ". " + log.getCoffeeName() + " - Rp." + log.getPrice() + " (Sisa Stok: " + log.getStock() + ")");
                            }
                            int totalIncome = 0;
                            for(BuyLog log : logs){
                                totalIncome += log.getIncome();
                            }
                            System.out.println("Total Pendapatan: Rp." + totalIncome + "\n");
                        }
                    } else{
                        System.out.println("Password salah. Akses ditolak");
                        System.out.print("\n");
                    }
                    break;

                case 5:
                    System.out.println("Keluar dari menu myCoffee. Sampai jumpa!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi");
            }
        }
        while (choice != 5);
        scanner.close();
    }
}