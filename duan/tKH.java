package duan;

import java.util.Scanner;

public class tKH {
    public static void main(String[] args) {
        // Khởi tạo danh sách khách hàng
        danhSachKhachHang dskh = new danhSachKhachHang();
        Scanner sc = new Scanner(System.in);
        int luaChon = -1;

        // Thêm khách hàng mẫu (đã có sẵn thông tin) để dễ test
        khachHang manualKh1 = new khachHang("M001", "Doan Van T", "Dia chi T", "0123", 50);
        khachHang manualKh2 = new khachHang("M002", "Bui Thi H", "Dia chi H", "0456", 100);

        // Cần dùng hàm themKhachHang đã sửa (bỏ kh.NhapThongTinKH() bên trong)
        dskh.themKhachHang(manualKh1);
        dskh.themKhachHang(manualKh2);
        System.out.println("Da them 2 khach hang mau (M001, M002).");

        // Menu chính
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Them khach hang moi");
            System.out.println("2. Xoa khach hang theo ma");
            System.out.println("3. Tim kiem khach hang theo ma");
            System.out.println("4. Tim kiem khach hang theo ten");
            System.out.println("5. Sua thong tin khach hang theo ma");
            System.out.println("6. Cap nhat diem tich luy");
            System.out.println("7. Sap xep danh sach (Theo Ten)");
            System.out.println("8. Sap xep danh sach (Theo Diem Tich Luy - Giam dan)");
            System.out.println("9. Hien thi danh sach khach hang");
            System.out.println("10. Thong ke khach hang");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");

            // Xử lý lỗi nhập liệu cho menu
            if (sc.hasNextInt()) {
                luaChon = sc.nextInt();
                sc.nextLine(); // Đọc bỏ ký tự xuống dòng
            } else {
                System.out.println("Vui long chi nhap so cho lua chon menu.");
                sc.nextLine(); // Đọc bỏ dòng nhập sai
                luaChon = -1;
                continue;
            }

            switch (luaChon) {
                case 1:
                    // Them khach hang moi
                    System.out.println("--- Them khach hang ---");
                    khachHang khMoi = new khachHang();
                    // BẮT BUỘC: Gọi NhapThongTinKH() TRƯỚC KHI thêm và TRUYỀN SCANNER
                    khMoi.NhapThongTinKH();
                    dskh.themKhachHang(khMoi);
                    break;
                case 2:
                    // Xoa khach hang theo ma
                    System.out.println("--- Xoa khach hang ---");
                    System.out.print("Nhap ma khach hang can xoa: ");
                    String maXoa = sc.nextLine();
                    dskh.xoaKhachHang(maXoa);
                    break;
                case 3:
                    // Tim kiem khach hang theo ma
                    System.out.println("--- Tim kiem theo Ma ---");
                    System.out.print("Nhap ma khach hang can tim: ");
                    String maTim = sc.nextLine();
                    khachHang khTimMa = dskh.timKiemTheoMa(maTim);
                    if (khTimMa != null) {
                        System.out.println("Tim thay khach hang:");
                        khTimMa.HienThiThongTinKH();
                    } else {
                        System.out.println("Khong tim thay khach hang voi ma: " + maTim);
                    }
                    break;
                case 4:
                    // Tim kiem khach hang theo ten
                    System.out.println("--- Tim kiem theo Ten ---");
                    System.out.print("Nhap ten khach hang can tim: ");
                    String tenTim = sc.nextLine();
                    khachHang[] khTimTen = dskh.timKiemTheoTen(tenTim);
                    if (khTimTen.length > 0) {
                        System.out.println("Tim thay " + khTimTen.length + " khach hang voi ten '" + tenTim + "':");
                        for (khachHang kh : khTimTen) {
                            kh.HienThiThongTinKH();
                            System.out.println("---");
                        }
                    } else {
                        System.out.println("Khong tim thay khach hang voi ten: " + tenTim);
                    }
                    break;
                case 5:
                    // Sua thong tin khach hang theo ma
                    System.out.println("--- Sua thong tin khach hang ---");
                    System.out.print("Nhap ma khach hang can sua: ");
                    String maSua = sc.nextLine();
                    // BẮT BUỘC: Gọi suaThongTinKH() và TRUYỀN SCANNER
                    dskh.suaThongTinKH(maSua);
                    break;
                case 6:
                    // Cap nhat diem tich luy
                    System.out.println("--- Cap nhat diem tich luy ---");
                    System.out.print("Nhap ma khach hang can cap nhat: ");
                    String maCapNhat = sc.nextLine();
                    System.out.print("Nhap so diem muon cong them: ");

                    int diemCongThem = 0;
                    if (sc.hasNextInt()) {
                        diemCongThem = sc.nextInt();
                        sc.nextLine(); // Đọc bỏ ký tự xuống dòng
                        dskh.capNhapDiemTichLuy(maCapNhat, diemCongThem);
                    } else {
                        System.out.println("Vui long nhap so cho diem tich luy. Thao tac cap nhat bi huy.");
                        sc.nextLine();
                    }
                    break;
                case 7:
                    // Sap xep danh sach (Theo Ten)
                    System.out.println("--- Sap xep theo Ten ---");
                    dskh.sapXepTheoTen();
                    dskh.hienThiDanhSachKH();
                    break;
                case 8:
                    // Sap xep danh sach (Theo Diem Tich Luy - Giam dan)
                    System.out.println("--- Sap xep theo Diem Tich Luy (Giam dan) ---");
                    dskh.sapXepTheoDiemTichLuy();
                    dskh.hienThiDanhSachKH();
                    break;
                case 9:
                    // Hien thi danh sach khach hang
                    System.out.println("--- Hien thi danh sach ---");
                    dskh.hienThiDanhSachKH();
                    break;
                case 10:
                    // Thong ke khach hang
                    System.out.println("--- Thong ke ---");
                    dskh.thongKeKH();
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh. Tam biet! 👋");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }

        } while (luaChon != 0);

        sc.close();
    }
}
