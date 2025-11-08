// package duan;

// import java.util.Scanner;

// public class ChiTietPhieuNhapHang {
//     private String maPNH;
//     private String maThuoc;
//     private int soLuong;
//     private double donGia;
//     private double thanhTien;

//     public ChiTietPhieuNhapHang() {
//     }

//     public ChiTietPhieuNhapHang(String maPNH, String maThuoc, int soLuong, double donGia, double thanhTien) {
//         this.maPNH = maPNH;
//         this.maThuoc = maThuoc;
//         this.soLuong = soLuong;
//         this.donGia = donGia;
//         this.thanhTien = thanhTien;
//     }

//     public ChiTietPhieuNhapHang(ChiTietPhieuNhapHang other) {
//         if (other == null)
//             return;
//         this.maPNH = other.maPNH;
//         this.maThuoc = other.maThuoc;
//         this.soLuong = other.soLuong;
//         this.donGia = other.donGia;
//         this.thanhTien = other.thanhTien;
//     }

//     public String getMaPNH() {
//         return maPNH;
//     }

//     public void setMaPNH(String maPNH) {
//         this.maPNH = maPNH;
//     }

//     public String getMaThuoc() {
//         return maThuoc;
//     }

//     public void setMaThuoc(String maThuoc) {
//         this.maThuoc = maThuoc;
//     }

//     public int getSoLuong() {
//         return soLuong;
//     }

//     public void setSoLuong(int soLuong) {
//         this.soLuong = soLuong;
//     }

//     public double getDonGia() {
//         return donGia;
//     }

//     public void setDonGia(double donGia) {
//         this.donGia = donGia;
//     }

//     public double getThanhTien() {
//         return thanhTien;
//     }

//     public void setThanhTien(double thanhTien) {
//         this.thanhTien = thanhTien;
//     }

//     public double tinhThanhTien() {
//         return this.soLuong * this.donGia;
//     }

//     public void nhap() {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Nhap ma phieu nhap: ");
//         this.maPNH = sc.nextLine().trim();
//         System.out.print("Nhap ma thuoc: ");
//         this.maThuoc = sc.nextLine().trim();
//         System.out.print("Nhap so luong: ");
//         this.soLuong = sc.nextLine().trim();
//         System.out.print("Nhap don gia: ");
//         this.donGia = sc.nextLine().trim();
//         this.thanhTien = tinhThanhTien();
//     }

//     public void Xuat() {
//         final String LINE = "══════════════════════════════════════════════════════════════════════════════════════";
//         final String ROW_FMT = "║ %-18s %-66s ║%n";

//         System.out.println("╔" + LINE + "╗");
//         System.out.println("║                             CHI TIET PHIEU NHAP                                    ║");
//         System.out.println("╠" + LINE + "╣");
//         System.out.printf(ROW_FMT, "Ma phieu nhap:", maPNH == null ? "" : maPNH);
//         System.out.println("╠" + LINE + "╣");
//         System.out.printf(ROW_FMT, "Ma thuoc:", maThuoc == null ? "" : maThuoc);
//         System.out.printf(ROW_FMT, "So luong:", String.valueOf(soLuong));
//         System.out.printf(ROW_FMT, "Don gia:", String.format("%,.2f VND", donGia));
//         System.out.printf(ROW_FMT, "Thanh tien:", String.format("%,.2f VND", thanhTien));
//         System.out.println("╚" + LINE + "╝");
//     }

//     @Override
//     public String toString() {
//         return maPNH + "," + maThuoc + "," +
//                 soLuong + "," + donGia + "," + thanhTien;
//     }
// }