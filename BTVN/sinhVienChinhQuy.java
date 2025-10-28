package BTVN;

import java.util.Scanner;

public class sinhVienChinhQuy extends sinhVien {
    public int diemRenLuyen;

    public sinhVienChinhQuy() {
    }

    public sinhVienChinhQuy(String ho, String ten, String mSSV, String nS, String gt, int diemRenLuyen) {
        super(ho, ten, mSSV, nS, gt);
        this.diemRenLuyen = diemRenLuyen;
    }

    public int getDiemRenLuyen() {
        return diemRenLuyen;
    }

    public void setDiemRenLuyen(int diemRenLuyen) {
        this.diemRenLuyen = diemRenLuyen;
    }

    @Override
    public void Nhap() {
        super.Nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap diem ren luyen: ");
        this.diemRenLuyen = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("Diem ren luyen: " + this.diemRenLuyen);
    }

    
}