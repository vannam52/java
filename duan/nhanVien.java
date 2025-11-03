package duan;

import java.util.Scanner;

public class nhanVien extends conNguoi {
    private String maNV;
    private String diaChi;
    private double luongCoBan;
    private double thuong;

    public nhanVien() {
        super();
    }

    // Constructor khớp với file CSV: maNV, HoTen, GioiTinh, SDT, diaChi, tuoi,
    // luongCoBan, thuong
    public nhanVien(String maNV, String HoTen, String GioiTinh, String SDT,
            String diaChi, int tuoi, double luongCoBan, double thuong) {
        super(HoTen, tuoi, GioiTinh, SDT); 
        this.maNV = maNV;
        this.diaChi = diaChi;
        this.luongCoBan = luongCoBan;
        this.thuong = thuong;
    }

    public nhanVien(nhanVien other) {
        this.maNV = other.maNV;
        this.diaChi = other.diaChi;
        this.luongCoBan = other.luongCoBan;
        this.thuong = other.thuong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getThuong() {
        return thuong;
    }

    public void setThuong(double thuong) {
        this.thuong = thuong;
    }

    public double getLuong() {
        return this.luongCoBan + this.thuong;
    }

    public void NhapMa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien (NV...): ");
        this.maNV = sc.nextLine();
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin nhan vien:");

        super.Nhap();

        System.out.print("Nhap dia chi: ");
        this.diaChi = sc.nextLine();

        boolean luongCoBanHopLe = false;
        do {
            System.out.print("Nhap luong co ban: ");
            try {
                this.luongCoBan = Double.parseDouble(sc.nextLine());
                if (this.luongCoBan < 0)
                    throw new NumberFormatException();
                luongCoBanHopLe = true;
            } catch (NumberFormatException e) {
                System.out.println(">> Vui long nhap so hop le lon hon hoac bang 0 cho luong co ban.");
            }
        } while (!luongCoBanHopLe);

        boolean thuongHopLe = false;
        do {
            System.out.print("Nhap luong thuong: ");
            try {
                this.thuong = Double.parseDouble(sc.nextLine());
                if (this.thuong < 0)
                    throw new NumberFormatException();
                thuongHopLe = true;
            } catch (NumberFormatException e) {
                System.out.println(">> Vui long nhap so hop le lon hon hoac bang 0 cho luong thuong.");
            }
        } while (!thuongHopLe);
    }

    @Override
    public void Xuat() {
        final String LINE = "══════════════════════════════════════════════════════════════════════════════════════";

        System.out.println("╔" + LINE + "╗");
        System.out.println("║                                 NHAN VIEN                                            ║");
        System.out.println("╠" + LINE + "╣");
        System.out.printf("║ Ma NV: %-77s ║%n", maNV);
        System.out.println("╠" + LINE + "╣");
        System.out.println("║                             THONG TIN CA NHAN                                        ║");
        System.out.println("╠" + LINE + "╣");

        super.Xuat();
        System.out.printf("║ Dia chi: %-75s ║%n", diaChi);
        System.out.printf("║ Luong co ban: %-66.0f VND ║%n", luongCoBan);
        System.out.printf("║ Thuong: %-72.0f VND ║%n", thuong);
        System.out.printf("║ Tong luong: %-68.0f VND ║%n", getLuong());
        System.out.println("╚" + LINE + "╝");
    }

    public void suaThongTinNV(Scanner sc) {
        System.out.println("--- Cap nhat thong tin Nhan Vien ---");
        System.out.println("(Bo trong neu khong muon thay doi)");

        System.out.print("Ho ten moi: ");
        String tenMoi = sc.nextLine();
        if (!tenMoi.isEmpty())
            setHoTen(tenMoi);

        System.out.print("Dia chi moi: ");
        String diaChiMoi = sc.nextLine();
        if (!diaChiMoi.isEmpty())
            this.diaChi = diaChiMoi;

        boolean luongCoBanHopLe = false;
        do {
            System.out.print("Nhap luong co ban moi: ");
            String luongMoiStr = sc.nextLine();
            if (luongMoiStr.isEmpty())
                break;

            try {
                double luongMoi = Double.parseDouble(luongMoiStr);
                if (luongMoi < 0)
                    throw new NumberFormatException();
                setLuongCoBan(luongMoi);
                luongCoBanHopLe = true;
            } catch (NumberFormatException e) {
                System.out.println(">> Vui long nhap lai so hop le va lon hon 0.");
            }
        } while (!luongCoBanHopLe);

        boolean thuongHopLe = false;
        do {
            System.out.print("Nhap luong thuong moi: ");
            String thuongMoiStr = sc.nextLine();
            if (thuongMoiStr.isEmpty())
                break;

            try {
                double thuongMoi = Double.parseDouble(thuongMoiStr);
                if (thuongMoi < 0)
                    throw new NumberFormatException();
                setThuong(thuongMoi);
                thuongHopLe = true;
            } catch (NumberFormatException e) {
                System.out.println(">> Vui long nhap lai so hop le va lon hon 0.");
            }
        } while (!thuongHopLe);

        System.out.println("✓ Cap nhat thanh cong!");
    }

    public void tinhLuong(double tien) {
        this.thuong += tien;
    }
}