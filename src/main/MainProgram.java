package main;

import java.util.Scanner;

import view.QuanLyNhanSuConsole;

public class MainProgram {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		QuanLyNhanSuConsole program = new QuanLyNhanSuConsole();
		System.out.println("Chương trình Quản lý Nhân sự");
		program.start();
		
		System.out.println("Chương trình đã kết thúc");
		
	}
}
