package duan;

import java.util.Scanner;

public class chiTietPhieuNhapHang {
    private String maPNH;
    private String maThuoc;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    public chiTietPhieuNhapHang() {}

    public chiTietPhieuNhapHang(chiTietPhieuNhapHang other) {
        if (other == null) return;
        this.maPNH = other.maPNH;
        this.maThuoc = other.maThuoc;
        this.soLuong = other.soLuong;
        this.donGia = other.donGia;
        this.thanhTien = other.thanhTien;
    }

    // Constructor 4 tham số (giống file test)
    public chiTietPhieuNhapHang(String maPNH, String maThuoc, int soLuong, double donGia) {
        this.maPNH = maPNH;
        this.maThuoc = maThuoc;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia; // Tự tính
    }

    public String getMaPNH() { return maPNH; }
    public void setMaPNH(String maPNH) { this.maPNH = maPNH; }
    public String getMaThuoc() { return maThuoc; }
    public void setMaThuoc(String maThuoc) { this.maThuoc = maThuoc; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }
    public double getThanhTien() { return thanhTien; }
    public void setThanhTien(double thanhTien) { this.thanhTien = thanhTien; }

   // Hàm thanhTien() (giống file test)
    public void thanhTien() {
        this.thanhTien = this.soLuong * this.donGia;
    }

    // Hàm nhapChiTietPhieuNhapHang() (giống mẫu phieuXuatHang)
    public void nhapChiTietPhieuNhapHang() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma cua phieu nhap hang: ");
        this.maPNH = sc.nextLine();
        System.out.println("Nhap ma thuoc duoc nhap hang: ");
        this.maThuoc = sc.nextLine();
        System.out.println("Nhap so luong thuoc: ");
        this.soLuong = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap don gia thuoc: ");
        this.donGia = sc.nextDouble();
        sc.nextLine();
        thanhTien(); // Gọi hàm nội bộ
        System.out.println("nhap thong tin thanh cong.");
    }

    public void Xuat() {
        final String LINE = "═════════════════════════════════════════════════════════════════════════════";
        final int W = 77;

        System.out.println("╔" + LINE + "╗");
        System.out.println("║ ---------------- THONG TIN CHI TIET PHIEU NHAP ---------------------------  ║");
        System.out.println("╠" + LINE + "╣");
        System.out.printf("║ Ma phieu nhap hang: %-" + (W - 22) + "s ║%n", maPNH);
        System.out.printf("║ Ma thuoc: %-" + (W - 12) + "s ║%n", maThuoc);
        System.out.printf("║ So luong: %-" + (W - 12) + "d ║%n", soLuong);
        System.out.printf("║ Don gia: %-" + (W - 11) + ".2f ║%n", donGia);
        System.out.printf("║ Thanh tien: %-" + (W - 14) + ".2f ║%n", thanhTien);
        System.out.println("╚" + LINE + "╝");
    }

    @Override
    public String toString() {
        return "Mã PNH: " + maPNH +
                ", Mã Thuốc: " + maThuoc +
                ", Số Lượng: " + soLuong +
                ", Đơn Giá: " + donGia +
                ", Thành Tiền: " + thanhTien;
    }
}