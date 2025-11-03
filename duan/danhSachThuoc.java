package duan;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class danhSachThuoc implements ChucNang, IFile {
    private Thuoc[] dsThuoc;
    private int soLuongThuoc;

    public danhSachThuoc() {
        this.dsThuoc = new Thuoc[0];
        this.soLuongThuoc = 0;
    }

    public void themThuoc(Thuoc th) {
        if (timKiemTheoMa(th.getMaThuoc()) != null) {
            System.out.println("Ma thuoc da ton tai");
            return;
        }
        dsThuoc = Arrays.copyOf(dsThuoc, soLuongThuoc + 1);
        dsThuoc[soLuongThuoc] = th;
        soLuongThuoc++;
        System.out.println("Them thuoc thanh cong");
    }

    @Override
    public void Them() {
        Scanner sc = new Scanner(System.in);
        Thuoc thuocMoi = new Thuoc();
        boolean maBiTrung;
        do {
            maBiTrung = false;
            thuocMoi.NhapMa();
            if (timKiemTheoMa(thuocMoi.getMaThuoc()) != null) {
                System.out.println(">> MA BI TRUNG! Vui long nhap lai ma khac.");
                maBiTrung = true;
            }
        } while (maBiTrung);

        System.out.println("--- Nhap thong tin chi tiet (ma: " + thuocMoi.getMaThuoc() + ") ---");
        thuocMoi.Nhap();

        themThuoc(thuocMoi);
    }

    public Thuoc timKiemTheoMa(String maThuoc) {
        for (int i = 0; i < soLuongThuoc; i++) {
            if (dsThuoc[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                return dsThuoc[i];
            }
        }
        return null;
    }

    public Thuoc[] timKiemTheoTen(String tenThuoc) {
        Thuoc[] ketQua = new Thuoc[soLuongThuoc];
        int dem = 0;
        for (int i = 0; i < soLuongThuoc; i++) {
            if (dsThuoc[i].getTenThuoc().toLowerCase().contains(tenThuoc.toLowerCase())) {
                ketQua[dem] = dsThuoc[i];
                dem++;
            }
        }
        return Arrays.copyOf(ketQua, dem);
    }

    public void xoaThuoc(String maThuoc) {
        int vt = -1;
        for (int i = 0; i < soLuongThuoc; i++) {
            if (dsThuoc[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("✗ Khong tim thay thuoc co ma " + maThuoc);
            return;
        }

        for (int j = vt; j < soLuongThuoc - 1; j++) {
            dsThuoc[j] = dsThuoc[j + 1];
        }
        dsThuoc = Arrays.copyOf(dsThuoc, soLuongThuoc - 1);
        soLuongThuoc--;
        System.out.println("✓ Xoa thuoc co ma " + maThuoc + " thanh cong!");
    }

    public void suaThongTinThuoc(String maThuoc) {
        Scanner sc = new Scanner(System.in);
        Thuoc th = timKiemTheoMa(maThuoc);
        if (th != null) {
            th.suaThongTinThuoc(sc);
        } else {
            System.out.println("✗ Khong tim thay thuoc co ma " + maThuoc);
        }
    }

    @Override
    public void Xoa() {
        if (soLuongThuoc == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma thuoc can xoa: ");
        String maCanXoa = sc.nextLine();
        xoaThuoc(maCanXoa);
    }

    @Override
    public void Sua() {
        if (soLuongThuoc == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma thuoc can sua: ");
        String maCanSua = sc.nextLine();
        suaThongTinThuoc(maCanSua);
    }

    @Override
    public void TimKiem() {
        if (soLuongThuoc == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoac ten thuoc can tim: ");
        String tuKhoa = sc.nextLine();

        Thuoc th = timKiemTheoMa(tuKhoa);
        if (th != null) {
            System.out.println("✓ Tim thay thuoc theo ma:");
            th.XuatChiTiet();
        } else {
            Thuoc[] ketQua = timKiemTheoTen(tuKhoa);
            if (ketQua.length > 0) {
                System.out.println("✓ Tim thay " + ketQua.length + " thuoc theo ten:");
                hienThiBang(ketQua, ketQua.length);
            } else {
                System.out.println("✗ Khong tim thay thuoc co ma/ten: " + tuKhoa);
            }
        }
    }

    public void thongKe() {
        if (soLuongThuoc == 0) {
            System.out.println("✗ Danh sach thuoc rong");
            return;
        }

        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║              THONG KE DANH SACH THUOC                            ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════╣");

        System.out.printf("║ Tong so thuoc: %-50d║%n", soLuongThuoc);

        // Thuốc có giá cao nhất
        Thuoc thuocMax = dsThuoc[0];
        for (int i = 1; i < soLuongThuoc; i++) {
            if (dsThuoc[i].getGiaBan() > thuocMax.getGiaBan()) {
                thuocMax = dsThuoc[i];
            }
        }
        System.out.printf("║ Thuoc gia cao nhat: %-45s║%n", thuocMax.getTenThuoc());
        System.out.printf("║ Gia: %-60.2f║%n", thuocMax.getGiaBan());

        // Tổng giá trị kho
        double tongGia = 0;
        for (int i = 0; i < soLuongThuoc; i++) {
            tongGia += dsThuoc[i].getGiaBan();
        }
        System.out.printf("║ Tong gia tri kho: %-47.2f║%n", tongGia);
        System.out.printf("║ Trung binh gia/thuoc: %-43.2f║%n", tongGia / soLuongThuoc);

        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    public void hienThiBang(Thuoc[] arr, int size) {
        final String LINE = "═════════════════════════════════════════════════════════════════════════════════════";
        System.out.println("╔" + LINE + "╗");
        System.out.println("║                            DANH SACH THUOC                                          ║");
        System.out.println("╠═════════════╦════════════════════════╦═════════════════╦═════════════╦══════════════╣");
        System.out.println("║   Ma Thuoc  ║      Ten Thuoc         ║   Don Vi Tinh   ║   Gia Ban   ║ Ngay Het Han ║");
        System.out.println("╠═════════════╬════════════════════════╬═════════════════╬═════════════╬══════════════╣");

        for (int i = 0; i < size; i++) {
            if (arr[i] != null) {
                String tenHienThi = arr[i].getTenThuoc().length() > 22 ? arr[i].getTenThuoc().substring(0, 19) + "..."
                        : arr[i].getTenThuoc();
                String donViHienThi = arr[i].getDonViTinh().length() > 15
                        ? arr[i].getDonViTinh().substring(0, 12) + "..."
                        : arr[i].getDonViTinh();

                System.out.printf("║ %-11s ║ %-22s ║ %-15s ║ %11.2f ║ %-12s ║%n",
                        arr[i].getMaThuoc(), tenHienThi, donViHienThi,
                        arr[i].getGiaBan(), arr[i].getNgayHetHan());
            }
        }

        System.out.println("╚═════════════╩════════════════════════╩═════════════════╩═════════════╩══════════════╝");
        System.out.println("Tong so: " + size + " thuoc");
    }

    public void XuatDS() {
        if (soLuongThuoc == 0) {
            System.out.println("✗ Danh sach thuoc rong");
        } else {
            hienThiBang(dsThuoc, soLuongThuoc);
        }
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong thuoc muon them: ");
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
            System.out.println("\n--- Nhap thuoc thu " + (soLuongThuoc + 1) + " ---");
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
                    .println("║ → Bat dau voi danh sach RONG. Hay them thuoc moi!                                   ║");
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");
            this.dsThuoc = new Thuoc[0];
            this.soLuongThuoc = 0;
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
                System.out.println("File khong co thuoc de doc.");
                this.dsThuoc = new Thuoc[0];
                this.soLuongThuoc = 0;
                return;
            }

            this.dsThuoc = new Thuoc[count];
            this.soLuongThuoc = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && soLuongThuoc < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String maThuoc = parts[0].trim();
                        String tenThuoc = parts[1].trim();
                        String donViTinh = parts[2].trim();
                        double giaBan = Double.parseDouble(parts[3].trim());
                        String ngayHetHan = parts[4].trim();

                        dsThuoc[soLuongThuoc] = new Thuoc(maThuoc, tenThuoc, donViTinh, giaBan, ngayHetHan);
                        soLuongThuoc++;

                    } catch (NumberFormatException e) {
                        System.err.println(" ✗ Dong " + lineNumber + ": Loi dinh dang so - " + e.getMessage());
                        System.err.println("     Noi dung: " + line);
                    }
                } else {
                    System.err.println(" ✗ Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
                            + " truong, can 5)");
                    System.err.println("     Noi dung: " + line);
                }
                lineNumber++;
            }

            if (soLuongThuoc < count) {
                System.out.println("Canh bao: Chi doc duoc " + soLuongThuoc + "/" + count + " thuoc");
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out
                    .println("║                            DOC FILE THANH CONG!                                     ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-77d ║%n", this.soLuongThuoc);
            System.out.printf("║ Tu file: %-76s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsThuoc = new Thuoc[0];
            this.soLuongThuoc = 0;
        }
    }

    @Override
    public void ghiFile(String tenFile) {
        System.out.println("→ Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(soLuongThuoc);

            for (int i = 0; i < soLuongThuoc; i++) {
                Thuoc th = dsThuoc[i];
                pw.printf("%s,%s,%s,%.2f,%s%n",
                        th.getMaThuoc(),
                        th.getTenThuoc(),
                        th.getDonViTinh(),
                        th.getGiaBan(),
                        th.getNgayHetHan());
            }

            System.out.println(
                    "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out
                    .println("║                            GHI FILE THANH CONG!                                     ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-77d ║%n", this.soLuongThuoc);
            System.out.printf("║ Vao file: %-74s ║%n", tenFile);
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");
        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

}