package duan;

import java.util.Scanner;

public class thuocKeDon extends Thuoc {
    private String loaiThuoc;

    public thuocKeDon() {
        super();
    }

    public thuocKeDon(String ma, String ten, String dv, double gia, int soLuong, String HSD,
            String loaiThuoc) {
        super(ma, ten, dv, gia, soLuong, HSD);
        this.loaiThuoc = loaiThuoc;
    }

    public thuocKeDon(thuocKeDon other) {
        super(other);
        this.loaiThuoc = other.loaiThuoc;
    }

    public String getLoaiThuocKeDon() {
        return loaiThuoc;
    }

    public void setLoaiThuocKeDon(String loaiThuoc) {
        this.loaiThuoc = loaiThuoc;
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        super.Nhap();

        System.out.print("Nhap loai: ");
        this.loaiThuoc = sc.nextLine();

    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("Loai: " + loaiThuoc);
    }

    @Override
    public String toString() {
        return super.toString() + "," + loaiThuoc;
    }

}