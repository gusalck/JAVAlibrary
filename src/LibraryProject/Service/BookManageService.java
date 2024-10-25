package LibraryProject.Service;

import LibraryProject.DTO.BookDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManageService {
    String isbn;
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
        bs.add(new BookDTO("8983711892", "코스모스", "칼세이건", "사이언스북스", 15000));
        bs.add(new BookDTO("9791156645672", "자바를부탁해", "박세홍", "한빛아카데미", 26000));
        bs.add(new BookDTO("9788990982575", "가면산장살인사건", "히가시노게이고", "재인", 16800));
        bs.add(new BookDTO("9788936434595", "채식주의자", "한강", "창비", 15000));
        bs.add(new BookDTO("9791167901484", "나미야잡화점의기적", "히가시노게이고", "현대문학", 14500));
        bs.add(new BookDTO("9788958281801", "몽구스크루", "신여랑", "사계절", 10800));
        bs.add(new BookDTO("9791158792152", "백설공주에게죽음을", "넬레노이하우스", "북로드", 17800));
        bs.add(new BookDTO("9788956604992", "7년의밤", "정유정", "은행나무", 18500));
        bs.add(new BookDTO("9788938201010", "그리고아무도없었다", "애거서크리스티", "해문출판사", 12000));
        bs.add(new BookDTO("9791168340770", "미움받을용기", "기시미이치로", "인플루엔셜", 15900));
    }

    public void saveBookList() {
        for (int i = 0; i < bs.size(); i++) {
            System.out.println((i + 1) + ". " + bs.get(i));
        }
    }

    public void bookAddition() {
        Scanner sc = new Scanner(System.in);

        System.out.print("ISBN을 입력하세요: ");
        isbn = sc.nextLine();

        System.out.print("제목을 입력하세요: ");
        title = sc.nextLine();

        System.out.print("작가를 입력하세요: ");
        author = sc.nextLine();

        System.out.print("출판사를 입력하세요: ");
        publisher = sc.nextLine();

        while (true) {
            System.out.print("가격을 입력하세요: ");
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

    public void bookDelete(){
        saveBookList();
        System.out.println("삭제할 책 번호를 입력해주세요");
        Scanner sc = new Scanner(System.in);
        try {
            int id = sc.nextInt();
            bs.remove(id-1);
            System.out.println("삭제가 완료되었습니다.\n");
        }catch (IndexOutOfBoundsException e) {
            System.out.println("잘못된 입력입니다.");
        }

    }

    public void bookSelect(){
        Scanner sc = new Scanner(System.in);
        System.out.println("============================================📖 조회 하실 항목을 선택해주세요 📖============================================");
        System.out.println("MENU :\t\t  1️⃣ ISBN\t\t  2️⃣ 제목명\t\t  3️⃣ 작가명\t\t  4️⃣ 출판사명\t\t  5️⃣ 가격\t\t  6️⃣ 홈으로 돌아가기");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("ISBN을 입력하세요 : ");
                String inputISBN = sc.next();
                for (BookDTO book : bs) {
                    if (book.getIsbn().equals(inputISBN)) {
                        System.out.println(book);
                        return;
                    }
                }
                System.out.println("입력하신 ISBN 도서를 찾을 수 없습니다."); break;
            case 2:
                System.out.printf("제목을 입력하세요 : ");
                String inputTitle = sc.next();
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
                String inputAuthor = sc.next();
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
                String inputPublisher = sc.next();
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
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
        }
    }
    public void bookEdit(){
        Scanner sc = new Scanner(System.in);
        saveBookList();
        System.out.println("====================================📖 수정 하실 책을 선택해주세요(맨 왼쪽 번호 입력) 📖====================================");

        int bookChoice = sc.nextInt()-1;
        BookDTO editBook = bs.get(bookChoice);
        System.out.println("\n"+editBook+"을(를) 선택하셨습니다.\n");
        System.out.println("============================================📖 수정 할 사항을 선택해주세요 📖============================================");

        System.out.println("MENU :\t\t  1️⃣ ISBN\t\t  2️⃣ 제목명\t\t  3️⃣ 작가명\t\t  4️⃣ 출판사명\t\t  5️⃣ 가격\t\t  6️⃣ 전체\t\t 7️⃣ 홈으로 돌아가기");

        int editChoice = sc.nextInt();
        switch (editChoice) {
            case 1:
                System.out.printf("수정사항을 입력하세요.(ISBN) \n현재 : " + editBook.getIsbn() + "\n새로운 ISBN : ");
                String newIsbn = sc.next();
                editBook.setIsbn(newIsbn);
                System.out.println("ISBN이 수정되었습니다.\n"+ editBook);
                break;
            case 2:
                System.out.printf("수정사항을 입력하세요.(제목) \n현재 : " + editBook.getTitle() + "\n새로운 제목 : ");
                String newTitle = sc.next();
                editBook.setTitle(newTitle);
                System.out.println("제목이 수정되었습니다.\n"+ editBook);
                break;
            case 3:
                System.out.printf("수정사항을 입력하세요.(작가명) \n현재 : " + editBook.getAuthor() + "\n새로운 작가명 : ");
                String newAuthor = sc.next();
                editBook.setAuthor(newAuthor);
                System.out.println("작가명이 수정되었습니다.\n"+ editBook);
                break;
            case 4:
                System.out.printf("수정사항을 입력하세요.(출판사명) \n현재 : " + editBook.getPublisher() + "\n새로운 출판사명 : ");
                String newPublisher = sc.next();
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
                String nIsbn = sc.next();
                editBook.setIsbn(nIsbn);
                System.out.printf("수정사항을 입력하세요.(제목) \n현재 : " + editBook.getTitle() + "\n새로운 제목 : ");
                String nTitle = sc.next();
                editBook.setTitle(nTitle);
                System.out.printf("수정사항을 입력하세요.(작가명) \n현재 : " + editBook.getAuthor() + "\n새로운 작가명 : ");
                String nAuthor = sc.next();
                editBook.setAuthor(nAuthor);
                System.out.printf("수정사항을 입력하세요.(출판사명) \n현재 : " + editBook.getPublisher() + "\n새로운 출판사명 : ");
                String nPub = sc.next();
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
