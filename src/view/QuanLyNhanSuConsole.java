package view;

import java.util.Scanner;

import controller.QuanLyNhanSu;
import model.GiamDoc;
import model.NhanSu;
import model.NhanVien;
import model.TruongPhong;

public class QuanLyNhanSuConsole {
	private QuanLyNhanSu controller;
	private Scanner scanner = new Scanner(System.in);
	private double loiNhuanThang = 0;
	
	public QuanLyNhanSuConsole() {
		controller = new QuanLyNhanSu();
	}
	
	public void start() {
		int option;
		do {
			inMenu();
			option = Integer.parseInt(scanner.nextLine());
		} while (xuLyMenu(option));
	}

	private void inMenu() {
		System.out.println("\nDanh sách chức năng:");
		System.out.println("\t1.Nhập thông tin công ty.");
		System.out.println("\t2.In thông tin công ty.");
		System.out.println("\t3.Thêm nhân sự.");
		System.out.println("\t4.Xóa nhân sự.");
		System.out.println("\t5.In danh sách nhân sự.");
		System.out.println("\t6.In tổng lương công ty.");
		System.out.println("\t7.Tìm kiếm.");
		System.out.println("\t8.Danh sách thu nhập của giám đốc.");
		System.out.println("\t0.Thoát.");
		System.out.println("Lựa chọn: ");
	}

	private boolean xuLyMenu(int option) {
		boolean isContinue = true;
		String maNSXoa;
		switch(option) {
		case 1: // Nhập thông tin công ty
			controller.nhapThongTinCongTy(scanner);
			break;
		case 2: // Xuất thông tin công ty
			controller.xuatThongTinCongTy();
			break;
		case 3: // Thêm nhân sự
			themNhanSu();
			break;
		case 4: //Xóa nhân sự 
			System.out.print("Nhập mã nhân sự muốn xóa: ");
			maNSXoa = scanner.nextLine();
			controller.xoaNhanSu(maNSXoa);
			break;
		case 5: // In danh sách nhân sự
			controller.xuatDanhSachNhanSu();
			break;
		case 6: // In tổng lương công ty
			System.out.print("Tổng lương công ty: " + controller.tongLuongCongTy());
			break;
		case 7: // Tìm kiếm
			timKiem();
			break;
		case 8: // Danh sách thu nhập của giám đốc
			System.out.println(String.format("%-5s%-15s%-30s%-30s", "STT", "Mã số", "Họ tên", "Thu nhập"));
			System.out.println("-----------------------------------------------------------------------");
			controller.xuatDSGiamDoc();
		case 0: 
			isContinue = false;
			break;
		default:
			System.out.println("Lựa chọn không hợp lệ.");
			break;
		}
		return isContinue;
	}

	private void themNhanSu() {
		System.out.println("Loại nhân viên:");
		System.out.println("1. Nhân viên");
		System.out.println("2. Trưởng phòng");
		System.out.println("3. Giám đốc");
		System.out.print("Lựa chọn: ");
		
		NhanSu nhanSu;
		
		switch(Integer.parseInt(scanner.nextLine())) {
		case 1: 
			nhanSu = new NhanVien();
			break;
		case 2: 
			nhanSu = new TruongPhong();
			break;
		case 3: 
			nhanSu = new GiamDoc();
			break;
		default:
			System.out.println("Loại nhân sự không hợp lệ.");
			return;
		}
		
		nhanSu.nhapThongTin(scanner);
		controller.them(nhanSu);
	}
	
	private void timKiem() {
		System.out.println("---------------------------TÌM KIẾM---------------------------");
		System.out.println("1. Tìm nhân viên thường có lương cao nhất.");
		System.out.println("2. Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất.");
		System.out.println("3. Tìm giám đốc có số lượng cổ phẩn nhiều nhất.");
		System.out.print("Lựa chọn");
		
		switch(Integer.parseInt(scanner.nextLine())) {
		case 1:
			controller.dsNhanViens();
			controller.header("Nhân viên có lương cao nhất", "Mã trưởng phòng");
			controller.nvLuongCaoNhat().xuatThongTin(1);
			break;
			
		case 2:
			controller.dsTruongPhong();
			controller.header("Trưởng phòng có nhân viên dưới quyền nhiều nhất", "Số nhân viên quản lý");
			controller.truongPhongNhieuNhanVien().xuatThongTin(1);
			break;
			
		case 3:
			controller.dsGiamDoc();
			controller.header("Giám đốc có số cổ phần nhiều nhất", "Số cổ phần");
			controller.giamDocNhieuCoPhan().xuatThongTin(1);
			break;
		
		default:
		System.out.println("Tìm kiếm không thấy");
		return;
		}
	}	
}

