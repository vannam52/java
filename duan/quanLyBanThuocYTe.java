package duan;

import java.util.Scanner;

public class quanLyBanThuocYTe {
    private final danhSachNhanVien dsNhanVien;
    private final danhSachKhachHang dsKhachHang;
    private final danhSachThuoc dsThuoc;
    private final danhSachKhuyenMai dsKhuyenMai;
    private final Scanner sc;

    public quanLyBanThuocYTe() {
        this.dsNhanVien = new danhSachNhanVien();
        this.dsKhachHang = new danhSachKhachHang();
        this.dsThuoc = new danhSachThuoc();
        this.dsKhuyenMai = new danhSachKhuyenMai();
        this.sc = new Scanner(System.in);

    }

    public static void main(String[] args) {
        quanLyBanThuocYTe heThong = new quanLyBanThuocYTe();
        heThong.hienThiMenuChinh();
    }

    public void hienThiMenuThuoc() {
        int chon;
        do {
            System.out.println("\n--- CHỨC NĂNG QUẢN LÝ THUỐC ---");
            System.out.println("1. Thêm thuốc mới");
            System.out.println("2. Xóa thuốc theo mã");
            System.out.println("3. Sửa thông tin thuốc");
            System.out.println("4. Tìm kiếm thuốc");
            System.out.println("5. Thống kê & Hiển thị danh sách");
            System.out.println("0. Quay lại Menu trước");
            System.out.print("Chọn chức năng: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                chon = -1;
            }

            switch (chon) {
                case 1:
                    dsThuoc.themThuoc();
                    break;
                case 2:
                    dsThuoc.xoaThuoc();
                    break;
                case 3:
                    dsThuoc.suaThongTinThuoc();
                    break;
                case 4:
                    timKiemThuoc();
                    break; //
                case 5:
                    dsThuoc.thongKeThuoc();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (chon != 0);
    }

    public void timKiemThuoc() {
        System.out.print("Nhập mã thuốc cần tìm: ");
        String maThuocCanTim = sc.nextLine();

        Thuoc th = dsThuoc.timKiemThuocTheoMa(maThuocCanTim);

        if (th != null) {
            th.hienThiThongTinThuoc();
        } else {
            System.out.println("Không tìm thấy mã thuốc: " + maThuocCanTim);
        }
    }

    public void hienThiMenuChinh() {
        int chon;

        do {
            System.out.println("\n\n============ HỆ THỐNG QUẢN LÝ BÁN THUỐC Y TẾ ============");
            System.out.println("1. Quản lý SẢN PHẨM (Thuốc, Thiết bị, TPCN)");
            System.out.println("2. Quản lý NHÂN VIÊN");
            System.out.println("3. Quản lý KHÁCH HÀNG");
            System.out.println("4. Quản lý KHUYẾN MÃI");
            System.out.println("5. Quản lý HÓA ĐƠN");
            System.out.println("0. THOÁT chương trình");
            System.out.println("=========================================================");
            System.out.print("Nhập lựa chọn của bạn (0-5): ");

            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                chon = -1; // Đặt giá trị không hợp lệ
            }

            switch (chon) {
                case 1:
                    hienThiMenuSanPham();
                    break;
                case 2:
                    hienThiMenuNhanVien();
                    break;
                case 3:
                    hienThiMenuKhachHang();
                    break;
                case 4:
                    hienThiMenuKhuyenMai();
                    break;
                case 5:
                    System.out.println("Đang vào Menu Quản lý Hóa đơn...");
                    break;
                case 0:
                    System.out.println("👋 Cảm ơn bạn đã sử dụng hệ thống! Hẹn gặp lại.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (chon != 0);
    }

    public void hienThiMenuKhachHang() {
        int chon;
        do {
            System.out.println("\n--- Quan ly khach hang ---");
            System.out.println("1. Thêm khách hàng mới");
            System.out.println("2. Xóa khách hàng theo mã");
            System.out.println("3. Sửa thông tin khách hàng");
            System.out.println("4. Tìm kiếm khách hàng");
            // System.out.println("5. Hiển thị tất cả khách hàng");
            System.out.println("0. Quay lại Menu Chính");
            System.out.print("Chọn chức năng: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                chon = -1;
            }

            switch (chon) {
                case 1:
                    dsKhachHang.themKhachHang();
                    break;
                case 2:
                    dsKhachHang.xoaKhachHang();
                    break;
                case 3:
                    dsKhachHang.suaThongTinKH();
                    break;
                case 4:
                    dsKhachHang.timTiemKhachHang();
                    ;
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (chon != 0);
    }

    public void hienThiMenuNhanVien() {
        int chon;
        do {
            System.out.println("\n--- Quan ly nhan vien ---");
            System.out.println("1. Them nhan vien moi");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Sua thong tin nhan vien");
            System.out.println("4. Tìm kiếm nhan vien");
            // System.out.println("5. Hiển thị tất cả khách hàng");
            System.out.println("0. Quay lại Menu Chính");
            System.out.print("Chọn chức năng: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                chon = -1;
            }

            switch (chon) {
                case 1:
                    dsNhanVien.themNhanVien();
                    break;
                case 2:
                    dsNhanVien.xoaNhanVien();
                    break;
                case 3:
                    dsNhanVien.suaThongTinNV();
                    break;
                case 4:
                    dsNhanVien.timKiemNhanVien();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (chon != 0);
    }
}