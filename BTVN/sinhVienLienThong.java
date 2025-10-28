package BTVN;
import java.util.Scanner;

public class sinhVienLienThong extends sinhVien {
    public String namTotNghiepCD;
    public String nganhTotNghiep;

    public sinhVienLienThong() {
    }

    public sinhVienLienThong(String ho, String ten, String mSSV, String nS, String gt, String namTotNghiepCD,
            String nganhTotNghiep) {
        super(ho, ten, mSSV, nS, gt);
        this.namTotNghiepCD = namTotNghiepCD;
        this.nganhTotNghiep = nganhTotNghiep;
    }

    public String getNamTotNghiepCD() {
        return namTotNghiepCD;
    }

    public void setNamTotNghiepCD(String namTotNghiepCD) {
        this.namTotNghiepCD = namTotNghiepCD;
    }

    public String getNganhTotNghiep() {
        return nganhTotNghiep;
    }

    public void setNganhTotNghiep(String nganhTotNghiep) {
        this.nganhTotNghiep = nganhTotNghiep;
    }

    @Override
    public void Nhap() {
        super.Nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap nam tot nghiep cao dang: ");
        this.namTotNghiepCD = sc.nextLine();
        System.out.println("Nhap nganh tot nghiep: ");
        this.nganhTotNghiep = sc.nextLine();
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("Nam tot nghiep cao dang: " + this.namTotNghiepCD + " - Nganh tot nghiep: " + this.nganhTotNghiep);
    }
}