package LibraryProject.Service;

import LibraryProject.DTO.BookDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManageService {
    long isbn;
    String title;
    String author;
    String publisher;
    int price;

    ArrayList<BookDTO> bs = new ArrayList<>();

    public BookManageService() {
        BookList(); // 도서 초기화
    }

    public void BookList() {
        // 도서 10권 정보
        bs.add(new BookDTO(8983711892L, "코스모스", "칼 세이건", "사이언스 북스", 15000));
        bs.add(new BookDTO(9791156645672L, "자바를 부탁해", "박세홍", "한빛 아카데미", 26000));
        bs.add(new BookDTO(9788990982575L, "가면산장 살인사건", "히가시노 게이고", "재인", 16800));
        bs.add(new BookDTO(9788936434595L, "채식주의자", "한강", "창비", 15000));
        bs.add(new BookDTO(9791167901484L, "나미야 잡화점의 기적", "히가시노 게이고", "현대문학", 14500));
        bs.add(new BookDTO(9788958281801L, "몽구스 크루", "신여랑", "사계절", 10800));
        bs.add(new BookDTO(9791158792152L, "백설공주에게 죽음을", "넬레 노이하우스", "북로드", 17800));
        bs.add(new BookDTO(9788956604992L, "7년의 밤", "정유정", "은행나무", 18500));
        bs.add(new BookDTO(9788938201010L, "그리고 아무도 없었다", "애거서 크리스티", "해문출판사", 12000));
        bs.add(new BookDTO(9791168340770L, "미움 받을 용기", "기시미 이치로", "인플루엔셜", 15900));
    }

    public void saveBookList() {
        for (int i = 0; i < bs.size(); i++) {
            System.out.println((i + 1) + ". " + bs.get(i));
        }
    }

    public void bookAddition() { // 도서 추가
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.print("ISBN을 입력하세요(숫자만 입력) : ");
            if (sc.hasNextLong()) {
                isbn = sc.nextLong();
                break;
            }
            else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                sc.next();
            }
        }

        System.out.print("제목을 입력하세요 : ");
        sc.nextLine();
        title = sc.nextLine();

        System.out.print("작가를 입력하세요 : ");
        author = sc.nextLine();

        System.out.print("출판사를 입력하세요 : ");
        publisher = sc.nextLine();

        while (true) {
            System.out.print("가격을 입력하세요(숫자만 입력) : ");
            if (sc.hasNextInt()) {
                price = sc.nextInt();
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                sc.next();
            }
        }

        BookDTO newBook = new BookDTO(isbn, title, author, publisher, price);
        bs.add(newBook);
        System.out.println("도서 정보가 추가되었습니다.");
    }

    public void bookDelete(){ // 도서 삭제
        System.out.println("1. 번호 선택 2. 삭제 취소(홈으로 이동)");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        try {
            if (choice == 1){
                saveBookList();
                System.out.println("삭제할 책 번호를 입력해주세요");
                int id = sc.nextInt();
                bs.remove(id-1);
                System.out.println("삭제가 완료되었습니다.\n");
            }
            else if (choice == 2){
                System.out.println("홈으로 이동");
            }
            else {
                System.out.println("잘못된 입력입니다.");
            }

        }catch (IndexOutOfBoundsException e) {
            System.out.println("잘못된 입력입니다.");
        }

    }

    public void bookSelect(){ //도서 정보 조회
        Scanner sc = new Scanner(System.in);
        System.out.println("============================================📖 조회 하실 항목을 선택해주세요 📖============================================");
        System.out.println("MENU :\t\t  1️⃣ ISBN\t\t  2️⃣ 제목명\t\t  3️⃣ 작가명\t\t  4️⃣ 출판사명\t\t  5️⃣ 가격\t\t  6️⃣ 홈으로 돌아가기");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("ISBN을 입력하세요(숫자만 입력) : ");
                sc.nextLine();
                long inputISBN = sc.nextLong();
                boolean ISBNFound = false;
                for (BookDTO book : bs) {
                    if (book.getIsbn() == inputISBN) {
                        System.out.println(book);
                        ISBNFound = true;
                    }
                }
                if (!ISBNFound)
                    System.out.println("입력하신 ISBN 도서를 찾을 수 없습니다."); break;
            case 2:
                System.out.printf("제목을 입력하세요 : ");
                sc.nextLine();
                String inputTitle = sc.nextLine();
                boolean titleFound = false;
                for (BookDTO book : bs) {
                    if (book.getTitle().equals(inputTitle)) {
                        System.out.println(book);
                        titleFound = true;
                    }
                }
                if (!titleFound)
                    System.out.println("입력하신 제목의 도서를 찾을 수 없습니다."); break;
            case 3:
                System.out.printf("작가 이름을 입력하세요 : ");
                sc.nextLine();
                String inputAuthor = sc.nextLine();
                boolean authorFound = false;
                for (BookDTO book : bs) {
                    if (book.getAuthor().equals(inputAuthor)) {
                        System.out.println(book);
                        authorFound = true;
                    }
                }
                if (!authorFound)
                    System.out.println("입력하신 작가의 도서를 찾을 수 없습니다."); break;
            case 4:
                System.out.printf("출판사명을 입력하세요 : ");
                sc.nextLine();
                String inputPublisher = sc.nextLine();
                boolean publisherFound = false;
                for (BookDTO book : bs) {
                    if (book.getPublisher().equals(inputPublisher)) {
                        System.out.println(book);
                        publisherFound = true;
                    }
                }
                if (!publisherFound)
                    System.out.println("입력하신 출판사의 도서를 찾을 수 없습니다.");break;
            case 5:
                System.out.printf("책의 가격을 입력하세요 : ");
                int inputPrice = sc.nextInt();
                boolean priceFound = false;
                for (BookDTO book : bs) {
                    if (book.getPrice() == inputPrice) {
                        System.out.println(book);
                        priceFound = true;
                    }
                }
                if (!priceFound)
                    System.out.println("입력하신 가격의 도서를 찾을 수 없습니다.");break;
            case 6:
                System.out.println("홈으로 이동");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }
    public void bookEdit(){ // 도서 정보 수정
        Scanner sc = new Scanner(System.in);
        saveBookList();
        System.out.println("====================================📖 수정 하실 책을 선택해주세요(맨 왼쪽 번호 입력) 📖====================================");

        int bookChoice = sc.nextInt()-1;
        BookDTO editBook = bs.get(bookChoice);
        System.out.println("\n"+editBook+"을(를) 선택하셨습니다.\n");
        System.out.println("============================================📖 수정 할 사항을 선택해주세요 📖============================================");

        System.out.println("MENU :\t\t1️⃣ ISBN\t\t2️⃣ 제목명\t\t3️⃣ 작가명\t\t4️⃣ 출판사명\t\t5️⃣ 가격\t\t6️⃣ 전체\t\t7️⃣ 홈으로 돌아가기");

        int editChoice = sc.nextInt();
        switch (editChoice) {
            case 1:
                System.out.printf("수정사항을 입력하세요.(ISBN) \n현재 : " + editBook.getIsbn() + "\n새로운 ISBN : ");
                sc.nextLine();
                long newIsbn = sc.nextLong();
                editBook.setIsbn(newIsbn);
                System.out.println("ISBN이 수정되었습니다.\n"+ editBook);
                break;
            case 2:
                System.out.printf("수정사항을 입력하세요.(제목) \n현재 : " + editBook.getTitle() + "\n새로운 제목 : ");
                sc.nextLine();
                String newTitle = sc.nextLine();
                editBook.setTitle(newTitle);
                System.out.println("제목이 수정되었습니다.\n"+ editBook);
                break;
            case 3:
                System.out.printf("수정사항을 입력하세요.(작가명) \n현재 : " + editBook.getAuthor() + "\n새로운 작가명 : ");
                sc.nextLine();
                String newAuthor = sc.nextLine();
                editBook.setAuthor(newAuthor);
                System.out.println("작가명이 수정되었습니다.\n"+ editBook);
                break;
            case 4:
                System.out.printf("수정사항을 입력하세요.(출판사명) \n현재 : " + editBook.getPublisher() + "\n새로운 출판사명 : ");
                sc.nextLine();
                String newPublisher = sc.nextLine();
                editBook.setPublisher(newPublisher);
                System.out.println("출판사명이 수정되었습니다.\n"+ editBook);
                break;
            case 5:
                System.out.printf("수정사항을 입력하세요.(가격) \n현재 : " + editBook.getPrice() + "\n새로운 가격 : ");
                int newPrice = sc.nextInt();
                editBook.setPrice(newPrice);
                System.out.println("가격이 수정되었습니다.\n"+ editBook);
                break;
            case 6:
                System.out.printf("수정사항을 입력하세요.(ISBN) \n현재 : " + editBook.getIsbn() + "\n새로운 ISBN : ");
                sc.nextLine();
                long nIsbn = sc.nextLong();
                editBook.setIsbn(nIsbn);
                System.out.printf("수정사항을 입력하세요.(제목) \n현재 : " + editBook.getTitle() + "\n새로운 제목 : ");
                sc.nextLine();
                String nTitle = sc.nextLine();
                editBook.setTitle(nTitle);
                System.out.printf("수정사항을 입력하세요.(작가명) \n현재 : " + editBook.getAuthor() + "\n새로운 작가명 : ");
                String nAuthor = sc.nextLine();
                editBook.setAuthor(nAuthor);
                System.out.printf("수정사항을 입력하세요.(출판사명) \n현재 : " + editBook.getPublisher() + "\n새로운 출판사명 : ");
                String nPub = sc.nextLine();
                editBook.setPublisher(nPub);
                System.out.printf("수정사항을 입력하세요.(가격) \n현재 : " + editBook.getPrice() + "\n새로운 가격 : ");
                int np = sc.nextInt();
                editBook.setPrice(np);
                System.out.println("책 정보가 수정되었습니다.\n"+ editBook);
                break;
            case 7:
                System.out.println("홈으로 이동");
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 입력하세요");
        }
    }
}
