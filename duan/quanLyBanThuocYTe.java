package duan;

import java.util.Scanner;

public class quanLyBanThuocYTe {

    public static danhSachNhanVien dsNhanVien = new danhSachNhanVien();
    public static danhSachKhachHang dsKhachHang = new danhSachKhachHang();
    public static danhSachKhuyenMai dsKhuyenMai = new danhSachKhuyenMai();
    public static danhSachThuoc dsThuocYTe = new danhSachThuoc();
    public static danhSachPhieuXuatHang dsPhieuXuatHang = new danhSachPhieuXuatHang();
    public static danhSachHoaDon dsHoaDon = new danhSachHoaDon();
    public static danhSachChiTietHoaDon dsChiTietHoaDon = new danhSachChiTietHoaDon();
    public static danhSachNhaCungCap dsNhaCungCap = new danhSachNhaCungCap();

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        taiDuLieu();
        hienThiMenuChinh();
        luuDuLieu();
        sc.close();
    }

    // Tai du lieu tu file
    public static void taiDuLieu() {
        dsNhanVien.docFile("duan/nhanVien.txt");
        dsKhachHang.docFile("duan/khachHang.txt");
        dsThuocYTe.docFile("duan/Thuoc.txt");
        dsKhuyenMai.docFile("duan/khuyenMai.txt");
        dsPhieuXuatHang.docFile("duan/phieuXuatHang.txt");
        dsHoaDon.docFile("duan/hoaDon.txt");
        dsChiTietHoaDon.docFile("duan/chiTietThuoc.txt");
        dsNhaCungCap.docFile("duan/nhaCungCap.txt");

        System.out.println("Tai du lieu thanh cong!");
    }

    // Luu du lieu vao file
    public static void luuDuLieu() {
        dsNhanVien.ghiFile("duan/nhanVien.txt");
        dsKhachHang.ghiFile("duan/khachHang.txt");
        dsThuocYTe.ghiFile("duan/Thuoc.txt");
        dsKhuyenMai.ghiFile("duan/khuyenMai.txt");
        dsPhieuXuatHang.ghiFile("duan/phieuXuatHang.txt");
        dsHoaDon.ghiFile("duan/hoaDon.txt");
        dsChiTietHoaDon.ghiFile("duan/chiTietThuoc.txt");
        dsNhaCungCap.ghiFile("duan/nhaCungCap.txt");
    }

    // Hien thi menu chinh
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
                    "║ 5. Quan ly danh sach hoa don                                                          ║");
            System.out.println(
                    "║ 6. Quan ly danh sach chi tiet hoa don                                                 ║");
            System.out.println(
                    "║ 7. Quan ly danh sach nha cung cap                                                     ║");
            System.out.println(
                    "║ 8. Quan ly danh sach phieu xuat hang                                                  ║");
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
                case 5:
                    menuQuanLyHoaDon(sc);
                    break;
                case 6:
                    menuQuanLyChiTietHoaDon(sc);
                    break;
                case 7:
                    menuQuanLyNhaCungCap(sc);
                    break;
                case 8:
                    menuQuanLyPhieuXuatHang(sc);
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai.");
            }

        } while (choice != 0);
    }

    // Menu quan ly thuoc
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

    // Menu quan ly nhan vien
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

    // Menu quan ly khach hang
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
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Vui long nhap lai. ");
            }
        } while (choice != 0);
    }

    // Menu quan ly khuyen mai
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

    // Menu quan ly hoa don
    public static void menuQuanLyHoaDon(Scanner sc) {
        int choice = 0;
        do {
            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                              QUAN LY DANH SACH HOA DON                                ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(
                    "║ 1. Nhap danh sach hoa don                                                             ║");
            System.out.println(
                    "║ 2. Them hoa don                                                                       ║");
            System.out.println(
                    "║ 3. Sua thong tin hoa don                                                              ║");
            System.out.println(
                    "║ 4. Xoa hoa don                                                                        ║");
            System.out.println(
                    "║ 5. Tim kiem hoa don                                                                   ║");
            System.out.println(
                    "║ 6. Xem danh sach hoa don                                                              ║");
            System.out.println(
                    "║ 7. Thong ke hoa don                                                                   ║");
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
                    dsHoaDon.nhapNHoaDon();
                    break;
                case 2:
                    dsHoaDon.Them();
                    break;
                case 3:
                    dsHoaDon.Sua();
                    break;
                case 4:
                    dsHoaDon.Xoa();
                    break;
                case 5:
                    dsHoaDon.TimKiem();
                    break;
                case 6:
                    dsHoaDon.hienThiDanhSachHoaDon();
                    break;
                case 7:
                    dsHoaDon.menuThongKe();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    // Menu quan ly chi tiet hoa don
    public static void menuQuanLyChiTietHoaDon(Scanner sc) {
        int choice = 0;
        do {
            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                          QUAN LY DANH SACH CHI TIET HOA DON                           ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(
                    "║ 1. Nhap danh sach chi tiet hoa don                                                    ║");
            System.out.println(
                    "║ 2. Them chi tiet hoa don                                                              ║");
            System.out.println(
                    "║ 3. Sua thong tin chi tiet hoa don                                                     ║");
            System.out.println(
                    "║ 4. Xoa chi tiet hoa don                                                               ║");
            System.out.println(
                    "║ 5. Tim kiem chi tiet hoa don                                                          ║");
            System.out.println(
                    "║ 6. Xem danh sach chi tiet hoa don                                                     ║");
            System.out.println(
                    "║ 7. Thong ke chi tiet hoa don                                                          ║");
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
                    dsChiTietHoaDon.nhapNChiTietHoaDon();
                    break;
                case 2:
                    dsChiTietHoaDon.Them();
                    break;
                case 3:
                    dsChiTietHoaDon.Sua();
                    break;
                case 4:
                    dsChiTietHoaDon.Xoa();
                    break;
                case 5:
                    dsChiTietHoaDon.TimKiem();
                    break;
                case 6:
                    dsChiTietHoaDon.hienThiDanhSachChiTiet();
                    break;
                case 7:
                    dsChiTietHoaDon.menuThongKe();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    // Menu quan ly nha cung cap
    public static void menuQuanLyNhaCungCap(Scanner sc) {
        int choice = 0;
        do {
            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                          QUAN LY DANH SACH NHA CUNG CAP                               ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(
                    "║ 1. Nhap danh sach nha cung cap                                                        ║");
            System.out.println(
                    "║ 2. Them nha cung cap                                                                  ║");
            System.out.println(
                    "║ 3. Sua thong tin nha cung cap                                                         ║");
            System.out.println(
                    "║ 4. Xoa nha cung cap                                                                   ║");
            System.out.println(
                    "║ 5. Tim kiem nha cung cap                                                              ║");
            System.out.println(
                    "║ 6. Xem danh sach nha cung cap                                                         ║");
            System.out.println(
                    "║ 7. Thong ke nha cung cap                                                              ║");
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
                    dsNhaCungCap.nhapNNhaCungCap();
                    break;
                case 2:
                    dsNhaCungCap.Them();
                    break;
                case 3:
                    dsNhaCungCap.Sua();
                    break;
                case 4:
                    dsNhaCungCap.Xoa();
                    break;
                case 5:
                    dsNhaCungCap.TimKiem();
                    break;
                case 6:
                    dsNhaCungCap.hienThiDanhSachNCC();
                    break;
                case 7:
                    dsNhaCungCap.menuThongKe();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    // Menu quan ly phieu xuat hang
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