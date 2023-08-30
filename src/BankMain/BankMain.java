package BankMain;

import BankRepository.BankRepository;
import BankService.BankService;

import java.util.Scanner;

public class BankMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService();
        BankRepository bankRepository = new BankRepository();

        boolean run = true;
        while (run) {
            System.out.println("---------------------------------------------------");
            System.out.println("1.신규계좌개설 2.잔액조회 3.입금 4.출금");
            System.out.println("5.입출금 내역 조회 0.종료");
            System.out.println("---------------------------------------------------");
            System.out.print("메뉴를 선택하세요 : ");
            int menu = scanner.nextInt();
            if (menu == 1) {
                System.out.println("신규계좌개설 페이지");
                bankService.creat();

            } else if (menu == 2) {
                System.out.println("잔액조회 페이지");
                bankService.search();

            } else if (menu == 3) {
                System.out.println("입금 페이지");
                bankService.inBalance();

            } else if (menu == 4) {
                System.out.println("출금 페이지");
                bankService.outBalance();
            } else if (menu == 5) {
                bankService.inout();
                // Main페이지에서 생성한 BankRepository에 저장된 ArrayList와
                // BankService에서 생성한 BankRepository에 저장된 ArrayList와
                // 값이 다름.
            } else if (menu == 0) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else {
                System.out.println("번호를 확인하세요");
            }


        }

    }
}
