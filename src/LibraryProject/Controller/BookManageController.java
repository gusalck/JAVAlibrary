package LibraryProject.Controller;

import LibraryProject.View.BookManageView;

public class BookManageController {
//     service 내 기능을 호출해서 프로그램이 돌아가게 만드는 기능(main 메소드 여기에 생성)
    public static void main(String[] args) {
        BookManageView bookManageView = new BookManageView();
        bookManageView.showView();
    }
}
