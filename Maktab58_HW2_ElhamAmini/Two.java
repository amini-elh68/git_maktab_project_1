package Maktab58_HW2_ElhamAmini.two;

import java.util.Scanner;

public class Two {

    private static Book[] books = new Book[50];
    private static Member[] members = new Member[50];
    private static int bookId = 999;
    private static int memberId = 19;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your command");
            String command = scanner.next();
            if (command.equals("addBook")) {
                String name = scanner.next();
                int count = scanner.nextInt();
                addBook(name, count);
            } else if (command.equals("addMember")) {
                String name = scanner.next();
                String birthDate = scanner.next();
                addMember(name, birthDate);
            } else if (command.equals("get")) {
                int memberId = scanner.nextInt();
                int bookId = scanner.nextInt();
                get(memberId, bookId);
            } else if (command.equals("return")) {
                int memberId = scanner.nextInt();
                int bookId = scanner.nextInt();
                returnBook(memberId, bookId);
            } else if (command.equals("bookStat")) {
                bookStat();
            } else if (command.equals("memberStat")) {
                memberStat();
            }
        }

    }

    private static void addBook(String name, int count) {
        if (books[49] != null) {
            System.out.println("limit of books are 50.");
        } else {
            Book book = new Book(bookId + 1, name);
            book.setCount(count);
            for (int i = 0; i < 50; i++) {
                if (books[i] == null) {
                    books[i] = book;
                    bookId++;
                    break;
                }
            }
        }
    }

    private static void addMember(String name, String birthDate) {
        if (members[49] != null) {
            System.out.println("limit of members are 50.");
        } else {
            Member member = new Member(memberId + 1, name, birthDate);
            for (int i = 0; i < 50; i++) {
                if (members[i] == null) {
                    members[i] = member;
                    memberId++;
                    break;
                }
            }
        }
    }

    private static void get(int memberId, int bookId) {
        int bookIndex = indexOfBook(bookId);
        int memberIndex = indexOfMember(memberId);
        if (bookIndex != -1 && memberIndex != -1) {
            if (books[bookIndex].getCount() == 0) {
                System.out.println("NotAvailable : [" + books[bookIndex].getName() + "] [" + books[bookIndex].getId() + "]");
            } else {
                int result = members[memberIndex].addBook(books[bookIndex]);
                if (result == 0)
                    books[bookIndex].setCount(books[bookIndex].getCount() - 1);
            }
        }
    }

    private static void returnBook(int memberId, int bookId) {
        int bookIndex = indexOfBook(bookId);
        int memberIndex = indexOfMember(memberId);
        if (bookIndex != -1 && memberIndex != -1) {
            int result = members[memberIndex].deleteBook(books[bookIndex]);
            if (result == 0)
                books[bookIndex].setCount(books[bookIndex].getCount() + 1);
        }
    }

    private static void bookStat() {
        for (Book b : books) {
            if (b == null) {
                break;
            }
            System.out.println("[" + b.getName() + "] [" + b.getId() + "] [" + b.getCount() + "]");
        }
    }

    private static void memberStat() {
        for (Member m : members) {
            if (m == null) {
                break;
            }
            System.out.println("[" + m.getName() + "] [" + m.getId() + "] [" + m.getBookList() + "]");
        }
    }

    private static int indexOfMember(int memberId) {
        int index = -1;
        for (int i = 0; i < 50; i++) {
            if (members[i] == null) {
                break;
            }
            if (members[i].getId() == memberId) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static int indexOfBook(int memberId) {
        int index = -1;
        for (int i = 0; i < 50; i++) {
            if (books[i] == null) {
                break;
            }
            if (books[i].getId() == memberId) {
                index = i;
                break;
            }
        }
        return index;
    }
}
