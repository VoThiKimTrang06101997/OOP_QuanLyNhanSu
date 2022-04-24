package model;

import java.util.Scanner;

import controller.QuanLyNhanSu;

public class GiamDoc extends NhanSu {
	/* properties */
	private float soCoPhan;
	private double thuNhapGiamDoc;
	
	/* constructors */
	public GiamDoc() {
		super();
	}
	
	public GiamDoc(String maSo, String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay, float luongThang, float soCoPhan) {
		super(maSo, hoTen, soDienThoai, soNgayLam, luongMotNgay, luongThang);
		this.soCoPhan = soCoPhan;
	}
	
	/* getters and setters */
	public float getSoCoPhan() {
		return soCoPhan;
	}

	public void setSoCoPhan(float soCoPhan) {
		this.soCoPhan = soCoPhan;
	}

	public double getThuNhapGiamDoc() {
		return thuNhapGiamDoc;
	}

	public void setThuNhapGiamDoc(double thuNhapGiamDoc) {
		this.thuNhapGiamDoc = thuNhapGiamDoc;
	}
	
	/* method */
	@Override
	public void nhapThongTin(Scanner scanner) {
		super.nhapThongTin(scanner);
		do {
			System.out.print("Số cổ phần (%): ");
			this.soCoPhan = Float.parseFloat(scanner.nextLine());
		} while (this.soCoPhan < 0 || this.soCoPhan > 100);
	}
	
	@Override
	public void xuatThongTin(int stt) {
		super.xuatThongTin(stt);
		System.out.println(String.format("%-30s", this.soCoPhan));
	}
	
	@Override
	public float tinhLuong() {
		this.luongMotNgay = 300;
		this.luongThang = this.soNgayLam * this.luongMotNgay;
		return this.luongThang;
	}
	
	// Thu nhập của giám đốc
	public double thuNhapGiamDoc() {
		QuanLyNhanSu danhSachNS = new QuanLyNhanSu();
		danhSachNS.tongLuongCongTy();
		danhSachNS.tinhLoiNhuan();
		return this.thuNhapGiamDoc = this.luongThang + this.soCoPhan * danhSachNS.getLoiNhuanThang()/100;
	}
}
