package duan;

import java.util.Scanner;

public class chiTietHoaDon {
    private String maHD;
    private String maThuoc;
    private String tenThuoc;
    private int soLuong;
    private int donGia;
    private int thanhTien;

    public chiTietHoaDon() {
    }

    public chiTietHoaDon(chiTietHoaDon other) {
        this.maHD = other.maHD;
        this.maThuoc = other.maThuoc;
        this.tenThuoc = other.tenThuoc;
        this.soLuong = other.soLuong;
        this.donGia = other.donGia;
        this.thanhTien = other.thanhTien;
    }

    public chiTietHoaDon(String maHD, String maThuoc, String tenThuoc, int soLuong, int donGia) {
        this.maHD = maHD;
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chi tiet hoa don:");
        System.out.print("Nhap ma thuoc: ");
        this.maThuoc = sc.nextLine();
        System.out.print("Nhap ten thuoc: ");
        this.tenThuoc = sc.nextLine();

        while (true) {
            try {
                System.out.print("Nhap so luong: ");
                this.soLuong = Integer.parseInt(sc.nextLine());
                if (this.soLuong > 0) {
                    break;
                }
            } catch (NumberFormatException var4) {
                System.out.println("So luong khong hop le. Vui long nhap lai.");
            }
        }

        while (true) {
            try {
                System.out.print("Nhap don gia: ");
                this.donGia = Integer.parseInt(sc.nextLine());
                if (this.donGia > 0) {
                    break;
                }
            } catch (NumberFormatException var3) {
                System.out.println("Don gia khong hop le. Vui long nhap lai.");
            }
        }

        this.thanhTien = this.soLuong * this.donGia;
    }

    public void Xuat() {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                       CHI TIET HOA DON                     ║");
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        System.out.printf("║ Ma hoa don    : %-45s ║%n", this.maHD);
        System.out.printf("║ Ma thuoc      : %-45s ║%n", this.maThuoc);
        System.out.printf("║ Ten thuoc     : %-45s ║%n", this.tenThuoc);
        System.out.printf("║ So luong      : %-45d ║%n", this.soLuong);
        System.out.printf("║ Don gia       : %-45d VND ║%n", this.donGia);
        System.out.printf("║ Thanh tien    : %-45d VND ║%n", this.thanhTien);
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }
}
