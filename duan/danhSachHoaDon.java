package duan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class danhSachHoaDon implements ChucNang, IFile {
    public hoaDon[] dsHoaDon;
    public int soLuongHoaDon;
    final int MAX_HOA_DON = 100;

    private static Scanner sc = new Scanner(System.in);

    public danhSachHoaDon() {
        dsHoaDon = new hoaDon[MAX_HOA_DON];
        soLuongHoaDon = 0;
    }

    public danhSachHoaDon(danhSachHoaDon other) {
        this.soLuongHoaDon = other.soLuongHoaDon;
        this.dsHoaDon = new hoaDon[MAX_HOA_DON];
        for (int i = 0; i < other.soLuongHoaDon; i++) {
            this.dsHoaDon[i] = new hoaDon(other.dsHoaDon[i]);
        }
    }

    public boolean kiemTraMa(String maHD) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaHD().equals(maHD))
                return true;
        }
        return false;
    }

    public void themHoaDon(hoaDon hd) {
        if (soLuongHoaDon >= MAX_HOA_DON) {
            System.out.println("Danh sach hoa don day");
            return;
        }
        String maHD;
        while (kiemTraMa(hd.getMaHD())) {
            System.out.print("Nhap ma hoa don khac: ");
            maHD = sc.nextLine();
            if (!kiemTraMa(maHD)) {
                hd.setMaHD(maHD);
                break;
            }
            System.out.println("Ma hoa don bi trung, vui long nhap lai!");
        }
        this.dsHoaDon = Arrays.copyOf(dsHoaDon, dsHoaDon.length + 1);
        dsHoaDon[soLuongHoaDon] = hd;
        soLuongHoaDon++;
        System.out.println("Them hoa don thanh cong");
    }

    @Override
    public void Them() {
        if (soLuongHoaDon >= MAX_HOA_DON) {
            System.out.println("Danh sach hoa don day");
            return;
        }
        hoaDon hd = new hoaDon();
        hd.Nhap();
        this.themHoaDon(hd);
    }

    public void xoaHoaDon(String maHD) {
        while (!kiemTraMa(maHD)) {
            System.out.print("Ma hoa don khong hop le, vui long nhap lai (nhan 'q' de thoat): ");
            maHD = sc.nextLine();
            if (maHD.equalsIgnoreCase("q"))
                return;
        }
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaHD().equals(maHD)) {
                for (int j = i; j < soLuongHoaDon - 1; j++) {
                    dsHoaDon[j] = dsHoaDon[j + 1];
                }
                dsHoaDon = Arrays.copyOf(dsHoaDon, soLuongHoaDon - 1);
                soLuongHoaDon--;
                System.out.println("Xoa hoa don thanh cong");
                return;
            }
        }
        System.out.println("Khong tim thay ma hoa don can xoa");
    }

    @Override
    public void Xoa() {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }

        System.out.print("Nhap ma hoa don can xoa: ");
        String maHD = sc.nextLine();
        xoaHoaDon(maHD);
    }

    public void suaHoaDon(String maHD) {
        while (!kiemTraMa(maHD)) {
            System.out.print("Ma hoa don khong hop le, vui long nhap lai (nhan 'q' de thoat): ");
            maHD = sc.nextLine();
            if (maHD.equalsIgnoreCase("q"))
                return;
        }
        for (int i = 0; i < this.soLuongHoaDon; i++) {
            if (this.dsHoaDon[i].getMaHD().equalsIgnoreCase(maHD)) {
                System.out.println(">> Nhap lai thong tin moi: ");
                this.dsHoaDon[i].Xuat();
                System.out.println(">> Da cap nhat!");
                return;
            }
        }
        System.out.println(">> Khong tim thay ma hoa don!");
    }

    @Override
    public void Sua() {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }
        System.out.print("Nhap ma hoa don can sua: ");
        String maHD = sc.nextLine();
        this.suaHoaDon(maHD);
    }

    public void timKiemHoaDon(String maHD) {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }
        while (!kiemTraMa(maHD)) {
            System.out.print("Ma hoa don khong hop le. Vui long nhap lai (nhap 'q' de thoat): ");
            maHD = sc.nextLine();
            if (maHD.equalsIgnoreCase("q"))
                break;
        }
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaHD().equalsIgnoreCase(maHD)) {
                dsHoaDon[i].Xuat();
                return;
            }
        }
        System.out.println("Khong tim thay hoa don co ma " + maHD);
    }

    @Override
    public void TimKiem() {
        System.out.print("Nhap ma hoa don can tim kiem: ");
        String maHD = sc.nextLine();
        this.timKiemHoaDon(maHD);
    }

    public void hienThiDanhSachHoaDon() {
        if (soLuongHoaDon == 0) {
            System.out.println("Danh sach hoa don rong");
            return;
        }
        for (int i = 0; i < soLuongHoaDon; i++) {
            dsHoaDon[i].hienThiHD();
            System.out.println("-----------------------");
        }
    }

    public void thongKeHoaDonTheoMaKH(String maKH) {
        int cnt = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaKH().equals(maKH))
                cnt++;
        }
        if (cnt == 0) {
            System.out.println("Khong tim thay hoa don cua khach hang ma: " + maKH);
            return;
        }
        System.out.println("So luong hoa don cua khach hang ma: " + maKH + " la: " + cnt);
    }

    public void thongKeHoaDonTheoMaNV(String maNV) {
        int cnt = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dsHoaDon[i].getMaNV().equals(maNV))
                cnt++;
        }
        if (cnt == 0) {
            System.out.println("Khong tim thay hoa don nhan vien co ma: " + maNV);
            return;
        }
        System.out.println("So luong hoa don nhan vien co ma: " + maNV + " la: " + cnt);
    }

    public void nhapNHoaDon() {
        if (soLuongHoaDon >= MAX_HOA_DON) {
            System.out.println("Danh sach hoa don day, khong the nhap them");
            return;
        }
        try {
            System.out.print("Nhap so luong hoa don can them: ");
            int n = Integer.parseInt(sc.nextLine());
            if (n <= 0) {
                System.out.println("So luong phai lon hon 0");
                return;
            }
            for (int i = 0; i < n; i++) {
                System.out.println("Nhap hoa don thu " + (i + 1) + ":");
                this.Them();
            }
        } catch (NumberFormatException e) {
            System.out.println("So luong khong hop le");
        }
    }

    @Override
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println("File khong ton tai. Danh sach rong.");
            this.dsHoaDon = new hoaDon[0];
            this.soLuongHoaDon = 0;
            return;
        }

        System.out.println("Dang doc file: " + tenFile + "...");

        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String firstLine = br.readLine();
            if (firstLine == null || firstLine.trim().isEmpty()) {
                throw new IOException("File rong hoac khong co so luong!");
            }

            int count = Integer.parseInt(firstLine.trim());
            if (count <= 0) {
                System.out.println("File khong co hoa don de doc.");
                this.dsHoaDon = new hoaDon[0];
                this.soLuongHoaDon = 0;
                return;
            }

            this.dsHoaDon = new hoaDon[count];
            this.soLuongHoaDon = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && this.soLuongHoaDon < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length >= 10) {
                    try {
                        String maHD = parts[0].trim();
                        String maKH = parts[1].trim();
                        String maNV = parts[2].trim();
                        String ngayLap = parts[3].trim();
                        Double tongTien = Double.parseDouble(parts[4].trim());
                        int soLuongChiTiet = Integer.parseInt(parts[5].trim());

                        int expectedLength = 6 + (soLuongChiTiet * 4);
                        if (parts.length < expectedLength) {
                            System.err.println(" Dong " + lineNumber + ": Thiếu dữ liệu chi tiết. (có " + parts.length
                                    + " trường, cần " + expectedLength + ")");
                            lineNumber++;
                            continue;
                        }

                        this.dsHoaDon[this.soLuongHoaDon] = new hoaDon(maHD, maKH, maNV, ngayLap, tongTien);
                        this.dsHoaDon[this.soLuongHoaDon].chiTietHoaDon = new chiTietHoaDon[soLuongChiTiet];

                        for (int i = 0; i < soLuongChiTiet; i++) {
                            String maHH = parts[6 + i * 4].trim();
                            String tenHH = parts[7 + i * 4].trim();
                            int soLuong = Integer.parseInt(parts[8 + i * 4].trim());
                            int gia = Integer.parseInt(parts[9 + i * 4].trim());

                            this.dsHoaDon[this.soLuongHoaDon].chiTietHoaDon[i] = new chiTietHoaDon(maHD, maHH, tenHH,
                                    soLuong, gia);
                        }

                        this.soLuongHoaDon++;

                    } catch (NumberFormatException e) {
                        System.err.println("Dong " + lineNumber + ": Loi dinh dang so - " + e.getMessage());
                    }
                } else {
                    System.err.println(" Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
                            + " truong, can toi thieu 10)");
                }

                lineNumber++;
            }

            if (this.soLuongHoaDon < count) {
                System.out.println("Canh bao: Chi doc duoc " + this.soLuongHoaDon + "/" + count + " hoa don");
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            DOC FILE THANH CONG!                                      ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-76d ║%n", this.soLuongHoaDon);
            System.out.printf("║ Tu file: %-75s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsHoaDon = new hoaDon[0];
            this.soLuongHoaDon = 0;
        }
    }

    @Override
    public void ghiFile(String tenFile) {
        if (this.soLuongHoaDon == 0) {
            System.out.println("Danh sach trong, khong co du lieu de ghi.");
            return;
        }

        System.out.println("Dang ghi file: " + tenFile + "...");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {

            bw.write(
                    "╔════════════╦════════════╦════════════╦════════════╦══════════════╦════════════╦════════════════════╦════════════╦════════════╦══════════════╗\n");
            bw.write(
                    "║   Ma HD    ║   Ma KH    ║   Ma NV    ║  Ngay Lap  ║   Tong Tien  ║   Ma HH    ║       Ten HH       ║  So Luong  ║    Gia     ║   Tong Chi   ║\n");
            bw.write(
                    "╠════════════╬════════════╬════════════╬════════════╬══════════════╬════════════╬════════════════════╬════════════╬════════════╬══════════════╣\n");

            for (int i = 0; i < this.soLuongHoaDon; i++) {
                hoaDon hd = this.dsHoaDon[i];

                for (int j = 0; j < hd.chiTietHoaDon.length; j++) {
                    chiTietHoaDon ct = hd.chiTietHoaDon[j];
                    double tongChi = ct.getSoLuong() * ct.getGia();

                    if (j == 0) {
                        bw.write(String.format(
                                "║ %-10s ║ %-10s ║ %-10s ║ %-10s ║ %12.0f ║ %-10s ║ %-18s ║ %10d ║ %10.0f ║ %12.0f ║%n",
                                hd.getMaHD(),
                                hd.getMaKH(),
                                hd.getMaNV(),
                                hd.getNgayLap(),
                                hd.getTongTien(),
                                ct.getMaHH(),
                                ct.getTenHH(),
                                ct.getSoLuong(),
                                ct.getGia(),
                                tongChi));
                    } else {
                        bw.write(String.format(
                                "║ %-10s ║ %-10s ║ %-10s ║ %-10s ║ %-12s ║ %-10s ║ %-18s ║ %10d ║ %10.0f ║ %12.0f ║%n",
                                "",
                                "",
                                "",
                                "",
                                "",
                                ct.getMaHH(),
                                ct.getTenHH(),
                                ct.getSoLuong(),
                                ct.getGia(),
                                tongChi));
                    }
                }
            }

            bw.write(
                    "╚════════════╩════════════╩════════════╩════════════╩══════════════╩════════════╩════════════════════╩════════════╩════════════╩══════════════╝\n");

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            GHI FILE THANH CONG!                                      ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-76d ║%n", this.soLuongHoaDon);
            System.out.printf("║ Vao file: %-74s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

}