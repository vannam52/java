package duan;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class danhSachChiTietPhieuNhapHang implements ChucNang, IFile {
    private chiTietPhieuNhapHang[] ds;
    private int size;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public danhSachChiTietPhieuNhapHang() {
        this.ds = new chiTietPhieuNhapHang[0];
        this.size = 0;
    }

    // THEM (khong tuong tac)
    public void themChiTiet(chiTietPhieuNhapHang ct) {
        if (ct == null)
            return;
        for (int i = 0; i < size; i++) {
            if (ds[i].getMaPNH() != null && ds[i].getMaPNH().equalsIgnoreCase(ct.getMaPNH())
                    && ds[i].getMaThuoc() != null && ds[i].getMaThuoc().equalsIgnoreCase(ct.getMaThuoc())) {
                System.out.println("Chi tiet da ton tai: " + ct.getMaPNH() + " - " + ct.getMaThuoc());
                return;
            }
        }
        ds = Arrays.copyOf(ds, size + 1);
        ds[size++] = ct;
        System.out.println("Them chi tiet phieu nhap thanh cong!");
    }

    // THEM (tuong tac)
    @Override
    public void Them() {
        Scanner sc = new Scanner(System.in);
        chiTietPhieuNhapHang ct = new chiTietPhieuNhapHang();
        boolean trung;
        do {
            trung = false;
            ct.nhap();
            for (int i = 0; i < size; i++) {
                if (ds[i].getMaPNH() != null && ds[i].getMaPNH().equalsIgnoreCase(ct.getMaPNH())
                        && ds[i].getMaThuoc() != null && ds[i].getMaThuoc().equalsIgnoreCase(ct.getMaThuoc())) {
                    System.out.println("Chi tiet bi trung. Nhap lai.");
                    trung = true;
                    break;
                }
            }
        } while (trung);
        ct.setThanhTien(ct.tinhThanhTien());
        themChiTiet(ct);
    }

    // XOA (khong tuong tac)
    public void xoaChiTiet(String maPNH, String maThuoc) {
        int vt = -1;
        for (int i = 0; i < size; i++) {
            if (ds[i].getMaPNH() != null && ds[i].getMaPNH().equalsIgnoreCase(maPNH)
                    && ds[i].getMaThuoc() != null && ds[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay chi tiet: " + maPNH + " - " + maThuoc);
            return;
        }
        for (int j = vt; j < size - 1; j++)
            ds[j] = ds[j + 1];
        ds = Arrays.copyOf(ds, size - 1);
        size--;
        System.out.println("Da xoa chi tiet: " + maPNH + " - " + maThuoc);
    }

    // XOA (tuong tac)
    @Override
    public void Xoa() {
        if (size == 0) {
            System.out.println("Danh sach chi tiet rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu nhap: ");
        String maPNH = sc.nextLine().trim();
        System.out.print("Nhap ma thuoc: ");
        String maThuoc = sc.nextLine().trim();
        xoaChiTiet(maPNH, maThuoc);
    }

    // SUA (tuong tac)
    @Override
    public void Sua() {
        if (size == 0) {
            System.out.println("Danh sach chi tiet rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu nhap cua chi tiet can sua: ");
        String maPNH = sc.nextLine().trim();
        System.out.print("Nhap ma thuoc cua chi tiet can sua: ");
        String maThuoc = sc.nextLine().trim();

        int viTri = -1;
        for (int i = 0; i < size; i++) {
            if (ds[i].getMaPNH() != null && ds[i].getMaPNH().equalsIgnoreCase(maPNH)
                    && ds[i].getMaThuoc() != null && ds[i].getMaThuoc().equalsIgnoreCase(maThuoc)) {
                viTri = i;
                break;
            }
        }
        if (viTri == -1) {
            System.out.println("Khong tim thay chi tiet.");
            return;
        }

        chiTietPhieuNhapHang ct = ds[viTri];
        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println(
                    "\n╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                          SUA CHI TIET PHIEU NHAP: " + String.format("%-20s", maPNH)
                    + "       ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(
                    "║ 1. Sua so luong                                                                        ║");
            System.out.println(
                    "║ 2. Sua don gia                                                                         ║");
            System.out.println(
                    "║ 0. Hoan thanh                                                                          ║");
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-2): ");

            String chon = sc.nextLine().trim();
            switch (chon) {
                case "1":
                    System.out.print("Nhap so luong moi: ");
                    try {
                        ct.setSoLuong(Integer.parseInt(sc.nextLine().trim()));
                    } catch (Exception e) {
                        ct.setSoLuong(0);
                    }
                    ct.setThanhTien(ct.tinhThanhTien());
                    break;
                case "2":
                    System.out.print("Nhap don gia moi: ");
                    try {
                        ct.setDonGia(Double.parseDouble(sc.nextLine().trim()));
                    } catch (Exception e) {
                        ct.setDonGia(0.0);
                    }
                    ct.setThanhTien(ct.tinhThanhTien());
                    break;
                case "0":
                    System.out.println("Hoan thanh sua thong tin!");
                    tiepTuc = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    // TIM (MaPNH)
    public chiTietPhieuNhapHang[] timKiemTheoMaPNH(String maPNH) {
        if (maPNH == null)
            return new chiTietPhieuNhapHang[0];
        chiTietPhieuNhapHang[] ketQua = new chiTietPhieuNhapHang[size];
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            String m = ds[i].getMaPNH();
            if (m != null && m.equalsIgnoreCase(maPNH)) {
                ketQua[cnt++] = ds[i];
            }
        }
        return Arrays.copyOf(ketQua, cnt);
    }

    // TIM (MaThuoc)
    public chiTietPhieuNhapHang[] timKiemTheoMaThuoc(String maThuoc) {
        if (maThuoc == null)
            return new chiTietPhieuNhapHang[0];
        chiTietPhieuNhapHang[] ketQua = new chiTietPhieuNhapHang[size];
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            String m = ds[i].getMaThuoc();
            if (m != null && m.equalsIgnoreCase(maThuoc)) {
                ketQua[cnt++] = ds[i];
            }
        }
        return Arrays.copyOf(ketQua, cnt);
    }

    // TIM (tuong tac)
    @Override
    public void TimKiem() {
        if (size == 0) {
            System.out.println("Danh sach chi tiet rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("--- TIM KIEM CHI TIET PHIEU NHAP ---");
        System.out.println("1. Tim theo ma phieu nhap");
        System.out.println("2. Tim theo ma thuoc");
        System.out.print("Chon loai tim kiem: ");

        int chon = 0;
        try {
            chon = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("✗ Lua chon khong hop le!");
            return;
        }

        switch (chon) {
            case 1:
                System.out.print("Nhap ma phieu nhap can tim: ");
                String ma = sc.nextLine().trim();
                chiTietPhieuNhapHang[] a = timKiemTheoMaPNH(ma);
                if (a.length > 0) {
                    System.out.println("✓ Tim thay " + a.length + " ket qua:");
                    hienThiBang(a, a.length);
                } else {
                    System.out.println("✗ Khong tim thay chi tiet phu hop.");
                }
                break;
            case 2:
                System.out.print("Nhap ma thuoc can tim: ");
                String mt = sc.nextLine().trim();
                chiTietPhieuNhapHang[] b = timKiemTheoMaThuoc(mt);
                if (b.length > 0) {
                    System.out.println("✓ Tim thay " + b.length + " ket qua:");
                    hienThiBang(b, b.length);
                } else {
                    System.out.println("✗ Khong tim thay chi tiet phu hop.");
                }
                break;
            default:
                System.out.println("✗ Lua chon khong hop le!");
        }
    }

    public void thongKe() {
        if (size == 0) {
            System.out.println("✗ Danh sach chi tiet rong");
            return;
        }
        double tongTien = 0;
        int tongSoLuong = 0;
        double maxTT = ds[0].getThanhTien();
        double minTT = ds[0].getThanhTien();
        chiTietPhieuNhapHang maxCt = ds[0], minCt = ds[0];

        for (int i = 0; i < size; i++) {
            tongTien += ds[i].getThanhTien();
            tongSoLuong += ds[i].getSoLuong();
            if (ds[i].getThanhTien() > maxTT) {
                maxTT = ds[i].getThanhTien();
                maxCt = ds[i];
            }
            if (ds[i].getThanhTien() < minTT) {
                minTT = ds[i].getThanhTien();
                minCt = ds[i];
            }
        }

        final int W_FMT_TD = 12;
        final int W_FMT_TSL = 13;
        final int W_FMT_TTT = 15;
        final int W_FMT_TBTT = 13;
        final int W_FMT_MAX = 20;

        final int W_BDR_TD = W_FMT_TD + 2;
        final int W_BDR_TSL = W_FMT_TSL + 2;
        final int W_BDR_TTT = W_FMT_TTT + 2;
        final int W_BDR_TBTT = W_FMT_TBTT + 2;
        final int W_BDR_MAX = W_FMT_MAX + 2;

        final String LINE = repeatChar('═', W_BDR_TD) + "╦" +
                repeatChar('═', W_BDR_TSL) + "╦" +
                repeatChar('═', W_BDR_TTT) + "╦" +
                repeatChar('═', W_BDR_TBTT) + "╦" +
                repeatChar('═', W_BDR_MAX);

        final String TOP_BORDER = "╔" + LINE.replace('╦', '╤') + "╗";
        final String MID_BORDER_HEAVY = "╠" + LINE.replace('╦', '╬') + "╣";
        final String MID_BORDER_LIGHT = "╟" + LINE.replace('╦', '┼') + "╢";
        final String BOT_BORDER = "╚" + LINE.replace('╦', '╧') + "╝";

        // 4. Tạo các chuỗi định dạng (format string) cho printf
        final String HEADER_FMT = " %-" + W_FMT_TD + "s │ %-" + W_FMT_TSL + "s │ %-" + W_FMT_TTT + "s │ %-" + W_FMT_TBTT
                + "s │ %-" + W_FMT_MAX + "s ";
        final String ROW_FMT = " %" + W_FMT_TD + "d │ %" + W_FMT_TSL + "d │ %" + W_FMT_TTT + ".0f │ %" + W_FMT_TBTT
                + ".0f │ %-" + W_FMT_MAX + "s ";

        // 5. In bảng
        System.out.println(TOP_BORDER);
        int totalWidth = LINE.length(); // 87
        System.out.printf("║%s║%n", center("BANG THONG KE CHI TIET PHIEU NHAP", totalWidth));
        System.out.println(MID_BORDER_HEAVY);

        System.out.println("║" + String.format(HEADER_FMT,
                "Tong dong", "Tong so luong", "Tong thanh tien", "TB thanh tien", "Max (PNH:Thuoc)") + "║");

        System.out.println(MID_BORDER_LIGHT);

        String maxKey = truncate(maxCt.getMaPNH() + ":" + maxCt.getMaThuoc(), W_FMT_MAX);
        System.out.println("║" + String.format(ROW_FMT,
                size,
                tongSoLuong,
                tongTien,
                (size > 0 ? tongTien / size : 0),
                maxKey) + "║");

        System.out.println(BOT_BORDER);
    }

    public void hienThiBang(chiTietPhieuNhapHang[] arr, int sz) {
        // 1. Định nghĩa độ rộng cột cho printf (NỘI DUNG)
        final int W_FMT_MAPNH = 10;
        final int W_FMT_MATHUOC = 10;
        final int W_FMT_SOLUONG = 7;
        final int W_FMT_DONGIA = 12;
        final int W_FMT_THANHTIEN = 15;

        // 2. Định nghĩa độ rộng đường viền (W_BDR = W_FMT + 2)
        final int W_BDR_MAPNH = W_FMT_MAPNH + 2; // 12
        final int W_BDR_MATHUOC = W_FMT_MATHUOC + 2; // 12
        final int W_BDR_SOLUONG = W_FMT_SOLUONG + 2; // 9
        final int W_BDR_DONGIA = W_FMT_DONGIA + 2; // 14
        final int W_BDR_THANHTIEN = W_FMT_THANHTIEN + 2; // 17

        // 3. Tạo các chuỗi đường viền
        // Tổng độ dài: 12 + 1 + 12 + 1 + 9 + 1 + 14 + 1 + 17 = 68
        final String LINE = repeatChar('═', W_BDR_MAPNH) + "╦" +
                repeatChar('═', W_BDR_MATHUOC) + "╦" +
                repeatChar('═', W_BDR_SOLUONG) + "╦" +
                repeatChar('═', W_BDR_DONGIA) + "╦" +
                repeatChar('═', W_BDR_THANHTIEN);

        final String TOP_BORDER = "╔" + LINE.replace('╦', '╤') + "╗";
        final String MID_BORDER = "╠" + LINE.replace('╦', '╬') + "╣";
        final String MID_BORDER_LIGHT = "╟" + LINE.replace('╦', '┼') + "╢";
        final String BOT_BORDER = "╚" + LINE.replace('╦', '╧') + "╝";

        // 4. Tạo các chuỗi định dạng (format string) cho printf

        final String HEADER_FMT = " %-" + W_FMT_MAPNH + "s │ %-" + W_FMT_MATHUOC + "s │ %" + W_FMT_SOLUONG + "s │ %"
                + W_FMT_DONGIA + "s │ %" + W_FMT_THANHTIEN + "s ";
        final String ROW_FMT = " %-" + W_FMT_MAPNH + "s │ %-" + W_FMT_MATHUOC + "s │ %" + W_FMT_SOLUONG + "d │ %"
                + W_FMT_DONGIA + ".0f │ %" + W_FMT_THANHTIEN + ".0f ";

        // 5. In bảng
        System.out.println(TOP_BORDER);

        int totalWidth = LINE.length(); // 68

        System.out.printf("║%s║%n", center("DANH SACH CHI TIET PHIEU NHAP", totalWidth));
        System.out.println(MID_BORDER);

        System.out.println("║" + String.format(HEADER_FMT,
                "MaPNH", "MaThuoc", "SoLuong", "DonGia", "ThanhTien") + "║");

        System.out.println(MID_BORDER_LIGHT); // Dùng đường kẻ mỏng

        // In nội dung các dòng
        for (int i = 0; i < sz; i++) {
            chiTietPhieuNhapHang c = arr[i];

            System.out.println("║" + String.format(ROW_FMT,
                    truncate(c.getMaPNH(), W_FMT_MAPNH),
                    truncate(c.getMaThuoc(), W_FMT_MATHUOC),
                    c.getSoLuong(),
                    c.getDonGia(),
                    c.getThanhTien()) + "║");
        }
        System.out.println(BOT_BORDER);
    }

    public void XuatDS() {
        if (size == 0) {
            System.out.println("Danh sach chi tiet rong");
            return;
        }
        hienThiBang(ds, size);
    }

    // GHI FILE
    @Override
    public void ghiFile(String tenFile) {
        System.out.println("→ Dang ghi file: " + tenFile + "...");
        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(size);
            for (int i = 0; i < size; i++) {
                chiTietPhieuNhapHang c = ds[i];
                pw.printf(Locale.US, "%s,%s,%d,%.2f,%.2f%n",
                        escape(c.getMaPNH()), escape(c.getMaThuoc()), c.getSoLuong(), c.getDonGia(), c.getThanhTien());
            }
            System.out.println("Ghi file thanh cong. Da ghi: " + size);
        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

    // DOC FILE
    @Override
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println("File khong ton tai. Bat dau voi danh sach rong.");
            this.ds = new chiTietPhieuNhapHang[0];
            this.size = 0;
            return;
        }
        System.out.println("→ Dang doc file: " + tenFile + "...");
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String first = br.readLine();
            if (first == null || first.trim().isEmpty())
                throw new IOException("File rong hoac khong co so luong!");
            int count = Integer.parseInt(first.trim());
            this.ds = new chiTietPhieuNhapHang[count];
            this.size = 0;
            String line;
            int ln = 2;
            while ((line = br.readLine()) != null && size < count) {
                line = line.trim();
                if (line.isEmpty()) {
                    ln++;
                    continue;
                }
                String[] parts = line.split(",", -1);
                if (parts.length < 5) {
                    System.err.println("Dong " + ln + ": Sai dinh dang");
                    ln++;
                    continue;
                }

                String maPNH = unescape(parts[0].trim());
                String maThuoc = unescape(parts[1].trim());
                int sl = 0;
                double dg = 0.0;
                double tt = 0.0;
                try {
                    sl = Integer.parseInt(parts[2].trim());
                } catch (Exception e) {
                    System.err.println("Dong " + ln + ": Loi SoLuong");
                }
                try {
                    dg = Double.parseDouble(parts[3].trim());
                } catch (Exception e) {
                    System.err.println("Dong " + ln + ": Loi DonGia");
                }
                try {
                    tt = Double.parseDouble(parts[4].trim());
                } catch (Exception e) {
                    tt = sl * dg;
                }

                ds[size++] = new chiTietPhieuNhapHang(maPNH, maThuoc, sl, dg, tt);
                ln++;
            }
            System.out.println("Doc file xong. Da doc: " + size);
        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.ds = new chiTietPhieuNhapHang[0];
            this.size = 0;
        }
    }

    private LocalDate parseDate(String s) {
        if (s == null || s.trim().isEmpty())
            return null;
        try {
            return LocalDate.parse(s.trim(), DTF);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private String repeatChar(char c, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private String center(String text, int width) {
        if (text == null || text.length() >= width) {
            return truncate(text, width);
        }
        int padding = width - text.length();
        int leftPad = padding / 2;
        int rightPad = padding - leftPad;
        return repeatChar(' ', leftPad) + text + repeatChar(' ', rightPad);
    }

    private String truncate(String text, int width) {
        if (text == null)
            return "";
        if (text.length() <= width) {
            return text;
        }
        if (width < 3) {
            return text.substring(0, width);
        }
        return text.substring(0, width - 3) + "...";
    }

    private static String escape(String s) {
        if (s == null)
            return "";
        return s.replace("\n", " ").replace("\r", " ").replace(",", ";");
    }

    private static String unescape(String s) {
        if (s == null)
            return "";
        return s.replace(";", ",");
    }

    public int getSize() {
        return size;
    }

    public chiTietPhieuNhapHang[] getDs() {
        return Arrays.copyOf(ds, size);
    }
}