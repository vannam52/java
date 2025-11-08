package duan;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale; // Thêm Locale

public class danhSachPhieuNhapHang implements ChucNang, IFile { // Đã implement
    private phieuNhapHang[] ds;
    private int size;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public danhSachPhieuNhapHang() {
        this.ds = new phieuNhapHang[0];
        this.size = 0;
    }

    // Thêm phiếu (không tương tác)
    public void themPhieu(phieuNhapHang p) {
        if (p == null)
            return;
        if (timKiemTheoMa(p.getMaPNH()) != null) {
            System.out.println("Ma phieu da ton tai: " + p.getMaPNH());
            return;
        }
        ds = Arrays.copyOf(ds, size + 1);
        ds[size++] = p;
        System.out.println("Them phieu nhap thanh cong!");
    }

    // Thêm (tương tác)
    @Override // Đã thêm
    public void Them() {
        Scanner sc = new Scanner(System.in);
        phieuNhapHang p = new phieuNhapHang();
        boolean trung;
        do {
            trung = false;
            p.nhap();
            if (timKiemTheoMa(p.getMaPNH()) != null) {
                System.out.println("Ma phieu bi trung. Nhap lai.");
                trung = true;
            }
        } while (trung);
        themPhieu(p);

    }

    // Xóa không tương tác
    public void xoaPhieu(String ma) {
        int vt = -1;
        for (int i = 0; i < size; i++) {
            if (ds[i].getMaPNH() != null && ds[i].getMaPNH().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay phieu: " + ma);
            return;
        }
        for (int j = vt; j < size - 1; j++) {
            ds[j] = ds[j + 1];
        }
        ds = Arrays.copyOf(ds, size - 1);
        size--;
        System.out.println("Da xoa phieu: " + ma);
    }

    // Xóa tương tác
    @Override // Đã thêm
    public void Xoa() {
        if (size == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu can xoa: ");
        String ma = sc.nextLine().trim();
        xoaPhieu(ma);
        sc.close();
    }

    // Sửa tương tác
    @Override // Đã thêm
    public void Sua() {
        if (size == 0) { // Sửa lỗi: soLuong -> size
            System.out.println("Danh sach rong");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu can sua: ");
        String ma = sc.nextLine().trim();
        sc.close();

        int viTri = -1;
        for (int i = 0; i < size; i++) { // Sửa lỗi: soLuong -> size
            if (ds[i].getMaPNH().equalsIgnoreCase(ma)) {
                viTri = i;
                break;
            }
        }
        if (viTri == -1) {
            System.out.println("Khong tim thay phieu co ma " + ma);
            return;
        }

        phieuNhapHang p = ds[viTri];
        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println(
                    "\n╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                    "║                         SUA THONG TIN PHIEU NHAP: " + String.format("%-20s", ma) + "        ║");
            System.out.println(
                    "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(
                    "║ 1. Sua ma nhan vien                                                                   ║");
            System.out.println(
                    "║ 2. Sua ma nha cung cap                                                                ║");
            System.out.println(
                    "║ 3. Sua ngay nhap (dd/MM/yyyy)                                                         ║");
            System.out.println(
                    "║ 4. Sua tong tien                                                                      ║");
            System.out.println(
                    "║ 8. Nhap lai tat ca                                                                     ║");
            System.out.println(
                    "║ 0. Hoan thanh                                                                         ║");
            System.out.println(
                    "╚══════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print("Chon (0-8): ");

            String chon = sc.nextLine().trim();
            switch (chon) {
                case "1":
                    System.out.print("Nhap ma nhan vien moi: ");
                    p.setMaNV(sc.nextLine().trim());
                    break;
                case "2":
                    System.out.print("Nhap ma nha cung cap moi: ");
                    p.setMaNCC(sc.nextLine().trim());
                    break;
                case "3":
                    System.out.print("Nhap ngay nhap moi (dd/MM/yyyy): ");
                    p.setNgayNhap(sc.nextLine().trim());
                    break;
                case "4":
                    System.out.print("Nhap tong tien moi: ");
                    try {
                        p.setTongTien(Double.parseDouble(sc.nextLine().trim()));
                    } catch (Exception e) {
                        p.setTongTien(0);
                    }
                    break;
                case "8":
                    System.out.println("Nhap lai tat ca thong tin:");
                    p.nhap();
                    break;
                case "0":
                    System.out.println("Hoan thanh sua thong tin!");
                    tiepTuc = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
        // Không đóng Scanner
    }

    // Tìm theo mã
    public phieuNhapHang timKiemTheoMa(String ma) {
        if (ma == null)
            return null;
        for (int i = 0; i < size; i++) {
            if (ds[i].getMaPNH() != null && ds[i].getMaPNH().equalsIgnoreCase(ma)) {
                return ds[i];
            }
        }
        return null;
    }

    // Tìm theo mã nhân viên (trả mảng)
    public phieuNhapHang[] timKiemTheoMaNV(String maNV) {
        if (maNV == null)
            return new phieuNhapHang[0];
        phieuNhapHang[] ketQua = new phieuNhapHang[size];
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            String m = ds[i].getMaNV();
            if (m != null && m.toLowerCase().contains(maNV.toLowerCase())) {
                ketQua[cnt++] = ds[i]; // Sửa lỗi: tmp -> ketQua
            }
        }
        return Arrays.copyOf(ketQua, cnt);
    }

    // Tìm tương tác
    @Override // Đã thêm
    public void TimKiem() {
        if (size == 0) {
            System.out.println("Danh sach rong");
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
            sc.close();
            return;
        }

        switch (chon) {
            case 1:
                System.out.print("Nhap ma phieu nhap hang can tim: ");
                String ma = sc.nextLine();
                phieuNhapHang p = timKiemTheoMa(ma);
                if (p != null) { // Sửa lỗi: if ( != null) -> if (p != null)
                    System.out.println("✓ Tim thay phieu nhap hang:");
                    p.Xuat(); // Dùng hàm Xuat() đã được làm lại
                } else {
                    System.out.println("✗ Khong tim thay phieu nhap hang co ma: " + ma);
                }
                break;
            case 2:
                System.out.print("Nhap ma nhan vien can tim: ");
                String maNV = sc.nextLine();
                phieuNhapHang[] ketQua = timKiemTheoMaNV(maNV);
                if (ketQua.length > 0) {
                    System.out.println("✓ Tim thay " + ketQua.length + " phieu nhap hang:");
                    hienThiBang(ketQua, ketQua.length);
                } else {
                    System.out.println("✗ Khong tim thay phieu nhap hang co ma nhan vien nay: " + maNV);
                }
                break;
            default:
                System.out.println("✗ Lua chon khong hop le!");
        }
        sc.close();
    }

    public void thongKe() {
        if (size == 0) {
            System.out.println("✗ Danh sach phieu nhap hang rong");
            return;
        }

        double tongTien = 0;
        double maxTong = ds[0].getTongTien();
        double minTong = ds[0].getTongTien();
        phieuNhapHang pMax = ds[0];
        phieuNhapHang pMin = ds[0];

        for (int i = 0; i < size; i++) {
            tongTien += ds[i].getTongTien();
            if (ds[i].getTongTien() > maxTong) {
                maxTong = ds[i].getTongTien();
                pMax = ds[i];
            }
            if (ds[i].getTongTien() < minTong) {
                minTong = ds[i].getTongTien();
                pMin = ds[i];
            }
        }

        System.out.println(
                "╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(
                "║                                  BANG THONG KE PHIEU NHAP HANG                                              ║");
        System.out.println(
                "╠════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╣");
        System.out.printf("║ %-14s ║ %-15s ║ %-15s ║ %-17s ║ %-17s ║ %-26s ║%n",
                "Tong so phieu",
                "Tong tien",
                "Tien TB",
                "PNH cao nhat",
                "PNH thap nhat",
                "Chenh lech");
        System.out.println(
                "╠════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╣");
        System.out.printf("║ %-14d ║ %-16.2f ║ %-16.2f ║ %-16s ║ %-16s ║ %-16.2f ║%n",
                size,
                tongTien,
                tongTien / size,
                pMax.getMaPNH(),
                pMin.getMaPNH(),
                maxTong - minTong);
        System.out.println(
                "╚════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╝");
    }

    // =========================================================================
    // HÀM HIENTHIBANG() ĐÃ ĐƯỢC CẬP NHẬT THEO KHUNG CHUẨN
    // =========================================================================
    public void hienThiBang(phieuNhapHang[] arr, int sz) {
        // 1. Định nghĩa độ rộng cột cho printf (W_FMT)
        final int W_FMT_MAPNH = 10;
        final int W_FMT_MANV = 10;
        final int W_FMT_MANCC = 10;
        final int W_FMT_NGAY = 12;
        final int W_FMT_TONGTIEN = 20;

        // 2. Định nghĩa độ rộng đường viền (W_BORDER = W_FMT + 2)
        final int W_BDR_MAPNH = W_FMT_MAPNH + 2;
        final int W_BDR_MANV = W_FMT_MANV + 2;
        final int W_BDR_MANCC = W_FMT_MANCC + 2;
        final int W_BDR_NGAY = W_FMT_NGAY + 2;
        final int W_BDR_TONGTIEN = W_FMT_TONGTIEN + 2;

        // 3. Tạo các chuỗi đường viền
        final String LINE = repeatChar('═', W_BDR_MAPNH) + "╦" +
                repeatChar('═', W_BDR_MANV) + "╦" +
                repeatChar('═', W_BDR_MANCC) + "╦" +
                repeatChar('═', W_BDR_NGAY) + "╦" +
                repeatChar('═', W_BDR_TONGTIEN);

        final String TOP_BORDER = "╔" + LINE.replace('╦', '╤') + "╗";
        final String MID_BORDER = "╠" + LINE.replace('╦', '╬') + "╣";
        final String BOT_BORDER = "╚" + LINE.replace('╦', '╧') + "╝";

        // 4. Tạo các chuỗi định dạng (format string) cho printf
        final String HEADER_FMT = "║ %-" + W_FMT_MAPNH + "s ║ %-" + W_FMT_MANV + "s ║ %-" + W_FMT_MANCC + "s ║ %-"
                + W_FMT_NGAY + "s ║ %" + W_FMT_TONGTIEN + "s ║%n";
        final String ROW_FMT = "║ %-" + W_FMT_MAPNH + "s ║ %-" + W_FMT_MANV + "s ║ %-" + W_FMT_MANCC + "s ║ %-"
                + W_FMT_NGAY + "s ║ %" + W_FMT_TONGTIEN + ".0f ║%n";

        // 5. In bảng
        System.out.println(TOP_BORDER);
        int totalWidth = LINE.length() + 1; // Tổng độ rộng bên trong
        System.out.printf("║ %s ║%n", center("DANH SACH PHIEU NHAP HANG", totalWidth));
        System.out.println(MID_BORDER);

        System.out.printf(HEADER_FMT,
                "MaPNH",
                "MaNV",
                "MaNCC",
                "NgayNhap",
                "TongTien");
        System.out.println(MID_BORDER);

        for (int i = 0; i < sz; i++) {
            phieuNhapHang p = arr[i];

            System.out.printf(ROW_FMT,
                    truncate(p.getMaPNH(), W_FMT_MAPNH),
                    truncate(p.getMaNV(), W_FMT_MANV),
                    truncate(p.getMaNCC(), W_FMT_MANCC),
                    truncate(p.getNgayNhap(), W_FMT_NGAY),
                    p.getTongTien());
        }
        System.out.println(BOT_BORDER);
    }

    public void XuatDS() {
        if (size == 0) {
            System.out.println("Danh sach phieu nhap rong");
            return;
        }
        hienThiBang(ds, size); // Sửa lỗi: hienThiBang() -> hienThiBang(ds, size)
    }

    // ghi file
    @Override // Đã thêm
    public void ghiFile(String tenFile) {
        System.out.println("→ Dang ghi file: " + tenFile + "...");

        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println(size);

            for (int i = 0; i < size; i++) {
                phieuNhapHang p = ds[i];
                // Thêm escape() và Locale.US
                pw.printf(Locale.US, "%s,%s,%s,%s,%.2f%n",
                        escape(p.getMaPNH()),
                        escape(p.getMaNV()),
                        escape(p.getMaNCC()),
                        escape(p.getNgayNhap()),
                        p.getTongTien());
            }
            // Thông báo đơn giản giống file model
            System.out.println("Ghi file thanh cong. Da ghi: " + size);

        } catch (IOException e) {
            System.err.println("Loi ghi file: " + e.getMessage());
        }
    }

    // đọc file
    @Override // Đã thêm
    public void docFile(String tenFile) {
        File f = new File(tenFile);
        if (!f.exists()) {
            System.out.println("File khong ton tai. Bat dau voi danh sach rong.");
            this.ds = new phieuNhapHang[0];
            this.size = 0;
            return;
        }
        System.out.println("→ Dang doc file: " + tenFile + "...");
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String first = br.readLine();
            if (first == null || first.trim().isEmpty())
                throw new IOException("File rong hoac khong co so luong!");

            int count = Integer.parseInt(first.trim());
            this.ds = new phieuNhapHang[count];
            this.size = 0;
            String line;
            int ln = 2;

            while ((line = br.readLine()) != null && size < count) {
                if (line.trim().isEmpty()) {
                    ln++;
                    continue;
                }
                String[] parts = line.split(",", -1);

                if (parts.length < 5) { // Cần 5 trường
                    System.err.println("Dong " + ln + ": Sai dinh dang (thieu truong)");
                    ln++;
                    continue;
                }

                try {
                    String maPNH = unescape(parts[0].trim());
                    String maNV = unescape(parts[1].trim());
                    String maNCC = unescape(parts[2].trim());
                    String ngay = unescape(parts[3].trim());
                    double tong = Double.parseDouble(parts[4].trim());

                    ds[size++] = new phieuNhapHang(maPNH, maNV, maNCC, ngay, tong);

                } catch (NumberFormatException e) {
                    System.err.println("Dong " + ln + ": Loi dinh dang so (TongTien)");
                }
                ln++;
            }
            System.out.println("Doc file xong. Da doc: " + size);
        } catch (Exception e) {
            System.err.println("Loi doc file: " + e.getMessage());
            this.ds = new phieuNhapHang[0];
            this.size = 0;
        }
    }

    // 1) Tổng tiền trong khoảng
    public double tongTienTrongKhoang(String fromStr, String toStr) {
        LocalDate f = parseDate(fromStr), t = parseDate(toStr);
        if (f == null || t == null)
            return 0.0;
        if (t.isBefore(f)) {
            LocalDate tmp = f;
            f = t;
            t = tmp;
        }
        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            LocalDate d = parseDate(ds[i].getNgayNhap()); // Sửa: getNgayGiao -> getNgayNhap
            if (d == null)
                continue;
            if ((d.isEqual(f) || d.isAfter(f)) && (d.isEqual(t) || d.isBefore(t)))
                sum += ds[i].getTongTien();
        }
        return sum;
    }

    // 2) Thống kê theo quý của 1 năm
    public double[] thongKeTheoQuy(int nam) {
        double[] q = new double[4];
        for (int i = 0; i < size; i++) {
            LocalDate d = parseDate(ds[i].getNgayNhap()); // Sửa: getNgayGiao -> getNgayNhap
            if (d == null || d.getYear() != nam)
                continue;
            int idx = (d.getMonthValue() - 1) / 3;
            q[idx] += ds[i].getTongTien();
        }
        return q;
    }

    // 3) Thống kê tổng theo tháng trong năm -> 12 phần tử
    public double[] thongKeTheoThangTrongNam(int nam) {
        double[] m = new double[12];
        for (int i = 0; i < size; i++) {
            LocalDate d = parseDate(ds[i].getNgayNhap()); // Sửa: getNgayGiao -> getNgayNhap
            if (d == null || d.getYear() != nam)
                continue;
            m[d.getMonthValue() - 1] += ds[i].getTongTien();
        }
        return m;
    }

    public void inThongKeQuy(int nam) {
        double[] q = thongKeTheoQuy(nam);
        for (int i = 0; i < 4; i++)
            System.out.printf("Nam %d - Quy %d: %.2f%n", nam, i + 1, q[i]);
    }

    public void inThongKeThang(int nam) {
        double[] m = thongKeTheoThangTrongNam(nam);
        for (int i = 0; i < 12; i++)
            System.out.printf("Nam %d - Thang %02d: %.2f%n", nam, i + 1, m[i]);
    }

    // =========================================================================
    // HÀM HELPER (Đã thêm)
    // =========================================================================
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

    private LocalDate parseDate(String s) {
        if (s == null || s.trim().isEmpty())
            return null;
        try {
            return LocalDate.parse(s.trim(), DTF);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public int getSize() {
        return size;
    }

    public phieuNhapHang[] getDs() {
        return Arrays.copyOf(ds, size);
    }
}