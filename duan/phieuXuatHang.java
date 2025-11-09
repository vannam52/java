package duan;

import java.util.Scanner;

public class phieuXuatHang {
    private String maPXH;
    private String maThuoc;
    private int soLuong;
    private double donGia;
    private double thanhTien;
    private String maKH;

    public phieuXuatHang() {
    }

    public phieuXuatHang(phieuXuatHang other) {
        this.maPXH = other.maPXH;
        this.maThuoc = other.maThuoc;
        this.soLuong = other.soLuong;
        this.donGia = other.donGia;
        this.thanhTien = other.thanhTien;
        this.maKH = other.maKH;
    }

    public phieuXuatHang(String maPXH, String maThuoc, int soLuong, double donGia, String maKH) {
        this.maPXH = maPXH;
        this.maThuoc = maThuoc;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
        this.maKH = maKH;
    }

    public String getMaPXH() {
        return maPXH;
    }

    public void setMaPXH(String maPXH) {
        this.maPXH = maPXH;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
        thanhTien();
    }

    public double getthanhTien() {
        return thanhTien;
    }

    public String getmaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void thanhTien() {
        this.thanhTien = this.soLuong * this.donGia;
    }

    public void nhapPhieuXuatHang() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma cua phieu nhap hang: ");
        this.maPXH = sc.nextLine();
        System.out.println("Nhap ma thuoc duoc xuat hang: ");
        this.maThuoc = sc.nextLine();
        System.out.println("Nhap so luong thuoc: ");
        this.soLuong = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap don gia thuoc: ");
        this.donGia = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nhap ma khach hang: ");
        this.maKH = sc.nextLine();
        thanhTien();
        System.out.println("nhap thong tin thanh cong.");

    }

    public void Xuat() {
        final String LINE = "═══════════════════════════════════════════════════════════════════════════════";
        final int W = 77;

        System.out.println("╔" + LINE + "╗");
        System.out.println("║ ---------------- THONG TIN PHIEU XUAT HANG ------------------------------- ║");
        System.out.println("╠" + LINE + "╣");
        System.out.printf("║ Ma phieu xuat hang: %-" + (W - 22) + "s ║%n", maPXH);
        System.out.printf("║ Ma thuoc: %-" + (W - 12) + "s ║%n", maThuoc);
        System.out.printf("║ So luong: %-" + (W - 12) + "d ║%n", soLuong);
        System.out.printf("║ Don gia: %-" + (W - 11) + ".2f ║%n", donGia);
        System.out.printf("║ Ma khach hang: %-" + (W - 18) + "s ║%n", maKH);
        System.out.printf("║ Thanh tien: %-" + (W - 15) + ".2f ║%n", thanhTien);
        System.out.println("╚" + LINE + "╝");
    }

    @Override
    public String toString() {
        return "Mã PXH: " + maPXH +
                ", Mã Thuốc: " + maThuoc +
                ", Số Lượng: " + soLuong +
                ", Đơn Giá: " + donGia +
                ", Thành Tiền: " + thanhTien +
                ", Mã KH: " + maKH;
    }

}
