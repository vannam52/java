// package duan;

// import java.util.*;
// import java.io.*;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.time.format.DateTimeParseException;

// public class danhSachPhieuNhapHang implements ChucNang, IFile{
//     private PhieuNhapHang[] ds;
//     private int size;
//     private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//     public danhSachPhieuNhapHang() {
//         this.ds = new PhieuNhapHang[0];
//         this.size = 0;
//     }

//     // Thêm phiếu (không tương tác)
//     public void themPhieu(PhieuNhapHang p) {
//         if (p == null) return;
//         if (timKiemTheoMa(p.getMaPNH()) != null) {
//             System.out.println("Ma phieu da ton tai: " + p.getMaPNH());
//             return;
//         }
//         ds = Arrays.copyOf(ds, size + 1);
//         ds[size++] = p;
//         System.out.println("Them phieu nhap thanh cong!");
//     }

//     // Thêm (tương tác)
//     @Override
//     public void Them() {
//         Scanner sc = new Scanner(System.in);
//         PhieuNhapHang p = new PhieuNhapHang();
//         boolean trung;
//         do {
//             trung = false;
//             p.nhap();
//             if (timKiemTheoMa(p.getMaPNH()) != null) {
//                 System.out.println("Ma phieu bi trung. Nhap lai.");
//                 trung = true;
//             }
//         } while (trung);
//         themPhieu(p);
//     }

//     // Xóa không tương tác
//     public void xoaPhieu(String ma) {
//         int vt = -1;
//         for (int i = 0; i < size; i++) {
//             if (ds[i].getMaPNH() != null && ds[i].getMaPNH().equalsIgnoreCase(ma)) { 
//                 vt = i; 
//                 break; 
//             }
//         }
//         if (vt == -1) { 
//             System.out.println("Khong tim thay phieu: " + ma); 
//             return; 
//         }
//         for (int j = vt; j < size - 1; j++) {
//             ds[j] = ds[j + 1];
//         }
//         ds = Arrays.copyOf(ds, size - 1);
//         size--;
//         System.out.println("Da xoa phieu: " + ma);
//     }

//     // Xóa tương tác
//     @Override
//     public void Xoa() {
//         if (size == 0) {
//             System.out.println("Danh sach rong");
//             return;
//         }
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Nhap ma phieu can xoa: ");
//         String ma = sc.nextLine().trim();
//         xoaPhieu(ma);
//     }

//     // Sửa tương tác
//     @Override
//     public void Sua() {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Nhap ma phieu can sua: ");
//         String ma = sc.nextLine().trim();

//         int viTri = -1;
//         for (int i = 0; i < size; i++) {
//             if (ds[i].getMaPNH().equalsIgnoreCase(ma)) { viTri = i; break; }
//         }
//         if (viTri == -1) {
//             System.out.println("Khong tim thay phieu co ma " + ma);
//             return;
//         }

//         PhieuNhapHang p = ds[viTri];
//         boolean tiepTuc = true;
//         while (tiepTuc) {
//             System.out.println("\n╔══════════════════════════════════════════════════════════════════════════════════════╗");
//             System.out.println("║                         SUA THONG TIN PHIEU NHAP: " + String.format("%-20s", ma) + "        ║");
//             System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════╣");
//             System.out.println("║ 1. Sua ma nhan vien                                                                   ║");
//             System.out.println("║ 2. Sua ma nha cung cap                                                                ║");
//             System.out.println("║ 3. Sua ngay nhap (dd/MM/yyyy)                                                         ║");
//             System.out.println("║ 4. Sua tong tien                                                                      ║");
//             System.out.println("║ 8. Nhap lai tat ca                                                                     ║");
//             System.out.println("║ 0. Hoan thanh                                                                         ║");
//             System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════╝");
//             System.out.print("Chon (0-8): ");

//             String chon = sc.nextLine().trim();
//             switch (chon) {
//                 case "1":
//                     System.out.print("Nhap ma nhan vien moi: ");
//                     p.setMaNV(sc.nextLine().trim());
//                     break;
//                 case "2":
//                     System.out.print("Nhap ma nha cung cap moi: ");
//                     p.setMaNCC(sc.nextLine().trim());
//                     break;
//                 case "3":
//                     System.out.print("Nhap ngay nhap moi (dd/MM/yyyy): ");
//                     p.setNgayNhap(sc.nextLine().trim());
//                     break;
//                 case "4":
//                     System.out.print("Nhap tong tien moi: ");
//                     p.setTongTien(Double.parseDouble(sc.nextLine().trim()));
//                     break;
//                 case "8":
//                     System.out.println("Nhap lai tat ca thong tin:");
//                     p.nhap();
//                     break;
//                 case "0":
//                     System.out.println("Hoan thanh sua thong tin!");
//                     tiepTuc = false;
//                     break;
//                 default:
//                     System.out.println("Lua chon khong hop le!");
//             }
//         }
//     }

