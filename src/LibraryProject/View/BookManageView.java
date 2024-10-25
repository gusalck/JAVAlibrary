package LibraryProject.View;

import LibraryProject.Service.BookManageService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookManageView {
    //view
    BookManageService bookManageService = new BookManageService();

    public void showView(){ //출력메소드
        while(true){
            try {
                System.out.println("\n=================================================📖  도서관리 시스템  📖=================================================");
                System.out.println("MENU :\t\t\t1️⃣ 도서정보추가\t\t\t2️⃣ 조회\t\t\t3️⃣ ️️수정\t\t\t4️⃣ 삭제\t\t\t5️⃣ 출력\t\t\t6️⃣ 종료");
                Scanner userInput = new Scanner(System.in);
                int choice = userInput.nextInt();

                switch(choice){
                    case 1:
                        bookManageService.bookAddition(); // 도서정보추가
                        break;
                    case 2:
                        bookManageService.bookSelect(); // 조회
                        break;
                    case 3:
                        bookManageService.bookEdit(); // 수정
                        break;
                    case 4:
                        bookManageService.bookDelete(); // 삭제
                        break;
                    case 5:
                        bookManageService.saveBookList(); // 출력
                        break;
                    case 6:
                        System.out.println("시스템 종료");
                        userInput.close();
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
            }
        }
    }
}
