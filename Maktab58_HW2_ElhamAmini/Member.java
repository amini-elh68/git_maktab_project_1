package Maktab58_HW2_ElhamAmini.two;

public class Member {
    private int id;
    private String name;
    private String birthDate;
    private Book[] books = new Book[5];

    public Member(int id, String name, String birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int addBook(Book book) {
        int result = -1;
        for (int i = 0; i < 5; i++) {
            if (books[i] != null && books[i].getName() == book.getName()) {
                System.out.println("Access to " + book.getName() + " is not possible for : " + getName() + " " + getId());
                break;
            }
            if (books[i] == null) {
                books[i] = book;
                result = 0;
                break;
            }
            if (i == 4 && books[i] != null) {
                System.out.println("MaxReached : [" + getName() + "] [" + getId() + "]");
            }
        }
        return result;
    }

    public int deleteBook(Book book) {
        int result = -1;
        for (int i = 0; i < 5; i++) {
            if (books[i] == null) {
                System.out.println("member dont have any book.");
                break;
            }
            if (books[i].getId() == book.getId()) {
                books[i] = null;
                result = 0;
                Book[] temp = new Book[5];
                int index = 0;
                for (Book b : books) {
                    if (b != null) {
                        temp[index++] = b;
                    }
                }
                setBooks(temp);
                break;
            }
            if (i == 4 && books[i].getId() != book.getId()) {
                System.out.println("NotAvailable : [" + book.getName() + "] [" + book.getId() + "]");
            }
        }
        return result;
    }

    public String getBookList() {
        String result = "";
        for (Book b : books) {
            if (b == null) {
                break;
            }
            result += "[" + b.getName() + "] [" + b.getId() + "] - ";
        }
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 3);
        }
        return result;
    }
}