//     // Tìm theo mã
//     public PhieuNhapHang timKiemTheoMa(String ma) {
//         if (ma == null) return null;
//         for (int i = 0; i < size; i++) {
//             if (ds[i].getMaPNH() != null && ds[i].getMaPNH().equalsIgnoreCase(ma)) { 
//                 return ds[i];
//             }
//         }
//         return null;
//     }

//     // Tìm theo mã nhân viên (trả mảng)
//     public PhieuNhapHang[] timKiemTheoMaNV(String maNV) {
//         if (maNV == null) return new PhieuNhapHang[0];
//         PhieuNhapHang[] ketQua = new PhieuNhapHang[size];
//         int cnt = 0;
//         for (int i = 0; i < size; i++) {
//             String m = ds[i].getMaNV();
//             if (m != null && m.toLowerCase().contains(maNV.toLowerCase())) {
//                 tmp[cnt++] = ds[i];
//             }
//         }
//         return Arrays.copyOf(ketQua, cnt);
//     }

//     // Tìm tương tác
//     @Override
//     public void TimKiem() {
//         if (size == 0) { 
//             System.out.println("Danh sach rong"); 
//             return; 
//         }
//         Scanner sc = new Scanner(System.in);
//         System.out.println("--- TIM KIEM PHIEU NHAP HANG ---");
//         System.out.println("1. Tim theo ma phieu nhap hang");
//         System.out.println("2. Tim theo ma nhan vien");
//         System.out.print("Chon loai tim kiem: ");

//         int chon = 0;
//         try {
//             chon = Integer.parseInt(sc.nextLine());
//         } catch (NumberFormatException e) {
//             System.out.println("✗ Lua chon khong hop le!");
//             return;
//         }

//         switch (chon) {
//             case 1:
//                 System.out.print("Nhap ma phieu nhap hang can tim: ");
//                 String ma = sc.nextLine();
//                 phieuNhapHang p = timKiemTheoMa(ma);
//                 if ( != null) {
//                     System.out.println("✓ Tim thay phieu nhap hang:");
//                     p.Xuat();
//                 } else {
//                     System.out.println("✗ Khong tim thay phieu nhap hang co ma: " + ma);
//                 }
//                 break;
//             case 2:
//                 System.out.print("Nhap ma nhan vien can tim: ");
//                 String maNV = sc.nextLine();
//                 phieuNhapHang[] ketQua = timKiemTheoMaNV(maNV);
//                 if (ketQua.length > 0) {
//                     System.out.println("✓ Tim thay " + ketQua.length + " phieu nhap hang:");
//                     hienThiBang(ketQua, ketQua.length);
//                 } else {
//                     System.out.println("✗ Khong tim thay phieu nhap hang co ma nhan vien nay: " + maNV);
//                 }
//                 break;
//             default:
//                 System.out.println("✗ Lua chon khong hop le!");
//         }
//     }

//     public void thongKe() {
//         if (size == 0) {
//             System.out.println("✗ Danh sach phieu nhap hang rong");
//             return;
//         }

//         double tongTien = 0;
//         double maxTong = ds[0].getTongTien();
//         double minTong = ds[0].getTongTien();
//         PhieuNhapHang pMax = ds[0];
//         PhieuNhapHang pMin = ds[0];

//         for (int i = 0; i < size; i++) {
//             tongTien += ds[i].getTongTien();
//             if (ds[i].getTongTien() > maxTong) {
//                 maxTong = ds[i].getTongTien();
//                 pMax = ds[i];
//             }
//             if (ds[i].getTongTien() < minTong) {
//                 minTong = ds[i].getTongTien();
//                 pMin = ds[i];
//             }
//         }

//         System.out.println(
//                 "╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
//         System.out.println(
//                 "║                                  BANG THONG KE PHIEU NHAP HANG                                              ║");
//         System.out.println(
//                 "╠════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╦══════════════════╣");
//         System.out.printf("║ %-14s ║ %-15s ║ %-15s ║ %-17s ║ %-17s ║ %-26s ║%n",
//                 "Tong so phieu",
//                 "Tong tien",
//                 "Tien TB",
//                 "PNH cao nhat",
//                 "PNH thap nhat",
//                 "Chenh lech");
//         System.out.println(
//                 "╠════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╬══════════════════╣");
//         System.out.printf("║ %-14d ║ %-16.2f ║ %-16.2f ║ %-16s ║ %-16s ║ %-16.2f ║%n",
//                 size,
//                 tongTien,
//                 tongTien / size,
//                 pMax.getMaPNH(),
//                 pMin.getMaPNH(),
//                 maxTong - minTong);
//         System.out.println(
//                 "╚════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╩══════════════════╝");
//     }
    
