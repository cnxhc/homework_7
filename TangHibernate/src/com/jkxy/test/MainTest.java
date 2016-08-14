package com.jkxy.test;

import java.util.Scanner;

import com.jkxy.service.UserService;

public class MainTest {
	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("*******************************");
			System.out.println("********欢迎使用唐诗查询！***********");
			System.out.println("*******************************");
			System.out.println("1，查询诗人诗词数量");
			System.out.println("2，分页查询诗词");
			System.out.println("3，查询诗词前15个字");
			System.out.println("请输入需要操作的功能，例如输入：1");
			System.out.println("*******************************");
			MainTest mt = new MainTest();
			UserService us = new UserService();
			String str = scanner.next();
			String reg = "\\d";
			if (str.matches(reg)) {
				int number = Integer.parseInt(str);
				switch (number) {
				case 1:
					System.out.println("*******************************");
					System.out.println("请输入诗人名：(例如 ：李白)");
					String name = scanner.next();
					us.getCountByName(name);
					break;

				case 2:
					System.out.println("*******************************");
					System.out.println("请输入诗人名：(例如: 李白)");
					String name2 = scanner.next();
					us.getPager(name2);
					break;
				case 3:
					System.out.println("*******************************");
					System.out.println("请输入诗人名：(例如 :李白)");
					String name3 = scanner.next();
					us.byContent(name3);
					break;
				default:
					break;
				}
			} else {
				System.out.println("输入有误，请输入数字");
			}

		}
	}

}
