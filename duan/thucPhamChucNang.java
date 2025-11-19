package duan;

import java.util.Scanner;

public class thucPhamChucNang extends Thuoc {
    private String loaiTP;

    public thucPhamChucNang() {
        super();
    }

    public thucPhamChucNang(String ma, String ten, String donVi, double gia, int soLuong, String HSD, String loaiTP) {
        super(ma, ten, donVi, gia, soLuong, HSD);
        this.loaiTP = loaiTP;
    }

    public thucPhamChucNang(thucPhamChucNang other) {
        super(other);
        this.loaiTP = other.loaiTP;
    }

    public String getLoaiTP() {
        return loaiTP;
    }

    public void setLoaiTP(String loaiTP) {
        this.loaiTP = loaiTP;
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        super.Nhap();
        System.out.println("Nhap loai: ");
        this.loaiTP = sc.nextLine();
    }

    @Override
    public void Xuat() {
        super.Xuat();
        //
    }

    @Override
    public String toString() {
        return super.toString() + "," + loaiTP;
    }
}