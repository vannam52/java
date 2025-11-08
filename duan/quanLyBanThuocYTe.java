package duan;

import java.util.Scanner;

public class quanLyBanThuocYTe {

    public static danhSachNhanVien dsNhanVien = new danhSachNhanVien();
    public static danhSachKhachHang dsKhachHang = new danhSachKhachHang();
    public static danhSachKhuyenMai dsKhuyenMai = new danhSachKhuyenMai();
    public static danhSachThuoc dsThuocYTe = new danhSachThuoc();
    public static danhSachPhieuXuatHang dsPhieuXuatHang = new danhSachPhieuXuatHang();
    public static danhSachPhieuNhapHang dsPhieuNhapHang = new danhSachPhieuNhapHang();

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        taiDuLieu();
        hienThiMenuChinh();
        luuDuLieu();
        sc.close();
    }

    public static void taiDuLieu() {
        dsNhanVien.docFile("duan/nhanVien.txt");
        dsKhachHang.docFile("duan/khachHang.txt");
        dsThuocYTe.docFile("duan/Thuoc.txt");
        dsKhuyenMai.docFile("duan/khuyenMai.txt");
        dsPhieuXuatHang.docFile("duan/phieuXuatHang.txt");
        dsPhieuNhapHang.docFile("duan/phieuNhapHang.txt");
        System.out.println("Tai du lieu thanh cong!");
    }

    public static void luuDuLieu() {
        dsNhanVien.ghiFile("duan/nhanVien.txt");
        dsKhachHang.ghiFile("duan/khachHang.txt");
        dsKhachHang.ghiFile("duan/Thuoc.txt");
        dsKhuyenMai.ghiFile("duan/khuyenMai.txt");
        dsPhieuXuatHang.ghiFile("duan/phieuXuatHang.txt");
        dsPhieuNhapHang.ghiFile("duan/phieuNhapHang.txt");
    }

    public static void hienThiMenuChinh() {
        int choice = 0;
        do {
            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                          MENU QUAN LY BAN THUOC Y TE                                  ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(
                    "║ 1. Quan ly danh sach thuoc y te                                                       ║");
            System.out.println(
                    "║ 2. Quan ly danh sach nhan vien                                                        ║");
            System.out.println(
                    "║ 3. Quan ly danh sach khach hang                                                       ║");
            System.out.println(
                    "║ 4. Quan ly danh sach khuyen mai                                                       ║");
            System.out.println(
                    "║ 5. Quan ly danh sach hoa don ban hang                                                 ║");
            System.out.println(
                    "║ 6. Quan ly danh sach phieu hang                                                       ║");
            System.out.println(
                    "║ 7. Quan ly danh sach phieu xuat hang                                                  ║");
            System.out.println(
                    "║ 8. Quan ly danh sach phieu nhap hang                                                  ║");
            System.out.println(
                    "║ 0. Thoat chuong trinh                                                                 ║");
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print("Nhap lua chon: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    menuQuanLyThuoc(sc);
                    break;
                case 2:
                    menuQuanLyNhanVien(sc);
                    break;
                case 3:
                    menuQuanLyKhachHang(sc);
                    break;
                case 4:
                    menuQuanLyKhuyenMai(sc);
                    break;
                // case 5:
                // menuQuanLyHoaDonBan
                // break;
                // case 6: menuQuanLyHoaDonNhap(sc);
                // break;
                case 7:
                    menuQuanLyPhieuXuatHang(sc);
                case 0:
                    break;
                default:
                    System.out.println("Vui long chon lai.");
            }

        } while (choice != 0);
    }

    public static void menuQuanLyThuoc(Scanner sc) {
        int choice = 0;
        do {
            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                              QUAN LY DANH SACH THUOC Y TE                            ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(
                    "║ 1. Nhap danh sach thuoc                                                              ║");
            System.out.println(
                    "║ 2. Them thuoc                                                                        ║");
            System.out.println(
                    "║ 3. Sua thong tin thuoc                                                               ║");
            System.out.println(
                    "║ 4. Xoa thuoc                                                                         ║");
            System.out.println(
                    "║ 5. Tim kiem thuoc                                                                    ║");
            System.out.println(
                    "║ 6. Xem danh sach thuoc                                                               ║");
            System.out.println(
                    "║ 7. Thong ke thuoc                                                                    ║");
            System.out.println(
                    "║ 0. Quay lai Menu chinh                                                               ║");
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print("Nhap lua chon: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    dsThuocYTe.Nhap();
                    break;
                case 2:
                    dsThuocYTe.Them();
                    break;
                case 3:
                    dsThuocYTe.Sua();
                    break;
                case 4:
                    dsThuocYTe.Xoa();
                    break;
                case 5:
                    dsThuocYTe.TimKiem();
                    break;
                case 6:
                    dsThuocYTe.XuatDS();
                    break;
                case 7:
                    dsThuocYTe.menuThongKe();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Vui long nhap lai.");
            }
        } while (choice != 0);
    }

    public static void menuQuanLyNhanVien(Scanner sc) {
        int choice = 0;
        do {
            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                              QUAN LY DANH SACH NHAN VIEN                             ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(
                    "║ 1. Nhap danh sach nhan vien                                                          ║");
            System.out.println(
                    "║ 2. Them nhan vien                                                                    ║");
            System.out.println(
                    "║ 3. Sua thong tin nhan vien                                                           ║");
            System.out.println(
                    "║ 4. Xoa nhan vien                                                                     ║");
            System.out.println(
                    "║ 5. Tim kiem nhan vien                                                                ║");
            System.out.println(
                    "║ 6. Xem danh sach nhan vien                                                           ║");
            System.out.println(
                    "║ 7. Thong ke nhan vien                                                                ║");
            System.out.println(
                    "║ 0. Quay lai Menu chinh                                                               ║");
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print("Nhap lua chon: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    dsNhanVien.Nhap();
                    break;
                case 2:
                    dsNhanVien.Them();
                    break;
                case 3:
                    dsNhanVien.Sua();
                    break;
                case 4:
                    dsNhanVien.Xoa();
                    break;
                case 5:
                    dsNhanVien.TimKiem();
                    break;
                case 6:
                    dsNhanVien.XuatDS();
                    break;
                case 7:
                    dsNhanVien.menuThongKe();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Vui long nhap lai");
            }
        } while (choice != 0);
    }

    public static void menuQuanLyKhachHang(Scanner sc) {
        int choice = 0;
        do {
            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                              QUAN LY DANH SACH KHACH HANG                            ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(
                    "║ 1. Nhap danh sach khach hang                                                         ║");
            System.out.println(
                    "║ 2. Them khach hang                                                                   ║");
            System.out.println(
                    "║ 3. Sua thong tin khach hang                                                          ║");
            System.out.println(
                    "║ 4. Xoa khach hang                                                                    ║");
            System.out.println(
                    "║ 5. Tim kiem khach hang                                                               ║");
            System.out.println(
                    "║ 6. Xem danh sach khach hang                                                          ║");
            System.out.println(
                    "║ 7. Thong ke khach hang                                                               ║");
            System.out.println(
                    "║ 0. Quay lai menu chinh                                                               ║");
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print("Nhap lua chon: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    dsKhachHang.Nhap();
                    break;
                case 2:
                    dsKhachHang.Them();
                    break;
                case 3:
                    dsKhachHang.Sua();
                    break;
                case 4:
                    dsKhachHang.Xoa();
                    break;
                case 5:
                    dsKhachHang.TimKiem();
                    break;
                case 6:
                    dsKhachHang.XuatDS();
                    break;
                case 7:
                    dsKhachHang.menuThongKe();
                    ;
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Vui long nhap lai. ");
            }
        } while (choice != 0);
    }

    public static void menuQuanLyKhuyenMai(Scanner sc) {
        int choice = 0;
        do {
            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                              QUAN LY DANH SACH KHUYEN MAI                             ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(
                    "║ 1. Nhap danh sach khuyen mai                                                          ║");
            System.out.println(
                    "║ 2. Them khuyen mai                                                                    ║");
            System.out.println(
                    "║ 3. Sua thong tin khuyen mai                                                           ║");
            System.out.println(
                    "║ 4. Xoa khuyen mai                                                                     ║");
            System.out.println(
                    "║ 5. Tim kiem khuyen mai                                                                ║");
            System.out.println(
                    "║ 6. Xem danh sach khuyen mai                                                           ║");
            System.out.println(
                    "║ 7. Thong ke khuyen mai                                                                ║");
            System.out.println(
                    "║ 0. Quay lai menu chinh                                                                ║");
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print("Nhap lua chon: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    dsKhuyenMai.Nhap();
                    break;
                case 2:
                    dsKhuyenMai.Them();
                    break;
                case 3:
                    dsKhuyenMai.Sua();
                    break;
                case 4:
                    dsKhuyenMai.Xoa();
                    break;
                case 5:
                    dsKhuyenMai.TimKiem();
                    break;
                case 6:
                    dsKhuyenMai.XuatDS();
                    break;
                case 7:
                    dsKhuyenMai.thongKe();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    public static void menuPhieuNhapHang(Scanner sc) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- MENU QUAN LY PHIEU NHAP HANG ---");
            System.out.println("1. Them");
            System.out.println("2. Sua");
            System.out.println("3. Xoa");
            System.out.println("4. Xuat danh sach");
            System.out.println("5. Tim kiem");
            System.out.println("6. Thong ke");
            System.out.println("0. Quay lai Menu Chinh");
            System.out.print("→ Chon: ");
            String chon = sc.nextLine().trim();

            switch (chon) {
                case "1":
                    dsPhieuNhapHang.Them();
                    break;
                case "2":
                    dsPhieuNhapHang.Sua();
                    break;
                case "3":
                    dsPhieuNhapHang.Xoa();
                    break;
                case "4":
                    dsPhieuNhapHang.XuatDS();
                    break;
                case "5":
                    dsPhieuNhapHang.TimKiem();
                    break;
                case "6":
                    dsPhieuNhapHang.thongKe();
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("(!) Lua chon khong hop le!");
            }
        }
    }

    public static void menuQuanLyPhieuXuatHang(Scanner sc) {
        int choice = 0;
        do {
            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                              QUAN LY DANH SACH PHIEU XUAT HANG                        ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(
                    "║ 1. Nhap danh sach phieu xuat hang                                                     ║");
            System.out.println(
                    "║ 2. Them phieu xuat hang                                                               ║");
            System.out.println(
                    "║ 3. Sua thong tin phieu xuat hang                                                      ║");
            System.out.println(
                    "║ 4. Xoa phieu xuat hang                                                                ║");
            System.out.println(
                    "║ 5. Tim kiem phieu xuat hang                                                           ║");
            System.out.println(
                    "║ 6. Xem danh sach phieu xuat hang                                                      ║");
            System.out.println(
                    "║ 7. Thong ke phieu xuat hang                                                           ║");
            System.out.println(
                    "║ 0. Quay lai menu chinh                                                                ║");
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print("Nhap lua chon: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    dsPhieuXuatHang.Nhap();
                    break;
                case 2:
                    dsPhieuXuatHang.Them();
                    break;
                case 3:
                    dsPhieuXuatHang.Sua();
                    break;
                case 4:
                    dsPhieuXuatHang.Xoa();
                    break;
                case 5:
                    dsPhieuXuatHang.TimKiem();
                    break;
                case 6:
                    dsPhieuXuatHang.XuatDS();
                    break;
                case 7:
                    dsPhieuXuatHang.thongKe();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }
}