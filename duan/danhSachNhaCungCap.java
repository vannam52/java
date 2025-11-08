// package duan;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.*;

// import duan.nhaCungCap;

// public class danhSachNhaCungCap implements ChucNang, IFile {
//     private nhaCungCap[] dsNCC;
//     private int soLuongNCC;
//     private final int MAX_NCC = 100;

//     private static Scanner sc = new Scanner(System.in);

//     public danhSachNhaCungCap() {
//         dsNCC = new nhaCungCap[MAX_NCC];
//         soLuongNCC = 0;
//     }

//     public danhSachNhaCungCap(danhSachNhaCungCap ds) {
//         this.dsNCC = new nhaCungCap[ds.soLuongNCC];
//         this.soLuongNCC = ds.soLuongNCC;
//         for (int i = 0; i < this.soLuongNCC; i++) {
//             this.dsNCC[i] = new nhaCungCap(ds.dsNCC[i]);
//         }
//     }

//     public boolean kiemTraMa(String maNCC) {
//         for (int i = 0; i < soLuongNCC; i++) {
//             if (dsNCC[i].getMaNCC().equals(maNCC))
//                 return true;
//         }
//         return false;
//     }

//     public void themNhaCungCap(nhaCungCap ncc) {
//         if (this.soLuongNCC >= MAX_NCC) {
//             System.out.println("Danh sach nha cung cap da day.");
//             return;
//         }
//         String maNCC;
//         while (kiemTraMa(ncc.getMaNCC())) {
//             System.out.print("Ma nha cung cap da ton tai, vui long nhap lai: ");
//             maNCC = sc.nextLine();
//             ncc.setMaNCC(maNCC);
//         }
//         this.dsNCC[soLuongNCC] = ncc;
//         this.soLuongNCC++;
//         System.out.println("Da them nha cung cap thanh cong.");
//     }

//     @Override
//     public void Them() {
//         if (soLuongNCC >= MAX_NCC) {
//             System.out.println("Danh sach nha cung cap day");
//             return;
//         }
//         nhaCungCap ncc = new nhaCungCap();
//         ncc.Nhap();
//         this.themNhaCungCap(ncc);
//     }

//     public void nhapNNhaCungCap() {
//         if (soLuongNCC >= MAX_NCC) {
//             System.out.println("Danh sach nha cung cap day, khong the nhap them");
//             return;
//         }
//         int n;
//         try {
//             System.out.print("Nhap so luong nha cung cap can them: ");
//             n = Integer.parseInt(sc.nextLine());
//             if (n <= 0) {
//                 System.out.println("So luong phai lon hon 0");
//                 return;
//             }
//         } catch (NumberFormatException e) {
//             System.out.println("So luong khong hop le");
//             return;
//         }
//         for (int i = 0; i < n; i++) {
//             System.out.println("Nhap nha cung cap " + (i + 1) + ":");
//             this.Them();
//         }
//     }

//     @Override
//     public void Xoa() {
//         if (soLuongNCC == 0) {
//             System.out.println("Danh sach nha cung cap rong");
//             return;
//         }
//         String maNCC;
//         do {
//             System.out.print("Nhap ma nha cung cap can xoa (nhap 'q' de thoat): ");
//             maNCC = sc.nextLine();
//             if (maNCC.equalsIgnoreCase("q"))
//                 return;
//             if (kiemTraMa(maNCC))
//                 break;
//             System.out.println("Khong tim thay ma nha cung cap, vui long nhap lai.");
//         } while (true);

//         for (int i = 0; i < soLuongNCC; i++) {
//             if (dsNCC[i].getMaNCC().equals(maNCC)) {
//                 for (int j = i; j < soLuongNCC - 1; j++) {
//                     dsNCC[j] = dsNCC[j + 1];
//                 }
//                 dsNCC = Arrays.copyOf(dsNCC, soLuongNCC - 1);
//                 soLuongNCC--;
//                 System.out.println("Da xoa nha cung cap co ma: " + maNCC);
//                 return;
//             }
//         }
//     }

