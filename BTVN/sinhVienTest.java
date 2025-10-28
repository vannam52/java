package BTVN;

import java.util.Scanner;

public class sinhVienTest {
    public static void main(String[] args) {
        danhSachSV ds = new danhSachSV();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println(" QUAN LY SINH VIEN ");
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. Xuat danh sach sinh vien");
            System.out.println("3. Tim kiem theo diem ren luyen");
            System.out.println("4. Them sinh vien");
            System.out.println("5. Tim sinh vien theo diem ren luyen");
            System.out.println("6. Tim kiem sinh vien theo ho");
            System.out.println("7. Thong ke so luong sinh vien theo loai");
            System.out.println("8. Thong ke so luong sinh vien theo tuoi");
            System.out.println("9. Thoat");
            System.out.print("Chon chuc nang: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ds.Nhap();
                    break;
                case 2:
                    ds.Xuat();
                    break;
                case 3:
                    ds.timKiemTheoDRL();
                    break;
                case 4:
                    ds.ThemSV();
                    break;
                case 5:
                    ds.timDRL(choice);
                    break;
                case 6:
                    System.out.print("Nhap ho can tim: ");
                    sc.nextLine();
                    String ho = sc.nextLine();
                    ds.TimKiemHo(ho);
                    break;
                case 7:
                    ds.thongKeLoaiSV();
                    break;
                case 8:
                    ds.thongKeTuoi();
                    break;
                case 9:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le!");
            }
        } while (choice != 9);
    }
}