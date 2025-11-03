package duan;

import java.util.Scanner;

public class khachHang extends conNguoi {
    private String maKH;
    private String diaChi;
    private int diemTichLuy;

    public khachHang() {
        super();
    }

    public khachHang(String maKH, String HoTen, String GioiTinh, String SDT, int tuoi, String diaChi,
            int diemTichLuy) {
        super(HoTen, tuoi, GioiTinh, SDT);
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

    public void NhapMa() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Nhap ma khach hang (KH...): ");
            this.maKH = sc.nextLine();
            if (this.maKH.trim().isEmpty()) {
                System.out.println(">> Loi: Ma KH khong duoc de trong.");
            }
        } while (this.maKH.trim().isEmpty());
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        super.Nhap();

        System.out.print("Nhap dia chi: ");
        this.diaChi = sc.nextLine();

        boolean nhapSai;
        do {
            nhapSai = false;
            System.out.print("Nhap diem tich luy ban dau: ");
            try {
                this.diemTichLuy = Integer.parseInt(sc.nextLine());
                if (this.diemTichLuy < 0)
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println(">> Loi: Diem phai la so nguyen khong am.");
                nhapSai = true;
            }
        } while (nhapSai);
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

        System.out.printf("║ Dia chi: %-" + (W - 10) + "s ║%n", diaChi);
        System.out.printf("║ Diem tich luy: %-" + (W - 16) + "d ║%n", diemTichLuy);
        System.out.println("╚" + LINE + "╝");
    }

    public void suaThongTinKH(Scanner sc) {
        System.out.println("--- Cap nhat thong tin Khach Hang ---");
        System.out.println("(Bo trong neu khong muon thay doi)");

        System.out.print("Ho ten moi: ");
        String tenMoi = sc.nextLine();
        if (!tenMoi.isEmpty())
            setHoTen(tenMoi);

        System.out.print("Dia chi moi: ");
        String diaChiMoi = sc.nextLine();
        if (!diaChiMoi.isEmpty())
            this.diaChi = diaChiMoi;

        System.out.print("SDT moi: ");
        String sdtMoi = sc.nextLine();
        if (!sdtMoi.isEmpty())
            setSDT(sdtMoi);

        System.out.println("✓ Cap nhat thanh cong!");
    }

    public void capNhapDiemTichLuy(int diem) {
        this.diemTichLuy += diem;
    }
}