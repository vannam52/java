package duan;

import java.util.Scanner;
import java.util.Locale;

public class quanLyBanThuocYTe {

    public static danhSachNhanVien dsNhanVien = new danhSachNhanVien();
    public static danhSachKhachHang dsKhachHang = new danhSachKhachHang();
    public static danhSachKhuyenMai dsKhuyenMai = new danhSachKhuyenMai();
    public static danhSachThuoc dsThuocYTe = new danhSachThuoc();
    // public static danhSachHoaDonNhapHang dsHoaDonNhap = new
    // danhSachHoaDonNhapHang();
    // public static danhSachHoaDonBanHang dsHoaDonBan = new
    // danhSachHoaDonBanHang();

    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        taiDuLieu();

        hienThiMenuChinh();

        luuDuLieu();
        sc.close();
    }

    public static void taiDuLieu() {
        dsNhanVien.docFile("duan/nhanVien.txt");
        dsKhachHang.docFile("duan/khachHang.txt");
        dsThuocYTe.docFile("duan/Thuoc.txt");

        System.out.println("Tai du lieu thanh cong!");
    }

    public static void luuDuLieu() {
        dsNhanVien.ghiFile("duan/nhanVien.txt");
        dsKhachHang.ghiFile("duan/khachHang.txt");
        dsKhachHang.ghiFile("duan/Thuoc.txt");

    }

    public static void hienThiMenuChinh() {
        int choice = 0;
        do {
            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                              MENU QUAN LY BAN THUOC Y TE                             ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(
                    "║ 1. Quan ly danh sach thuoc y te                                                      ║");
            System.out.println(
                    "║ 2. Quan ly danh sach nhan vien                                                       ║");
            System.out.println(
                    "║ 3. Quan ly danh sach khach hang                                                      ║");
            System.out.println(
                    "║ 4. Quan ly danh sach khuyen mai                                                      ║");
            System.out.println(
                    "║ 5. Quan ly danh sach hoa don ban hang                                                ║");
            System.out.println(
                    "║ 6. Quan ly danh sach hoa don nhap hang                                               ║");
            System.out.println(
                    "║ 0. Thoat chuong trinh                                                                ║");
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
                    menuQuanLyThuoc(sc);
                    break;
                case 2:
                    menuQuanLyNhanVien(sc);
                    break;
                case 3:
                    menuQuanLyKhachHang(sc);
                    break;
                // case 4: menuQuanLyKhuyenMai(sc);
                // break;
                // case 5: menuQuanLyHoaDonBan(sc);
                // break;
                // case 6: menuQuanLyHoaDonNhap(sc);
                // break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
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
                    dsThuocYTe.thongKe();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("✗ Lua chon khong hop le!");
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
                    dsNhanVien.thongKe();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("✗ Lua chon khong hop le!");
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
                    dsKhachHang.thongKe();
                    ;
                    break;
                case 0:
                    break;
                default:
                    System.out.println("✗ Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    // public static void menuQuanLyKhuyenMai(Scanner sc) {
    // int choice = 0;
    // do {
    // System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════╗");
    // System.out.println("║                              QUẢN LÝ DANH SÁCH KHUYẾN
    // MÃI                            ║");
    // System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════╣");
    // System.out.println("║ 1. Nhập danh sách khuyến mãi                          
    //                               ║");
    // System.out.println("║ 2. Thêm khuyến mãi                                    
    //                               ║");
    // System.out.println("║ 3. Sửa thông tin khuyến mãi                            
    //                              ║");
    // System.out.println("║ 4. Xóa khuyến mãi                                      
    //                              ║");
    // System.out.println("║ 5. Tìm kiếm khuyến mãi                                
    //                               ║");
    // System.out.println("║ 6. Xem danh sách khuyến mãi                            
    //                              ║");
    // System.out.println("║ 0. Quay lại menu chính                                
    //                               ║");
    // System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════╝");
    // System.out.print("Nhập lựa chọn: ");

    // try {
    // choice = Integer.parseInt(sc.nextLine());
    // } catch (NumberFormatException e) {
    // choice = -1;
    // }

    // switch (choice) {
    // case 1: dsKhuyenMai.Nhap();
    // break;
    // case 2: dsKhuyenMai.Them();
    // break;
    // case 3: dsKhuyenMai.Sua();
    // break;
    // case 4: dsKhuyenMai.Xoa();
    // break;
    // case 5: dsKhuyenMai.TimKiem();
    // break;
    // case 6: dsKhuyenMai.XuatDS();
    // break;
    // case 0:
    // break;
    // default: System.out.println("Lựa chọn không hợp lệ!");
    // }
    // } while (choice != 0);
    // }

    // public static void menuQuanLyHoaDonBan(Scanner sc) {
    // int choice = 0;
    // do {
    // System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════╗");
    // System.out.println("║                              QUẢN LÝ HÓA ĐƠN BÁN HÀNG  
    //                              ║");
    // System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════╣");
    // System.out.println("║ 1. Nhập danh sách hóa đơn bán hàng                    
    //                               ║");
    // System.out.println("║ 2. Thêm hóa đơn bán hàng                              
    //                               ║");
    // System.out.println("║ 3. Sửa hóa đơn bán hàng                                
    //                              ║");
    // System.out.println("║ 4. Xóa hóa đơn bán hàng                                
    //                              ║");
    // System.out.println("║ 5. Tìm kiếm hóa đơn bán hàng                          
    //                               ║");
    // System.out.println("║ 6. Xem danh sách hóa đơn bán hàng                      
    //                              ║");
    // System.out.println("║ 0. Quay lại menu chính                                
    //                               ║");
    // System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════╝");
    // System.out.print("Nhập lựa chọn: ");

    // try {
    // choice = Integer.parseInt(sc.nextLine());
    // } catch (NumberFormatException e) {
    // choice = -1;
    // }

    // switch (choice) {
    // case 1: dsHoaDonBan.Nhap(sc);
    // break;
    // case 2: dsHoaDonBan.Them();
    // break;
    // case 3: dsHoaDonBan.Sua();
    // break;
    // case 4: dsHoaDonBan.Xoa();
    // break;
    // case 5: dsHoaDonBan.TimKiem();
    // break;
    // case 6: dsHoaDonBan.XuatDS();
    // break;
    // case 0:
    // break;
    // default: System.out.println("Lựa chọn không hợp lệ!");
    // }
    // } while (choice != 0);
    // }

    // public static void menuQuanLyHoaDonNhap(Scanner sc) {
    // int choice = 0;
    // do {
    // System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════╗");
    // System.out.println("║                              QUẢN LÝ HÓA ĐƠN NHẬP HÀNG
    //                               ║");
    // System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════╣");
    // System.out.println("║ 1. Nhập danh sách hóa đơn nhập hàng                    
    //                              ║");
    // System.out.println("║ 2. Thêm hóa đơn nhập hàng                              
    //                              ║");
    // System.out.println("║ 3. Sửa hóa đơn nhập hàng                              
    //                               ║");
    // System.out.println("║ 4. Xóa hóa đơn nhập hàng                              
    //                               ║");
    // System.out.println("║ 5. Tìm kiếm hóa đơn nhập hàng                          
    //                              ║");
    // System.out.println("║ 6. Xem danh sách hóa đơn nhập hàng                    
    //                               ║");
    // System.out.println("║ 0. Quay lại menu chính                                
    //                               ║");
    // System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════╝");
    // System.out.print("Nhập lựa chọn: ");

    // try {
    // choice = Integer.parseInt(sc.nextLine());
    // } catch (NumberFormatException e) {
    // choice = -1;
    // }

    // switch (choice) {
    // case 1: dsHoaDonNhap.Nhap(sc, dsNhanVien);
    // break;
    // case 2: dsHoaDonNhap.Them();
    // break;
    // case 3: dsHoaDonNhap.Sua();
    // break;
    // case 4: dsHoaDonNhap.Xoa();
    // break;
    // case 5: dsHoaDonNhap.TimKiem();
    // break;
    // case 6: dsHoaDonNhap.XuatDS();
    // break;
    // case 0:
    // break;
    // default: System.out.println("Lựa chọn không hợp lệ!");
    // }
    // } while (choice != 0);
    // }
}