//     @Override
//     public void Sua() {
//         if (soLuongNCC == 0) {
//             System.out.println("Danh sach nha cung cap rong");
//             return;
//         }
//         String maNCC;
//         do {
//             System.out.print("Nhap ma nha cung cap can sua (nhap 'q' de thoat): ");
//             maNCC = sc.nextLine();
//             if (maNCC.equalsIgnoreCase("q"))
//                 return;
//             if (kiemTraMa(maNCC))
//                 break;
//             System.out.println("Ma nha cung cap khong ton tai. Vui long nhap lai.");
//         } while (true);
//         for (int i = 0; i < soLuongNCC; i++) {
//             if (this.dsNCC[i].getMaNCC().equals(maNCC)) {
//                 dsNCC[i].Nhap();
//                 System.out.println("Sua nha cung cap thanh cong");
//                 return;
//             }
//         }
//     }

//     @Override
//     public void TimKiem() {
//         if (soLuongNCC == 0) {
//             System.out.println("Danh sach nha cung cap rong");
//             return;
//         }
//         String maNCC;
//         do {
//             System.out.print("Nhap ma nha cung cap can tim (nhap 'q' de thoat): ");
//             maNCC = sc.nextLine();
//             if (maNCC.equalsIgnoreCase("q"))
//                 return;
//             if (kiemTraMa(maNCC))
//                 break;
//             System.out.println("Ma nha cung cap khong ton tai. Vui long nhap lai.");
//         } while (true);
//         for (int i = 0; i < soLuongNCC; i++) {
//             if (dsNCC[i].getMaNCC().equals(maNCC)) {
//                 dsNCC[i].Xuat();
//                 return;
//             }
//         }
//     }

//     public void hienThiDanhSachNCC() {
//         if (soLuongNCC == 0) {
//             System.out.println("Danh sach nha cung cap rong");
//             return;
//         }
//         System.out.println("╔════════════╦════════════════════╦══════════════════════════════╦════════════╗");
//         System.out.println("║   Ma NCC   ║     Ten NCC        ║          Dia Chi             ║ So DT      ║");
//         System.out.println("╠════════════╬════════════════════╬══════════════════════════════╬════════════╣");
//         for (int i = 0; i < soLuongNCC; i++) {
//             System.out.printf("║ %-10s ║ %-18s ║ %-28s ║ %-10s ║%n",
//                     dsNCC[i].getMaNCC(),
//                     dsNCC[i].getTenNCC(),
//                     dsNCC[i].getDiaChi(),
//                     dsNCC[i].getSdt());
//         }
//         System.out.println("╚════════════╩════════════════════╩══════════════════════════════╩════════════╝");
//     }

//     public void sapXepNCCTheoTen() {
//         if (soLuongNCC == 0) {
//             System.out.println("Danh sach nha cung cap rong");
//             return;
//         }
//         for (int i = 0; i < soLuongNCC - 1; i++) {
//             for (int j = i + 1; j < soLuongNCC; j++) {
//                 if (dsNCC[i].getTenNCC().compareTo(dsNCC[j].getTenNCC()) > 0) {
//                     nhaCungCap temp = dsNCC[i];
//                     dsNCC[i] = dsNCC[j];
//                     dsNCC[j] = temp;
//                 }
//             }
//         }
//         System.out.println("Da sap xep danh sach nha cung cap theo ten");
//         hienThiDanhSachNCC();
//     }

//     @Override
//     public void docFile(String tenFile) {
//         File f = new File(tenFile);
//         if (!f.exists()) {
//             System.out.println("File khong ton tai. Danh sach rong.");
//             this.dsNCC = new nhaCungCap[0];
//             this.soLuongNCC = 0;
//             return;
//         }

//         System.out.println("Dang doc file: " + tenFile + "...");

//         try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
//             String firstLine = br.readLine();
//             if (firstLine == null || firstLine.trim().isEmpty()) {
//                 throw new IOException("File rong hoac khong co so luong!");
//             }

//             int count = Integer.parseInt(firstLine.trim());
//             if (count <= 0) {
//                 System.out.println("File khong co nha cung cap de doc.");
//                 this.dsNCC = new nhaCungCap[0];
//                 this.soLuongNCC = 0;
//                 return;
//             }

