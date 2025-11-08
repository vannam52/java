package duan;

import java.util.Scanner;

public class khachHang extends conNguoi {
    private String maKH;
    private String diaChi;
    private int diemTichLuy;

    public khachHang() {
        super();
    }

    public khachHang(String maKH, String HoTen, String ngaySinh, String GioiTinh, String SDT, String diaChi,
            int diemTichLuy) {
        super(HoTen, ngaySinh, GioiTinh, SDT);
        this.maKH = maKH;
        this.diaChi = diaChi;
        this.diemTichLuy = diemTichLuy;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap maKH: ");
        maKH = sc.nextLine();
        super.Nhap();
        System.out.print("Nhap dia chi: ");
        diaChi = sc.nextLine();
        System.out.print("Nhap diem tich luy: ");
        diemTichLuy = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public void Xuat() {
        final String LINE = "════════════════════════════════════════════════════════════════════════════════";
        final int W = 77;

        System.out.println("╔" + LINE + "╗");
        System.out.println("║                         THONG TIN KHACH HANG                                   ║");
        System.out.println("╠" + LINE + "╣");
        System.out.printf("║ Ma KH: %-71s ║%n", maKH);
        System.out.printf("║ Ho ten: %-70s ║%n", getHoTen());
        System.out.printf("║ Nam sinh: %-68s ║%n", getNgaySinh());
        System.out.printf("║ Gioi tinh: %-67s ║%n", getGioiTinh());
        System.out.printf("║ SDT: %-73s ║%n", getSDT());
        System.out.printf("║ Tuoi: %-72d ║%n", tinhTuoi());
        System.out.printf("║ Dia chi: %-69s ║%n", diaChi);
        System.out.printf("║ Diem tich luy: %-63d ║%n", diemTichLuy);
        System.out.println("╚" + LINE + "╝");
    }

    public void capNhapDiemTichLuy(int diem) {
        this.diemTichLuy += diem;
    }
    // @Override
    // public int tinhTuoi(){
    // super.tinhTuoi();
    // }
}