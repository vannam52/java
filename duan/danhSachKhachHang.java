package duan;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class danhSachKhachHang implements ChucNang, IFile {
    private khachHang[] dsKH = new khachHang[0];
    private int soLuongKH;

    public danhSachKhachHang() {
        this.dsKH = new khachHang[0];
        this.soLuongKH = 0;
    }

    public void themKhachHang(khachHang kh) {
        if (timKiemTheoMa(kh.getMaKH()) != null) {
            System.out.println("Ma khach hang da ton tai");
            return;
        }
        dsKH = Arrays.copyOf(dsKH, soLuongKH + 1);
        dsKH[soLuongKH] = kh;
        soLuongKH++;
        System.out.println("Them khach hang thanh cong");
    }

    @Override
    public void Them() {
        Scanner sc = new Scanner(System.in);
        khachHang khMoi = new khachHang();
        boolean maBiTrung;
        do {
            maBiTrung = false;
            khMoi.NhapMa();
            if (timKiemTheoMa(khMoi.getMaKH()) != null) {
                System.out.println(">> MA BI TRUNG! Vui long nhap lai ma khac.");
                maBiTrung = true;
            }
        } while (maBiTrung);

        System.out.println("--- Nhap thong tin chi tiet (ma: " + khMoi.getMaKH() + ") ---");
        khMoi.Nhap();

        themKhachHang(khMoi);
    }

    public khachHang timKiemTheoMa(String maKH) {
        for (int i = 0; i < soLuongKH; i++) {
            if (dsKH[i].getMaKH().equals(maKH)) {
                return dsKH[i];
            }
        }
        return null;
    }

    public khachHang[] timKiemTheoTen(String tenKH) {
        khachHang[] ketQua = new khachHang[soLuongKH];
        int dem = 0;
        for (int i = 0; i < soLuongKH; i++) {
            if (dsKH[i].getHoTen().toLowerCase().contains(tenKH.toLowerCase())) {
                ketQua[dem] = dsKH[i];
                dem++;
            }
        }
        return Arrays.copyOf(ketQua, dem);
    }

    public void xoaKhachHang(String maKH) {
        int vt = -1;
        for (int i = 0; i < soLuongKH; i++) {
            if (dsKH[i].getMaKH().equalsIgnoreCase(maKH)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("✗ Khong tim thay khach hang co ma " + maKH);
            return;
        }

        for (int j = vt; j < soLuongKH - 1; j++) {
            dsKH[j] = dsKH[j + 1];
        }
        dsKH = Arrays.copyOf(dsKH, soLuongKH - 1);
        soLuongKH--;
        System.out.println("✓ Xoa khach hang co ma " + maKH + " thanh cong!");
    }

    public void suaThongTinKH(String maKH) {
        Scanner sc = new Scanner(System.in);
        khachHang kh = timKiemTheoMa(maKH);
        if (kh != null) {
            kh.suaThongTinKH(sc);
        } else {
            System.out.println("✗ Khong tim thay khach hang co ma " + maKH);
        }
    }

    @Override
    public void Xoa() {
        if (soLuongKH == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khach hang can xoa: ");
        String maCanXoa = sc.nextLine();
        xoaKhachHang(maCanXoa);
    }

    @Override
    public void Sua() {
        if (soLuongKH == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khach hang can sua: ");
        String maCanSua = sc.nextLine();
        suaThongTinKH(maCanSua);
    }

    @Override
    public void TimKiem() {
        if (soLuongKH == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoac ten khach hang can tim: ");
        String tuKhoa = sc.nextLine();

        khachHang kh = timKiemTheoMa(tuKhoa);
        if (kh != null) {
            System.out.println("✓ Tim thay khach hang theo ma:");
            kh.Xuat();
        } else {
            khachHang[] ketQua = timKiemTheoTen(tuKhoa);
            if (ketQua.length > 0) {
                System.out.println("✓ Tim thay " + ketQua.length + " khach hang theo ten:");
                hienThiBang(ketQua, ketQua.length);
            } else {
                System.out.println("✗ Khong tim thay khach hang co ma/ten: " + tuKhoa);
            }
        }
    }

    public void thongKe() {
        if (soLuongKH == 0) {
            System.out.println("✗ Danh sach khach hang rong");
            return;
        }

        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║              THONG KE DANH SACH KHACH HANG                       ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");

        // Tổng số khách hàng
        System.out.printf("║ Tong so khach hang: %-45d║%n", soLuongKH);

        // Khách hàng có điểm tích lũy cao nhất
        khachHang khMax = dsKH[0];
        for (int i = 1; i < soLuongKH; i++) {
            if (dsKH[i].getDiemTichLuy() > khMax.getDiemTichLuy()) {
                khMax = dsKH[i];
            }
        }
        System.out.printf("║ Khach hang co diem cao nhat: %-36s║%n", khMax.getHoTen());
        System.out.printf("║ Diem tich luy: %-50d║%n", khMax.getDiemTichLuy());

        // Tổng điểm tích lũy
        int tongDiem = 0;
        for (int i = 0; i < soLuongKH; i++) {
            tongDiem += dsKH[i].getDiemTichLuy();
        }
        System.out.printf("║ Tong diem tich luy: %-45d║%n", tongDiem);
        System.out.printf("║ Trung binh diem/khach: %-42.2f║%n", (double) tongDiem / soLuongKH);

        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    // Trong class danhSachKhachHang.java

    public void hienThiBang(khachHang[] arr, int size) {
        // ⭐ SỬA 1: Sửa lại đường kẻ và tiêu đề để THÊM CỘT "NĂM SINH"
        final String LINE = "══════════════════════════════════════════════════════════════════════════════════════════════════════════";
        System.out.println("╔" + LINE + "╗");
        System.out.println(
                "║                                             DANH SACH KHACH HANG                                                 ║");
        System.out.println(
                "╠════════════╦══════════════════════╦════════════╦═════════════════╦═══════════════════════════╦════════════╣");
        System.out.println(
                "║    Ma KH   ║      Ho va Ten       ║  Nam Sinh  ║      SDT        ║         Dia chi           ║    Diem    ║");
        System.out.println(
                "╠════════════╬══════════════════════╬════════════╬═════════════════╬═══════════════════════════╬════════════╣");

        for (int i = 0; i < size; i++) {
            if (arr[i] != null) {

                // Logic cắt chuỗi (nếu bạn muốn giữ lại)
                String tenHienThi = arr[i].getHoTen().length() > 20 ? arr[i].getHoTen().substring(0, 17) + "..."
                        : arr[i].getHoTen();
                String diaChiHienThi = arr[i].getDiaChi().length() > 25 ? arr[i].getDiaChi().substring(0, 22) + "..."
                        : arr[i].getDiaChi();

                // ⭐ SỬA 2: Thêm arr[i].getNgaySinh() vào printf
                System.out.printf("║ %-10s ║ %-20s ║ %-10d ║ %-15s ║ %-25s ║ %-10d ║%n",
                        arr[i].getMaKH(),
                        tenHienThi,
                        arr[i].getTuoi(), // Lấy năm sinh
                        arr[i].getSDT(),
                        diaChiHienThi,
                        arr[i].getDiemTichLuy());
            }
        }

        System.out.println(
                "╚════════════╩══════════════════════╩════════════╩═════════════════╩═══════════════════════════╩════════════╝");
        System.out.println("Tong so: " + size + " khach hang");
    }

    public void XuatDS() {
        if (soLuongKH == 0) {
            System.out.println("✗ Danh sach khach hang rong");
        } else {
            hienThiBang(dsKH, soLuongKH);
        }
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong khach hang muon them: ");
        int soLuongThem = 0;
        try {
            soLuongThem = Integer.parseInt(sc.nextLine());
            if (soLuongThem <= 0) {
                System.out.println("✗ So luong phai lon hon 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("✗ Loi: Vui long nhap so hop le.");
            return;
        }

        for (int i = 0; i < soLuongThem; i++) {
            System.out.println("\n--- Nhap khach hang thu " + (soLuongKH + 1) + " ---");
            Them();
        }
    }

    @Override
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out
                    .println("║                            THONG BAO FILE KHONG TON TAI                             ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║ File: " + String.format("%-80s", tenFile) + " ║");
            System.out
                    .println("║ → Bat dau voi danh sach RONG. Hay them khach hang moi!                              ║");
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");
            this.dsKH = new khachHang[0];
            this.soLuongKH = 0;
            return;
        }

        System.out.println("→ Dang doc file: " + tenFile + "...");

        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String firstLine = br.readLine();
            if (firstLine == null || firstLine.trim().isEmpty()) {
                throw new IOException("File rong hoac khong co so luong!");
            }

            int count = Integer.parseInt(firstLine.trim());
            if (count <= 0) {
                System.out.println("File khong co khach hang de doc.");
                this.dsKH = new khachHang[0];
                this.soLuongKH = 0;
                return;
            }

            this.dsKH = new khachHang[count];
            this.soLuongKH = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && soLuongKH < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 7) {
                    try {
                        String maKH = parts[0].trim();
                        String hoTen = parts[1].trim();
                        int tuoi = Integer.parseInt(parts[2].trim());
                        String gioiTinh = parts[3].trim();
                        String sdt = parts[4].trim();
                        String diaChi = parts[5].trim();
                        int diemTichLuy = Integer.parseInt(parts[6].trim());

                        dsKH[soLuongKH] = new khachHang(maKH, hoTen, gioiTinh, sdt, tuoi, diaChi, diemTichLuy);
                        soLuongKH++;

                    } catch (NumberFormatException e) {
                        System.err.println(" ✗ Dong " + lineNumber + ": Loi dinh dang so - " + e.getMessage());
                        System.err.println("     Noi dung: " + line);
                    }
                } else {
                    System.err.println(" ✗ Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
                            + " truong, can 7)");
                    System.err.println("     Noi dung: " + line);
                }

                lineNumber++;
            }

            if (soLuongKH < count) {
                System.out.println("Canh bao: Chi doc duoc " + soLuongKH + "/" + count + " khach hang");
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out
                    .println("║                            DOC FILE THANH CONG!                                     ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-77d ║%n", this.soLuongKH);
            System.out.printf("║ Tu file: %-76s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsKH = new khachHang[0];
            this.soLuongKH = 0;
        }
    }

    @Override
    public void ghiFile(String tenFile) {
        System.out.println("→ Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(soLuongKH);

            for (int i = 0; i < soLuongKH; i++) {
                khachHang kh = dsKH[i];
                pw.printf("%s,%s,%d,%s,%s,%s,%d%n",
                        kh.getMaKH(), kh.getHoTen(), kh.getTuoi(),
                        kh.getGioiTinh(), kh.getSDT(), kh.getDiaChi(),
                        kh.getDiemTichLuy());
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out
                    .println("║                            GHI FILE THANH CONG!                                     ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-77d ║%n", this.soLuongKH);
            System.out.printf("║ Vao file: %-74s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

}