//     // Xuất danh sách ngắn
//     public void hienThiBang(PhieuNhapHang[] arr, int size) {
//         final String LINE = "══════════════════════════════════════════════════════════════════════════════════════════════════";
//         System.out.println("╔" + LINE + "╗");
//         System.out.println("║                                     DANH SACH PHIEU NHAP                                    ║");
//         System.out.println("╠══════════╦════════════╦════════════╦══════════════╦═════════════════════════════════════════╣");
//         System.out.println("║  MaPNH   ║   MaNV     ║   MaNCC    ║  NgayNhap    ║                TongTien                 ║");
//         System.out.println("╠══════════╬════════════╬════════════╬══════════════╬═════════════════════════════════════════╣");
//         for (int i = 0; i < size; i++) {
//             PhieuNhapHang p = arr[i];
//             System.out.printf("║ %-8s ║ %-10s ║ %-10s ║ %-12s ║ %,33.2f ║%n",
//                     p.getMaPNH(), p.getMaNV(), p.getMaNCC(), p.getNgayNhap(), p.getTongTien());
//         }
//         System.out.println("╚══════════╩════════════╩════════════╩══════════════╩═════════════════════════════════════════╝");
//     }

//     public void XuatDS() {
//         if (size == 0) {
//             System.out.println("Danh sach phieu nhap rong");
//             return;
//         }
//         hienThiBang();
//     }

//     // ghi file
//     // ...existing code...
//     public void ghiFile(String tenFile) {
//         System.out.println("→ Dang ghi file: " + tenFile + "...");

//         try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
//             pw.println(size);

//             for (int i = 0; i < size; i++) {
//                 PhieuNhapHang p = ds[i];
//                 pw.printf("%s,%s,%s,%s,%.2f%n",
//                         p.getMaPNH(),
//                         p.getMaNV(),
//                         p.getMaNCC(),
//                         p.getNgayNhap(),
//                         p.getTongTien());
//             }

//             System.out.println(
//                     "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
//             System.out.println(
//                     "║                            GHI FILE THANH CONG!                                       ║");
//             System.out.println(
//                     "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
//             System.out.printf("║ Da ghi: %-77d ║%n", this.size);
//             System.out.printf("║ Vao file: %-74s ║%n", tenFile);
//             System.out.println(
//                     "╚═══════════════════════════════════════════════════════════════════════════════════════╝");

//         } catch (IOException e) {
//             System.err.println("Loi ghi file: " + e.getMessage());
//         }
//     }
// // ...existing code...

//     // đọc file
//     public void docFile(String tenFile) {
//         File f = new File(tenFile);
//         if (!f.exists()) {
//             System.out.println(
//                     "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
//             System.out.println(
//                     "║                            THONG BAO FILE KHONG TON TAI                              ║");
//             System.out.println(
//                     "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
//             System.out.println("║ File: " + String.format("%-80s", tenFile) + " ║");
//             System.out.println(
//                     "║ → Bat dau voi danh sach RONG. Hay them phieu nhap hang moi!                          ║");
//             System.out.println(
//                     "╚═══════════════════════════════════════════════════════════════════════════════════════╝");
//             this.ds = new PhieuNhapHang[0];
//             this.size = 0;
//             return;
//         }

//         System.out.println("→ Dang doc file: " + tenFile + "...");

//         try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
//             String firstLine = br.readLine();
//             if (firstLine == null || firstLine.trim().isEmpty()) {
//                 throw new IOException("File rong hoac khong co so luong!");
//             }

//             int count = Integer.parseInt(firstLine.trim());
//             if (count <= 0) {
//                 System.out.println("File khong co phieu nhap hang de doc.");
//                 this.ds = new PhieuNhapHang[0];
//                 this.size = 0;
//                 return;
//             }

//             this.ds = new PhieuNhapHang[count];
//             this.size = 0;
//             String line;
//             int lineNumber = 2;

//             while ((line = br.readLine()) != null && this.size < count) {
//                 line = line.trim();
//                 if (line.isEmpty()) {
//                     System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
//                     lineNumber++;
//                     continue;
//                 }