//             this.dsNCC = new nhaCungCap[count];
//             this.soLuongNCC = 0;
//             String line;
//             int lineNumber = 2;

//             while ((line = br.readLine()) != null && this.soLuongNCC < count) {
//                 line = line.trim();
//                 if (line.isEmpty()) {
//                     System.out.println("Dong " + lineNumber + ": Rong (bo qua)");
//                     lineNumber++;
//                     continue;
//                 }

//                 String[] parts = line.split(",");
//                 if (parts.length >= 4) {
//                     try {
//                         String maNCC = parts[0].trim();
//                         String tenNCC = parts[1].trim();
//                         String diaChi = parts[2].trim();
//                         String sdt = parts[3].trim();

//                         this.dsNCC[this.soLuongNCC] = new nhaCungCap(maNCC, tenNCC, diaChi, sdt);
//                         this.soLuongNCC++;

//                     } catch (Exception e) {
//                         System.err.println("Dong " + lineNumber + ": Loi doc du lieu - " + e.getMessage());
//                         System.err.println("     Noi dung: " + line);
//                     }
//                 } else {
//                     System.err.println(" Dong " + lineNumber + ": Sai dinh dang du lieu. (co " + parts.length
//                             + " truong, can 4)");
//                     System.err.println("     Noi dung: " + line);
//                 }

//                 lineNumber++;
//             }

//             if (this.soLuongNCC < count) {
//                 System.out.println("Canh bao: Chi doc duoc " + this.soLuongNCC + "/" + count + " nha cung cap");
//             }

//             System.out.println(
//                     "╔══════════════════════════════════════════════════════════════════════════════════════╗");
//             System.out.println(
//                     "║                            DOC FILE THANH CONG!                                      ║");
//             System.out.println(
//                     "╠══════════════════════════════════════════════════════════════════════════════════════╣");
//             System.out.printf("║ Da doc: %-76d ║%n", this.soLuongNCC);
//             System.out.printf("║ Tu file: %-75s ║%n", tenFile);
//             System.out.println(
//                     "╚══════════════════════════════════════════════════════════════════════════════════════╝");

//         } catch (Exception e) {
//             System.err.println("Loi doc file: " + e.getMessage());
//             this.dsNCC = new nhaCungCap[0];
//             this.soLuongNCC = 0;
//         }
//     }

//     @Override
//     public void ghiFile(String tenFile) {
//         if (this.soLuongNCC == 0) {
//             System.out.println("Danh sach trong, khong co du lieu de ghi.");
//             return;
//         }

//         System.out.println("Dang ghi file: " + tenFile + "...");

//         try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
//             bw.write(this.soLuongNCC + "\n");
//             bw.write("╔════════════╦════════════════════╦══════════════════════════════╦════════════╗\n");
//             bw.write("║   Ma NCC   ║     Ten NCC        ║          Dia Chi             ║ So DT      ║\n");
//             bw.write("╠════════════╬════════════════════╬══════════════════════════════╬════════════╣\n");

//             for (int i = 0; i < this.soLuongNCC; i++) {
//                 nhaCungCap ncc = this.dsNCC[i];
//                 bw.write(String.format("║ %-10s ║ %-18s ║ %-28s ║ %-10s ║\n",
//                         ncc.getMaNCC(),
//                         ncc.getTenNCC(),
//                         ncc.getDiaChi(),
//                         ncc.getSdt()));
//             }

//             bw.write("╚════════════╩════════════════════╩══════════════════════════════╩════════════╝\n");

//             System.out.println(
//                     "╔══════════════════════════════════════════════════════════════════════════════════════╗");
//             System.out.println(
//                     "║                            GHI FILE THANH CONG!                                      ║");
//             System.out.println(
//                     "╠══════════════════════════════════════════════════════════════════════════════════════╣");
//             System.out.printf("║ Da ghi: %-76d ║%n", this.soLuongNCC);
//             System.out.printf("║ Vao file: %-74s ║%n", tenFile);
//             System.out.println(
//                     "╚══════════════════════════════════════════════════════════════════════════════════════╝");

//         } catch (IOException e) {
//             System.err.println("Loi ghi file: " + e.getMessage());
//         }
//     }
// }