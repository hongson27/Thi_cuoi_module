package Thi_Cuoi_Module.view;


import Thi_Cuoi_Module.controller.AuthenticPhoneController;
import Thi_Cuoi_Module.controller.HandPhoneController;
import Thi_Cuoi_Module.model.AuthenticPhone;

import java.time.LocalDate;
import java.util.Scanner;

public class PhoneManagement {
    private static final Scanner sc = new Scanner(System.in);
    public static final AuthenticPhoneController authenticPhoneController = new AuthenticPhoneController();
    public static final HandPhoneController handPhoneController = new HandPhoneController();
    String regex = "^[1-9]\\d*$";
    public void displayMainMenu() {
        do {
            System.out.println("Chương trình quản lý điện thoại: \n" +
                    "1. Quản lý điện thoại chính hãng. \n" +
                    "2. Quản lý điện thoại xách tay. \n" +
                    "3. Thoát chương trình. \n" +
                    "Nhập lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    displayAuthenticPhoneMainMenu();
                    break;
                case 2:
                    //displayHandPhoneMainMenu();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn lại chức năng.");
                    displayMainMenu();
            }


        } while (true);
    }

    public void displayAuthenticPhoneMainMenu() {
        do {
            System.out.println("ĐIỆN THOẠI CHÍNH HÃNG: \n" +
                    "1. Thêm mới. \n" +
                    "2. Xóa. \n" +
                    "3. Xem danh sách. \n" +
                    "4. Tìm kiếm. \n" +
                    "5. Trở về menu chính. \n" +
                    "Nhập lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("------------ Thêm mới ---------------");
                    String id = Integer.toString(authenticPhoneController.getOrinalNumber());
                    System.out.println("Nhập Tên điện thoại:");
                    String name = sc.nextLine();

                    String price;
                    while (true) {
                        System.out.println("Nhập giá bán:");
                        price = sc.nextLine();
                        if (!price.matches(regex)) {
                            System.out.println("Vui lòng nhập số dương: ");
                        } else {
                            break;
                        }
                    }
                    String amount;
                    while (true) {
                        System.out.println("Nhập Số lượng:");
                        amount = sc.nextLine();
                        if (!amount.matches(regex)) {
                            System.out.println("Vui lòng nhập số dương: ");
                        } else {
                            break;
                        }
                    }

                    System.out.println("Nhập nhà sản xuất: ");
                    String manufacturer = sc.nextLine();
                    System.out.println("Nhập thời gian bảo hành: ");
                    String period = sc.nextLine();
                    LocalDate time = LocalDate.parse(period);
                    System.out.println("Nhập phạm vi bảo hành: ");
                    String scope = sc.nextLine();
                    AuthenticPhone newPhone = new AuthenticPhone(id,name,price,amount,manufacturer,time,scope);
                    authenticPhoneController.addAuthenticPhone(newPhone);
                    break;
                case 2:
                    System.out.println("------------ Xóa ----------------");
                    System.out.println("Nhập id cần xóa: ");
                    String idDelete = sc.nextLine();
                    authenticPhoneController.deleteAuthenticPhoneById(idDelete);
                    break;

                case 3:
                    System.out.println("------------- Xem danh sách -------------------");
                    authenticPhoneController.getAuthenticPhoneList();
                    break;
                case 4:
                    System.out.println("------------------- Tìm kiếm ------------------");
                    System.out.println("Nhập id cần tìm: ");
                    String idSearch = sc.nextLine();
                    authenticPhoneController.findAuthenticPhone(idSearch);
                case 5:
                    return;
                default:
                    System.out.println("Vui lòng chọn lại chức năng.");

            }
        } while (true);
    }
}