//                 String[] parts = line.split(",", -1);
//                 if (parts.length == 5) {
//                     try {
//                         String maPNH = unescape(parts[0].trim());
//                         String maNV = unescape(parts[1].trim());
//                         String maNCC = unescape(parts[2].trim());
//                         String ngay = unescape(parts[3].trim());
//                         double tong = Double.parseDouble(parts[4].trim());

//                         this.ds[this.size] = new PhieuNhapHang(maPNH, maNV, maNCC, ngay, tong);
//                         this.size++;

//                     } catch (NumberFormatException e) {
//                         System.err.println(" ✗ Dong " + lineNumber + ": Loi dinh dang so - " + e.getMessage());
//                         System.err.println("     Noi dung: " + line);
//                     }
//                 } else {
//                     System.err.println(" ✗ Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
//                             + " truong, can 5)");
//                     System.err.println("     Noi dung: " + line);
//                 }

//                 lineNumber++;
//             }

//             if (this.size < count) {
//                 System.out.println("Canh bao: Chi doc duoc " + this.size + "/" + count + " phieu nhap hang");
//             }

//             System.out.println(
//                     "╔═══════════════════════════════════════════════════════════════════════════════════════╗");
//             System.out.println(
//                     "║                            DOC FILE THANH CONG!                                       ║");
//             System.out.println(
//                     "╠═══════════════════════════════════════════════════════════════════════════════════════╣");
//             System.out.printf("║ Da doc: %-77d ║%n", this.size);
//             System.out.printf("║ Tu file: %-76s ║%n", tenFile);
//             System.out.println(
//                     "╚═══════════════════════════════════════════════════════════════════════════════════════╝");

//         } catch (Exception e) {
//             System.err.println("Loi doc file: " + e.getMessage());
//             this.ds = new PhieuNhapHang[0];
//             this.size = 0;
//         }
//     }

//     // 1) Tổng tiền trong khoảng 
//     public double tongTienTrongKhoang(String fromStr, String toStr) {
//         LocalDate f = parseDate(fromStr), t = parseDate(toStr);
//         if (f == null || t == null) return 0.0;
//         if (t.isBefore(f)) { LocalDate tmp = f; f = t; t = tmp; }
//         double sum = 0.0;
//         for (int i = 0; i < size; i++) {
//             LocalDate d = parseDate(ds[i].getNgayNhap());
//             if (d == null) continue;
//             if ((d.isEqual(f) || d.isAfter(f)) && (d.isEqual(t) || d.isBefore(t))) sum += ds[i].getTongTien();
//         }
//         return sum;
//     }

//     // 2) Thống kê theo quý của 1 năm 
//     public double[] thongKeTheoQuy(int nam) {
//         double[] q = new double[4];
//         for (int i = 0; i < size; i++) {
//             LocalDate d = parseDate(ds[i].getNgayNhap());
//             if (d == null || d.getYear() != nam) continue;
//             int idx = (d.getMonthValue() - 1) / 3;
//             q[idx] += ds[i].getTongTien();
//         }
//         return q;
//     }

//     // 3) Thống kê tổng theo tháng trong năm -> 12 phần tử
//     public double[] thongKeTheoThangTrongNam(int nam) {
//         double[] m = new double[12];
//         for (int i = 0; i < size; i++) {
//             LocalDate d = parseDate(ds[i].getNgayNhap());
//             if (d == null || d.getYear() != nam) continue;
//             m[d.getMonthValue() - 1] += ds[i].getTongTien();
//         }
//         return m;
//     }

//     public void inThongKeQuy(int nam) {
//         double[] q = thongKeTheoQuy(nam);
//         for (int i = 0; i < 4; i++) System.out.printf("Nam %d - Quy %d: %.2f%n", nam, i + 1, q[i]);
//     }

//     public void inThongKeThang(int nam) {
//         double[] m = thongKeTheoThangTrongNam(nam);
//         for (int i = 0; i < 12; i++) System.out.printf("Nam %d - Thang %02d: %.2f%n", nam, i + 1, m[i]);
//     }

//     // util
//     private static String escape(String s) {
//         if (s == null) return "";
//         return s.replace("\n", " ").replace("\r", " ").replace(",", ";");
//     }

//     private static String unescape(String s) {
//         if (s == null) return "";
//         return s.replace(";", ",");
//     }

//     public int getSize() { 
//         return size; 
//     }

//     public PhieuNhapHang[] getDs() { 
//         return Arrays.copyOf(ds, size); 
//     }
// }
