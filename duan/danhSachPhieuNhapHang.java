package duan;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class danhSachPhieuNhapHang implements ChucNang, IFile {
    private phieuNhapHang[] dsPNH;
    private int soLuongPNH;

    public danhSachPhieuNhapHang() {
        this.dsPNH = new phieuNhapHang[0];
        this.soLuongPNH = 0;
    }

    public void themPhieuNhapHang(phieuNhapHang pnh) {
        if (timKiemTheoMa(pnh.getMaPNH()) != null) {
            System.out.println("Ma phieu nhap hang da ton tai");
            return;
        }
        dsPNH = Arrays.copyOf(dsPNH, soLuongPNH + 1);
        dsPNH[soLuongPNH] = pnh;
        soLuongPNH++;
        System.out.println("Them phieu nhap hang thanh cong");
    }

    @Override
    public void Them() {
        Scanner sc = new Scanner(System.in);
        phieuNhapHang pnhMoi;
        boolean maBiTrung;

        do {
            maBiTrung = false;
            pnhMoi = new phieuNhapHang();

            System.out.println("--- Nhap thong tin phieu nhap hang moi ---");
            pnhMoi.nhapPhieuNhapHang();

            if (timKiemTheoMa(pnhMoi.getMaPNH()) != null) {
                System.out.println("✗ Ma phieu nhap hang da ton tai! Vui long nhap lai toan bo thong tin.");
                maBiTrung = true;
            } else {
                themPhieuNhapHang(pnhMoi);
                System.out.println("✓ Da them phieu nhap hang thanh cong!");
            }

        } while (maBiTrung);
    }

    public void xoaPhieuNhapHang(String maPNH) {
        int vt = -1;
        for (int i = 0; i < soLuongPNH; i++) {
            if (dsPNH[i].getMaPNH().equalsIgnoreCase(maPNH)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("✗ Khong tim thay phieu nhap hang co ma " + maPNH);
            return;
        }

        for (int j = vt; j < soLuongPNH - 1; j++) {
            dsPNH[j] = dsPNH[j + 1];
        }
        dsPNH = Arrays.copyOf(dsPNH, soLuongPNH - 1);
        soLuongPNH--;
        System.out.println("✓ Xoa phieu nhap hang co ma " + maPNH + " thanh cong!");
    }

    @Override
    public void Xoa() {
        if (soLuongPNH == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu nhap hang can xoa: ");
        String maCanXoa = sc.nextLine();
        xoaPhieuNhapHang(maCanXoa);
    }

    @Override
    public void Sua() {
        if (soLuongPNH == 0) {
            System.out.println("✗ Danh sach phieu nhap hang rong!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu nhap hang can sua: ");
        String ma = sc.nextLine().trim();

        int viTri = -1;
        for (int i = 0; i < soLuongPNH; i++) {
            if (dsPNH[i].getMaPNH().equalsIgnoreCase(ma)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println("✗ Khong tim thay phieu nhap hang co ma: " + ma);
            return;
        }

        phieuNhapHang pnh = dsPNH[viTri];
        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║             SUA THONG TIN PHIEU NHAP HANG: " + String.format("%-22s", ma) + "║");
            System.out.println("╠══════════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Sua ma nhan vien                                              ║");
            System.out.println("║ 2. Sua ma nha cung cap                                           ║");
            System.out.println("║ 3. Sua ngay nhap                                                 ║");
            System.out.println("║ 4. Sua tong tien                                                 ║");
            System.out.println("║ 5. Sua tat ca thong tin                                          ║");
            System.out.println("║ 0. Hoan thanh                                                    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-5): ");

            String luaChon = sc.nextLine();

            switch (luaChon) {
                case "1":
                    System.out.print("Nhap ma nhan vien moi (Hien tai: " + pnh.getMaNV() + "): ");
                    String maNV = sc.nextLine().trim();
                    if (!maNV.isEmpty())
                        pnh.setMaNV(maNV);
                    break;
                case "2":
                    System.out.print("Nhap ma nha cung cap moi (Hien tai: " + pnh.getMaNCC() + "): ");
                    String maNCC = sc.nextLine().trim();
                    if (!maNCC.isEmpty())
                        pnh.setMaNCC(maNCC);
                    break;
                case "3":
                    System.out.print("Nhap ngay nhap moi (Hien tai: " + pnh.getNgayNhap() + "): ");
                    String ngayNhap = sc.nextLine().trim();
                    if (!ngayNhap.isEmpty())
                        pnh.setNgayNhap(ngayNhap);
                    break;
                case "4":
                    System.out.print("Nhap tong tien moi (Hien tai: " + pnh.getTongTien() + "): ");
                    String tongTienStr = sc.nextLine().trim();
                    if (!tongTienStr.isEmpty()) {
                        try {
                            pnh.setTongTien(Double.parseDouble(tongTienStr));
                        } catch (NumberFormatException e) {
                            System.out.println("(!) Loi: Tong tien nhap vao khong hop le.");
                        }
                    }
                    break;
                case "5":
                    System.out.println("\n>> Nhap lai tat ca thong tin (tru ma phieu):");
                    System.out.println("Nhap ma nhan vien: ");
                    pnh.setMaNV(sc.nextLine());
                    System.out.println("Nhap ma nha cung cap: ");
                    pnh.setMaNCC(sc.nextLine());
                    System.out.println("Nhap ngay nhap (dd/MM/yyyy): ");
                    pnh.setNgayNhap(sc.nextLine());
                    System.out.println("Nhap tong tien: ");
                    pnh.setTongTien(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Da cap nhat tat ca thong tin.");
                    break;
                case "0":
                    System.out.println(">> Hoan thanh sua thong tin phieu nhap hang!");
                    tiepTuc = false;
                    break;
                default:
                    System.out.println(">> Lua chon khong hop le!");
                    break;
            }
        }
    }

    public phieuNhapHang timKiemTheoMa(String maPNH) {
        for (int i = 0; i < soLuongPNH; i++) {
            if (dsPNH[i].getMaPNH().equalsIgnoreCase(maPNH)) {
                return dsPNH[i];
            }
        }
        return null;
    }

    public phieuNhapHang[] timKiemTheoMaNV(String maNV) {
        phieuNhapHang[] ketQua = new phieuNhapHang[soLuongPNH];
        int dem = 0;
        for (int i = 0; i < soLuongPNH; i++) {
            if (dsPNH[i].getMaNV().toLowerCase().contains(maNV.toLowerCase())) {
                ketQua[dem] = dsPNH[i];
                dem++;
            }
        }
        return Arrays.copyOf(ketQua, dem);
    }

    @Override
    public void TimKiem() {
        if (soLuongPNH == 0) {
            System.out.println("✗ Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("--- TIM KIEM PHIEU NHAP HANG ---");
        System.out.println("1. Tim theo ma phieu nhap hang");
        System.out.println("2. Tim theo ma nhan vien");
        System.out.print("Chon loai tim kiem: ");

        int chon = 0;
        try {
            chon = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("✗ Lua chon khong hop le!");
            return;
        }

        switch (chon) {
            case 1:
                System.out.print("Nhap ma phieu nhap hang can tim: ");
                String maPNH = sc.nextLine();
                phieuNhapHang pnh = timKiemTheoMa(maPNH);
                if (pnh != null) {
                    System.out.println("✓ Tim thay phieu nhap hang:");
                    hienThiBang(new phieuNhapHang[] { pnh }, 1);
                } else {
                    System.out.println("✗ Khong tim thay phieu nhap hang co ma: " + maPNH);
                }
                break;
            case 2:
                System.out.print("Nhap ma nhan vien can tim: ");
                String maNV = sc.nextLine();
                phieuNhapHang[] ketQuaNV = timKiemTheoMaNV(maNV);
                if (ketQuaNV.length > 0) {
                    System.out.println("✓ Tim thay " + ketQuaNV.length + " phieu nhap hang:");
                    hienThiBang(ketQuaNV, ketQuaNV.length);
                } else {
                    System.out.println("✗ Khong tim thay phieu nhap hang co ma nhan vien: " + maNV);
                }
                break;
            default:
                System.out.println("✗ Lua chon khong hop le!");
        }
    }

    public void thongKe() {
        if (soLuongPNH == 0) {
            System.out.println("✗ Danh sach phieu nhap hang rong");
            return;
        }

        double tongChi = 0;
        double maxThanhTien = dsPNH[0].getTongTien();
        double minThanhTien = dsPNH[0].getTongTien();
        phieuNhapHang pnhMax = dsPNH[0];
        phieuNhapHang pnhMin = dsPNH[0];

        for (int i = 0; i < soLuongPNH; i++) {
            tongChi += dsPNH[i].getTongTien();
            if (dsPNH[i].getTongTien() > maxThanhTien) {
                maxThanhTien = dsPNH[i].getTongTien();
                pnhMax = dsPNH[i];
            }
            if (dsPNH[i].getTongTien() < minThanhTien) {
                minThanhTien = dsPNH[i].getTongTien();
                pnhMin = dsPNH[i];
            }
        }

        System.out.println(
                "╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(
                "║                                  BANG THONG KE PHIEU NHAP HANG                                                ║");
        System.out.println(
                "╠════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╣");
        System.out.printf("║ %-14s ║ %-16s ║ %-16s ║ %-16s ║ %-16s ║ %-16s ║%n",
                "Tong so PNH",
                "Tong chi",
                "Chi TB",
                "PNH cao nhat",
                "PNH thap nhat",
                "Chenh lech");
        System.out.println(
                "╠════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╣");
        System.out.printf("║ %-14d ║ %-16.2f ║ %-16.2f ║ %-16s ║ %-16s ║ %-16.2f ║%n",
                soLuongPNH,
                tongChi,
                (soLuongPNH > 0 ? tongChi / soLuongPNH : 0),
                pnhMax.getMaPNH(),
                pnhMin.getMaPNH(),
                maxThanhTien - minThanhTien);
        System.out.println(
                "╚════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╝");
    }

    public void hienThiBang(phieuNhapHang[] arr, int size) {
        final String LINE = "═════════════════════════════════════════════════════════════════════════";
        System.out.println("╔" + LINE + "╗");
        System.out
                .println("║                     DANH SACH PHIEU NHAP HANG                           ║");
        System.out
                .println("╠══════════════╦══════════════╦══════════════╦════════════╦═══════════════╣");
        System.out
                .println("║   Ma PNH     ║    Ma NV     ║    Ma NCC    ║ Ngay Nhap  ║   Tong Tien   ║");
        System.out
                .println("╠══════════════╬══════════════╬══════════════╬════════════╬═══════════════╣");

        for (int i = 0; i < size; i++) {
            if (arr[i] != null) {
                System.out.printf("║ %-12s ║ %-12s ║ %-12s ║ %-10s ║ %13.2f ║%n",
                        arr[i].getMaPNH(),
                        arr[i].getMaNV(),
                        arr[i].getMaNCC(),
                        arr[i].getNgayNhap(),
                        arr[i].getTongTien());
            }
        }

        System.out
                .println("╚══════════════╩══════════════╩══════════════╩════════════╩═══════════════╝");
        System.out.println("Tong so: " + size + " phieu nhap hang");
    }

    public void XuatDS() {
        if (soLuongPNH == 0) {
            System.out.println("✗ Danh sach phieu nhap hang rong");
        } else {
            hienThiBang(dsPNH, soLuongPNH);
        }
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phieu nhap hang muon them: ");
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
            System.out.println("\n--- Nhap phieu nhap hang thu " + (soLuongPNH + 1) + " ---");
            Them();
        }
    }

    @Override
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            THONG BAO FILE KHONG TON TAI                               ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║ File: " + String.format("%-79s", tenFile) + " ║");
            System.out.println(
                    "║ → Bat dau voi danh sach RONG. Hay them phieu nhap hang moi!                           ║");
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");
            this.dsPNH = new phieuNhapHang[0];
            this.soLuongPNH = 0;
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
                System.out.println("File khong co phieu nhap hang de doc.");
                this.dsPNH = new phieuNhapHang[0];
                this.soLuongPNH = 0;
                return;
            }

            this.dsPNH = new phieuNhapHang[count];
            this.soLuongPNH = 0;
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null && soLuongPNH < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
                    lineNumber++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String maPNH = parts[0].trim();
                        String maNV = parts[1].trim();
                        String maNCC = parts[2].trim();
                        String ngayNhap = parts[3].trim();
                        double tongTien = Double.parseDouble(parts[4].trim());

                        dsPNH[soLuongPNH] = new phieuNhapHang(maPNH, maNV, maNCC, ngayNhap, tongTien);
                        soLuongPNH++;

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

            if (soLuongPNH < count) {
                System.out.println("Canh bao: Chi doc duoc " + soLuongPNH + "/" + count + " phieu nhap hang");
            }

            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            DOC FILE THANH CONG!                                       ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da doc: %-77d ║%n", this.soLuongPNH);
            System.out.printf("║ Tu file: %-76s ║%n", tenFile);
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.dsPNH = new phieuNhapHang[0];
            this.soLuongPNH = 0;
        }
    }

    @Override
    public void ghiFile(String tenFile) {
        System.out.println("→ Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(soLuongPNH);

            for (int i = 0; i < soLuongPNH; i++) {
                phieuNhapHang pnh = dsPNH[i];
                pw.printf("%s,%s,%s,%s,%.2f%n",
                        pnh.getMaPNH(),
                        pnh.getMaNV(),
                        pnh.getMaNCC(),
                        pnh.getNgayNhap(),
                        pnh.getTongTien());
            }

            System.out.println(
                    "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                            GHI FILE THANH CONG!                                       ║");
            System.out.println(
                    "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║ Da ghi: %-77d ║%n", this.soLuongPNH);
            System.out.printf("║ Vao file: %-75s ║%n", tenFile);
            System.out.println(
                    "╚═══════════════════════════════════════════════════════════════════════════════════════╝");

        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

    public phieuNhapHang[] getDsPNH() {
        return Arrays.copyOf(dsPNH, soLuongPNH);
    }

    public int getSoLuongPNH() {
        return soLuongPNH;
    }
}