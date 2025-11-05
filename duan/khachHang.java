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
        System.out.print("Nhap diem tich luy ban dau: ");
        diemTichLuy = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public void Xuat() {
        final String LINE = "════════════════════════════════════════════════════════════════════════════════";
        final int W = 77;

        System.out.println("╔" + LINE + "╗");
        System.out.println("║ ------------------ THONG TIN KHACH HANG --------------------------------- ║");
        System.out.println("╠" + LINE + "╣");
        System.out.printf("║ Ma KH: %-" + (W - 6) + "s ║%n", maKH);

        super.Xuat();
        System.out.printf("║ Tuoi: %-" + (W - 7) + "d ║%n", tinhTuoi());
        System.out.printf("║ Dia chi: %-" + (W - 10) + "s ║%n", diaChi);
        System.out.printf("║ Diem tich luy: %-" + (W - 16) + "d ║%n", diemTichLuy);
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